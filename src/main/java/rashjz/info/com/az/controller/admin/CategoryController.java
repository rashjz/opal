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
import rashjz.info.com.az.entity.Category;
import rashjz.info.com.az.service.CategoryService;

/**
 *
 * @author Azik
 */
@Controller
@RequestMapping("/admin")
public class CategoryController implements Serializable{
    
    private static final Logger logger = Logger.getLogger(CategoryController.class.getName());
    
    @Autowired
    CategoryService categoryService;
    
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        //  binder.setValidator(customerFormValidator);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S ");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
    
    @RequestMapping(value = "/categoryAdmin", method = RequestMethod.GET)
    public String getCategoryAll(Model model){
        List<Category> listCategory=categoryService.getAll(Category.class);
        model.addAttribute("category", listCategory);
        return "admin/categoryAdmin";
    }
    
     @RequestMapping(value = "/editCategory", method = RequestMethod.POST)
    public String saveOrUpdateCustomers(@ModelAttribute("categorys") Category category, BindingResult result, Model model, final RedirectAttributes redirectAttributes
    ) {
        logger.info("save-Or-Update-Content - - - " + category.toString());
        if (result.hasErrors()) {
            logger.info("save-Or-Update-Content - - - " + result.toString());
            return "403";
        } else {
            redirectAttributes.addFlashAttribute("css", "success");

            if (category.getCatId() == null) {//is new

                redirectAttributes.addFlashAttribute("msg", "Customers added successfully!");
            } else {

                redirectAttributes.addFlashAttribute("msg", "Customers updated successfully!");
            }
          
            categoryService.AddOrUpdateUser(category);

            return "redirect:/admin/editCategory/" + category.getCatId();
        }
    }
    
    @RequestMapping(value = "editCategory/{id}", method = RequestMethod.GET)
    public String EditCategory(@PathVariable("id") int Id, Model model
    ) {

        logger.debug("showCustomers id: {}"+ Id);
        Category category= categoryService.getByKey(Id);
        
        System.out.println("showCustomers xxxxxxxxxxxxx" + category.toString());

        model.addAttribute("category", category);

        return "admin/editCategoryAdmin";

    }
    @RequestMapping(value = "category/add", method = RequestMethod.GET)
    public String AddCategoryForm(Model model) {

        logger.debug("showAddCustomersForm()");
        
        Category category = new Category();
        model.addAttribute("category", category);
        return "admin/editCategoryAdmin";
    }
    @RequestMapping(value = "/category/{id}/delete", method = RequestMethod.GET)
    public String getUpdateContent(@PathVariable("id") Integer id,
            final RedirectAttributes redirectAttributes) {
        logger.info("deleteCustomers() : {}" + id);
        Category category= categoryService.getByKey(id);
        categoryService.delete(category);
        redirectAttributes.addFlashAttribute("css", "success");
        redirectAttributes.addFlashAttribute("msg", "Category is deleted!");
        return "redirect:/admin/categoryAdmin";

    }
    
    
}
