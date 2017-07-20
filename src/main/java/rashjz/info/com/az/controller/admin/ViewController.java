/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rashjz.info.com.az.controller.admin;

import java.io.Serializable;
import org.apache.log4j.Logger; 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Azik
 */
@Controller
@RequestMapping("/admin")
public class ViewController implements Serializable {

    private static final Logger logger = Logger.getLogger(ViewController.class.getName());

    @RequestMapping(value = "/indexAdmin", method = RequestMethod.GET)
    public String getLogin2Page(Model model) {
        return "admin/indexAdmin";
    }

}
