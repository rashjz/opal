/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rashjz.info.com.az.controller.admin;

import java.io.File;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import static rashjz.info.com.az.controller.ProfileController.getExt;

import rashjz.info.com.az.entity.SliderImage;
import rashjz.info.com.az.service.SliderImageService;
import rashjz.info.com.az.util.StaticParams;

/**
 *
 * @author Azik
 */
@Controller
@RequestMapping("/admin")
public class SliderImagesController implements Serializable{
    
  private static final Logger logger = Logger.getLogger(SliderImagesController.class.getName());   
    
  @Autowired
  SliderImageService sliderImageService;
  
  @RequestMapping(value = "/slideradmin", method = RequestMethod.GET)
    public String getFaqAll(Model model){
        List<SliderImage> sliderImagesList=sliderImageService.getAll(SliderImage.class);
        model.addAttribute("sliderImagesList", sliderImagesList);
        return "admin/sliderImages";
    }
  
  
  @RequestMapping(value = "/uploadsliderimagemulti", method = RequestMethod.POST)
    public String doUpload(HttpServletRequest request, HttpServletResponse response,
            @RequestParam("imagefile") List<MultipartFile> multipartFile) {
       System.out.println("azer----------------");  
        for (MultipartFile file : multipartFile) {
            logger.info("--------------- " + "  file " + file.getOriginalFilename() );
            try {
                if (file != null && !file.isEmpty()) {
                    String fileName = UUID.randomUUID().toString() + "." + getExt(file.getOriginalFilename());
                    FileCopyUtils.copy(file.getBytes(), new File(StaticParams.UPLOAD_LOCATION + fileName));
                    //update userimage 
                    System.out.println("azer---------------- 1");  
                    SliderImage image = new SliderImage();
                    //uploads -  url that will get image folder from mvc resources
                    image.setImageName("/uploads/" + fileName);
                    sliderImageService.persist(image);
                    System.out.println("azer----------------2");  
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "redirect:/admin/slideradmin";
    }
    @RequestMapping(value = "slideradmin/{id}/delete", method = RequestMethod.GET)
    public String productImageDelete(
            @PathVariable("id") Integer id,
            final RedirectAttributes redirectAttributes) {
        logger.info("productImageDelete() : {}" + id );
        SliderImage image = new SliderImage();
        image.setId(id);
        
        sliderImageService.delete(image);
        redirectAttributes.addFlashAttribute("css", "success");
        redirectAttributes.addFlashAttribute("msg", "Slide Image is deleted!");
        return "redirect:/admin/slideradmin";
    }
  
}
