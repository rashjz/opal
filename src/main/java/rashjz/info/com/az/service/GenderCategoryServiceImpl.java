/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rashjz.info.com.az.service;

import java.util.List;
import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rashjz.info.com.az.dao.GenderCategoryDao;
import rashjz.info.com.az.entity.Gender;

/**
 *
 * @author Azik
 */
@Service
@Transactional
public class GenderCategoryServiceImpl implements GenderCategoryServise {

    @Autowired
    private GenderCategoryDao genderCategoryDao;

    @Override
    public Criteria createEntityCriteria() {
        return genderCategoryDao.createEntityCriteria();
    }

    @Override
    public void delete(Gender entity) {
        genderCategoryDao.delete(entity);
    }

    @Override
    public void update(Gender entity) {
        genderCategoryDao.update(entity);
    }

    @Override
    public void persist(Gender entity) {
        genderCategoryDao.persist(entity);
    }

    @Override
    public Gender getByKey(Integer key) {
        return genderCategoryDao.getByKey(key);
    }

    @Override
    public List<Gender> getAll(Class<Gender> type) {
        return genderCategoryDao.getAll(type);
    }

}
