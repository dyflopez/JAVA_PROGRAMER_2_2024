package com.aulamatriz.product.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDTO extends TraceDTO{

    @NotNull
    @Size(min = 3, message = "El nombre debe tener al menos 3 caracteres")
    private String name;

    @NotNull
    @Size(min = 4)
    private String description;

    @NotNull
    @DecimalMin(value = "10.0")
    private BigDecimal price;


    @NotNull
    @Min(value = 0, message = "el stock no puede ser negativo")
    private int stock;

}
