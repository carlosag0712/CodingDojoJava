package io.carlosarosemena.productsandcategories.Controllers;

import io.carlosarosemena.productsandcategories.Models.Category;
import io.carlosarosemena.productsandcategories.Models.Product;
import io.carlosarosemena.productsandcategories.Services.CategoryService;
import io.carlosarosemena.productsandcategories.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductCtrl {

    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;

    @RequestMapping("/new")
    public String productForm(@ModelAttribute("product")Product product){

        return "newproduct";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String createProduct(@Valid @ModelAttribute("product")Product product, BindingResult result){
        if(result.hasErrors()){
            return "redirect:/newproduct";
        }else{
            Product prod = productService.addProduct(product);
            String prodId = Long.toString(prod.getId());
            return "redirect:/products/".concat(prodId);
        }
    }

    @RequestMapping("/{id}")
    public String showProduct(@PathVariable("id")Long id, Model model, @ModelAttribute("category")Category category){

        Product product = productService.findOne(id);
        model.addAttribute("product", product);
        model.addAttribute("categories", categoryService.categoriesNotInUse(product));
        model.addAttribute("prodCats", product.getCategories());
        return "showproduct";

    }

    @RequestMapping(value = "/addCategory", method = RequestMethod.POST)
    public String addCatToProd(@RequestParam("newCategory") Long catId, @RequestParam("product")Long prodId, Model model){

        Category newCat = categoryService.findCategory(catId);
        Product updatedProduct = productService.findOne(prodId);

        List<Category> categoryList = updatedProduct.getCategories();
        categoryList.add(newCat);

        updatedProduct.setCategories(categoryList);
        productService.Update(updatedProduct);
        return "redirect:/products/" +prodId ;
    }
}
