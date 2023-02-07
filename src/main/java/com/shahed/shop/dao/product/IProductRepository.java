package com.shahed.shop.dao.product;

import com.shahed.shop.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author m.mohabbati on 2/5/2023
 */
public interface IProductRepository extends JpaRepository<Product, Long> {

    @Query("select e from Product e where e.categories.id = :categories")
    List<Product> findByCategories(Long categories);

    List<Product> findByTitleLike(String title);

    Product findByIdEquals(Long id);
}
