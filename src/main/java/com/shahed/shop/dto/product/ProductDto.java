package com.shahed.shop.dto.product;


import lombok.Getter;
import lombok.Setter;

/**
 * @author m.mohabbati on 2/6/2023
 */
@Getter
@Setter
public class ProductDto {

    private String title;

    private Long amount;

    private String price;

    private String description;

    private Long categories;
}
