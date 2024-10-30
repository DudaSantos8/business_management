package com.contract_manegement.business.management.controllers.contract;

import com.contract_manegement.business.management.controllers.contract.dtos.ContractUpdateDTO;
import com.contract_manegement.business.management.services.interfaces.ContractService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("contracts")
public class ContractController {

    @Autowired
    private ContractService service;

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable String id){
        try {
            return ResponseEntity.ok().body(service.getById(id));
        }catch (Exception e){
            return ResponseEntity.status(404).body(Map.of("message", e.getMessage()));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateContract(@PathVariable String id, @RequestBody @Valid ContractUpdateDTO updateDTO){
        try {
            service.update(id, updateDTO);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.status(404).body(Map.of("message", e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteContract(@PathVariable String id){
        try {
            service.remove(id);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.status(404).body(Map.of("message", e.getMessage()));
        }
    }
}
