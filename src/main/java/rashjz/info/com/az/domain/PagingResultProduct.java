/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rashjz.info.com.az.domain;

import java.util.ArrayList;
import java.util.List;
import rashjz.info.com.az.entity.Products;

/**
 *
 * @author Azik
 */
public class PagingResultProduct {
    
    private List<Products> list = new ArrayList<>();
    private Integer totalResult = 0;
    private String catgs;
    private String brands;
    private String gendertype;
    private String title;
    private float price;
    private String toDate;
    private String fromDate;

    public String getGendertype() {
        return gendertype;
    }

    public void setGendertype(String gendertype) {
        this.gendertype = gendertype;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    
    
    public String getCatgs() {
        return catgs;
    }

    public void setCatgs(String catgs) {
        this.catgs = catgs;
    }

    public String getBrands() {
        return brands;
    }

    public void setBrands(String brands) {
        this.brands = brands;
    }

    public List<Products> getList() {
        return list;
    }

    public void setList(List<Products> list) {
        this.list = list;
    }

    public Integer getTotalResult() {
        return totalResult;
    }

    public void setTotalResult(Integer totalResult) {
        this.totalResult = totalResult;
    }
    
}
