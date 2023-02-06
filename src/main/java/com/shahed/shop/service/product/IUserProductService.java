package com.shahed.shop.service.product;

import com.shahed.shop.model.product.factor;

import java.util.List;

/**
 * @author m.mohabbati on 2/5/2023
 */
public interface IUserProductService {

    List<factor> findByUserAccount(Long userId);

    Long save (factor factor) throws Exception;
}
