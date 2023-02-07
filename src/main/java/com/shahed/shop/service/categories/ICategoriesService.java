package com.shahed.shop.service.categories;

import com.shahed.shop.dto.common.ServiceResult;
import com.shahed.shop.model.categories.Categories;

/**
 * @author m.mohabbati on 2/5/2023
 */
public interface ICategoriesService {

    Categories findByCode(String code);

    Categories findById(Long id);

    ServiceResult<Long> save(Categories categories);

    ServiceResult<Categories>getAll();
}
