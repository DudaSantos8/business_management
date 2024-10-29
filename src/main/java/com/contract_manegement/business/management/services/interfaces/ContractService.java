package com.contract_manegement.business.management.services.interfaces;

import com.contract_manegement.business.management.controllers.contract.dtos.ContractRegisterDTO;
import com.contract_manegement.business.management.controllers.contract.dtos.ContractResponseDTO;
import com.contract_manegement.business.management.controllers.contract.dtos.ContractUpdateDTO;

public interface ContractService {
    ContractResponseDTO getById(String id);

    void create(String supplierId, ContractRegisterDTO registerDTO);

    void update(String id, ContractUpdateDTO updateDTO);

    void remove(String id);
}
