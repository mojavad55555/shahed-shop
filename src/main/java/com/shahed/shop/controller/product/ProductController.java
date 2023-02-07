package com.shahed.shop.controller.product;

import com.shahed.shop.dto.product.ProductDto;
import com.shahed.shop.model.product.Product;
import com.shahed.shop.service.product.IProductService;
import io.swagger.v3.oas.annotations.Operation;
import org.dozer.Mapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author m.mohabbati on 2/6/2023
 */
@RestController
@RequestMapping(value = "/api/product", produces = "application/json;charset=UTF-8")
public class ProductController {

    private final IProductService iProductService;

    public ProductController(IProductService iProductService) {
        this.iProductService = iProductService;
    }

    @PostMapping
    @Operation(tags = "product", description = "ثبت محصول", summary = "ثبت محصول")
    public Long save(@RequestBody ProductDto product) {
        return iProductService.saveDto(product);
    }

    @GetMapping(value = "/id")
    @Operation(tags = "product", summary = "لود محصول با شناسه")
    public Product findById(Long id) {
        return iProductService.findById(id);
    }

    @GetMapping(value = "/category")
    @Operation(tags = "product", summary = "لود محصول با دسته بندی")
    public List<Product> findByCategory(Long Category) {
        return iProductService.findByCategories(Category);
    }

    @GetMapping(value = "/title")
    @Operation(tags = "product", summary = "لود محصول با عنوان")
    public List<Product> findByTitle(String title) {
        return iProductService.findByTitle(title);
    }

    @GetMapping
    @Operation(tags = "product", summary = "لود محصولات")
    public List<Product> getAll() {
        return iProductService.getAll();
    }

}
