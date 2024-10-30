package com.contract_manegement.business.management.repositories;

import com.contract_manegement.business.management.models.Contracts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ContractRepository extends JpaRepository<Contracts, String> {

    @Query(value = "SELECT * FROM contracts WHERE supplier_id = :supplierId AND start_date = :startDate", nativeQuery = true)
    List<Contracts> findBySupplierIdAndStartDateGreaterThanEqual(
            @Param("supplierId") String supplierId,
            @Param("startDate") LocalDate startDate
    );

    @Query(value = "SELECT * FROM contracts WHERE supplier_id = :supplierId AND end_date = :endDate", nativeQuery = true)
    List<Contracts> findBySupplierIdAndEndDateGreaterThanEqual(
            @Param("supplierId") String supplierId,
            @Param("endDate") LocalDate endDate
    );

    @Query(value = "SELECT * FROM contracts WHERE supplier_id = :supplierId AND active = :active", nativeQuery = true)
    List<Contracts> findBySupplierIdAndActiveThanEqual(
            @Param("supplierId") String supplierId,
            @Param("active") Boolean active);
}
