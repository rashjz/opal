/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rashjz.info.com.az.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import rashjz.info.com.az.entity.Category;


/**
 *
 * @author Azik
 */
@Repository
public class CategoryImpl  extends AbstractDao<Integer, Category> implements Serializable, CategoryDao{
 
    Date date=new Date();
    @Override
    public Criteria createEntityCriteria() {
       return super.createEntityCriteria();
    }

    @Override
    public void delete(Category entity) {
        super.delete(entity);
    }

    @Override
    public void update(Category entity) {
        super.update(entity);
    }

    @Override
    public void persist(Category entity) {
        entity.setInsertDate(date);
        super.persist(entity);
    }
    

    @Override
    public List<Category> getAll(Class type) {
      
        return super.getAll(type);
    }

    @Override
    public Category getByKey(Integer key) {
        return super.getByKey(key);
    }
    
}
