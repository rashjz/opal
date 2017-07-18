/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rashjz.info.com.az.AdminController;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import rashjz.info.com.az.controller.CardController;
import rashjz.info.com.az.entity.Gender;
import rashjz.info.com.az.entity.OrderMessage;
import rashjz.info.com.az.entity.Products;
import rashjz.info.com.az.entity.Users;
import rashjz.info.com.az.service.OrderMessageService;
import rashjz.info.com.az.util.AuthoritiesConverter;

/**
 *
 * @author Azik
 */
@Controller
@RequestMapping("/admin")
public class OrderMessageController implements Serializable {

    private static final Logger logger = Logger.getLogger(OrderMessageController.class.getName());

    @Autowired
    OrderMessageService orderMessageService;

    
    
    @RequestMapping(value = "/listMassage", method = RequestMethod.GET)
    public String messageList(Model model) {

        List<OrderMessage> messageList = orderMessageService.getAll(OrderMessage.class);
        List<OrderMessage> unreadMessageList = orderMessageService.getMessageList("1");
//        long listMessage = orderMessageService.getMessageListCount("1");
//        List<OrderMessage> newMessageList = orderMessageService.getMessageList("1");
//        System.out.println("------------------ 9999999999999999 "+newMessageList);
//         model.addAttribute("messageListCount", listMessage);
//         model.addAttribute("newMessageList", newMessageList);
        model.addAttribute("messageList", messageList);
        model.addAttribute("unreadMessageList", unreadMessageList);
        return "admin/orderMessage";
    }
    

    @RequestMapping(value = "/userListMassage/{userId}/{pId}", method = RequestMethod.GET)
    public String UserMessageList(
            @PathVariable("userId") Integer userId,
            @PathVariable("pId") Integer pId,
            Model model) {

        List<OrderMessage> userMessageList = orderMessageService.getAllList(userId);
        System.out.println("-----------------" + userMessageList.size());
        model.addAttribute("userId", userId);
        model.addAttribute("pId", pId);
        model.addAttribute("userMessageList", userMessageList);
        return "admin/chat";
    }

    @RequestMapping(value = "/sendOrdermessage", method = RequestMethod.POST)
    @ResponseBody
    public String gettestPage(@RequestBody OrderMessage message) {
        try {
            logger.info("**---****--" + message.getPId().getPId());
            Users entity = AuthoritiesConverter.getUserObject().getUsers();
            message.setUserId(entity);
            message.setInsertDate(new Date());
            message.setStatus("2");

            orderMessageService.persist(message);
            return "success";
        } catch (Exception e) {
            return "error";
        }
    }

    @RequestMapping(value = "/userListMassage/{userId}/chatmessage", method = RequestMethod.POST)
    public String chatMessage(Model model, HttpServletRequest request) {
        logger.info("^^^^^^^^^^^^^^^^^^^^^^ " + request.getParameter("userId") + request.getParameter("pId") + " " + request.getParameter("adminmessage"));
        try {
            Users entity = AuthoritiesConverter.getUserObject().getUsers();
            OrderMessage message = new OrderMessage();
            message.setMessage(request.getParameter("adminmessage"));
            message.setUserId(entity);
            message.setInsertDate(new Date());
            message.setStatus("2");
            message.setName("Admin");
            Products products = new Products();
            products.setPId(Integer.parseInt(request.getParameter("pId")));
            message.setPId(products);
            orderMessageService.persist(message);
            return "redirect:/admin/userListMassage/" + request.getParameter("userId") + "/" + request.getParameter("pId");
        } catch (Exception e) {
            return "error";
        }
    }

    @RequestMapping(value = "testjson", method = RequestMethod.GET)
    @ResponseBody
    public OrderMessage gettestPage() {
        OrderMessage message = new OrderMessage();
        Products products = new Products();
        products.setNote("123");
        products.setPId(2);
        message.setPId(products);
        return message;
    }
}
