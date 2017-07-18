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
import rashjz.info.com.az.domain.PagingResult;
import rashjz.info.com.az.domain.PagingResultOrder;
import rashjz.info.com.az.entity.Orders;
import rashjz.info.com.az.entity.Users;

/**
 *
 * @author Rashad Javadov
 */
public interface OrderService {

    public Criteria createEntityCriteria();

    public Orders getByKey(Integer key);

    public void delete(Orders entity);

    public void update(Orders entity);

    public void persist(Orders entity);

    public List<Orders> getByUserId(Users entity,Integer statusType);

    public Double getTotalAmountByUserId(Users entity,Integer statusType);
    
    public List<Orders> getByStatusType(Integer statusType);

    public Double getTotalAmountByStatusType(Integer statusType);

    public List<Orders> getAll(Class<Orders> type);

     public PagingResult lazyLoadOrders(int first, int pageSize,
            String sortField,
            SortOrder sortOrder,
            Map<String, Object> filters);

    public Number lazyLoadOrdersCount(int first, int pageSize,
            String sortField,
            SortOrder sortOrder,
            Map<String, Object> filters, PagingResult pagingResult);
}
