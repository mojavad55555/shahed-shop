package com.shahed.shop.controller.product;

import com.shahed.shop.dto.common.ServiceResult;
import com.shahed.shop.dto.product.UserFavoriteProductDto;
import com.shahed.shop.model.product.UserFavoriteProduct;
import com.shahed.shop.service.product.IUserFavoriteProductService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

/**
 * @author m.mohabbati on 2/7/2023
 */

@RestController
@RequestMapping(value = "/api/user-favorite-product", produces = "application/json;charset=UTF-8")
public class UserFavoriteProductController {

    private final IUserFavoriteProductService iUserFavoriteProductService;

    public UserFavoriteProductController(IUserFavoriteProductService iUserFavoriteProductService) {
        this.iUserFavoriteProductService = iUserFavoriteProductService;
    }

    @PostMapping
    @Operation(tags = "user-favorite-product", description = " اضافه کردن محصول مورد علاقه", summary = "محصول مورد علاقه")
    public ServiceResult<Long> save(@RequestBody UserFavoriteProductDto userFavoriteProductDto) throws Exception {
        return iUserFavoriteProductService.save(userFavoriteProductDto);
    }

    @GetMapping(value = "/user-id")
    @Operation(tags = "user-favorite-product", summary = "لود محصولات مورد علاقه کاربر")
    public ServiceResult<UserFavoriteProduct> findByUserAccount(Long userId) {
        return iUserFavoriteProductService.findByUserAccount(userId);
    }

    @DeleteMapping
    @Operation(tags = "user-favorite-product", summary = "حذف محصول مورد علاقه کاربر")
    public ServiceResult delete(Long id) {
        return iUserFavoriteProductService.delete(id);
    }
}
