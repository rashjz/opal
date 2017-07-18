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
import rashjz.info.com.az.domain.PagingResult;
import rashjz.info.com.az.entity.ProductImage;
import rashjz.info.com.az.entity.Products;

/**
 *
 * @author Rashad Javadov
 */
public interface ProductService {

    public Criteria createEntityCriteria();

    public void delete(Products entity);

    public void update(Products entity);

    public void persist(Products entity);
    
    public void AddOrUpdateProduct(Products product);

    public Products getByKey(Integer key);

    public List<ProductImage> getLastProducts();

    public List<ProductImage> getMostProducts();

    public List<Products> getAll(Class<Products> type);

    public PagingResult lazyLoadProducts(int first, int pageSize,
            String sortField,
            SortOrder sortOrder,
            Map<String, Object> filters);

    public Number lazyLoadProductsCount(int first, int pageSize,
            String sortField,
            SortOrder sortOrder,
            Map<String, Object> filters, PagingResult pagingResult);

    public PagingResult lazyLoadProductsAdmin(int first, int pageSize,
            String sortField,
            SortOrder sortOrder,
            Map<String, Object> filters);

    public Number lazyLoadProductsCountAdmin(int first, int pageSize,
            String sortField,
            SortOrder sortOrder,
            Map<String, Object> filters, PagingResult pagingResult);

    public List<Products> getforcategory(Products product);
}
