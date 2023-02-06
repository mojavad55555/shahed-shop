package com.shahed.shop.service.impl.product;

import com.shahed.shop.dao.product.IUserProductRepository;
import com.shahed.shop.model.product.Product;
import com.shahed.shop.model.product.factor;
import com.shahed.shop.service.product.IProductService;
import com.shahed.shop.service.product.IUserProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author m.mohabbati on 2/5/2023
 */
@Service
public class UserProductService implements IUserProductService {

    private final IUserProductRepository iUserProductRepository;
    private final IProductService iProductService;

    public UserProductService(IUserProductRepository iUserProductRepository, IProductService iProductService) {
        this.iUserProductRepository = iUserProductRepository;
        this.iProductService = iProductService;
    }

    @Override
    public List<factor> findByUserAccount(Long userId) {
        return iUserProductRepository.findByUserAccount(userId) ;
    }

    @Override
    @Transactional
    public Long save(factor factor) throws Exception {
        Long id =iUserProductRepository.save(factor).getId();
        List<Product> productId= factor.getProducts();
        for (Product product :productId)
        {
            if(product.getAmount() == 0 ){
                throw new Exception("موجودی ناکافی");
            }
            product.setAmount(product.getAmount()-1);
            iProductService.save(product);
        }
        return id;
    }
}
