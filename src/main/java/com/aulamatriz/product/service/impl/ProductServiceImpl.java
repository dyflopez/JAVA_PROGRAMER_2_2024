package com.aulamatriz.product.service.impl;

import com.aulamatriz.product.repository.ProductRepository;
import com.aulamatriz.product.service.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements IProductService {

    private final ProductRepository productRepository;

}
