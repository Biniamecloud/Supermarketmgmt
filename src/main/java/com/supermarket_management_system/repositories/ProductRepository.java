package com.supermarket_management_system.repositories;



import com.supermarket_management_system.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}

