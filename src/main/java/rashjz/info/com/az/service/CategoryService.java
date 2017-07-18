/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rashjz.info.com.az.service;

import java.util.List;
import org.hibernate.Criteria;
import rashjz.info.com.az.entity.Category;

/**
 *
 * @author Azik
 */
public interface CategoryService {

    public Criteria createEntityCriteria();

    public void delete(Category entity);

    public void update(Category entity);

    public void persist(Category entity);

    public Category getByKey(Integer key);

    public void AddOrUpdateUser(Category category);

    public List<Category> getAll(Class<Category> type);

}
