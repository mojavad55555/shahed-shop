package com.shahed.shop.service.impl.product;

import com.shahed.shop.dao.product.IUserProductRepository;
import com.shahed.shop.dto.userProduct.UserProductDto;
import com.shahed.shop.model.product.Product;
import com.shahed.shop.model.product.UserProduct;
import com.shahed.shop.service.product.IProductService;
import com.shahed.shop.service.product.IUserProductService;
import com.shahed.shop.service.userAccount.IUserAccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @author m.mohabbati on 2/5/2023
 */
@Service
public class UserProductService implements IUserProductService {

    private final IUserProductRepository iUserProductRepository;
    private final IProductService iProductService;
    private final IUserAccountService iUserAccountService;

    public UserProductService(IUserProductRepository iUserProductRepository, IProductService iProductService, IUserAccountService iUserAccountService) {
        this.iUserProductRepository = iUserProductRepository;
        this.iProductService = iProductService;
        this.iUserAccountService = iUserAccountService;
    }

    @Override
    public List<UserProduct> findByUserAccount(Long userId) {
        return iUserProductRepository.findByUserAccount(userId);
    }

    @Override
    @Transactional
    public Long save(UserProductDto userProductDto) throws Exception {
        UserProduct userProduct = new UserProduct();
        userProduct.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        userProduct.setUserAccount(iUserAccountService.findByIdEquals(userProductDto.getUserAccount()));
        List<Product> loadProduct = new ArrayList<>();
        for (Long id : userProductDto.getProducts()) {
            Product product = iProductService.findById(id);
            loadProduct.add(product);
        }
        userProduct.setProducts(loadProduct);
        Long id = iUserProductRepository.save(userProduct).getId();
        List<Product> productId = userProduct.getProducts();
        for (Product product : productId) {
            if (product.getAmount() == 0) {
                throw new Exception("موجودی ناکافی");
            }
            product.setAmount(product.getAmount() - 1);
            iProductService.save(product);
        }
        return id;
    }
}
