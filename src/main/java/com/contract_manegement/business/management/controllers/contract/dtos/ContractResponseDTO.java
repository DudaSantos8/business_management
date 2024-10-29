package com.contract_manegement.business.management.controllers.contract.dtos;

public class ContractResponseDTO {
    private String contractNumber;
    private Number totalValue;
    private String description;
    private Boolean active;

    public ContractResponseDTO() {
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
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
