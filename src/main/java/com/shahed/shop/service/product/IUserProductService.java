package com.shahed.shop.service.product;

import com.shahed.shop.dto.userProduct.UserProductDto;
import com.shahed.shop.model.product.UserProduct;

import java.util.List;

/**
 * @author m.mohabbati on 2/5/2023
 */
public interface IUserProductService {

    List<UserProduct> findByUserAccount(Long userId);

    Long save(UserProductDto userProductDto) throws Exception;
}
