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
import rashjz.info.com.az.dao.CategoryDao;
import rashjz.info.com.az.entity.Category;

/**
 *
 * @author Azik
 */
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public Criteria createEntityCriteria() {
        return categoryDao.createEntityCriteria();
    }

    @Override
    public void delete(Category entity) {
        categoryDao.delete(entity);
    }

    @Override
    public void update(Category entity) {
        categoryDao.delete(entity);
    }

    @Override
    public void persist(Category entity) {
       categoryDao.persist(entity);
    }

    @Override
    public List<Category> getAll(Class<Category> type) {
        return categoryDao.getAll(type);
    }

    @Override
    public void AddOrUpdateUser(Category category) {
        if (category.getCatId()==null || category.getCatId()==0) {
            categoryDao.persist(category); 
        }else{
            categoryDao.update(category); 
        }

    }

    @Override
    public Category getByKey(Integer key) {
        return categoryDao.getByKey(key);
    }

}
