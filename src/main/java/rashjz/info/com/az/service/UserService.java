/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rashjz.info.com.az.service;

import java.util.List;
import java.util.Map;
import javax.swing.SortOrder;
import org.hibernate.Criteria;
import rashjz.info.com.az.domain.PagingResult;
import rashjz.info.com.az.entity.Users;

/**
 *
 * @author Rashad Javadov
 */
public interface UserService {

    public List<Users> getAllUser();

    public Users findByUsername(String username);

    public Criteria createEntityCriteria();

    public void delete(Users entity);

    public void update(Users entity);

    public void persist(Users entity);

    public Users getByKey(Integer key);
    
    public PagingResult lazyLoadUsers(int first, int pageSize,
            String sortField,
            SortOrder sortOrder,
            Map<String, Object> filters);

    public Number lazyLoadUsersCount(int first, int pageSize,
            String sortField,
            SortOrder sortOrder,
            Map<String, Object> filters, PagingResult pagingResult);

}
