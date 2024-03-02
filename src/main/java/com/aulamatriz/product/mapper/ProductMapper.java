package com.aulamatriz.product.mapper;

import com.aulamatriz.product.dto.ProductDTO;
import com.aulamatriz.product.model.ProductEntity;

import java.time.LocalDateTime;

public class ProductMapper {

    public static ProductEntity maoToEntity(ProductDTO productDTO){
        /*ProductEntity productEntity = new ProductEntity();

        productEntity.setName(productDTO.getName());
        productEntity.setStock(productDTO.getStock());
        productEntity.setPrice(productDTO.getPrice());
        productEntity.setDescription(productDTO. getDescription());
        productEntity.setCreatedAt(LocalDateTime.now());
*/


        return ProductEntity
                .builder()
                .name(productDTO.getName())
                .stock(productDTO.getStock())
                .description(productDTO.getDescription())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
