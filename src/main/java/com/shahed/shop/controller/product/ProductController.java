package com.shahed.shop.controller.product;

import com.shahed.shop.controller.common.BaseController;
import com.shahed.shop.dto.common.ServiceResult;
import com.shahed.shop.dto.product.ProductDto;
import com.shahed.shop.model.product.Product;
import com.shahed.shop.service.product.IProductService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

/**
 * @author m.mohabbati on 2/6/2023
 */
@RestController
@RequestMapping(value = "/api/product", produces = "application/json;charset=UTF-8")
public class ProductController extends BaseController {

    private final IProductService iProductService;

    public ProductController(IProductService iProductService) {
        this.iProductService = iProductService;
    }

    @PostMapping
    @Operation(tags = "product", description = "ثبت محصول", summary = "ثبت محصول")
    public ServiceResult<Long> save(@RequestBody ProductDto product) {
        return iProductService.saveDto(product);
    }

    @PutMapping
    @Operation(tags = "product", description = "ویرایش محصول", summary = "ویرایش محصول")
    public ServiceResult<Long> save(@RequestBody Product product) {
        return iProductService.save(product);
    }

    @GetMapping(value = "/id")
    @Operation(tags = "product", summary = "لود محصول با شناسه")
    public ServiceResult<Product> findById(Long id) {
        return iProductService.findById(id);
    }

    @GetMapping(value = "/category")
    @Operation(tags = "product", summary = "لود محصول با دسته بندی")
    public ServiceResult<Product> findByCategory(Long Category) {
        return iProductService.findByCategories(Category);
    }

    @GetMapping(value = "/title")
    @Operation(tags = "product", summary = "لود محصول با عنوان")
    public ServiceResult<Product> findByTitle(String title) {
        return iProductService.findByTitle(title);
    }

    @GetMapping
    @Operation(tags = "product", summary = "لود محصولات")
    public ServiceResult<Product> getAll() {
        return iProductService.getAll();
    }

}
