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

    @Override
    public ResponseEntity<?> getAll() {
        return this.iProductService.getAll();
    }

    @Override
    public ResponseEntity<?> delete(long id) {
        return this.iProductService.deleteById(id);
    }

    @Override
    public ResponseEntity<?> update(ProductDTO productDTO,long id) {
        return this.iProductService.update(productDTO,id);
    }

    @Override
    public ResponseEntity<?> getByName(String name) {
        return this.iProductService.getByName(name);
    }

    @Override
    public ResponseEntity<?> getByNameVersion2(String name) {
        return this.iProductService.getByName(name);
    }

    @Override
    public ResponseEntity<?> getByNameStock(String name, int stock) {
        return this.iProductService.getByNameAndStock(name,stock);
    }
}
