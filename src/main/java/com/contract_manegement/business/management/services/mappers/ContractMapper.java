package com.contract_manegement.business.management.services.mappers;

import com.contract_manegement.business.management.controllers.contract.dtos.ContractRegisterDTO;
import com.contract_manegement.business.management.models.Contracts;
import com.contract_manegement.business.management.models.Suppliers;

import java.time.LocalDate;


public class ContractMapper {

    public static Contracts forContract(Suppliers supplier, ContractRegisterDTO registerDTO){
        Contracts contract = new Contracts();

        contract.setContractNumber(registerDTO.getContractNumber());
        contract.setStartDate(registerDTO.getStartDate());
        contract.setEndDate(registerDTO.getEndDate());
        contract.setTotalValue(registerDTO.getTotalValue());
        contract.setDescription(registerDTO.getDescription());
        if (registerDTO.getStartDate().isBefore(registerDTO.getEndDate())){
            contract.setActive(registerDTO.getEndDate().isAfter(LocalDate.now()));
        }
        contract.setSuppliers(supplier);

        return contract;
    }
}
