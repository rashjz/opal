/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rashjz.info.com.az.service;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rashjz.info.com.az.dao.FAQDao;
import rashjz.info.com.az.entity.Faq;

/**
 *
 * @author Azik
 */
@Service
@Transactional
public class FaqServiceImpl implements Serializable, FaqService{

    @Autowired
    private FAQDao faqDao;
    
    @Override
    public Criteria createEntityCriteria() {
        return faqDao.createEntityCriteria();
    }

    @Override
    public void delete(Faq entity) {
        faqDao.delete(entity);
    }

    @Override
    public void update(Faq entity) {
        faqDao.update(entity);
    }

    @Override
    public void persist(Faq entity) {
        faqDao.persist(entity);
    }

    @Override
    public Faq getByKey(Integer key) {
        return faqDao.getByKey(key);
    }

    @Override
    public List<Faq> getAll(Class<Faq> type) {
        return faqDao.getAll(type);
    }

    @Override
    public void AddOrUpdateFaq(Faq faq) {
        if (faq.getId()==null || faq.getId()==0) {
            faqDao.persist(faq); 
        }else{
            faqDao.update(faq); 
        }
    }
    
    
    
}
