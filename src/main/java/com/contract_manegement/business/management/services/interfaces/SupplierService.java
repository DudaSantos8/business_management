package com.contract_manegement.business.management.services.interfaces;

import com.contract_manegement.business.management.controllers.supplier.dtos.SupplierRegisterDTO;
import com.contract_manegement.business.management.controllers.supplier.dtos.SupplierResponseDTO;
import com.contract_manegement.business.management.controllers.supplier.dtos.SupplierUpdateDTO;

import java.util.List;

public interface SupplierService {
    List<SupplierResponseDTO> getAll();

    SupplierResponseDTO getById(String id);

    void create(SupplierRegisterDTO registerDTO);

    void update(SupplierUpdateDTO updateDTO, String id);

    void remove(String id);
}
