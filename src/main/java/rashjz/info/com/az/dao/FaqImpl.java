/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rashjz.info.com.az.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import rashjz.info.com.az.entity.Faq;
import rashjz.info.com.az.entity.Products;

/**
 *
 * @author Azik
 */
@Repository
public class FaqImpl extends AbstractDao<Integer, Faq> implements Serializable, FAQDao{

    
    
    @Override
    public Criteria createEntityCriteria() {
        return  super.createEntityCriteria();
    }

    @Override
    public void delete(Faq entity) {
        super.delete(entity);
    }

    @Override
    public void update(Faq entity) {
        super.update(entity);
    }

    @Override
    public void persist(Faq entity) {
       super.persist(entity);
    }

    @Override
    public Faq getByKey(Integer key) {
        return super.getByKey(key);
    }

    @Override
    public List<Faq> getAll(Class type) {
        return super.getAll(type);
    }

   
    
}
