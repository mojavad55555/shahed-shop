package com.shahed.shop.service.product;

import com.shahed.shop.dto.common.ServiceResult;
import com.shahed.shop.dto.product.UserFavoriteProductDto;
import com.shahed.shop.model.product.UserFavoriteProduct;

import java.util.List;

/**
 * @author m.mohabbati on 2/7/2023
 */
public interface IUserFavoriteProductService {

    ServiceResult<UserFavoriteProduct> findByUserAccount(Long userId);

    ServiceResult<Long> save(UserFavoriteProductDto userFavoriteProductDto) throws Exception;

    ServiceResult delete(Long id);
}
