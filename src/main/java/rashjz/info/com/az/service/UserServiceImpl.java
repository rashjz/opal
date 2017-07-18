/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rashjz.info.com.az.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.swing.SortOrder;
import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rashjz.info.com.az.dao.UserDao;
import rashjz.info.com.az.domain.PagingResult;
import rashjz.info.com.az.entity.Users;

/**
 *
 * @author Rashad Javadov
 */
@Service
@Transactional
public class UserServiceImpl implements Serializable, UserService {

    @Autowired
    UserDao userDao;

    @Override
    public List<Users> getAllUser() {
        return userDao.getAllUser();
    }

    @Override
    public Users findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public Criteria createEntityCriteria() {
        return userDao.createEntityCriteria();
    }

    @Override
    public void delete(Users entity) {
        userDao.delete(entity);
    }

    @Override
    public void update(Users entity) {
        userDao.update(entity);
    }

    @Override
    public void persist(Users entity) {
        userDao.persist(entity);
    }

    @Override
    public Users getByKey(Integer key) {
        return userDao.getByKey(key);
    }

    @Override
    public PagingResult lazyLoadUsers(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
        return userDao.lazyLoadUsers(first, pageSize, sortField, sortOrder, filters);
    }

    @Override
    public Number lazyLoadUsersCount(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters, PagingResult pagingResult) {
       return userDao.lazyLoadUsersCount(first, pageSize, sortField, sortOrder, filters, pagingResult);
    }

}
