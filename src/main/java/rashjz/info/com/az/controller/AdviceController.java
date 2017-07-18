/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rashjz.info.com.az.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import rashjz.info.com.az.domain.ListWrapper;
import rashjz.info.com.az.entity.Brand;
import rashjz.info.com.az.entity.Category;
import rashjz.info.com.az.entity.Gender;
import rashjz.info.com.az.entity.OrderMessage;
import rashjz.info.com.az.entity.Orders;
import rashjz.info.com.az.service.BrandCategoryService;
import rashjz.info.com.az.service.CategoryService;
import rashjz.info.com.az.service.GenderCategoryServise;
import rashjz.info.com.az.service.OrderMessageService;
import rashjz.info.com.az.service.OrderService;

/**
 *
 * @author Rashad Javadov
 */
@ControllerAdvice
class AdviceController {

    public static final String DEFAULT_ERROR_VIEW = "error";

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private BrandCategoryService brandCategoryService;

    @Autowired
    private GenderCategoryServise genderCategoryServise;
    
     @Autowired
    OrderService orderService;
    
    @Autowired
    OrderMessageService orderMessageService;
    
     @ModelAttribute("messageListCount")
    public long mesaageListCount() {
        long list = orderMessageService.getMessageListCount("1");
        return list;
    }
     @ModelAttribute("newMessageList")
    public List<OrderMessage> populateategoryList() {
        List<OrderMessage> newMessageList = orderMessageService.getMessageList("1");
        return newMessageList;
    }
     @ModelAttribute("orderCount")
    public long orderListCount() {
        long list = orderService.getByStatusType(5).size();
        return list;
    }
     @ModelAttribute("newOrderList")
    public List<Orders> newOrderList() {
        List<Orders> newOrderList = orderService.getByStatusType(5);
        return newOrderList;
    }

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        // If the exception is annotated with @ResponseStatus rethrow it and let
        // the framework handle it - like the OrderNotFoundException example
        // at the start of this post.
        // AnnotationUtils is a Spring Framework utility class.
        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) {
            throw e;
        }

        // Otherwise setup and send the user to a default error-view.
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName(DEFAULT_ERROR_VIEW);
        return mav;

    }

    @ModelAttribute("listWrapper")
    public ListWrapper BrendCatList() {
        ListWrapper listWrapper = new ListWrapper();
        listWrapper.setCategoryList(categoryService.getAll(Category.class));
        listWrapper.setBrandCatList(brandCategoryService.getAll(Brand.class));
        listWrapper.setGenders(genderCategoryServise.getAll(Gender.class));
        return listWrapper;
    }

//    @InitBinder
//    public void initBinder(WebDataBinder webDataBinder) {
//        webDataBinder.setBindEmptyMultipartFiles(false);
//    }
}
