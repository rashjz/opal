/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rashjz.info.com.az.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import rashjz.info.com.az.domain.EmptyCard;
import rashjz.info.com.az.entity.OrderMessage;
import rashjz.info.com.az.entity.OrderStatus;
import rashjz.info.com.az.entity.Orders;
import rashjz.info.com.az.entity.Products;
import rashjz.info.com.az.entity.Users;
import rashjz.info.com.az.service.OrderMessageService;
import rashjz.info.com.az.service.OrderService;
import rashjz.info.com.az.service.ProductService;
import rashjz.info.com.az.util.AuthoritiesConverter;

/**
 * @author Rashad Javadov
 */
@Controller
public class CardController implements Serializable {

    private static final Logger logger = Logger.getLogger(CardController.class.getName());
    @Autowired
    OrderService orderService;
    @Autowired
    OrderMessageService orderMessageService;
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/checkout", method = RequestMethod.GET)
    public String getcheckoutPage(Model model, @RequestParam(value = "typeId", required = false) Integer typeId) {
        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser")) {
            return "redirect:/login";
        } else {
            if (typeId == null) {
                typeId = 3;//standart sebet
            }
            Users entity = AuthoritiesConverter.getUserObject().getUsers();
            List<Orders> orders = orderService.getByUserId(entity, typeId);
            Double totalPrice = orderService.getTotalAmountByUserId(entity, typeId);
            if (orders != null) {
                model.addAttribute("total", orders.size());
                model.addAttribute("price", totalPrice);
            } else {
                model.addAttribute("total", 0);
            }
            model.addAttribute("typeId", typeId);
            model.addAttribute("orders", orders);
        }
        return "checkout";
    }

    @RequestMapping(value = "/emptycard", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public EmptyCard emptyMycard(@RequestBody EmptyCard card) {
        logger.info("emptyMycard : " + card.toString() + " " + card.getOrderid());
        try {
            Integer a = Double.valueOf(card.getTotal()).intValue() - Double.valueOf(card.getCount()).intValue();
            card.setTotal(a.toString());
            //
            Orders orders = orderService.getByKey(card.getOrderid());
            OrderStatus orderStatus = new OrderStatus();
            orderStatus.setId(4);
            orders.setStatusId(orderStatus);

            orderService.update(orders);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return card;
    }

    //    @PreAuthorize("ROLE_ADMIN")
    @RequestMapping(value = "/addtocard", method = RequestMethod.POST)
    public String getAddToCard(HttpServletRequest request, HttpServletResponse response, Model model) {
        logger.info("---------------- quantity : " + request.getParameter("quantity") + " pId " + request.getParameter("code"));
        Integer pid = Integer.parseInt(request.getParameter("code"));
        Products products = productService.getByKey(pid);
        Orders orders = new Orders();
        orders.setUserId(AuthoritiesConverter.getUserObject().getUsers());
        orders.setInsertDate(new Date());
        orders.setProductId(products);
        OrderStatus orderStatus = new OrderStatus();
        orderStatus.setId(3);//sebetde
        orders.setStatusId(orderStatus);
        orders.setCount(Integer.parseInt(request.getParameter("quantity")));
        orderService.persist(orders);
        return "redirect:/checkout";
    }

    @RequestMapping(value = "/ordermessage", method = RequestMethod.POST)
    @ResponseBody
    public String gettestPage(@RequestBody OrderMessage message) {
        try {
            Users entity = AuthoritiesConverter.getUserObject().getUsers();
            message.setUserId(entity);
            message.setInsertDate(new Date());
            message.setStatus("1");
            logger.info(message.toString());
            orderMessageService.persist(message);
            return "success";
        } catch (Exception e) {
            return "error";
        }
    }
}
