package com.contract_manegement.business.management.controllers.supplier.dtos;

import com.contract_manegement.business.management.controllers.contract.dtos.ContractResponseDTO;

import java.util.List;

public class SupplierResponseContractDTO {
    private String id;
    private String name;
    private List<ContractResponseDTO> contracts;

    public SupplierResponseContractDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ContractResponseDTO> getContracts() {
        return contracts;
    }

    public void setContracts(List<ContractResponseDTO> contracts) {
        this.contracts = contracts;
    }
}
