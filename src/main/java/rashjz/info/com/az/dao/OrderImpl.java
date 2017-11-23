/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rashjz.info.com.az.dao;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import javax.swing.SortOrder;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;
import rashjz.info.com.az.domain.PagingResult;
import rashjz.info.com.az.domain.PagingResultOrder;
import rashjz.info.com.az.entity.Orders;

import rashjz.info.com.az.entity.Users;

/**
 *
 * @author Rashad Javadov
 */
@Repository
public class OrderImpl extends AbstractDao<Integer, Orders> implements Serializable, OrderDao {

    private static final Logger LOG = Logger.getLogger(OrderImpl.class.getName());

    @Override
    public Criteria createEntityCriteria() {
        return super.createEntityCriteria();
    }

    @Override
    public void delete(Orders entity) {
        super.delete(entity);
    }

    @Override
    public void update(Orders entity) {
        super.update(entity);
    }

    @Override
    public void persist(Orders entity) {
        super.persist(entity);
    }

    @Override
    public List<Orders> getAll(Class type) {

        return super.getAll(type);
    }

    @Override
    public List<Orders> getByUserId(Users entity, Integer statusType) {
        List<Orders> orders = null;
        try {
            Criteria crit = getSession().createCriteria(Orders.class, "o").add(Restrictions.eq("o.statusId.id", statusType));

            crit.createCriteria("o.userId", "userId", JoinType.INNER_JOIN, Restrictions.eq("userId", Integer.valueOf(entity.getUserId())));
            return crit.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public Double getTotalAmountByUserId(Users entity, Integer statusType) {
        Double total = null;
        try {
            Query query = getSession().createQuery("select sum(o.count*p.price) from Orders o   join o.productId  p where o.statusId.id=" + statusType + " and o.userId=" + entity.getUserId().intValue());
            List list = query.list();
            if (list != null && list.size() > 0) {
                total = Double.valueOf(list.get(0).toString());
            }
            return total;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return total;
    }

    @Override
    public List<Orders> getByStatusType(Integer statusType) {
        List<Orders> orders = null;
        try {
            Criteria crit = getSession().createCriteria(Orders.class, "o").add(Restrictions.eq("o.statusId.id", statusType));
            return crit.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public Double getTotalAmountByStatusType(Integer statusType) {
        Double total = null;
        try {
            Query query = getSession().createQuery("select sum(o.count*p.price) from Orders o   join o.productId  p where o.statusId.id=" + statusType);
            List list = query.list();
            if (list != null && list.size() > 0) {
                total = Double.valueOf(list.get(0).toString());
            }
            return total;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return total;
    }

    @Override
    public PagingResultOrder lazyLoadOrders(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
        PagingResultOrder result = new PagingResultOrder();
        LOG.info("first " + first + " pageSize " + pageSize + " sortField " + sortField + " SortOrder " + sortOrder);
        Transaction trns = null;
        Session session = getSession();
        try {
            Criteria crit = session.createCriteria(Orders.class, "o");
            if (filters != null && !filters.isEmpty()) {
                Iterator<Map.Entry<String, Object>> iterator = filters.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry<String, Object> entry = iterator.next();
                    
                    LOG.info("getKey " + entry.getKey() + " Value " + entry.getValue());
                     if(entry.getKey().equals("username") || entry.getKey().equals("firstname") || entry.getKey().equals("lastname")) {
                        crit.createCriteria("o.userId", entry.getKey(), JoinType.INNER_JOIN, Restrictions.like(entry.getKey(), entry.getValue().toString(), MatchMode.ANYWHERE));
                    }else if (entry.getKey().equals("productId")) {
                        crit.createCriteria("o.productId", "productId", JoinType.INNER_JOIN, Restrictions.like("title", entry.getValue().toString(), MatchMode.ANYWHERE));
                    } else if (entry.getKey().equals("count")) {
                        crit.add(Restrictions.eq(entry.getKey(), entry.getValue()));
                    } else if (entry.getKey().equals("statusId")) {
                        crit.createCriteria("o.statusId", "statusId", JoinType.INNER_JOIN, Restrictions.eq("id", entry.getValue()));
                    } else if (entry.getKey().equals("toDate")) {
                        crit.add(Expression.ge("insertDate", entry.getValue()));
                    } else if (entry.getKey().equals("fromDate")) {
                        crit.add(Expression.le("insertDate", entry.getValue()));
                    }
                }
            }
            crit = crit.setFirstResult(first).setMaxResults(pageSize);
            result.setList(crit.list());
            System.out.println("==listsize "+result.getList().size());
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Number lazyLoadOrdersCount(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters, PagingResultOrder pagingResult) {
        PagingResultOrder result = new PagingResultOrder();
        LOG.info("first " + first + " pageSize " + pageSize + " sortField " + sortField + " SortOrder " + sortOrder);
        Transaction trns = null;
        Session session = getSession();
        try {
            Criteria crit = session.createCriteria(Orders.class, "o");
            crit.setProjection(Projections.rowCount());
            if (filters != null && !filters.isEmpty()) {
                Iterator<Map.Entry<String, Object>> iterator = filters.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry<String, Object> entry = iterator.next();
                    LOG.info("getKey " + entry.getKey() + " Value " + entry.getValue());
                    if(entry.getKey().equals("username") || entry.getKey().equals("firstname") || entry.getKey().equals("lastname")) {
                        crit.createCriteria("o.userId", entry.getKey(), JoinType.INNER_JOIN, Restrictions.like(entry.getKey(), entry.getValue().toString(), MatchMode.ANYWHERE));
                    }else if (entry.getKey().equals("productId")) {
                        crit.createCriteria("o.productId", "productId", JoinType.INNER_JOIN, Restrictions.like("title", entry.getValue().toString(), MatchMode.ANYWHERE));
                    } else if (entry.getKey().equals("count")) {
                        crit.add(Restrictions.eq(entry.getKey(), entry.getValue()));
                    } else if (entry.getKey().equals("statusId")) {
                        crit.createCriteria("o.statusId", "typeId", JoinType.INNER_JOIN, Restrictions.eq("id", entry.getValue()));
                    } else if (entry.getKey().equals("toDate")) {
                        crit.add(Expression.ge("insertDate", entry.getValue()));
                    } else if (entry.getKey().equals("fromDate")) {
                        crit.add(Expression.le("insertDate", entry.getValue()));
                    }
                }
            }
        Long resultCount = (Long) crit.uniqueResult();
        pagingResult.setTotalResult(resultCount.intValue());
       System.out.println("count -------------"+resultCount);
        return resultCount;
    }
    catch (Exception e) {
            e.printStackTrace();
    }

return null;
    }
}
