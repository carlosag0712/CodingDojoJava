package io.carlosarosemena.productsandcategories.Repositories;

import io.carlosarosemena.productsandcategories.Models.Category;
import io.carlosarosemena.productsandcategories.Models.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    List<Category> findByNameNotIn(List<String> name);
}
