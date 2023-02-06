package com.shahed.shop.service.impl.categories;

import com.shahed.shop.dao.categories.ICategoriesRepository;
import com.shahed.shop.model.categories.Categories;
import com.shahed.shop.service.categories.ICategoriesService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author m.mohabbati on 2/5/2023
 */
@Service
public class CategoriesService implements ICategoriesService {


    private final ICategoriesRepository iCategoriesRepository;

    public CategoriesService(ICategoriesRepository iCategoriesRepository) {
        this.iCategoriesRepository = iCategoriesRepository;
    }

    @Override
    public Categories findByCode(String code) {
        return iCategoriesRepository.findByCode(code);
    }

    @Override
    @Transactional
    public Long save(Categories categories) {
        return iCategoriesRepository.save(categories).getId();
    }

    @Override
    public List<Categories> getAll() {
        return iCategoriesRepository.findAll();
    }

}
