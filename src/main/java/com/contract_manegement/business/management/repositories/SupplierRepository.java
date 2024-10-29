package com.contract_manegement.business.management.repositories;

import com.contract_manegement.business.management.models.Suppliers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Suppliers, String> {
}
