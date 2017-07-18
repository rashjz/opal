/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rashjz.info.com.az.service;

import java.util.List;
import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rashjz.info.com.az.dao.ProductImagesDao;
import rashjz.info.com.az.entity.ProductImage;
import rashjz.info.com.az.entity.Products;

/**
 *
 * @author Azik
 */
@Service
@Transactional
public class ProductImagesServiceImpl implements ProductImagesService{
   
    @Autowired
    ProductImagesDao productImagesDao;

    @Override
    public Criteria createEntityCriteria() {
        return productImagesDao.createEntityCriteria();
    }

    @Override
    public void delete(ProductImage entity) {
        productImagesDao.delete(entity);
    }

    @Override
    public void update(ProductImage entity) {
        productImagesDao.update(entity);
    }

    @Override
    public void persist(ProductImage entity) {
        productImagesDao.persist(entity);
    }

    @Override
    public ProductImage getByKey(Integer key) {
       return productImagesDao.getByKey(key);
    }

    @Override
    public List<ProductImage> getAll(Class<ProductImage> type) {
       return productImagesDao.getAll(type);
    }

    @Override
    public List<ProductImage> getProductImagesList(Products pId) {
        return productImagesDao.getProductImagesList(pId);
    }

    @Override
    public List<ProductImage> getImagesSlide(String statusId) {
        return productImagesDao.getImagesSlide(statusId);
    }
    
    
}
