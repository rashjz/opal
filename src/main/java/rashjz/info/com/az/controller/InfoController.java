/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rashjz.info.com.az.controller;

import java.io.Serializable;
import java.util.List;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import rashjz.info.com.az.entity.ContactMessages;
import rashjz.info.com.az.entity.Faq;
import rashjz.info.com.az.service.ContactMessageService;
import rashjz.info.com.az.service.FaqService;

/**
 *
 * @author Rashad Javadov
 */
@Controller
public class InfoController implements Serializable {
    
    private static final Logger LOG = Logger.getLogger(InfoController.class.getName());
    @Autowired
    private FaqService faqService;
    @Autowired
    private ContactMessageService messageService;
    
    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String getContactPage(Model model) {
        return "contact";
    }
    
    @RequestMapping(value = "/faq", method = RequestMethod.GET)
    public String getFAQPage(Model model) {
        List<Faq> list = faqService.getAll(Faq.class);
        model.addAttribute("listFaq", list);
        return "faq";
    }
    
    @RequestMapping(value = "/submitmessage", method = RequestMethod.GET)
    public String submitMessage(Model model, HttpServletRequest request, HttpServletResponse response) {
        ContactMessages messages = new ContactMessages();
        messages.setEmail(request.getParameter("email"));
        messages.setFirstname(request.getParameter("name"));
        messages.setPhone(request.getParameter("phone"));
        messages.setMessage(request.getParameter("ymsg"));
        
        messageService.persist(messages);
        return "contact";
    }
    
    @RequestMapping(value = "/privacyPolicy", method = RequestMethod.GET)
    public String getPrivacyPolicyPage(Model model) {
        return "privacy-policy";
    }
    
    @RequestMapping(value = "/termsConditions", method = RequestMethod.GET)
    public String getTermsConditionsyPage(Model model) {
        return "termsConditions";
    }
    
}
