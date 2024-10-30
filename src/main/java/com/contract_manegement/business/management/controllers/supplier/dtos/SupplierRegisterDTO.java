package com.contract_manegement.business.management.controllers.supplier.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CNPJ;

public class SupplierRegisterDTO {

    @NotBlank(message = "this field can't be blank")
    @NotNull(message = "this field can't be null")
    private String name;

    @CNPJ(message = "cnpj not valid")
    private String cnpj;

    @NotBlank(message = "this field can't be blank")
    @NotNull(message = "this field can't be null")
    private String phoneNumber;

    @NotBlank(message = "this field can't be blank")
    @NotNull(message = "this field can't be null")
    private String address;

    public SupplierRegisterDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
