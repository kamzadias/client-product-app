package com.example.clientproductapp.service;

import com.example.clientproductapp.dto.ProductDto;
import com.example.clientproductapp.entity.Product;
import com.example.clientproductapp.repository.ProductRepository;
import com.example.clientproductapp.specification.ProductSpecification;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public ProductService(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    public List<ProductDto> getProductsByDescription(String description) {
        List<Product> products = productRepository.findByDescriptionNative(description);
        return products.stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .toList();
    }

    public List<ProductDto> getProductsByFilter(Long categoryId, Double price, String description) {
        Specification<Product> spec = Specification
                .where(ProductSpecification.hasCategoryId(categoryId))
                .and(ProductSpecification.hasPrice(price))
                .and(ProductSpecification.hasDescription(description));

        List<Product> products = productRepository.findAll(spec);
        return products.stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .toList();
    }
}
