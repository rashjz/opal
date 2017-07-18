/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rashjz.info.com.az.dao;

import java.io.Serializable;
import java.util.List;
import org.springframework.stereotype.Repository;
import rashjz.info.com.az.entity.ContactMessages;

/**
 *
 * @author Rashad Javadov
 */
@Repository
public class ContactMessageImpl extends AbstractDao<Integer, ContactMessages> implements Serializable, ContactMessageDao {

    @Override
    public void delete(ContactMessages entity) {
        super.delete(entity);
    }

    @Override
    public void update(ContactMessages entity) {
        super.update(entity);
    }

    @Override
    public void persist(ContactMessages entity) {
        super.persist(entity);
    }

    @Override
    public ContactMessages getByKey(Integer key) {
        return super.getByKey(key);
    }

    @Override
    public List<ContactMessages> getAll(Class type) {
        return super.getAll(type);
    }

}
