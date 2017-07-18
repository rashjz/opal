/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rashjz.info.com.az.controller;

//import com.twocheckout.Twocheckout;
//import com.twocheckout.TwocheckoutCharge;
//import com.twocheckout.model.Authorization;
import java.io.File;
import java.io.Serializable;
import java.security.Principal;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionKey;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.User;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import rashjz.info.com.az.domain.AppUser;
import rashjz.info.com.az.entity.UserRoles;
import rashjz.info.com.az.entity.Users;
import rashjz.info.com.az.service.UserService;
import rashjz.info.com.az.util.AuthoritiesConverter;
import rashjz.info.com.az.util.SecurityUtil;
import rashjz.info.com.az.util.StaticParams;

/**
 *
 * @author Rashad Javadov
 */
@Controller
public class ProfileController implements Serializable {

    private static final Logger logger = Logger.getLogger(ProfileController.class.getName());

    @Autowired
    UserService userService;

    @Inject
    private ConnectionRepository connectionRepository;

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String getProfilePage(Model model) {
        model.addAttribute("user", AuthoritiesConverter.getUserObject().getUsers());
        return "profile";
    }

//    @RequestMapping(value = "/test2c", method = RequestMethod.POST)
//    public String test2c(Model model) {
////        F9E37ED9-86D9-4139-BFE2-6EABD521C13E
//        Twocheckout.privatekey = "4C7B5B7A-E434-4B5F-AF21-B0774283DBDB";
//        Twocheckout.mode = "sandbox";
//
//        logger.info("====================   start");
//        try {
//            HashMap<String, String> billing = new HashMap<String, String>();
//            billing.put("name", "Testing Tester");
//            billing.put("addrLine1", "xvxcvxcvxcvcx");
//            billing.put("city", "Columbus");
//            billing.put("state", "Ohio");
//            billing.put("country", "USA");
//            billing.put("zipCode", "43230");
//            billing.put("email", "tester@2co.com");
//            billing.put("phone", "555-555-5555");
//
//            HashMap<String, Object> request = new HashMap<String, Object>();
//            request.put("sellerId", "103118881");
//            request.put("merchantOrderId", "test123");
////            
//            request.put("token", "NTlkYmJhZWEtNTI4MS00ZTBjLTlmNDgtMzdlNTdmODNhNzM1");
////            request.put("token", "MGI4OTU0OTQtMDIxNi00YThlLTliOTctZjg1YmJiMzg0MjA3");
//            request.put("currency", "USD");
//            request.put("total", "1.00");
//            request.put("billingAddr", billing);
//
//            Authorization response = TwocheckoutCharge.authorize(request);
//            String message = response.getResponseMsg();
//            logger.info("====================   " + message);
//        } catch (Exception e) {
//            e.printStackTrace();
//            String message = e.toString();
//        }
//        return "login";
//    }

    @RequestMapping(value = "/uploadimage", method = RequestMethod.POST)
    public String doUpload(
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam("imagefile") MultipartFile file) {
        try {
            if (file != null && !file.isEmpty()) {
                String fileName = UUID.randomUUID().toString() + "." + getExt(file.getOriginalFilename());
                FileCopyUtils.copy(file.getBytes(), new File(StaticParams.UPLOAD_LOCATION + fileName));
                //update userimage 
                Users users = AuthoritiesConverter.getUserObject().getUsers();
                //uploads -  url that will get image folder from mvc resources
                users.setImage("/uploads/" + fileName);
                userService.update(users);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "profile";
    }

    public static String getExt(String fileName) {
        String extension = "";
        int i = fileName.lastIndexOf('.');
        if (i > 0) {
            extension = fileName.substring(i + 1);
        }
        return extension;
    }

    @RequestMapping(value = "/connect/facebook", method = RequestMethod.GET)
    public String auth(Principal currentUser, Model model) {
        Connection<Facebook> connection = connectionRepository.findPrimaryConnection(Facebook.class);
        if (connection == null) {
            return "redirect:/connect/facebook";
        }
        ConnectionKey connectionKey = connection.getKey();
        Facebook facebook = connection.getApi();

        User user = facebook.userOperations().getUserProfile();
        Users users = userService.findByUsername(user.getEmail());

        if (users == null) {
            users = new Users();
            users.setEnabled(1);
            users.setFirstname(user.getFirstName());
            users.setLastname(user.getLastName());
            users.setPassword(user.getId());
//            users.setPhone(user.get());
            users.setImage("https://graph.facebook.com/" + user.getId() + "/picture");
            UserRoles roles = new UserRoles();
            roles.setUserId(users);
            roles.setUserRoleId(1);
            roles.setRole("ROLE_USER");
            userService.persist(users);
        }
        AppUser appUser = new AppUser(users, users.getUsername(), users.getPassword(), true, true, true, true, users.getUserRolesCollection());
        SecurityUtil.authenticateUser(appUser);
        return "redirect:/checkout";

    }
}
