package com.contract_manegement.business.management.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import org.hibernate.annotations.UuidGenerator;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Suppliers {

    @Id
    @UuidGenerator
    private String id;
    private String name;
    private String cnpj;
    private String phoneNumber;
    private String address;

    @OneToMany(mappedBy = "suppliers", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Contracts> contracts = new ArrayList<>();

    public Suppliers() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public List<Contracts> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contracts> contracts) {
        this.contracts = contracts;
    }
}
