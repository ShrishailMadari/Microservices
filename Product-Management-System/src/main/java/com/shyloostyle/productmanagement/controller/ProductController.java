package com.shyloostyle.productmanagement.controller;

import com.shyloostyle.productmanagement.dto.ProductRequestDTO;
import com.shyloostyle.productmanagement.dto.ProductResponseDTO;
import com.shyloostyle.productmanagement.service.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    //Creating Product:
    @PostMapping("/product")
    public ResponseEntity<ProductResponseDTO> createProduct(@Valid @RequestBody ProductRequestDTO productRequestDTO){
        ProductResponseDTO product = productService.createProduct(productRequestDTO);
        if (!ObjectUtils.isEmpty(product)){
            return new ResponseEntity<>(product,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    //Get Product By Id:
    public ResponseEntity<ProductResponseDTO> getProductById(@Valid @PathVariable Long id){
        ProductResponseDTO productById = productService.getProductById(id);
        return ResponseEntity.status(HttpStatus.OK).body(productById);
    }





}
