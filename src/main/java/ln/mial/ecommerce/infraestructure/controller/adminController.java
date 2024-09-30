
package ln.mial.ecommerce.infraestructure.controller;

import java.io.IOException;
import ln.mial.ecommerce.app.service.CategoriasService;
import ln.mial.ecommerce.app.service.ProductosService;
import ln.mial.ecommerce.infraestructure.entity.CategoriasEntity;
import ln.mial.ecommerce.infraestructure.entity.ProductosEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author acer
 */
//complen la funcion del comtrolador 
@Controller
//define la ruta  
@RequestMapping("/admin/product")
public class adminController {
    private final ProductosService productosService;
    private final CategoriasService categoriasService;

    public adminController(ProductosService productosService, CategoriasService categoriasService) {
        this.productosService = productosService;
        this.categoriasService = categoriasService;
    }
    
    @GetMapping
    public String showProduct(Model model){
        Iterable<ProductosEntity> products = productosService.getProducts();
        Iterable<CategoriasEntity> categories = categoriasService.getCategories();
        
       model.addAttribute("products",products);
       model.addAttribute( "categories",categories);
       return "admin";
    }
    @PostMapping
    public String addProduct(ProductosEntity product, @RequestParam("file") 
           MultipartFile multipartFile, @RequestParam("categoryId") Integer categoryId ) throws IOException{
        
        CategoriasEntity category = categoriasService.getCategoryById(categoryId);
        product.setCategory(category);
        productosService.saveProduct(product, multipartFile);
        return "redirect:/admin/product";
    }
}
