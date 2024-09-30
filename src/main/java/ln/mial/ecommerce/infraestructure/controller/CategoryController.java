
package ln.mial.ecommerce.infraestructure.controller;

import jakarta.persistence.PostLoad;
import ln.mial.ecommerce.app.service.CategoriasService;
import ln.mial.ecommerce.infraestructure.entity.CategoriasEntity;
import ln.mial.ecommerce.infraestructure.entity.StatusCategoria;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author acer
 */
@Controller
@RequestMapping("/admin/Category")
public class CategoryController {
    
    private final CategoriasService categoriasService;

    public CategoryController(CategoriasService categoriasService) {
        this.categoriasService = categoriasService;
    }
    
   @GetMapping
   public  String showCategory(Model model){
       model.addAttribute("categories",categoriasService.getCategories());
       return "admin/product";
       
   }
   @PostMapping
   public String addCategory(@RequestParam String name, @RequestParam String status){
       CategoriasEntity category = new CategoriasEntity();
       category.setName(name);
       category.setStatusCategoria(StatusCategoria.valueOf(status));
       categoriasService.saveCategory(category);
       return "redirect:/admin/product";
   }
}

