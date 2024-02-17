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
import java.util.Optional;

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

    @Override
    public ResponseEntity getAll() {
        var listUser = this.productRepository.findAll();
        return ResponseEntity.ok(listUser);
    }

    @Override
    public ResponseEntity deleteById(long id) {

        this.productRepository.deleteById(id);
        return ResponseEntity.ok("product was deleted");
    }

    @Override
    public ResponseEntity update(ProductDTO productDTO, long id) {

        Optional<ProductEntity> optionalProductEntity = this.productRepository.findById(id);

        if(optionalProductEntity.isPresent()){
            ProductEntity productEntity = optionalProductEntity.get();

            productEntity.setName(productDTO.getName());
            productEntity.setStock(productDTO.getStock());
            productEntity.setPrice(productDTO.getPrice());
            productEntity.setDescription(productDTO. getDescription());
            productEntity.setCreatedAt(LocalDateTime.now());

            var updateProductEntity = this.productRepository.save(productEntity);

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(updateProductEntity);
        }

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .build();
    }
}
