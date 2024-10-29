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
import com.contract_manegement.business.management.services.mappers.SupplierMapper;
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
        Optional<Contracts> optional = contractRepository.findById(id);
        return ContractMapper.forContractResponse(optional.orElseThrow(()-> new RuntimeException("this contract don't exist")));
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
    public void update(String id,ContractUpdateDTO updateDTO) {
        Optional<Contracts> optional = contractRepository.findById(id);
        if(optional.isPresent()){
            optional.get().setContractNumber(updateDTO.getContractNumber());
            optional.get().setStartDate(updateDTO.getStartDate());
            optional.get().setEndDate(updateDTO.getEndDate());
            optional.get().setTotalValue(updateDTO.getTotalValue());
            optional.get().setDescription(updateDTO.getDescription());
            contractRepository.save(optional.get());
        }else{
            throw new RuntimeException("this contract don't exist");
        }
    }

    @Override
    public void remove(String id) {

    }
}
