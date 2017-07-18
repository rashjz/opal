/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rashjz.info.com.az.dao;

import java.util.List;
import org.hibernate.Criteria;
import rashjz.info.com.az.entity.Faq;
import rashjz.info.com.az.entity.Products;

/**
 *
 * @author Azik
 */
public interface FAQDao {
    
    public Criteria createEntityCriteria();

    public void delete(Faq entity);

    public void update(Faq entity);

    public void persist(Faq entity);

    public Faq getByKey(Integer key);
    
    public List<Faq> getAll(Class<Faq> type);
    
}
