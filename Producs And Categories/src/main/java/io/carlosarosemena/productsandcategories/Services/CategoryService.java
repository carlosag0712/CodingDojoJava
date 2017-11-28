package io.carlosarosemena.productsandcategories.Services;

import io.carlosarosemena.productsandcategories.Models.Category;
import io.carlosarosemena.productsandcategories.Models.Product;
import io.carlosarosemena.productsandcategories.Repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;



    public Category addCategory(Category category){
        return categoryRepository.save(category);
    }

    public Category findCategory(Long id){
        return categoryRepository.findOne(id);
    }

    public List<Category> categoriesNotInUse(Product product){

        List<String> name = new ArrayList<>();
        List<Category> currentCats = product.getCategories();

        if(currentCats.isEmpty()){
            name.add("");
        }else{
            for(Category c: currentCats){
                name.add(c.getName());
            }
        }
        List<Category> cats = categoryRepository.findByNameNotIn(name);
        return cats;
    }

    public void Update(Category category){
        categoryRepository.save(category);
    }



}
