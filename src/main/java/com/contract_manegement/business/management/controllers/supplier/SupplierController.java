package com.contract_manegement.business.management.controllers.supplier;

import com.contract_manegement.business.management.controllers.contract.dtos.ContractRegisterDTO;
import com.contract_manegement.business.management.controllers.supplier.dtos.SupplierRegisterDTO;
import com.contract_manegement.business.management.controllers.supplier.dtos.SupplierResponseDTO;
import com.contract_manegement.business.management.controllers.supplier.dtos.SupplierUpdateDTO;
import com.contract_manegement.business.management.services.interfaces.ContractService;
import com.contract_manegement.business.management.services.interfaces.SupplierService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/suppliers")
public class SupplierController {

    @Autowired
    private SupplierService service;

    @Autowired
    private ContractService contractService;

    @GetMapping
    public List<SupplierResponseDTO> showSuppliers(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable String id){
        try {
            return ResponseEntity.ok().body(service.getById(id));
        }catch (Exception e){
            return ResponseEntity.status(404).body(Map.of("message", e.getMessage()));
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createSupplier(@RequestBody @Valid SupplierRegisterDTO registerDTO){
        service.create(registerDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSupplier(@PathVariable String id, @RequestBody @Valid SupplierUpdateDTO updateDTO){
        try {
            service.update(updateDTO, id);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.status(404).body(Map.of("message", e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSupplier(@PathVariable String id){
        try {
            service.remove(id);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.status(404).body(Map.of("message", e.getMessage()));
        }
    }

    @GetMapping("/{id}/contracts")
    public ResponseEntity<?> getContractsById(@PathVariable String id){
        try {
            return ResponseEntity.ok().body(service.getContractsById(id));
        }catch (Exception e){
            return ResponseEntity.status(404).body(Map.of("message", e.getMessage()));
        }
    }

    @GetMapping("/{id}/contractsByDate")
    public ResponseEntity<?> getContractsByStartDate(@PathVariable String id, @RequestParam LocalDate date){
        try {
            return ResponseEntity.ok().body(service.getContractsByStartDate(id, date));
        }catch (Exception e){
            return ResponseEntity.status(404).body(Map.of("message", e.getMessage()));
        }
    }

    @GetMapping("/{id}/contractsByEndDate")
    public ResponseEntity<?> getContractsByEndDate(@PathVariable String id, @RequestParam LocalDate date){
        try {
            return ResponseEntity.ok().body(service.getContractsByEndDate(id, date));
        }catch (Exception e){
            return ResponseEntity.status(404).body(Map.of("message", e.getMessage()));
        }
    }

    @GetMapping("/{id}/contractsByActive")
    public ResponseEntity<?> getContractsByActive(@PathVariable String id, @RequestParam Boolean active){
        try {
            return ResponseEntity.ok().body(service.getContractsByActive(id, active));
        }catch (Exception e){
            return ResponseEntity.status(404).body(Map.of("message", e.getMessage()));
        }
    }

    @GetMapping("/{id}/contractsContains")
    public ResponseEntity<?> getContractsContains(@PathVariable String id, @RequestParam String keyword){
        try {
            return ResponseEntity.ok().body(service.getContractsContains(id, keyword));
        }catch (Exception e){
            return ResponseEntity.status(404).body(Map.of("message", e.getMessage()));
        }
    }

    @PostMapping("/{supplierId}/contracts")
    public ResponseEntity<?> createContract(@PathVariable String supplierId, @RequestBody @Valid ContractRegisterDTO contractRegisterDTO){
        try {
            contractService.create(supplierId, contractRegisterDTO);
            return ResponseEntity.status(201).build();
        }catch (Exception e){
            return ResponseEntity.status(404).body(Map.of("message", e.getMessage()));
        }
    }
}
