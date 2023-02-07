package com.shahed.shop.service.impl.product;

import com.shahed.shop.dao.product.IProductRepository;
import com.shahed.shop.dto.product.ProductDto;
import com.shahed.shop.model.categories.Categories;
import com.shahed.shop.model.product.Product;
import com.shahed.shop.service.categories.ICategoriesService;
import com.shahed.shop.service.product.IProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

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
    public Long saveDto(ProductDto entity) {
       Categories categories = iCategoriesService.findById(entity.getCategories());
        Product product=new Product();
        product.setCategories(categories);
        product.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        product.setAmount(entity.getAmount());
        product.setDescription(entity.getDescription());
        product.setPrice(entity.getPrice());
        product.setTitle(entity.getTitle());
        return iProductRepository.save(product).getId();
    }

    @Override
    public Long save(Product product) {
        return iProductRepository.save(product).getId();
    }

    @Override
    public List<Product> getAll() {
        return iProductRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return iProductRepository.getById(id);
    }


    @Override
    public List<Product> findByCategories(Long categories) {
        return iProductRepository.findByCategories(categories);
    }

    @Override
    public List<Product> findByTitle(String title) {
        return iProductRepository.findByTitleLike(title);
    }
}
