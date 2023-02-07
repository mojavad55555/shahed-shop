package com.shahed.shop.dao.product;

import com.shahed.shop.model.product.UserFavoriteProduct;
import com.shahed.shop.model.product.UserProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author m.mohabbati on 2/7/2023
 */
public interface IUserFavoriteProductRepository extends JpaRepository<UserFavoriteProduct, Long> {

    @Query("select e from UserFavoriteProduct e where e.userAccount.id = :userId")
    List<UserFavoriteProduct> findByUserAccount(Long userId);
}
