/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rashjz.info.com.az.service;

import java.util.List;
import java.util.Map;
import javax.swing.SortOrder;
import org.hibernate.Criteria;
import rashjz.info.com.az.domain.PagingResult;
import rashjz.info.com.az.entity.Brand;

/**
 *
 * @author Azik
 */
public interface BrandCategoryService {
    
    public Criteria createEntityCriteria();

    public void delete(Brand  entity);

    public void update(Brand entity);

    public void persist(Brand entity);
    
    public Brand getByKey(Integer key);
    
    public void AddOrUpdateBrand(Brand brand);
    
    public List<Brand> getAll(Class<Brand> type);
    
    public PagingResult lazyLoadBrands(int first, int pageSize,
            String sortField,
            SortOrder sortOrder,
            Map<String, Object> filters);

    public Number lazyLoadBrandsCount(int first, int pageSize,
            String sortField,
            SortOrder sortOrder,
            Map<String, Object> filters, PagingResult pagingResult);
    
}
