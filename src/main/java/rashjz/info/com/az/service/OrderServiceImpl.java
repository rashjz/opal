/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rashjz.info.com.az.service;

import java.util.List;
import java.util.Map;
import javax.swing.SortOrder;
import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rashjz.info.com.az.entity.Category;
import rashjz.info.com.az.dao.OrderDao;
import rashjz.info.com.az.domain.PagingResult;
import rashjz.info.com.az.domain.PagingResultOrder;
import rashjz.info.com.az.entity.Orders;
import rashjz.info.com.az.entity.Users;

/**
 *
 * @author Rashad Javadov
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public Criteria createEntityCriteria() {
        return orderDao.createEntityCriteria();
    }

    @Override
    public void delete(Orders entity) {
        orderDao.delete(entity);
    }

    @Override
    public void update(Orders entity) {
        orderDao.update(entity);
    }

    @Override
    public void persist(Orders entity) {
        orderDao.persist(entity);
    }

    @Override
    public List<Orders> getAll(Class<Orders> type) {
        return orderDao.getAll(type);
    }

    @Override
    public Double getTotalAmountByUserId(Users entity, Integer statusType) {
        return orderDao.getTotalAmountByUserId(entity, statusType);
    }

    @Override
    public List<Orders> getByUserId(Users entity, Integer statusType) {
        return orderDao.getByUserId(entity, statusType);
    }

    @Override
    public Orders getByKey(Integer key) {
        return orderDao.getByKey(key);
    }

    @Override
    public List<Orders> getByStatusType(Integer statusType) {
        return orderDao.getByStatusType(statusType);
    }

    @Override
    public Double getTotalAmountByStatusType(Integer statusType) {
       return orderDao.getTotalAmountByStatusType(statusType);
    }

    @Override
    public PagingResultOrder lazyLoadOrders(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
       return orderDao.lazyLoadOrders(first, pageSize, sortField, sortOrder, filters);
    }

    @Override
    public Number lazyLoadOrdersCount(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters, PagingResultOrder pagingResult) {
       return orderDao.lazyLoadOrdersCount(first, pageSize, sortField, sortOrder, filters, pagingResult);
    }

}
