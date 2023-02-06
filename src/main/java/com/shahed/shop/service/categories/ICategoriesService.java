package com.shahed.shop.service.categories;

import com.shahed.shop.model.categories.Categories;

import java.util.List;

/**
 * @author m.mohabbati on 2/5/2023
 */
public interface ICategoriesService {

    Categories findByCode(String code);

    Long save(Categories categories);

    List<Categories>getAll();
}
