/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rashjz.info.com.az.domain;

import java.util.ArrayList;
import java.util.List;
import rashjz.info.com.az.entity.Products;
import rashjz.info.com.az.entity.Users;

/**
 *
 * @author Mobby
 */
public class PagingResult implements java.io.Serializable {

    private List<Products> list = new ArrayList<>();
    private Integer totalResult = 0;
    private String catgs;
    private String brands;

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
