/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rashjz.info.com.az.service;

import java.util.List;
import org.hibernate.Criteria;
import rashjz.info.com.az.entity.ProductImage;
import rashjz.info.com.az.entity.Products;

/**
 *
 * @author Azik
 */
public interface ProductImagesService {
    
         public Criteria createEntityCriteria();

    public void delete(ProductImage entity);

    public void update(ProductImage entity);

    public void persist(ProductImage entity);
    
    public ProductImage getByKey(Integer key);
    
    public List<ProductImage> getProductImagesList(Products pId);
    
     public List<ProductImage> getImagesSlide(String statusId);
    
    public List<ProductImage> getAll(Class<ProductImage> type);
}
