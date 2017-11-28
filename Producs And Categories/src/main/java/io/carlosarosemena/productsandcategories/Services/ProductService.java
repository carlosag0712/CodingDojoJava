package io.carlosarosemena.productsandcategories.Services;

import io.carlosarosemena.productsandcategories.Models.Category;
import io.carlosarosemena.productsandcategories.Models.Product;
import io.carlosarosemena.productsandcategories.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;


    public Product addProduct(Product product){
       return productRepository.save(product);
    }

    public Product findOne(Long id){
        return productRepository.findOne(id);
    }

    public void Update(Product product){
        productRepository.save(product);
    }

    public List<Product> productsNotInUse(Category category){
        List<String> name = new ArrayList<>();
        List<Product> currentProducts = category.getProducts();

        if(currentProducts.isEmpty()){
            name.add("");
        } else {
            for(Product p: currentProducts){
                name.add(p.getName());
            }
        }

        List<Product> prods = productRepository.findByNameNotIn(name);
        return prods;


    }




}
