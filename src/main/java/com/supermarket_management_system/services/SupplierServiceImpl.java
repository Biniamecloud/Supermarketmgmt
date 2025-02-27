package com.supermarket_management_system.services;



import com.supermarket_management_system.dto.SupplierDto;
import com.supermarket_management_system.entities.Supplier;
import com.supermarket_management_system.repositories.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;

    @Override
    public List<SupplierDto> getAllSuppliers() {
        return supplierRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public SupplierDto getSupplierById(Long id) {
        var supplier = supplierRepository.findById(id).orElseThrow();
        return convertToDto(supplier);
    }

    @Override
    public SupplierDto createSupplier(SupplierDto supplierDto) {
        var supplier = new Supplier();
        supplier.setName(supplierDto.getName());
        supplier.setContactInfo(supplierDto.getContactInfo());
        supplierRepository.save(supplier);
        return convertToDto(supplier);
    }

    @Override
    public SupplierDto updateSupplier(Long id, SupplierDto supplierDto) {
        var supplier = supplierRepository.findById(id).orElseThrow();
        supplier.setName(supplierDto.getName());
        supplier.setContactInfo(supplierDto.getContactInfo());
        supplierRepository.save(supplier);
        return convertToDto(supplier);
    }

    @Override
    public void deleteSupplier(Long id) {
        supplierRepository.deleteById(id);
    }

    private SupplierDto convertToDto(Supplier supplier) {
        var supplierDto = new SupplierDto();
        supplierDto.setId(supplier.getId());
        supplierDto.setName(supplier.getName());
        supplierDto.setContactInfo(supplier.getContactInfo());
        return supplierDto;
    }
}

