package com.aulamatriz.product.service.impl;

import com.aulamatriz.product.dto.ProductDTO;
import com.aulamatriz.product.model.ProductEntity;
import com.aulamatriz.product.repository.ProductRepository;
import com.aulamatriz.product.service.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements IProductService {

    private final ProductRepository productRepository;

    @Override
    public ResponseEntity save(ProductDTO productDTO) {

        ProductEntity productEntity = new ProductEntity();

        productEntity.setName(productDTO.getName());
        productEntity.setStock(productDTO.getStock());
        productEntity.setPrice(productDTO.getPrice());
        productEntity.setDescription(productDTO. getDescription());
        productEntity.setCreatedAt(LocalDateTime.now());

        var newProduct = this.productRepository.save(productEntity);

        return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
    }
}
