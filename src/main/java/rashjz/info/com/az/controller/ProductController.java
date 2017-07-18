/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rashjz.info.com.az.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import javax.swing.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import rashjz.info.com.az.domain.PagingResult;
import rashjz.info.com.az.entity.ProductImage;
import rashjz.info.com.az.entity.Products;
import rashjz.info.com.az.entity.SliderImage;
import rashjz.info.com.az.service.ProductImagesService;
import rashjz.info.com.az.service.ProductService;
import rashjz.info.com.az.service.SliderImageService;
import rashjz.info.com.az.util.ProductActionUtil;

/**
 *
 * @author Rashad Javadov
 */
@Controller
public class ProductController implements Serializable {

    private static final Logger LOG = Logger.getLogger(ProductController.class.getName());

    @Autowired
    private ProductService productService;

    @Autowired
    private SliderImageService sliderImageService;

    @Autowired
    private ProductImagesService productImagesService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String gethLoginPage(Model model) {

        List<ProductImage> listLast = productService.getLastProducts();
        List<ProductImage> listMost = productService.getMostProducts();
        List<SliderImage> listSilderImages = sliderImageService.getAll(SliderImage.class);
        model.addAttribute("menuClassActive", 0);//ana menu
        model.addAttribute("content", 1);
        model.addAttribute("listLast", listLast);
        model.addAttribute("listMost", listMost);
        model.addAttribute("listSilder", listSilderImages);
        return "index";
    }

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String getViewPage(@RequestParam(value = "code", required = true) Long dataID, Model model) {
        Products product = productService.getByKey(dataID.intValue());
        if (product != null) {
            List<Products> sameCatProducts = productService.getforcategory(product);
            List<ProductImage> imagesList = productImagesService.getProductImagesList(product);
            model.addAttribute("sameCatProducts", sameCatProducts);
            LOG.info("::::::::::::::: ::::::::: " + sameCatProducts);

            model.addAttribute("dataCode", dataID);
            model.addAttribute("product", product);
            model.addAttribute("images", imagesList);
        } else {
            return "products";
        }
        return "view";
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String getProductList(Model model,
            @RequestParam(value = "catgs", required = false) String catgs,
            @RequestParam(value = "brands", required = false) String brand,
            @RequestParam(value = "gendertype", required = false) String gendertype,
            @RequestParam(value = "keyValue", required = false) String keyValue,
            Integer offset, Integer maxResults) {
        LOG.info("::::::  offset " + offset + " catgs " + catgs + " brand " + brand + " gendertype " + gendertype + " keyValue " + keyValue);
        Map<String, Object> filters = new HashMap<>();
        List<Integer> categories = new ArrayList<>();
        List<Integer> brandsList = new ArrayList<>();
        PagingResult pagingData = new PagingResult();

        try {
            ProductActionUtil.convertStringtoList(categories, brandsList, catgs, brand);
            ProductActionUtil.settingFilter(model, categories, brandsList, filters, gendertype, keyValue);
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/products";
        }

        if (offset == null) {
            offset = 0;
        }

        pagingData = productService.lazyLoadProducts(offset.intValue(), 9, null, SortOrder.UNSORTED, filters);//1310 
        Number totalcount = productService.lazyLoadProductsCount(offset.intValue(), 9, null, SortOrder.UNSORTED, filters, pagingData);//1289

        pagingData.setTotalResult(totalcount.intValue());
        model.addAttribute("productList", pagingData.getList());
        model.addAttribute("count", pagingData.getTotalResult());
        model.addAttribute("offset", offset);
        return "product";
    }

}
