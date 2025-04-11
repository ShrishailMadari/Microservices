package com.shyloostyle.productmanagement.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDTO {

    @NotBlank(message = "Name Is Required")
    private String name;

    @NotBlank(message = "Description is Required")
    private String description;

    @NotNull(message = "Price is Required")
    @Positive(message = "Price must be positive")
    private Double price;

    @NotNull(message = "Quantity is Required")
    @Min(value = 1,message = "Quantity must be at least 1")
    private Integer quantity;

}
