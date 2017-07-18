/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rashjz.info.com.az.service;

import java.util.List;
import rashjz.info.com.az.entity.SliderImage;

/**
 *
 * @author Azik
 */
public interface SliderImageService {

    public void delete(SliderImage entity);

    public void update(SliderImage entity);

    public void persist(SliderImage entity);

    public SliderImage getByKey(Integer key);

    public List<SliderImage> getAll(Class<SliderImage> type);

}
