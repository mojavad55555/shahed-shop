package com.shahed.shop.dao.product;

import com.shahed.shop.model.product.factor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author m.mohabbati on 2/5/2023
 */
public interface IUserProductRepository extends JpaRepository<factor, Long> {

    List<factor> findByUserAccount(Long userId);
}
