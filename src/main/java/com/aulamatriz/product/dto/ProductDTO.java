package com.aulamatriz.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDTO {

    private String name;
    private String description;
    private
    BigDecimal price;
    private int stock;


}
