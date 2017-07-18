/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rashjz.info.com.az.service;

import java.util.List;
import org.hibernate.Criteria;
import rashjz.info.com.az.entity.OrderStatus;

/**
 *
 * @author Azik
 */
public interface OrderStatusService  {
    
    public Criteria createEntityCriteria();

    public OrderStatus getByKey(Integer key);

    public void delete(OrderStatus entity);

    public void update(OrderStatus entity);

    public void persist(OrderStatus entity);

    public List<OrderStatus>  getAll(Class<OrderStatus> type);
    
}
