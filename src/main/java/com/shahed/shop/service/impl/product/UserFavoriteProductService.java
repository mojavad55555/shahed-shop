package com.shahed.shop.service.impl.product;

import com.shahed.shop.dao.product.IUserFavoriteProductRepository;
import com.shahed.shop.dto.common.ServiceResult;
import com.shahed.shop.dto.common.ServiceResultBuilder;
import com.shahed.shop.dto.product.UserFavoriteProductDto;
import com.shahed.shop.model.product.Product;
import com.shahed.shop.model.product.UserFavoriteProduct;
import com.shahed.shop.service.product.IProductService;
import com.shahed.shop.service.product.IUserFavoriteProductService;
import com.shahed.shop.service.userAccount.IUserAccountService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @author m.mohabbati on 2/7/2023
 */
@Service
public class UserFavoriteProductService implements IUserFavoriteProductService {

    private final IUserFavoriteProductRepository iUserFavoriteProductRepository;
    private final IProductService iProductService;
    private final IUserAccountService iUserAccountService;

    public UserFavoriteProductService(IUserFavoriteProductRepository iUserFavoriteProductRepository, IProductService iProductService, IUserAccountService iUserAccountService) {
        this.iUserFavoriteProductRepository = iUserFavoriteProductRepository;
        this.iProductService = iProductService;
        this.iUserAccountService = iUserAccountService;
    }

    @Override
    public ServiceResult<UserFavoriteProduct> findByUserAccount(Long userId) {
        return new ServiceResultBuilder<UserFavoriteProduct>().setResult(iUserFavoriteProductRepository.findByUserAccount(userId)).setMessage("Status : ok").build();
    }

    @Override
    public ServiceResult<Long> save(UserFavoriteProductDto userFavoriteProductDto) throws Exception {
        UserFavoriteProduct userFavoriteProduct = new UserFavoriteProduct();
        userFavoriteProduct.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        userFavoriteProduct.setUserAccount(iUserAccountService.findByIdEquals(userFavoriteProductDto.getUserAccount()));
        List<Product> loadProduct = new ArrayList<>();
        for (Long id : userFavoriteProductDto.getProducts()) {
            Product product = iProductService.findById(id).getSingleResult();
            loadProduct.add(product);
        }
        userFavoriteProduct.setProducts(loadProduct);

        return new ServiceResultBuilder<Long>().setSingleResult(iUserFavoriteProductRepository.save(userFavoriteProduct).getId()).setMessage("Status : ok").build();

    }

    @Override
    public ServiceResult delete(Long id) {
        iUserFavoriteProductRepository.deleteById(id);
        return new ServiceResultBuilder<String>().setMessage("Status : ok").build();
    }
}
