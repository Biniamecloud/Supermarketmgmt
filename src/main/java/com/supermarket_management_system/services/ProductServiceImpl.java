package com.supermarket_management_system.services;


import com.supermarket_management_system.dto.ProductDto;
import com.supermarket_management_system.entities.Product;
import com.supermarket_management_system.repositories.ProductRepository;
import com.supermarket_management_system.repositories.CategoryRepository;
import com.supermarket_management_system.repositories.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final SupplierRepository supplierRepository;

    @Override
    public List<ProductDto> getAllProducts() {
        return productRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto getProductById(Long id) {
        var product = productRepository.findById(id).orElseThrow();
        return convertToDto(product);
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        var category = categoryRepository.findById(productDto.getCategoryId()).orElseThrow();
        var supplier = supplierRepository.findById(productDto.getSupplierId()).orElseThrow();
        var product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setQuantity(productDto.getQuantity());
        product.setDescription(productDto.getDescription());
        product.setCategory(category);
        product.setSupplier(supplier);
        productRepository.save(product);
        return convertToDto(product);
    }

    @Override
    public ProductDto updateProduct(Long id, ProductDto productDto) {
        var product = productRepository.findById(id).orElseThrow();
        var category = categoryRepository.findById(productDto.getCategoryId()).orElseThrow();
        var supplier = supplierRepository.findById(productDto.getSupplierId()).orElseThrow();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setQuantity(productDto.getQuantity());
        product.setDescription(productDto.getDescription());
        product.setCategory(category);
        product.setSupplier(supplier);
        productRepository.save(product);
        return convertToDto(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    private ProductDto convertToDto(Product product) {
        var productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        productDto.setQuantity(product.getQuantity());
        productDto.setDescription(product.getDescription());
        productDto.setCategoryId(product.getCategory().getId());
        productDto.setSupplierId(product.getSupplier().getId());
        return productDto;
    }
}
