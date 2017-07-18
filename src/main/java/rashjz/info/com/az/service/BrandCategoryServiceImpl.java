/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rashjz.info.com.az.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.swing.SortOrder;
import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rashjz.info.com.az.dao.BrandCategoryDao;
import rashjz.info.com.az.domain.PagingResult;
import rashjz.info.com.az.entity.Brand;

/**
 *
 * @author Azik
 */
@Service
@Transactional
public class BrandCategoryServiceImpl implements Serializable,  BrandCategoryService{

    @Autowired
    private BrandCategoryDao brandCategoryDao;
    
    
    @Override
    public Criteria createEntityCriteria() {
       return brandCategoryDao.createEntityCriteria();
    }

    @Override
    public void delete(Brand entity) {
        brandCategoryDao.delete(entity);
    }

    @Override
    public void update(Brand entity) {
       brandCategoryDao.update(entity);
    }

    @Override
    public void persist(Brand entity) {
        brandCategoryDao.persist(entity);
    }

    @Override
    public Brand getByKey(Integer key) {
       return brandCategoryDao.getByKey(key);
    }

    @Override
    public List<Brand> getAll(Class<Brand> type) {
      return brandCategoryDao.getAll(type);
    }

    @Override
    public void AddOrUpdateBrand(Brand brand) {
        if (brand.getId()==null || brand.getId()==0) {
            brandCategoryDao.persist(brand);
        }else{
            brandCategoryDao.update(brand);
        }
    }

    @Override
    public PagingResult lazyLoadBrands(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
        
        return brandCategoryDao.lazyLoadBrands(first, pageSize, sortField, sortOrder, filters);
    }

    @Override
    public Number lazyLoadBrandsCount(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters, PagingResult pagingResult) {
        return brandCategoryDao.lazyLoadBrandsCount(first, pageSize, sortField, sortOrder, filters, pagingResult);
    }
    
}
