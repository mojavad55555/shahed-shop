package com.shahed.shop.dto.product;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author m.mohabbati on 2/7/2023
 */
@Getter
@Setter
public class UserFavoriteProductDto {
    private Long userAccount;
    private List<Long> products;
}
