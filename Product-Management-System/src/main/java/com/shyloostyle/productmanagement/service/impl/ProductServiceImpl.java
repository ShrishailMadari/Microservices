package com.shyloostyle.productmanagement.service.impl;

import com.shyloostyle.productmanagement.dto.ProductRequestDTO;
import com.shyloostyle.productmanagement.dto.ProductResponseDTO;
import com.shyloostyle.productmanagement.entity.Product;
import com.shyloostyle.productmanagement.exception.ProductNotFoundException;
import com.shyloostyle.productmanagement.repository.ProductRepository;
import com.shyloostyle.productmanagement.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO requestDTO) {

            Product product = Product.builder()
                    .name(requestDTO.getName().trim())
                    .description(requestDTO.getDescription())
                    .price(requestDTO.getPrice())
                    .quantity(requestDTO.getQuantity())
                    .build();
            productRepository.save(product);
            return toResponse(product);
    }

    private ProductResponseDTO toResponse(Product product) {
        return ProductResponseDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .build();
    }

    @Override
    public ProductResponseDTO updateProduct(Long id,ProductRequestDTO requestDTO) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
        requestDTO.setName(product.getName().trim());
        requestDTO.setDescription(product.getDescription().trim());
        requestDTO.setPrice(product.getPrice());
        requestDTO.setQuantity(product.getQuantity());
        productRepository.save(product);
        return toResponse(product);
    }

    @Override
    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)){
            throw new ProductNotFoundException("Product Not Found On "+id);
        }
        productRepository.deleteById(id);
    }

    @Override
    public ProductResponseDTO getProductById(Long id) {
        if (id == null) {
            throw new ProductNotFoundException("Product on "+id+" cannot be found");
        }
        Product product = productRepository.findById(id).get();
        return toResponse(product);
    }

    @Override
    public ProductResponseDTO getProductByName(String name) {
        if (!ObjectUtils.isEmpty(name)){
            return productRepository.getProductByName(name.trim())
                    .map(this::toResponse)
                    .orElseThrow(()-> new ProductNotFoundException("Product on"+name+"Not Found"));
        }
        throw new IllegalArgumentException("Product name must not be null or empty");
    }
}
