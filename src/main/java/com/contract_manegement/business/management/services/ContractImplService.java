package com.contract_manegement.business.management.services;

import com.contract_manegement.business.management.controllers.contract.dtos.ContractRegisterDTO;
import com.contract_manegement.business.management.controllers.contract.dtos.ContractResponseDTO;
import com.contract_manegement.business.management.controllers.contract.dtos.ContractUpdateDTO;
import com.contract_manegement.business.management.models.Contracts;
import com.contract_manegement.business.management.models.Suppliers;
import com.contract_manegement.business.management.repositories.ContractRepository;
import com.contract_manegement.business.management.repositories.SupplierRepository;
import com.contract_manegement.business.management.services.interfaces.ContractService;
import com.contract_manegement.business.management.services.mappers.ContractMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContractImplService implements ContractService {

    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public ContractResponseDTO getById(String id) {
        return null;
    }

    @Override
    public void create(String supplierId, ContractRegisterDTO registerDTO) {
        Optional<Suppliers> supplier = supplierRepository.findById(supplierId);

        if(supplier.isPresent()){
            Contracts contracts = ContractMapper.forContract(supplier.get(), registerDTO);
            contractRepository.save(contracts);
        }else{
            throw new RuntimeException("the supplier don't exist");
        }

    }

    @Override
    public void update(ContractUpdateDTO updateDTO) {

    }

    @Override
    public void remove(String id) {

    }
}
