package com.shahed.shop.dao.product;

import com.shahed.shop.model.categories.Categories;
import com.shahed.shop.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author m.mohabbati on 2/5/2023
 */
public interface IProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategories(Long categories);

    List<Product> findByTitleLike(String title);
}
