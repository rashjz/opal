/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rashjz.info.com.az.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import rashjz.info.com.az.entity.Brand;
import rashjz.info.com.az.entity.Category;
import rashjz.info.com.az.entity.ProductImage;
import rashjz.info.com.az.entity.Products;

/**
 *
 * @author Azik
 */
@Repository
public class ProductImagesDaoImpl  extends AbstractDao<Integer, ProductImage> implements Serializable,ProductImagesDao{

    
    @Override
    public ProductImage getByKey(Integer key) {
        return super.getByKey( key );
    }

    @Override
    public List<ProductImage> getAll(Class type) {
        return super.getAll(type);
    }

    @Override
    public Criteria createEntityCriteria() {
       return super.createEntityCriteria();
    }

    @Override
    public void delete(ProductImage entity) {
        super.delete(entity);
    }

    @Override
    public void update(ProductImage entity) {
        super.update(entity);
    }

    @Override
    public void persist(ProductImage entity) {
        super.persist(entity);
    }

    @Override
    public List<ProductImage> getProductImagesList(Products pId) {
        List<ProductImage> listImages=new ArrayList<>();
        try {
            Criteria criteria=getSession().createCriteria(ProductImage.class);
            criteria.add(Restrictions.eq("productId", pId));
            listImages=criteria.list(); 
            return  listImages;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ProductImage> getImagesSlide(String statusId) {
        List<ProductImage> listImages=new ArrayList<>();
        try {
            Criteria criteria=getSession().createCriteria(ProductImage.class);
            criteria.add(Restrictions.eq("status", statusId));
            listImages=criteria.list();
            return  listImages;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
