package com.contract_manegement.business.management.services;

import com.contract_manegement.business.management.controllers.supplier.dtos.SupplierRegisterDTO;
import com.contract_manegement.business.management.controllers.supplier.dtos.SupplierResponseContractDTO;
import com.contract_manegement.business.management.controllers.supplier.dtos.SupplierResponseDTO;
import com.contract_manegement.business.management.controllers.supplier.dtos.SupplierUpdateDTO;
import com.contract_manegement.business.management.models.Contracts;
import com.contract_manegement.business.management.models.Suppliers;
import com.contract_manegement.business.management.repositories.ContractRepository;
import com.contract_manegement.business.management.repositories.SupplierRepository;
import com.contract_manegement.business.management.services.interfaces.SupplierService;
import com.contract_manegement.business.management.services.mappers.SupplierMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class SupplierImplService implements SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private ContractRepository contractRepository;

    @Override
    public List<SupplierResponseDTO> getAll() {
        List<Suppliers> list = supplierRepository.findAll();
        return SupplierMapper.forSupplierResponse(list);
    }

    @Override
    public SupplierResponseDTO getById(String id) {
        Optional<Suppliers> optional = supplierRepository.findById(id);
        return SupplierMapper.forSupplierResponse(optional.orElseThrow(()-> new RuntimeException("this supplier don't exist")));
    }

    @Override
    public void create(SupplierRegisterDTO registerDTO) {
        supplierRepository.save(SupplierMapper.forSupplier(registerDTO));
    }

    @Override
    public void update(SupplierUpdateDTO updateDTO, String id) {
        Optional<Suppliers> optional = supplierRepository.findById(id);
        if(optional.isPresent()){
            optional.get().setName(updateDTO.getName());
            optional.get().setCnpj(updateDTO.getCnpj());
            optional.get().setAddress(updateDTO.getAddress());
            optional.get().setPhoneNumber(updateDTO.getPhoneNumber());
            supplierRepository.save(optional.get());
        }else{
            throw new RuntimeException("this supplier don't exist");
        }
    }

    @Override
    public void remove(String id) {
        Optional<Suppliers> optional = supplierRepository.findById(id);
        if(optional.isPresent()){
            supplierRepository.delete(optional.get());
        }else{
            throw new RuntimeException("this supplier don't exist");
        }
    }

    @Override
    public SupplierResponseContractDTO getContractsById(String id) {
        Optional<Suppliers> suppliers = supplierRepository.findById(id);
        return SupplierMapper.forSupplierResponseContract(suppliers.
                orElseThrow(()-> new RuntimeException("this supplier don't exist")));
    }

    @Override
    public SupplierResponseContractDTO getContractsByStartDate(String id, LocalDate date) {
        Optional<Suppliers> suppliers = Optional.ofNullable(supplierRepository.findById(id).
                orElseThrow(() -> new RuntimeException("This supplier don't exist")));
        List<Contracts> contracts = contractRepository.findBySupplierIdAndStartDateGreaterThanEqual(id, date);
        return SupplierMapper.forSupplierResponseContractByFilter(suppliers.get(), contracts);
    }

    @Override
    public SupplierResponseContractDTO getContractsByEndDate(String id, LocalDate date) {
        Optional<Suppliers> suppliers = Optional.ofNullable(supplierRepository.findById(id).
                orElseThrow(() -> new RuntimeException("This supplier don't exist")));
        List<Contracts> contracts = contractRepository.findBySupplierIdAndEndDateGreaterThanEqual(id, date);
        return SupplierMapper.forSupplierResponseContractByFilter(suppliers.get(), contracts);
    }

    @Override
    public SupplierResponseContractDTO getContractsByActive(String id, Boolean active) {
        Optional<Suppliers> suppliers = Optional.ofNullable(supplierRepository.findById(id).
                orElseThrow(() -> new RuntimeException("This supplier don't exist")));
        List<Contracts> contracts = contractRepository.findBySupplierIdAndActiveThanEqual(id, active);
        return SupplierMapper.forSupplierResponseContractByFilter(suppliers.get(), contracts);
    }

    @Override
    public SupplierResponseContractDTO getContractsContains(String id, String keyword) {
        Optional<Suppliers> suppliers = Optional.ofNullable(supplierRepository.findById(id).
                orElseThrow(() -> new RuntimeException("This supplier don't exist")));
        List<Contracts> contracts = contractRepository.findBySupplierIdAndDescriptionContaining(id, keyword);
        return SupplierMapper.forSupplierResponseContractByFilter(suppliers.get(), contracts);
    }
}
