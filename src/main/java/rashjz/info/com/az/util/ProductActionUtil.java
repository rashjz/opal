/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rashjz.info.com.az.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import org.springframework.ui.Model;
import rashjz.info.com.az.domain.ListWrapper;
import rashjz.info.com.az.entity.Brand;
import rashjz.info.com.az.entity.Category;

/**
 *
 * @author Mobby
 */
public class ProductActionUtil {

    private static final Logger LOG = Logger.getLogger(ProductActionUtil.class.getName());

//    public static void getListInt(ListWrapper listWrapper, List<Integer> categories, List<Integer> brandsList) {
//        for (Category category : listWrapper.getCategoryList()) {
//            if (category.action == true) {
//                categories.add(category.getCatId());
//            }
//        }
//        for (Brand category : listWrapper.getBrandCatList()) {
//            if (category.action == true) {
//                brandsList.add(category.getId());
//            }
//        }
//    }
    public static void settingFilter(Model model, List<Integer> categories, List<Integer> brandsList, Map<String, Object> filters, String gendertype, String keyValue) {

        if (brandsList.size() > 0) {
            filters.put("brandId", brandsList);
            //paginationa elave etmek ucun
            model.addAttribute("brands", brandsList.toString()); //brands.toString();

        }
        if (categories.size() > 0) {
            filters.put("categoryId", categories);
            model.addAttribute("catgs", categories.toString());

            if (categories.size() == 1) {
                model.addAttribute("menuClassActive", categories.get(0));
            }
        }

        if (gendertype != null && !gendertype.equals("")) {
            filters.put("gendertype", gendertype);
            model.addAttribute("gendertype", gendertype);
        }
        if (keyValue != null && !keyValue.equals("")) {
            filters.put("keyValue", keyValue);
            model.addAttribute("keyValue", keyValue);
        }

    }

    public static void convertStringtoList(List<Integer> categories, List<Integer> brandsList, String catgs, String brand) {
        if (catgs != null && !catgs.equals("") && !catgs.equals("[]")) {
            LOG.info(catgs + "''''''''''''''''''''''''''catgs " + catgs + " && !catgs.equals(\"\")''''''''''''''''''''''''''");
            //categoryden varsa  pagination ile yoxlayanda 
            String[] resplit = catgs.toString().substring(1, catgs.toString().length() - 1).split(",");

            for (String index : resplit) {
                categories.add(Integer.parseInt(index));
            }
        }
        if (brand != null && !brand.equals("") && !brand.equals("[]")) {
            //categoryden varsa  pagination ile yoxlayanda 
            String[] resplit = brand.toString().substring(1, brand.toString().length() - 1).split(",");
            for (String index : resplit) {
                brandsList.add(Integer.parseInt(index));
            }
        }

    }
}
