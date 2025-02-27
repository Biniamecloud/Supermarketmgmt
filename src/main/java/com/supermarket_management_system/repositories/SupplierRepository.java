package com.supermarket_management_system.repositories;



import com.supermarket_management_system.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}

