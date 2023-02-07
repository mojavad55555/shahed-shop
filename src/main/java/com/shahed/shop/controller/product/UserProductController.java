package com.shahed.shop.controller.product;

import com.shahed.shop.dto.product.ProductDto;
import com.shahed.shop.dto.userProduct.UserProductDto;
import com.shahed.shop.model.product.Product;
import com.shahed.shop.model.product.UserProduct;
import com.shahed.shop.service.product.IProductService;
import com.shahed.shop.service.product.IUserProductService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author m.mohabbati on 2/7/2023
 */
@RestController
@RequestMapping(value = "/api/user-product", produces = "application/json;charset=UTF-8")
public class UserProductController {

    private final IUserProductService iUserProductService;

    public UserProductController(IUserProductService iUserProductService) {
        this.iUserProductService = iUserProductService;
    }

    @PostMapping
    @Operation(tags = "user-product", description = "خرید محصول", summary = "خرید محصول")
    public Long save(@RequestBody UserProductDto userProductDto) throws Exception {
        return iUserProductService.save(userProductDto);
    }

    @GetMapping(value = "/user-id")
    @Operation(tags = "user-product", summary = "لود محصولات خریداری با شناسه کاربر")
    public List<UserProduct> findByUserAccount(Long userId) {
        return iUserProductService.findByUserAccount(userId);
    }
}
