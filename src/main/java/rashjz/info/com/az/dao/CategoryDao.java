/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rashjz.info.com.az.dao;

import java.util.List;
import org.hibernate.Criteria;
import rashjz.info.com.az.entity.Category;
import rashjz.info.com.az.entity.Products;


/**
 *
 * @author Azik
 */
public interface CategoryDao {
    
    public Criteria createEntityCriteria();

    public void delete(Category entity);

    public void update(Category entity);

    public void persist(Category entity);
    
    public Category getByKey(Integer key);
    
    public List<Category> getAll(Class<Category> type);
    
}
