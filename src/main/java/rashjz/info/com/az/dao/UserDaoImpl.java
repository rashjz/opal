/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rashjz.info.com.az.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import javax.swing.SortOrder;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import rashjz.info.com.az.domain.PagingResult;
import rashjz.info.com.az.entity.Users;

/**
 *
 * @author Rashad Javadov
 */
@Repository
public class UserDaoImpl extends AbstractDao<Integer, Users> implements Serializable, UserDao {

    private static final Logger LOG = Logger.getLogger(UserDaoImpl.class.getName());

    public Users findByUsername(String username) {
        LOG.info("findBySSO : {sso} " + username);
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("username", username));
        Users user = (Users) crit.uniqueResult();
        return user;
    }

    @Override
    public List<Users> getAllUser() {
        List<Users> users = new ArrayList<Users>();
        Transaction trns = null;
        Session session = getSession();
        try {
            users = session.createQuery("from Users ").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public Criteria createEntityCriteria() {
        return super.createEntityCriteria(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Users entity) {
        super.delete(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Users entity) {
        super.update(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void persist(Users entity) {
        super.persist(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Users getByKey(Integer key) {
        return super.getByKey(key); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public PagingResult lazyLoadUsers(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
        PagingResult result = new PagingResult();
       LOG.info("first " + first + " pageSize " + pageSize + " sortField " + sortField + " SortOrder " + sortOrder);
       Transaction trns=null;
       Session session=getSession();
        try {
            Criteria crit=session.createCriteria(Users.class);          
            if(filters != null && !filters.isEmpty()){
                Iterator<Map.Entry<String, Object>> iterator = filters.entrySet().iterator();         
                while (iterator.hasNext()) {
                    Map.Entry<String, Object> entry = iterator.next();
                    LOG.info("getKey " + entry.getKey() + " Value " + entry.getValue());
                    if (entry.getKey().equals("username")) {    
                        crit.add(Restrictions.like(entry.getKey(), entry.getValue().toString(), MatchMode.ANYWHERE));
                    } else if (entry.getKey().equals("firstname")) {
                       crit.add(Restrictions.like(entry.getKey(), entry.getValue().toString(), MatchMode.ANYWHERE));
                    } else if (entry.getKey().equals("lastname")) {
                        crit.add(Restrictions.like(entry.getKey(), entry.getValue().toString(), MatchMode.ANYWHERE));
                    }else if (entry.getKey().equals("phone")) {
                        crit.add(Restrictions.like(entry.getKey(), entry.getValue().toString(), MatchMode.ANYWHERE));
                    }else if (entry.getKey().equals("enabled")) {
                       crit.add(Restrictions.eq(entry.getKey(), entry.getValue()));
                    }
                }
            }
            crit = crit.setFirstResult(first).setMaxResults(pageSize);
            result.setList(crit.list());
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Number lazyLoadUsersCount(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters, PagingResult pagingResult) {
        
        PagingResult result = new PagingResult();
       LOG.info("first " + first + " pageSize " + pageSize + " sortField " + sortField + " SortOrder " + sortOrder);
       Transaction trns=null;
       Session session=getSession();
        try {
            Criteria crit=session.createCriteria(Users.class);
           crit.setProjection(Projections.rowCount());
            if(filters != null && !filters.isEmpty()){
                
                Iterator<Map.Entry<String, Object>> iterator = filters.entrySet().iterator();         
                while (iterator.hasNext()) {
                    Map.Entry<String, Object> entry = iterator.next();
                    LOG.info("getKey " + entry.getKey() + " Value " + entry.getValue());
                    if (entry.getKey().equals("username")) {    
                        crit.add(Restrictions.like(entry.getKey(), entry.getValue().toString(), MatchMode.ANYWHERE));
                    } else if (entry.getKey().equals("firstname")) {
                       crit.add(Restrictions.like(entry.getKey(), entry.getValue().toString(), MatchMode.ANYWHERE));
                    } else if (entry.getKey().equals("lastname")) {
                        crit.add(Restrictions.like(entry.getKey(), entry.getValue().toString(), MatchMode.ANYWHERE));
                    }else if (entry.getKey().equals("phone")) {
                        crit.add(Restrictions.like(entry.getKey(), entry.getValue().toString(), MatchMode.ANYWHERE));
                    }else if (entry.getKey().equals("enabled")) {
                       crit.add(Restrictions.eq(entry.getKey(), entry.getValue()));
                    }
                }
            }
           
            Long resultCount = (Long) crit.uniqueResult();
            pagingResult.setTotalResult(resultCount.intValue());
            return resultCount;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
