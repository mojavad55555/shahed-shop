package com.shahed.shop.service.impl.product;

import com.shahed.shop.dao.product.IProductRepository;
import com.shahed.shop.dto.common.ServiceResult;
import com.shahed.shop.dto.common.ServiceResultBuilder;
import com.shahed.shop.dto.product.ProductDto;
import com.shahed.shop.model.categories.Categories;
import com.shahed.shop.model.product.Product;
import com.shahed.shop.service.categories.ICategoriesService;
import com.shahed.shop.service.product.IProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

/**
 * @author m.mohabbati on 2/5/2023
 */
@Service
public class ProductService implements IProductService {
    private final IProductRepository iProductRepository;

    private final ICategoriesService iCategoriesService;

    public ProductService(IProductRepository iProductRepository, ICategoriesService iCategoriesService) {
        this.iProductRepository = iProductRepository;
        this.iCategoriesService = iCategoriesService;
    }

    @Override
    @Transactional
    public ServiceResult<Long> saveDto(ProductDto entity) {
        Categories categories = iCategoriesService.findById(entity.getCategories());
        Product product = new Product();
        product.setCategories(categories);
        product.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        product.setAmount(entity.getAmount());
        product.setDescription(entity.getDescription());
        product.setPrice(entity.getPrice());
        product.setTitle(entity.getTitle());
        return new ServiceResultBuilder<Long>().setSingleResult(iProductRepository.save(product).getId()).setMessage("Status : ok").build();
    }

    @Override
    public ServiceResult<Long> save(Product product) {
        return new ServiceResultBuilder<Long>().setSingleResult(iProductRepository.save(product).getId()).setMessage("Status : ok").build();
    }

    @Override
    public ServiceResult<Product> getAll() {
        return new ServiceResultBuilder<Product>().setResult(iProductRepository.findAll()).setMessage("Status : ok").build();
    }

    @Override
    public ServiceResult<Product> findById(Long id) {
        return new ServiceResultBuilder<Product>().setSingleResult(iProductRepository.findByIdEquals(id)).setMessage("Status : ok").build();
    }


    @Override
    public ServiceResult<Product> findByCategories(Long categories) {
        return new ServiceResultBuilder<Product>().setResult(iProductRepository.findByCategories(categories)).setMessage("Status : ok").build();

    }

    @Override
    public ServiceResult<Product> findByTitle(String title) {
        return new ServiceResultBuilder<Product>().setResult(iProductRepository.findByTitleLike(title)).setMessage("Status : ok").build();
    }
}
