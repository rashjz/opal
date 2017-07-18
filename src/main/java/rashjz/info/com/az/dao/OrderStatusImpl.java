/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rashjz.info.com.az.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import rashjz.info.com.az.entity.OrderStatus;
import rashjz.info.com.az.entity.Orders;
import rashjz.info.com.az.entity.Users;

/**
 *
 * @author Azik
 */
@Repository
public class OrderStatusImpl extends AbstractDao<Integer, OrderStatus> implements Serializable, OrderStatusDao{

    @Override
    public Criteria createEntityCriteria() {
        return super.createEntityCriteria();
    }

    @Override
    public OrderStatus getByKey(Integer key) {
        return super.getByKey(key);
    }

    @Override
    public void delete(OrderStatus entity) {
       super.delete(entity);
    }

    @Override
    public void update(OrderStatus entity) {
        super.update(entity);
    }

    @Override
    public void persist(OrderStatus entity) {
        super.persist(entity);
    }

    @Override
    public List<OrderStatus> getAll(Class type) {
       return super.getAll(type);
    }
    
   
}
