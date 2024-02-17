package com.aulamatriz.product.controller.doc;

import com.aulamatriz.product.dto.ProductDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Product" , description = "API exposed for management all products")
@RequestMapping("/api/v1/product")
public interface ProductDoc {

    @Operation(
            summary = "POST create",
            description = "This operation is for create a new product"
    )
    @ApiResponses(
           value = {
                   @ApiResponse (
                           responseCode = "201",
                           description = "product created",
                           content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
                   ),
                   @ApiResponse (
                           responseCode = "404",
                           description = "not found",
                           content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
                   ),
                   @ApiResponse (
                           responseCode = "500",
                           description = "internal server Error",
                           content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
                   )
           }
    )
    @PostMapping
    ResponseEntity<?> createProduct(@RequestBody ProductDTO productDTO);


    @Operation(
            summary = "Get list Product",
            description = "This operation is for getting all products in dafity"
    )
    @ApiResponses(
            value = {
                    @ApiResponse (
                            responseCode = "200",
                            description = "list all products",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
                    ),
                    @ApiResponse (
                            responseCode = "404",
                            description = "not found",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
                    ),
                    @ApiResponse (
                            responseCode = "500",
                            description = "internal server Error",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
                    )
            }
    )
    @GetMapping
    ResponseEntity<?> getAll();


    @Operation(
            summary = "Delete a  Product",
            description = "This operation is for delete a product on database"
    )
    @ApiResponses(
            value = {
                    @ApiResponse (
                            responseCode = "200",
                            description = "list all products",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
                    ),
                    @ApiResponse (
                            responseCode = "404",
                            description = "not found",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
                    ),
                    @ApiResponse (
                            responseCode = "500",
                            description = "internal server Error",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
                    )
            }
    )
    @DeleteMapping("/{id}")
    ResponseEntity<?> delete(@PathVariable long id);


    @Operation(
            summary = "update a  Product",
            description = "This operation is for update a product on database"
    )
    @ApiResponses(
            value = {
                    @ApiResponse (
                            responseCode = "200",
                            description = "update products",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
                    ),
                    @ApiResponse (
                            responseCode = "404",
                            description = "not found",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
                    ),
                    @ApiResponse (
                            responseCode = "500",
                            description = "internal server Error",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)
                    )
            }
    )
    @PutMapping("/{id}")
    ResponseEntity<?> update(@RequestBody ProductDTO productDTO,@PathVariable long id);

}
