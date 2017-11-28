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
import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryCtrl {

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;

    @RequestMapping("/new")
    public String categoryForm(@ModelAttribute("category")Category category){

        return "categoryform";

    }

    @RequestMapping(method = RequestMethod.POST)
    public String submitCategoryForm(@Valid @ModelAttribute("category")Category category, BindingResult result){
        if(result.hasErrors()){
            return "redirect:/categories/new";
        }else{
            Category cat = categoryService.addCategory(category);
            String catId = Long.toString(cat.getId());
            return "redirect:/categories/".concat(catId);
        }

    }

    @RequestMapping("/{id}")
    public String showCategory(@PathVariable("id")Long id, Model model){
        Category category = categoryService.findCategory(id);
        model.addAttribute("category", category);
        model.addAttribute("products",productService.productsNotInUse(category));
        model.addAttribute("ProdsInCat", category.getProducts());

        return "showcategory";
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST)
    public String addProduct(@RequestParam("productstobeadded")Long prodId,@RequestParam("categorytobeadded") Long catId, Model model){
        Product newProd = productService.findOne(prodId);
        Category updatedCategory = categoryService.findCategory(catId);

        List<Product> productList = updatedCategory.getProducts();
        productList.add(newProd);
        updatedCategory.setProducts(productList);

        categoryService.Update(updatedCategory);
        return "redirect:/categories/"+catId;


    }
}
