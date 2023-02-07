package com.shahed.shop.dao.product;

import com.shahed.shop.model.product.UserProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author m.mohabbati on 2/5/2023
 */
public interface IUserProductRepository extends JpaRepository<UserProduct, Long> {

    @Query("select e from UserProduct e where e.userAccount.id = :userId")
    List<UserProduct> findByUserAccount(Long userId);
}
