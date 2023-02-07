package com.shahed.shop.service.product;

import com.shahed.shop.dto.common.ServiceResult;
import com.shahed.shop.dto.product.ProductDto;
import com.shahed.shop.model.product.Product;

/**
 * @author m.mohabbati on 2/5/2023
 */
public interface IProductService {
    ServiceResult<Long> saveDto(ProductDto product);

    ServiceResult<Long> save(Product product);

    ServiceResult<Product> getAll();

    ServiceResult<Product> findById(Long id);

    ServiceResult<Product> findByCategories(Long categories);

    ServiceResult<Product> findByTitle(String title);
}
