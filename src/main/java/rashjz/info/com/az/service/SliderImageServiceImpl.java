/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rashjz.info.com.az.service;

import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rashjz.info.com.az.dao.SliderImageDao;
import rashjz.info.com.az.entity.SliderImage;

/**
 *
 * @author Azik
 */
@Service
@Transactional
public class SliderImageServiceImpl implements Serializable, SliderImageService{

    @Autowired
    SliderImageDao sliderImageDao;
    
    @Override
    public void delete(rashjz.info.com.az.entity.SliderImage entity) {
        sliderImageDao.delete(entity);
    }

    @Override
    public void update(rashjz.info.com.az.entity.SliderImage entity) {
        sliderImageDao.update(entity);
    }

    @Override
    public void persist(rashjz.info.com.az.entity.SliderImage entity) {
        sliderImageDao.persist(entity);
    }

    @Override
    public SliderImage getByKey(Integer key) {
        return sliderImageDao.getByKey(key);
    }

    @Override
    public List<SliderImage> getAll(Class type) {
        return sliderImageDao.getAll(type);
    }
    
    
    
}
