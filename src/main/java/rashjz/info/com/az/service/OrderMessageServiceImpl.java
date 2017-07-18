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
import rashjz.info.com.az.dao.OrderMessageDao;
import rashjz.info.com.az.entity.OrderMessage;

/**
 *
 * @author Rashad Javadov
 */
@Service
@Transactional
public class OrderMessageServiceImpl implements OrderMessageService {

    @Autowired
    private OrderMessageDao messageDao;

    @Override
    public Criteria createEntityCriteria() {
        return messageDao.createEntityCriteria();
    }

    @Override
    public void delete(OrderMessage entity) {
        messageDao.delete(entity);
    }

    @Override
    public void update(OrderMessage entity) {
        messageDao.update(entity);
    }

    @Override
    public void persist(OrderMessage entity) {
        messageDao.persist(entity);
    }

    @Override
    public List<OrderMessage> getAll(Class<OrderMessage> type) {
        return messageDao.getAll(type);
    }

    @Override
    public OrderMessage getByKey(Integer key) {
        return messageDao.getByKey(key);
    }

    @Override
    public List<OrderMessage> getMessageList(String statusId) {
        return messageDao.getMessageList(statusId);
    }

    @Override
    public List<OrderMessage> getAllList(int userId) {
        return messageDao.getAllList(userId);
    }

    @Override
    public Long getMessageListCount(String statusId) {
       return messageDao.getMessageListCount(statusId);
    }

}
