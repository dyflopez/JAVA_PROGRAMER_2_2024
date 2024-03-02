package com.aulamatriz.product.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class SaludoController {

    @Value("${saludo.aulamatriz}")
    private String saludo;

    @GetMapping
    public ResponseEntity showSaludo (){
        return  ResponseEntity.ok(saludo);
    }
}
