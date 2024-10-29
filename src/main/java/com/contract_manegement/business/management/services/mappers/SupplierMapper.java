package com.contract_manegement.business.management.services.mappers;

import com.contract_manegement.business.management.controllers.dtos.SupplierRegisterDTO;
import com.contract_manegement.business.management.models.Suppliers;

public class SupplierMapper {

    public static Suppliers forSupplier(SupplierRegisterDTO registerDTO){
        Suppliers supplier = new Suppliers();

        supplier.setName(registerDTO.getName());
        supplier.setCnpj(registerDTO.getCnpj());
        supplier.setPhoneNumber(registerDTO.getPhoneNumber());
        supplier.setAddress(registerDTO.getAddress());

        return supplier;
    }
}
