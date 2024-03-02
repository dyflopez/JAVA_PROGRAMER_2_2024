package com.aulamatriz.product.service.impl;

import com.aulamatriz.product.dto.ProductDTO;
import com.aulamatriz.product.exception.MyHandleException;
import com.aulamatriz.product.mapper.ProductMapper;
import com.aulamatriz.product.model.ProductEntity;
import com.aulamatriz.product.repository.ProductRepository;
import com.aulamatriz.product.service.IProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class ProductServiceImpl implements IProductService {

    private final ProductRepository productRepository;

    @Override
    public ResponseEntity save(ProductDTO productDTO) {

        var trackingId = productDTO.getTrackingId();

        log.info("getting product {}",trackingId);
        var productExist = this.productRepository.findByName(productDTO.getName());

        log.info("validate  if exist product {}",trackingId);
        if(productExist.isPresent()){
            log.info("product already exist");
            throw new MyHandleException("product with name " + productDTO.getName() + " now exists  in database");
        }

        log.info("mapping entity product {}",trackingId);
        ProductEntity productEntity = ProductMapper.maoToEntity(productDTO);

        log.info("saving  product {}",trackingId);
        var newProduct = this.productRepository.save(productEntity);

        log.info("created product {}",trackingId);
        return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
    }

    @Override
    public ResponseEntity getAll() {
        var listUser = this.productRepository.findAll();
        return ResponseEntity.ok(listUser);
    }

    @Override
    public ResponseEntity deleteById(long id) {

        log.warn("deleting product by id" + id);
        this.productRepository.deleteById(id);
        return ResponseEntity.ok("product was deleted");
    }

    @Override
    public ResponseEntity update(ProductDTO productDTO, long id) {

        log.warn("getting product by id" + id);

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

    @Override
    public ResponseEntity getByName(String name) {

        ProductEntity  productEntity =  this.productRepository
                .findByName(name)
                .orElseThrow(()-> new MyHandleException("""
                        Product with name %s does not exist in database
                        """.formatted(name)));

        return ResponseEntity.ok(productEntity);
    }

    @Override
    public ResponseEntity getByNameVersion2(String name) {

        return this.productRepository
                .findByName(name)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());

    }

    @Override
    public ResponseEntity getByNameAndStock(String name, int stock) {
        return this.productRepository
                .findByNameAndStockGreaterThan(name,stock)
                .map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }
}
