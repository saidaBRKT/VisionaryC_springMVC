package com.visionaryCrofting.demo.Controller;

import com.visionaryCrofting.demo.entity.Product;
import com.visionaryCrofting.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping(path="/index")
    public String index(){
        return "index";
    }

    // All Product for stock
    @GetMapping(path="/products")
    public String products(Model model,
                           @RequestParam(name="page",defaultValue ="0")int page,
                           @RequestParam(name = "size",defaultValue = "5")int size,
                           @RequestParam(name="motCle",defaultValue="")String motCle){
        Page<Product> pageProduits=productService
                .findByNameContains(motCle,PageRequest.of(page,size));
        model.addAttribute("listProduits",pageProduits);
        model.addAttribute("currentPage",page);
        model.addAttribute("size",size);
        model.addAttribute("motCle",motCle);
        model.addAttribute("pages",new int[pageProduits.getTotalPages()]);
        return "products";
    }

    // All Product for Client
    @GetMapping(path="/Client")
    public String products(Model model){
        List<Product> products=productService.getAll();
        model.addAttribute("AllProducts",products);
        return "ClientProduct";
    }

    @GetMapping(path="/deleteProduit")
    public String delete(Long id,String page,String size,String motCle){
        productService.deleteById(id);
        return "redirect:/products?page="+page+"&motCle="+motCle+"&size="+size;
    }







    @PutMapping(path="/UpdateProduit")
    public String update(Product p,String page,String size,String motCle){
        Product product = productService.findByRef(p.getRef());
        if(product!=null){
            productService.save(p);
        }
        return "redirect:/products?page="+page+"&motCle="+motCle+"&size="+size;
    }

   //  add product
    @RequestMapping("/add-product")
    public String addProduct(){
        return "AddProductForm";
    }

   //  handel add product
    @RequestMapping(value = "/handle-product",method = RequestMethod.POST)
    public String handelProduct(@ModelAttribute Product product){
        productService.save(product);
        return "redirect:/products?page="+0+"&motCle="+""+"&size="+5;
    }

}


