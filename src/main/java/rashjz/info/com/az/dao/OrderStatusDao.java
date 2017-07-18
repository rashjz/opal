/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rashjz.info.com.az.dao;

import java.util.List;
import org.hibernate.Criteria;
import rashjz.info.com.az.entity.OrderStatus;
import rashjz.info.com.az.entity.Orders;
import rashjz.info.com.az.entity.Users;

/**
 *
 * @author Azik
 */
public interface OrderStatusDao {
    
     public Criteria createEntityCriteria();

    public OrderStatus getByKey(Integer key);

    public void delete(OrderStatus entity);

    public void update(OrderStatus entity);

    public void persist(OrderStatus entity);

    public List<OrderStatus>  getAll(Class<OrderStatus> type);

    
}
