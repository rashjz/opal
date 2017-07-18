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
import rashjz.info.com.az.entity.Gender;

/**
 *
 * @author Azik
 */
@Repository
public class GenderCategoryImpl extends AbstractDao<Integer, Gender>  implements Serializable, GenderCategoryDao{

    @Override
    public Criteria createEntityCriteria() {
       return super.createEntityCriteria();
    }

    @Override
    public void delete(Gender entity) {
        super.delete(entity);
    }

    @Override
    public void update(Gender entity) {
        super.update(entity);
    }

    @Override
    public void persist(Gender entity) {
        super.persist(entity);
    }

    @Override
    public Gender getByKey(Integer key) {
        return  super.getByKey(key);
    }

    @Override
    public List<Gender> getAll(Class type) {
        return super.getAll(type);
    }

}
