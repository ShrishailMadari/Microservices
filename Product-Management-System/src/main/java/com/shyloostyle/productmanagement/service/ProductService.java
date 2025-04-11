package com.shyloostyle.productmanagement.service;

import com.shyloostyle.productmanagement.dto.ProductRequestDTO;
import com.shyloostyle.productmanagement.dto.ProductResponseDTO;

public interface ProductService {
    ProductResponseDTO createProduct(ProductRequestDTO requestDTO);
    ProductResponseDTO updateProduct(Long id,ProductRequestDTO requestDTO);
    void deleteProduct(Long id);
    ProductResponseDTO getProductById(Long id);
    ProductResponseDTO getProductByName(String name);
}
