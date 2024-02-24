package id.ac.ui.cs.advprog.eshop.controller;
import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("/create")
    public String createProductPage(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "CreateProduct";
    }

    @PostMapping("/create")
    public String createProductPost(@ModelAttribute Product product, Model model) {
        service.create(product);
        return "redirect:list";
    }

    @GetMapping("/list")
    public String productListPage(Model model) {
        List<Product> allProducts = service.findAll();
        model.addAttribute("products", allProducts);
        return "ProductList";
    }
    
    @GetMapping("/home")
    public String homePage(Model model) {
        return "HomePage";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable("id") String id) {
        service.deleteById(id);
        return "redirect:/product/list";
    }

    @GetMapping("/edit/{id}")
    public String editProductPage(Model model, @PathVariable("id") String id) {
        Product product = service.getById(id);
        model.addAttribute("product", product);
        return "EditProduct";
    }

    @PostMapping("/edit/{id}")
    public String editProductPost(@ModelAttribute Product product, Model model, @PathVariable("id") String id) {
        service.edit(product, id);
        return "redirect:/product/list";
    }
}

