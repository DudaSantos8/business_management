package com.contract_manegement.business.management.services.interfaces;

import com.contract_manegement.business.management.controllers.supplier.dtos.SupplierRegisterDTO;
import com.contract_manegement.business.management.controllers.supplier.dtos.SupplierResponseContractDTO;
import com.contract_manegement.business.management.controllers.supplier.dtos.SupplierResponseDTO;
import com.contract_manegement.business.management.controllers.supplier.dtos.SupplierUpdateDTO;

import java.time.LocalDate;
import java.util.List;

public interface SupplierService {
    List<SupplierResponseDTO> getAll();

    SupplierResponseDTO getById(String id);

    void create(SupplierRegisterDTO registerDTO);

    void update(SupplierUpdateDTO updateDTO, String id);

    void remove(String id);

    SupplierResponseContractDTO getContractsById(String id);

    SupplierResponseContractDTO getContractsByStartDate(String id, LocalDate date);

    SupplierResponseContractDTO getContractsByEndDate(String id, LocalDate date);

    SupplierResponseContractDTO getContractsByActive(String id, Boolean active);

    SupplierResponseContractDTO getContractsContains(String id, String keyword);

}
