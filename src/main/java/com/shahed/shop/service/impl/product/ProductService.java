package com.shahed.shop.service.impl.product;

import com.shahed.shop.dao.product.IProductRepository;
import com.shahed.shop.model.product.Product;
import com.shahed.shop.service.product.IProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author m.mohabbati on 2/5/2023
 */
@Service
public class ProductService implements IProductService {
    private final IProductRepository iProductRepository;

    public ProductService(IProductRepository iProductRepository) {
        this.iProductRepository = iProductRepository;
    }

    @Override
    @Transactional
    public Long save(Product product) {
        return iProductRepository.save(product).getId();
    }

    @Override
    public List<Product> getAll() {
        return iProductRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return iProductRepository.findById(id);
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
