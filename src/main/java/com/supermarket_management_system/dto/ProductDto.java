package com.supermarket_management_system.dto;

import lombok.Data;

@Data
public class ProductDto {
    private Long id;
    private String name;
    private double price;
    private int quantity;
    private String description;
    private Long categoryId;
    private Long supplierId;
}
