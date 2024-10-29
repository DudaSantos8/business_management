package com.contract_manegement.business.management.repositories;

import com.contract_manegement.business.management.models.Contracts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends JpaRepository<Contracts, String> {
}
