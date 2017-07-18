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
import rashjz.info.com.az.entity.ContactMessages;
import rashjz.info.com.az.entity.ProductImage;
import rashjz.info.com.az.entity.SliderImage;

/**
 *
 * @author Azik
 */
@Repository
public class SliderImageDaoImpl extends AbstractDao<Integer, SliderImage> implements Serializable, SliderImageDao{

    @Override
    public void delete(rashjz.info.com.az.entity.SliderImage entity) {
        super.delete(entity);
    }

    @Override
    public void update(rashjz.info.com.az.entity.SliderImage entity) {
        super.update(entity);
    }

    @Override
    public void persist(rashjz.info.com.az.entity.SliderImage entity) {
        super.persist(entity);
    }

    @Override
    public SliderImage getByKey(Integer key) {
        return super.getByKey(key);
    }

    @Override
    public List<SliderImage> getAll(Class type) {
        List<SliderImage> listImages=new ArrayList<>();
        try {
            Criteria criteria=getSession().createCriteria(SliderImage.class);
//            criteria.add(Restrictions.eq("status",1));
            criteria.setMaxResults(3);
            listImages=criteria.list(); 
            System.out.println("---*-*-*-*-*-*-*-*-*---"+listImages);
            return  listImages;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
