/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rashjz.info.com.az.domain;

import java.util.List;
import rashjz.info.com.az.entity.Brand;
import rashjz.info.com.az.entity.Category;
import rashjz.info.com.az.entity.Gender;

/**
 *
 * @author rasha_000
 */
public class ListWrapper {

    private List<Category> categoryList;
    private List<Brand> brandCatList;
    List<Gender> genders;

    public List<Gender> getGenders() {
        return genders;
    }

    public void setGenders(List<Gender> genders) {
        this.genders = genders;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public List<Brand> getBrandCatList() {
        return brandCatList;
    }

    public void setBrandCatList(List<Brand> brandCatList) {
        this.brandCatList = brandCatList;
    }

    @Override
    public String toString() {
        return "ListWrapper{" + "categoryList=" + categoryList + ", brandCatList=" + brandCatList + '}';
    }

}
