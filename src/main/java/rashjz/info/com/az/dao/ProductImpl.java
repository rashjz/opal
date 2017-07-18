/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rashjz.info.com.az.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import javax.swing.SortOrder;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;
import rashjz.info.com.az.domain.PagingResult;
import rashjz.info.com.az.entity.ProductImage;
import rashjz.info.com.az.entity.Products;
import rashjz.info.com.az.entity.Users;

/**
 *
 * @author Rashad Javadov
 */
@Repository
public class ProductImpl extends AbstractDao<Integer, Products> implements Serializable, ProductDao {

    private static final Logger LOG = Logger.getLogger(ProductImpl.class.getName());

    @Override
    public Criteria createEntityCriteria() {
        return super.createEntityCriteria(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Products entity) {
        super.delete(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Products entity) {
        super.update(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void persist(Products entity) {
        super.persist(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Products getByKey(Integer key) {
        return super.getByKey(key); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Products> getAll(Class type) {
        return super.getAll(type); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ProductImage> getLastProducts() {
        List<Products> listProductses = null;
        List<ProductImage> images = new ArrayList<>();
        Session session = getSession();
        try {
//            PagingResultImage result = new PagingResultImage();
            Criteria criteria = session.createCriteria(Products.class);
            criteria.addOrder(Order.desc("insertDate"));
            criteria.setMaxResults(5);
 
            listProductses = criteria.list();
            for (Products products : listProductses) {
                if (products.getProductImageCollection().size() > 0) {
                   images.add((ProductImage) products.getProductImageCollection().toArray()[0]);
                }
              
            } 
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return images;
    }

    @Override
    public List<ProductImage> getMostProducts() {
        List< Products> listProductses = new ArrayList<>();

        List< ProductImage> listImage = new ArrayList<>();
        Session session = getSession();
        try {
            Criteria criteria = session.createCriteria(Products.class);
            criteria.addOrder(Order.desc("viewCount"));
            criteria.setMaxResults(5);
            listProductses = criteria.list();
            for (int i = 0; i < listProductses.size(); i++) {
                Products p = listProductses.get(i);
                if (p.getProductImageCollection().size() > 0) {
                    listImage.add((ProductImage) p.getProductImageCollection().toArray()[0]);
                }
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return listImage;
    }

    @Override
    public PagingResult lazyLoadProducts(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
        LOG.info("lazyLoadProducts");
        PagingResult result = new PagingResult();
        Transaction trns = null;
        Session session = getSession();

        try {
            Criteria crit = session.createCriteria(Products.class, "p");

            if (filters != null && !filters.isEmpty()) {
                Iterator<Map.Entry<String, Object>> iterator = filters.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry<String, Object> entry = iterator.next();

                    if (entry.getKey().equals("categoryId")) {
                        List<Integer> list = (List<Integer>) entry.getValue();
                        //creating array of id where category in selected checkbox number 
//                        Restrictions.in "catId" means where condition in()
                        crit.createCriteria("p.categoryId", "categoryId", JoinType.INNER_JOIN, Restrictions.in("catId", list.toArray()));
                    }
                    if (entry.getKey().equals("brandId")) {
                        List<Integer> list = (List<Integer>) entry.getValue();
                        crit.createCriteria("p.brandId", "brandId", JoinType.INNER_JOIN, Restrictions.in("id", list.toArray()));
                    }
                    if (entry.getKey().equals("gendertype")) {
                        crit.createCriteria("p.genderId", "genderId", JoinType.INNER_JOIN, Restrictions.eq("genderId", Integer.valueOf(entry.getValue().toString())));
                    }
                    if (entry.getKey().equals("insertUsers")) {
                       
                        crit.createCriteria("p.insertUser", "insertUser", JoinType.INNER_JOIN, Restrictions.eq("userId", Integer.valueOf(entry.getValue().toString())));
                    }
                    if (entry.getKey().equals("keyValue")) {
                        crit = crit.add(Restrictions.like("title", entry.getValue().toString(), MatchMode.EXACT));
                    }
                }
            }
            crit = crit.setFirstResult(first).setMaxResults(pageSize);

            result.setList(crit.list());
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Number lazyLoadProductsCount(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters, PagingResult pagingResult) {
        LOG.info("lazyLoadProductsCount");
        PagingResult result = new PagingResult();
        Transaction trns = null;
        Session session = getSession();

        try {

            Criteria crit = session.createCriteria(Products.class, "p");
            crit.setProjection(Projections.rowCount());
            System.out.println("aaaaaa --------------- 1");
            if (filters != null && !filters.isEmpty()) {
                Iterator<Map.Entry<String, Object>> iterator = filters.entrySet().iterator();
                while (iterator.hasNext()) {
                    System.out.println("aaaaaa --------------- 2");
                    Map.Entry<String, Object> entry = iterator.next();
                    if (entry.getKey().equals("categoryId")) {
                        List<Integer> list = (List<Integer>) entry.getValue();
                        //creating array of id where category in selected checkbox number 
//                        Restrictions.in "catId" means where condition in() 
                        crit.createCriteria("p.categoryId", "categoryId", JoinType.INNER_JOIN, Restrictions.in("catId", list.toArray()));
                    }

                    if (entry.getKey().equals("brandId")) {
                        List<Integer> list = (List<Integer>) entry.getValue();
                        crit.createCriteria("p.brandId", "brandId", JoinType.INNER_JOIN, Restrictions.in("id", list.toArray()));
                    }
                    if (entry.getKey().equals("gendertype")) {
                        crit.createCriteria("p.genderId", "genderId", JoinType.INNER_JOIN, Restrictions.eq("genderId", Integer.valueOf(entry.getValue().toString())));
                    }
                    
                    if (entry.getKey().equals("keyValue")) {
                        crit = crit.add(Restrictions.like("title", entry.getValue().toString(), MatchMode.EXACT));
                    }
                }
            }
            Long resultCount = (Long) crit.uniqueResult();
            pagingResult.setTotalResult(resultCount.intValue());
            return resultCount;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public PagingResult lazyLoadProductsAdmin(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
        PagingResult result = new PagingResult();
        LOG.info("first " + first + " pageSize " + pageSize + " sortField " + sortField + " SortOrder " + sortOrder);
        Transaction trns = null;
        Session session = getSession();
        try {
            System.out.println("aaaaaa --------------- 1");
            Criteria crit = session.createCriteria(Products.class , "p");
            if (filters != null && !filters.isEmpty()) {
                Iterator<Map.Entry<String, Object>> iterator = filters.entrySet().iterator();
                while (iterator.hasNext()) {
                    
                    Map.Entry<String, Object> entry = iterator.next();
                    LOG.info("getKey " + entry.getKey() + " Value " + entry.getValue());
                    if (entry.getKey().equals("title")) {
                        crit.add(Restrictions.like(entry.getKey(), entry.getValue().toString(), MatchMode.ANYWHERE));
                    } else if (entry.getKey().equals("price")) { 
                        crit.add(Restrictions.eq(entry.getKey(), entry.getValue()));
                    }  
                    else if (entry.getKey().equals("toDate")) { 
                        crit.add(Expression.ge("insertDate", entry.getValue()));           
                    }else if (entry.getKey().equals("fromDate")) { 
                        crit.add(Expression.le("insertDate", entry.getValue())); 
                    } 
                    else if (entry.getKey().equals("categoryId")) {
                        crit.createCriteria("p.categoryId", "categoryId", JoinType.INNER_JOIN, Restrictions.eq("catId", entry.getValue()));
                    } 
                    else if (entry.getKey().equals("genderId")) {
                         crit.createCriteria("p.genderId", "genderId", JoinType.INNER_JOIN, Restrictions.eq("genderId",entry.getValue()));
                    } 
                    else if (entry.getKey().equals("brandId")) {
                         crit.createCriteria("p.brandId", "brandId", JoinType.INNER_JOIN, Restrictions.eq("id",entry.getValue()));
                    }
                    else if (entry.getKey().equals("insertUser")) {
                   crit.createCriteria("p.insertUser", "insertUser", JoinType.INNER_JOIN, Restrictions.eq("userId", Integer.valueOf(entry.getValue().toString())));
                    }
                }
            }
            crit = crit.setFirstResult(first).setMaxResults(pageSize);
            result.setList(crit.list());
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Number lazyLoadProductsCountAdmin(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters, PagingResult pagingResult) {
        PagingResult result = new PagingResult();
        LOG.info("first " + first + " pageSize " + pageSize + " sortField " + sortField + " SortOrder " + sortOrder);
        Transaction trns = null;
        Session session = getSession();
        try {
            Criteria crit = session.createCriteria(Products.class, "p");
            crit.setProjection(Projections.rowCount());
            if (filters != null && !filters.isEmpty()) {
                Iterator<Map.Entry<String, Object>> iterator = filters.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry<String, Object> entry = iterator.next();
                    LOG.info("getKey " + entry.getKey() + " Value " + entry.getValue());
                    if (entry.getKey().equals("title")) {
                        crit.add(Restrictions.like(entry.getKey(), entry.getValue().toString(), MatchMode.ANYWHERE));
                    } else if (entry.getKey().equals("price")) {
                        crit.add(Restrictions.eq(entry.getKey(), entry.getValue()));
                    } else if (entry.getKey().equals("toDate")) { 
                        crit.add(Expression.ge("insertDate", entry.getValue()));           
                    }else if (entry.getKey().equals("fromDate")) { 
                        crit.add(Expression.le("insertDate", entry.getValue())); 
                    } 
                    else if (entry.getKey().equals("categoryId")) {
                        crit.createCriteria("p.categoryId", "categoryId", JoinType.INNER_JOIN, Restrictions.eq("catId",entry.getValue()));
                    } else if (entry.getKey().equals("genderId")) {
                        crit.createCriteria("p.genderId", "genderId", JoinType.INNER_JOIN, Restrictions.eq("genderId",entry.getValue()));
                    } else if (entry.getKey().equals("brandId")) {
                        crit.createCriteria("p.brandId", "brandId", JoinType.INNER_JOIN, Restrictions.eq("id",entry.getValue()));
                    } else if (entry.getKey().equals("insertUser")) {
                        System.out.println("aaaaaa  azer azer " +entry.getValue().toString());
                        crit.createCriteria("p.insertUser", "insertUser", JoinType.INNER_JOIN, Restrictions.eq("userId", Integer.valueOf(entry.getValue().toString())));
                    }
                }
            }

            Long resultCount = (Long) crit.uniqueResult();
            pagingResult.setTotalResult(resultCount.intValue());
            return resultCount;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Products> getforcategory(Products product) {
        List<Products> list = null;
        Criteria crit = null;
        try {
            crit = getSession().createCriteria(Products.class, "p");
            crit.createCriteria("p.categoryId", "categoryId", JoinType.INNER_JOIN, Restrictions.eq("catId", product.getCategoryId().getCatId()));
            crit.add(Restrictions.ne("pId", product.getPId()));
            crit.setMaxResults(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return crit.list();
    }

}
