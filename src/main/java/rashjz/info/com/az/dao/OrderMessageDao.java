/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rashjz.info.com.az.dao;

import java.util.List;
import org.hibernate.Criteria;
import rashjz.info.com.az.entity.OrderMessage;

/**
 *
 * @author Rashad Javadov
 */
public interface OrderMessageDao {

    public Criteria createEntityCriteria();

    public OrderMessage getByKey(Integer key);

    public void delete(OrderMessage entity);

    public void update(OrderMessage entity);

    public void persist(OrderMessage entity);

    public List<OrderMessage> getAll(Class<OrderMessage> type);
    
    public List<OrderMessage> getMessageList(String statusId);
    
     public Long getMessageListCount(String statusId);
    
    public List<OrderMessage> getAllList(int userId);

}
