package com.contract_manegement.business.management.services;

import com.contract_manegement.business.management.controllers.dtos.SupplierRegisterDTO;
import com.contract_manegement.business.management.controllers.dtos.SupplierResponseDTO;
import com.contract_manegement.business.management.controllers.dtos.SupplierUpdateDTO;
import com.contract_manegement.business.management.models.Suppliers;
import com.contract_manegement.business.management.repositories.SupplierRepository;
import com.contract_manegement.business.management.services.mappers.SupplierMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierImplService implements SupplierService{

    @Autowired
    private SupplierRepository supplierRepository;

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

    }

    @Override
    public void remove(String id) {

    }
}
