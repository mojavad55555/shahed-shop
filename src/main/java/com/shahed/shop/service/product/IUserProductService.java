package com.shahed.shop.service.product;

import com.shahed.shop.dto.common.ServiceResult;
import com.shahed.shop.dto.product.UserProductDto;
import com.shahed.shop.model.product.UserProduct;

/**
 * @author m.mohabbati on 2/5/2023
 */
public interface IUserProductService {

    ServiceResult<UserProduct> findByUserAccount(Long userId);

    ServiceResult<Long> save(UserProductDto userProductDto) throws Exception;
}
