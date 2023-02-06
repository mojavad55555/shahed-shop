package com.shahed.shop.dao.categories;

import com.shahed.shop.model.categories.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author m.mohabbati on 2/5/2023
 */
public interface ICategoriesRepository extends JpaRepository<Categories, Long> {
    Categories findByCode(String code);
}
