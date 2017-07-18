/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rashjz.info.com.az.dao;

import java.util.List;
import rashjz.info.com.az.entity.ContactMessages;

/**
 *
 * @author Rashad Javadov
 */
public interface ContactMessageDao {

    public void delete(ContactMessages entity);

    public void update(ContactMessages entity);

    public void persist(ContactMessages entity);

    public ContactMessages getByKey(Integer key);

    public List<ContactMessages> getAll(Class<ContactMessages> type);
}
