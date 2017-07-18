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
import rashjz.info.com.az.dao.ProductDao;
import rashjz.info.com.az.domain.PagingResult;
import rashjz.info.com.az.entity.ProductImage;
import rashjz.info.com.az.entity.Products;

/**
 *
 * @author Rashad Javadov
 */
@Service
@Transactional
public class ProductServiceImpl implements Serializable, ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Criteria createEntityCriteria() {
        return productDao.createEntityCriteria();
    }

    @Override
    public void delete(Products entity) {
        productDao.delete(entity);
    }

    @Override
    public void update(Products entity) {
        productDao.update(entity);
    }

    @Override
    public void persist(Products entity) {
        productDao.persist(entity);
    }

    @Override
    public Products getByKey(Integer key) {
        return productDao.getByKey(key);
    }

    @Override
    public List<Products> getAll(Class<Products> type) {
        return productDao.getAll(type);
    }

    @Override
    public List<ProductImage> getLastProducts() {
        return productDao.getLastProducts();
    }

    @Override
    public List<ProductImage> getMostProducts() {
        return productDao.getMostProducts();
    }

    @Override
    public PagingResult lazyLoadProducts(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
        return productDao.lazyLoadProducts(first, pageSize, sortField, sortOrder, filters);
    }

    @Override
    public Number lazyLoadProductsCount(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters, PagingResult pagingResult) {
        return productDao.lazyLoadProductsCount(first, pageSize, sortField, sortOrder, filters, pagingResult);
    }

    @Override
    public PagingResult lazyLoadProductsAdmin(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
        return productDao.lazyLoadProductsAdmin(first, pageSize, sortField, sortOrder, filters);
    }

    @Override
    public Number lazyLoadProductsCountAdmin(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters, PagingResult pagingResult) {
        return productDao.lazyLoadProductsCountAdmin(first, pageSize, sortField, sortOrder, filters, pagingResult);
    }

    @Override
    public List<Products> getforcategory(Products product) {
        return productDao.getforcategory(product);
    }

    @Override
    public void AddOrUpdateProduct(Products product) {
 
        if (product.getPId()==null || product.getPId()==0) {
            System.out.println("---------------------- 1");
            System.out.println("-------------------------------- "+product.toString());
            productDao.persist(product);
        }else{
            productDao.update(product);
        }
    }
    

}
