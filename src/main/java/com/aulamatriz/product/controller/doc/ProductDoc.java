package com.aulamatriz.product.controller.doc;

import com.aulamatriz.product.dto.ProductDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "Product" , description = "API exposed for management all products")
@RequestMapping("/api/v1/product")
public interface ProductDoc {

    @PostMapping
    ResponseEntity<?> createProduct(@RequestBody ProductDTO productDTO);
}
