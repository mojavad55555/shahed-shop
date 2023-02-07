package com.shahed.shop.service.impl.categories;

import com.shahed.shop.dao.categories.ICategoriesRepository;
import com.shahed.shop.dto.common.ServiceResult;
import com.shahed.shop.dto.common.ServiceResultBuilder;
import com.shahed.shop.model.categories.Categories;
import com.shahed.shop.service.categories.ICategoriesService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public Categories findById(Long id) {
        return iCategoriesRepository.getById(id);
    }

    @Override
    @Transactional
    public ServiceResult<Long> save(Categories categories) {
        return new ServiceResultBuilder<Long>().setSingleResult(iCategoriesRepository.save(categories).getId()).setMessage("Status : ok").build();

    }

    @Override
    public ServiceResult<Categories> getAll() {
        return new ServiceResultBuilder<Categories>().setResult(iCategoriesRepository.findAll()).setMessage("Status : ok").build();
    }

}
