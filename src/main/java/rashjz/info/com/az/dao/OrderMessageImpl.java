/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rashjz.info.com.az.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;
import rashjz.info.com.az.entity.OrderMessage;

/**
 *
 * @author Rashad Javadov
 */
@Repository
public class OrderMessageImpl extends AbstractDao<Integer, OrderMessage> implements Serializable, OrderMessageDao {

    private static final Logger LOG = Logger.getLogger(OrderMessageImpl.class.getName());

    @Override
    public Criteria createEntityCriteria() {
        return super.createEntityCriteria();
    }

    @Override
    public void delete(OrderMessage entity) {
        super.delete(entity);
    }

    @Override
    public void update(OrderMessage entity) {
        super.update(entity);
    }

    @Override
    public void persist(OrderMessage entity) {
        super.persist(entity);
    }

    @Override
    public List<OrderMessage> getAll(Class type) { 
        return super.getAll(type);
    }

    @Override
    public List<OrderMessage> getMessageList(String statusId) {
        List<OrderMessage> messageList=new ArrayList<>();
        try {
            Criteria criteria=getSession().createCriteria(OrderMessage.class);
            criteria.add(Restrictions.eq("status", statusId));
            messageList=criteria.list();
            // System.out.println("------------------------ xxxxxxxxxxxxxxxxx "+messageList.size());
            return messageList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<OrderMessage> getAllList(int userId) {
        List<OrderMessage> messageList=new ArrayList<>();
        try {
            Criteria criteria=getSession().createCriteria(OrderMessage.class, "o");
            criteria.createCriteria("o.userId", "userId", JoinType.INNER_JOIN, Restrictions.eq("userId", userId));
            criteria.addOrder(Order.asc("insertDate"));
            messageList=criteria.list();
           
            return messageList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Long getMessageListCount(String statusId) {
        try {
          Criteria criteria=getSession().createCriteria(OrderMessage.class);
          criteria.add(Restrictions.eq("status", statusId));
         int resultCount =criteria.list().size();
         return (long)resultCount;
        } catch (Exception e) {
            e.printStackTrace();
        }
       return null;
    }

}
