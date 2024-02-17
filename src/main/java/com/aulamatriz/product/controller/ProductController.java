package com.aulamatriz.product.controller;

import com.aulamatriz.product.controller.doc.ProductDoc;
import com.aulamatriz.product.dto.ProductDTO;
import com.aulamatriz.product.service.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


@AllArgsConstructor
@RestController
public class ProductController implements ProductDoc {

    private final IProductService iProductService;

    @Override
    public ResponseEntity<?> createProduct(ProductDTO productDTO) {
        return this.iProductService.save(productDTO);
    }
}
