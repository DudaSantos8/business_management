package com.contract_manegement.business.management.controllers.contract.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class ContractRegisterDTO {

    @NotBlank(message = "this field can't be blank")
    @NotNull(message = "this field can't be null")
    private String contractNumber;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "this field can't be null")
    private LocalDate startDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "this field can't be null")
    private LocalDate endDate;

    @Min(value = 1, message = "the value can't be zero")
    private Number totalValue;

    @NotBlank(message = "this field can't be blank")
    @NotNull(message = "this field can't be null")
    private String description;

    @NotNull(message = "this field can't be null")
    private Boolean active;

    public ContractRegisterDTO() {
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Number getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Number totalValue) {
        this.totalValue = totalValue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
