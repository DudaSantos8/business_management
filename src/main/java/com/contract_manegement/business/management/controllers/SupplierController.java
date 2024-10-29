package com.contract_manegement.business.management.controllers;

import com.contract_manegement.business.management.controllers.dtos.SupplierRegisterDTO;
import com.contract_manegement.business.management.controllers.dtos.SupplierResponseDTO;
import com.contract_manegement.business.management.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/suppliers")
public class SupplierController {

    @Autowired
    private SupplierService service;

    @GetMapping
    public List<SupplierResponseDTO> showSuppliers(){
        return service.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createSupplier(@RequestBody SupplierRegisterDTO registerDTO){
        service.create(registerDTO);
    }
}
