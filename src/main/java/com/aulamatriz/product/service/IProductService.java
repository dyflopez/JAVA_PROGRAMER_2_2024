package com.aulamatriz.product.service;

import com.aulamatriz.product.dto.ProductDTO;
import org.springframework.http.ResponseEntity;

public interface IProductService {

    ResponseEntity save(ProductDTO productDTO);

    ResponseEntity getAll();

    ResponseEntity deleteById(long id);


    ResponseEntity update(ProductDTO productDTO , long id);


    ResponseEntity getByName(String name);

    ResponseEntity getByNameVersion2(String name);

    ResponseEntity getByNameAndStock(String name,int stock);

}
