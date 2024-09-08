package com.example.clientproductapp.specification;

import com.example.clientproductapp.entity.Product;
import org.springframework.data.jpa.domain.Specification;

public class ProductSpecification {

    public static Specification<Product> hasCategoryId(Long categoryId) {
        return (root, query, criteriaBuilder) ->
                categoryId == null ? null : criteriaBuilder.equal(root.get("categoryId"), categoryId);
    }

    public static Specification<Product> hasPrice(Double price) {
        return (root, query, criteriaBuilder) ->
                price == null ? null : criteriaBuilder.equal(root.get("price"), price);
    }

    public static Specification<Product> hasDescription(String description) {
        return (root, query, criteriaBuilder) ->
                description == null ? null : criteriaBuilder.like(root.get("description"), "%" + description + "%");
    }
}
