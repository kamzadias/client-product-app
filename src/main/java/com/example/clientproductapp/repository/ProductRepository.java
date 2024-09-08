package com.example.clientproductapp.repository;

import com.example.clientproductapp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {

    @Query(value = "SELECT * FROM products WHERE description LIKE %:description%", nativeQuery = true)
    List<Product> findByDescriptionNative(@Param("description") String description);
}
