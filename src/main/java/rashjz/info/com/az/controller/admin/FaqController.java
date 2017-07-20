/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rashjz.info.com.az.controller.admin;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import rashjz.info.com.az.entity.Faq;
import rashjz.info.com.az.service.FaqService;

/**
 *
 * @author Azik
 */
@Controller
@RequestMapping("/admin")
public class FaqController implements Serializable{
 
   private static final Logger logger = Logger.getLogger(FaqController.class.getName());
    
    @Autowired
    FaqService faqService;
    
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        //  binder.setValidator(customerFormValidator);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.S");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
    
    @RequestMapping(value = "/faqAdmin", method = RequestMethod.GET)
    public String getFaqAll(Model model){
        List<Faq> listFaq=faqService.getAll(Faq.class);
        model.addAttribute("faqList", listFaq);
        return "admin/faqAdmin";
    }
    
     @RequestMapping(value = "/editFaq", method = RequestMethod.POST)
    public String saveOrUpdateFaq(@ModelAttribute("faq") Faq faq, BindingResult result, Model model, final RedirectAttributes redirectAttributes
    ) {
        logger.info("save-Or-Update-faq - - - " + faq.toString());
        if (result.hasErrors()) {
            logger.info("save-Or-Update-faq- - - " + result.toString());
            return "403";
        } else {
            redirectAttributes.addFlashAttribute("css", "success");

            if (faq.getId() == null) {//is new

                redirectAttributes.addFlashAttribute("msg", "Faq added successfully!");
            } else {

                redirectAttributes.addFlashAttribute("msg", "Faq updated successfully!");
            }
            System.out.println("--------- "+faq.getAnswer());
            faqService.AddOrUpdateFaq(faq);

            return "redirect:/admin/editFaq/" + faq.getId();
        }
    }
    
    @RequestMapping(value = "editFaq/{id}", method = RequestMethod.GET)
    public String EditBrand(@PathVariable("id") int Id, Model model
    ) {

        logger.debug("showFaq id: {}"+ Id);
        Faq faq= faqService.getByKey(Id);
        
        System.out.println("showCustomers xxxxxxxxxxxxx" + faq.toString());

        model.addAttribute("faq", faq);

        return "admin/editFaq";

    }
    @RequestMapping(value = "faq/add", method = RequestMethod.GET)
    public String AddFaqForm(Model model) {

        logger.debug("showAddCustomersForm()");

        Faq faq = new Faq();
        model.addAttribute("faq", faq);
        return "admin/editFaq";
    }
    @RequestMapping(value = "faq/{id}/delete", method = RequestMethod.GET)
    public String getDelete(@PathVariable("id") Integer id,
            final RedirectAttributes redirectAttributes) {
        logger.info("deleteCustomers() : {}" + id);
        Faq faq= faqService.getByKey(id);
        faqService.delete(faq);
        redirectAttributes.addFlashAttribute("css", "success");
        redirectAttributes.addFlashAttribute("msg", "Faq is deleted!");
        return "redirect:/admin/faqAdmin";

    }
}
