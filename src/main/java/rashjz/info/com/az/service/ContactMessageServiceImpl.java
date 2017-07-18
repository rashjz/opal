/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rashjz.info.com.az.service;

import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rashjz.info.com.az.dao.ContactMessageDao;
import rashjz.info.com.az.entity.ContactMessages;

/**
 *
 * @author Rashad Javadov
 */
@Service
@Transactional
public class ContactMessageServiceImpl implements Serializable, ContactMessageService{

    @Autowired
    private ContactMessageDao messageDao;
 

    @Override
    public void delete(ContactMessages entity) {
        messageDao.delete(entity);
    }

    @Override
    public void update(ContactMessages entity) {
        messageDao.update(entity);
    }

    @Override
    public void persist(ContactMessages entity) {
        messageDao.persist(entity);
    }

    @Override
    public ContactMessages getByKey(Integer key) {
        return messageDao.getByKey(key);
    }

    @Override
    public List<ContactMessages> getAll(Class<ContactMessages> type) {
        return messageDao.getAll(type);
    }

    
    
    
    
}
