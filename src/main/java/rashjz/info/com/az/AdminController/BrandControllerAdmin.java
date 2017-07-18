/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rashjz.info.com.az.AdminController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.SortOrder;
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
import rashjz.info.com.az.domain.PagingResult;

import rashjz.info.com.az.entity.Brand;
import rashjz.info.com.az.service.BrandCategoryService;

/**
 *
 * @author Azik
 */
@Controller
@RequestMapping("/admin")
public class BrandControllerAdmin {

    private static final Logger logger = Logger.getLogger(BrandControllerAdmin.class.getName());

    @Autowired
    BrandCategoryService brandCategoryService;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        //  binder.setValidator(customerFormValidator);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @RequestMapping(value = "/brands", method = RequestMethod.GET)
    public String getBrandAll(Model model, @ModelAttribute("brands") Brand brands, Integer offset, Integer maxResults) {
        Map<String, Object> filters = new HashMap<>();
        filters.put("", 0);
        if (brands == null) {
            brands = new Brand();
        }
        PagingResult pagingData = new PagingResult();
        if (offset == null) {
            offset = 0;
            filters.put("enabled", 1);
        }
        if (offset != null) {//new or old
            if (brands.getName() != null && !brands.getName().equals("")) {
                filters.put("name", brands.getName());
            }

        }
        pagingData = brandCategoryService.lazyLoadBrands(offset.intValue(), 10, null, SortOrder.UNSORTED, filters);
        brandCategoryService.lazyLoadBrandsCount(offset.intValue(), 10, null, SortOrder.UNSORTED, filters, pagingData);

        model.addAttribute("brandsList", pagingData.getList());
        model.addAttribute("count", pagingData.getTotalResult());
        model.addAttribute("brand", brands);
        model.addAttribute("offset", offset);
        return "admin/brand";
    }

    @RequestMapping(value = "/editBrand", method = RequestMethod.POST)
    public String saveOrUpdateBrand(@ModelAttribute("brand") Brand brand, BindingResult result, Model model, final RedirectAttributes redirectAttributes
    ) {
        logger.info("save-Or-Update-Brand - - - " + brand.toString());
        if (result.hasErrors()) {
            logger.info("save-Or-Update-Brand - - - " + result.toString());
            return "403";
        } else {
            redirectAttributes.addFlashAttribute("css", "success");

            if (brand.getId() == null) {//is new

                redirectAttributes.addFlashAttribute("msg", "Brand added successfully!");
            } else {

                redirectAttributes.addFlashAttribute("msg", "Brand updated successfully!");
            }

            brandCategoryService.AddOrUpdateBrand(brand);

            return "redirect:/admin/editBrand/" + brand.getId();
        }
    }

    @RequestMapping(value = "editBrand/{id}", method = RequestMethod.GET)
    public String EditBrand(@PathVariable("id") int Id, Model model ) {
        logger.info("showBrand id: {}" + Id);
        Brand brand = brandCategoryService.getByKey(Id);
        System.out.println("showCustomers xxxxxxxxxxxxx" + brand.toString());
        model.addAttribute("brand", brand);
        return "admin/editBrand";
    }

    @RequestMapping(value = "brand/add", method = RequestMethod.GET)
    public String AddBrandForm(Model model) {

        logger.debug("showAddCustomersForm()");

        Brand brand = new Brand();
        model.addAttribute("brand", brand);
        return "admin/editBrand";
    }

    @RequestMapping(value = "brand/{id}/delete", method = RequestMethod.GET)
    public String getDelete(@PathVariable("id") Integer id,
            final RedirectAttributes redirectAttributes) {
        logger.info("deleteCustomers() : {}" + id);
        Brand brand = brandCategoryService.getByKey(id);
        brandCategoryService.delete(brand);
        redirectAttributes.addFlashAttribute("css", "success");
        redirectAttributes.addFlashAttribute("msg", "Brand is deleted!");
        return "redirect:/admin/brand";

    }

}
