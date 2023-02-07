package com.shahed.shop.dto.userProduct;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author m.mohabbati on 2/7/2023
 */

@Getter
@Setter
public class UserProductDto {
    private Long userAccount;
    private List<Long> products;
}
