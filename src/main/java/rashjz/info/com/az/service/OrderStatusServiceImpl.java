/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rashjz.info.com.az.service;

import java.util.List;
import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rashjz.info.com.az.dao.OrderStatusDao;
import rashjz.info.com.az.entity.OrderStatus;

/**
 *
 * @author Azik
 */
@Service
@Transactional
public class OrderStatusServiceImpl implements OrderStatusService{

    @Autowired
    OrderStatusDao orderStatusDao;
    
    @Override
    public Criteria createEntityCriteria() {
      return orderStatusDao.createEntityCriteria();
    }

    @Override
    public OrderStatus getByKey(Integer key) {
       return orderStatusDao.getByKey(key);
    }

    @Override
    public void delete(OrderStatus entity) {
       orderStatusDao.delete(entity);
    }

    @Override
    public void update(OrderStatus entity) {
        orderStatusDao.update(entity);
    }

    @Override
    public void persist(OrderStatus entity) {
        orderStatusDao.persist(entity);
    }

    @Override
    public List<OrderStatus> getAll(Class<OrderStatus> type) {
       return orderStatusDao.getAll(type);
    }
    
    
}
