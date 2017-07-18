/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rashjz.info.com.az.dao;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.swing.SortOrder;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.apache.log4j.Logger; 
import org.springframework.stereotype.Repository;
import rashjz.info.com.az.domain.PagingResult;
import rashjz.info.com.az.entity.Brand;
import rashjz.info.com.az.entity.Users;

/**
 *
 * @author Azik
 */
@Repository
public class BrandCategoryImpl extends AbstractDao<Integer, Brand> implements Serializable, BrandCategoryDao{

    private static final Logger LOG = Logger.getLogger(BrandCategoryImpl.class.getName());
    @Override
    public Criteria createEntityCriteria() {
        return super.createEntityCriteria();
    }

    @Override
    public void delete(Brand entity) {
        super.delete(entity);
    }

    @Override
    public void update(Brand entity) {
        super.update(entity);   
    }
    

    @Override
    public void persist(Brand entity) {
        super.persist(entity);
    }

    @Override
    public Brand getByKey(Integer key) {
       return super.getByKey( key );
    }

    @Override
    public List<Brand> getAll(Class type) {
      return super.getAll(type);
    }

    @Override
    public PagingResult lazyLoadBrands(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
       PagingResult result = new PagingResult();
       LOG.info("first " + first + " pageSize " + pageSize + " sortField " + sortField + " SortOrder " + sortOrder);
       Transaction trns=null;
       Session session=getSession();
        try {
            Criteria crit=session.createCriteria(Brand.class);          
            if(filters != null && !filters.isEmpty()){
                Iterator<Map.Entry<String, Object>> iterator = filters.entrySet().iterator();         
                while (iterator.hasNext()) {
                    Map.Entry<String, Object> entry = iterator.next();
                    LOG.info("getKey " + entry.getKey() + " Value " + entry.getValue());
                    if (entry.getKey().equals("name")) {    
                        crit.add(Restrictions.like(entry.getKey(), entry.getValue().toString(), MatchMode.ANYWHERE));
                    } 
                }
            }
            crit = crit.setFirstResult(first).setMaxResults(pageSize);
            result.setList(crit.list());
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Number lazyLoadBrandsCount(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters, PagingResult pagingResult) {
       PagingResult result = new PagingResult();
       LOG.info("first " + first + " pageSize " + pageSize + " sortField " + sortField + " SortOrder " + sortOrder);
       Transaction trns=null;
       Session session=getSession();
        try {
            Criteria crit=session.createCriteria(Brand.class);
           crit.setProjection(Projections.rowCount());
            if(filters != null && !filters.isEmpty()){
                
                Iterator<Map.Entry<String, Object>> iterator = filters.entrySet().iterator();         
                while (iterator.hasNext()) {
                    Map.Entry<String, Object> entry = iterator.next();
                    LOG.info("getKey " + entry.getKey() + " Value " + entry.getValue());
                    if (entry.getKey().equals("name")) {    
                        crit.add(Restrictions.like(entry.getKey(), entry.getValue().toString(), MatchMode.ANYWHERE));
                    } 
                }
            }
           
            Long resultCount = (Long) crit.uniqueResult();
            pagingResult.setTotalResult(resultCount.intValue());
            return resultCount;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
