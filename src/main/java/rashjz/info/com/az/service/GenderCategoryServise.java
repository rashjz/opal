/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rashjz.info.com.az.service;

import java.util.List;
import org.hibernate.Criteria;
import rashjz.info.com.az.entity.Gender;

/**
 *
 * @author Azik
 */
public interface GenderCategoryServise {
    
    public Criteria createEntityCriteria();

    public void delete(Gender entity);

    public void update(Gender entity);

    public void persist(Gender entity);
    
    public Gender getByKey(Integer key);
    
    public List<Gender> getAll(Class<Gender> type);
    
}
