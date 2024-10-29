package com.contract_manegement.business.management.services.mappers;

import com.contract_manegement.business.management.controllers.supplier.dtos.SupplierRegisterDTO;
import com.contract_manegement.business.management.controllers.supplier.dtos.SupplierResponseDTO;
import com.contract_manegement.business.management.models.Suppliers;

import java.util.ArrayList;
import java.util.List;

public class SupplierMapper {

    public static Suppliers forSupplier(SupplierRegisterDTO registerDTO){
        Suppliers supplier = new Suppliers();

        supplier.setName(registerDTO.getName());
        supplier.setCnpj(registerDTO.getCnpj());
        supplier.setPhoneNumber(registerDTO.getPhoneNumber());
        supplier.setAddress(registerDTO.getAddress());

        return supplier;
    }

    public static List<SupplierResponseDTO> forSupplierResponse(List<Suppliers> suppliersList){
        List<SupplierResponseDTO> dtoList = new ArrayList<>();
        for(Suppliers supplier : suppliersList){
            SupplierResponseDTO dto = new SupplierResponseDTO();
            dto.setId(supplier.getId());
            dto.setName(supplier.getName());
            dto.setPhoneNumber(supplier.getPhoneNumber());
            dto.setAddress(supplier.getAddress());
            dto.setCnpj(supplier.getCnpj());
            dtoList.add(dto);
        }
        return dtoList;
    }

    public static SupplierResponseDTO forSupplierResponse(Suppliers supplier){
        SupplierResponseDTO responseDTO = new SupplierResponseDTO();
        responseDTO.setId(supplier.getId());
        responseDTO.setName(supplier.getName());
        responseDTO.setAddress(supplier.getAddress());
        responseDTO.setCnpj(supplier.getCnpj());
        responseDTO.setPhoneNumber(supplier.getPhoneNumber());

        return responseDTO;
    }
}
