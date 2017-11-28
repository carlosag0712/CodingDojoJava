package io.carlosarosemena.productsandcategories.Repositories;

import io.carlosarosemena.productsandcategories.Models.Category;
import io.carlosarosemena.productsandcategories.Models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findByNameNotIn(List<String> name);

}
