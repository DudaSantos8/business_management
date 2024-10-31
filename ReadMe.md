# Business Management

![](.dev/static/contrato.jpg)

-------
## Introduction of project

This project aims to manage suppliers with their contracts,
with a control whether it is active or not.

## API Supplier

Add new supplier
POST/suppliers
route: localhost:8080/suppliers
```json
{
  "name": "Ivete Sangalo",
  "cnpj": "91.261.564/0001-33",
  "phoneNumber": "(11) 96344-9866",
  "address": "Av. Ipiranga, 200 - República, São Paulo - SP, 01046-010"

}
```
Get all suppliers
GET /suppliers
Route : localhost:8080/suppliers
Return:
```json
[
  {
    "id": "564a5479-ff45-417e-ade1-453c3b00a4e6",
    "name": "Ivete Sangalo",
    "cnpj": "91.261.564/0001-33",
    "phoneNumber": "(11) 96344-9866",
    "address": "Av. Ipiranga, 200 - República, São Paulo - SP, 01046-010"
  },
  {
    "id": "b35443bd-4d01-4860-a36f-3286ebe6a68a",
    "name": "dona maria",
    "cnpj": "59.135.051/0001-73",
    "phoneNumber": "(61) 2761-5163",
    "address": "Rua Pioneiro Francisco Nominato Fritz"
  }
]
```

Get specific supplier 
GET / suppliers
Route : localhost:8080/suppliers/{id_supplier}

Update supplier
PUT / suppliers
Route : localhost:8080/suppliers/{id_supplier}
```json
{
    "name": "dona maria luiza",
    "cnpj": "59.135.051/0001-73",
    "phoneNumber": "(61) 2761-5163",
    "address": "Rua Pioneiro Francisco Nominato Fritz"
}
```

Delete supplier
DELETE / suppliers
Route : localhost:8080/suppliers/{id_supplier}

## API Contract

Add new contract
POST/ suppliers
route: localhost:8080/suppliers/{id_contract}/contracts
```json
{
  "contractNumber": "MCK-2024-021",
  "startDate": "2024-10-30",
  "endDate": "2024-12-01",
  "totalValue": 2000,
  "description": "contrato de serviços",
  "active": true
}
```

Get specific contract
GET / contract
Route : localhost:8080/contracts/{contract_id}

Update contract
PUT / contract
Route : localhost:8080/contracts/{contract_id}
```json
{
  "contractNumber": "MCK-2024-021",
  "startDate": "2021-10-30",
  "endDate": "2024-12-01",
  "totalValue": 20000,
  "description": "contrato de serviços",
  "active": true
}
```

Delete contract
DELETE / contract
Route : localhost:8080/contracts/{contract_id}


## API Filters

Get contracts of specific supplier by start date
GET / suppliers
Route : localhost:8080/suppliers/{id_supplier}/contractsByDate?date={start_date}

```json
{
  "id": "564a5479-ff45-417e-ade1-453c3b00a4e6",
  "name": "Ivete Sangalo",
  "contracts": [
    {
      "contractNumber": "MCK-2024-021",
      "startDate": "2021-10-30",
      "endDate": "2024-12-01",
      "totalValue": 20000,
      "description": "contrato de serviços",
      "active": true
    }
  ]
}
```

Get contracts of specific supplier by end date
GET / suppliers
Route : localhost:8080/suppliers/{id_supplier}/contractsByEndDate?date={end_date}

```json
{
  "id": "564a5479-ff45-417e-ade1-453c3b00a4e6",
  "name": "Ivete Sangalo",
  "contracts": [
    {
      "contractNumber": "MCK-2024-021",
      "startDate": "2021-10-30",
      "endDate": "2024-12-01",
      "totalValue": 20000,
      "description": "contrato de serviços",
      "active": true
    }
  ]
}
```

Get contracts of specific supplier by active
GET / suppliers
Route : localhost:8080/suppliers/{id_supplier}/contractsByActive?active={boolean_active}

Get contracts of specific supplier by keyword
GET / suppliers
Route : localhost:8080/suppliers/{id_supplier}/contractsContains?keyword={keyword}

Ex: keyword = serviços

```json
{
  "id": "564a5479-ff45-417e-ade1-453c3b00a4e6",
  "name": "Ivete Sangalo",
  "contracts": [
    {
      "contractNumber": "MCK-2024-021",
      "startDate": "2021-10-30",
      "endDate": "2024-12-01",
      "totalValue": 20000,
      "description": "contrato de 'serviços' ",
      "active": true
    }
  ]
}
```