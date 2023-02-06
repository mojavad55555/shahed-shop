package com.shahed.shop.service.product;

import com.shahed.shop.model.product.Product;

import java.util.List;
import java.util.Optional;

/**
 * @author m.mohabbati on 2/5/2023
 */
public interface IProductService {
    Long save(Product product);

    List<Product> getAll();

    Optional<Product> findById(Long id);

    List<Product> findByCategories(Long categories);

    List<Product> findByTitle(String title);
}
