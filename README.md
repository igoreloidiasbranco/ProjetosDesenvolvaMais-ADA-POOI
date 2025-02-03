# Projeto DesenvolvaMais-ADA-POOI
Projeto final do módulo Programação Orientada a Objetos I

## Grupo 2: 
- Daniela Marcilio Dmarc
- Ezequias Lima
- Igor Eloi
- Ronaldo Di George
- Wander Leandro

# Sistema de Locação de Veículos 

## Descrição Geral 
O objetivo deste projeto é desenvolver um sistema para uma locadora de veículos, aplicando os conceitos de Programação Orientada a Objetos (POO) em Java. O sistema permitirá o cadastro de veículos, clientes e locações, além de oferecer serviços adicionais para veículos de luxo. O projeto visa praticar conceitos essenciais, como **encapsulamento, herança, polimorfismo e interfaces, além de dividir as responsabilidades do projeto em equipe**. 

## Requisitos Funcionais 

O sistema deve permitir as seguintes funcionalidades: 

### Cadastro de Veículos 
- Os veículos podem ser de diferentes tipos, como **CarroComum, CarroPremium, SUV, Moto e Caminhão.**
- Apenas **Carros Premium e SUVs** podem oferecer serviços de luxo (Carros Comuns não podem oferecer comportamentos de serviços de luxo).
- Cada veículo possui:
  - Modelo
  - Placa
  - Valor da diária
  - Disponibilidade 

### Cadastro de Clientes 
- Dois tipos de clientes: 
  - **Pessoa Física** (CPF)
  - **Pessoa Jurídica** (CNPJ)
  
- Informações comuns:
  - Nome
  - Documento (CPF/CNPJ)
  - Endereço
  - Telefone
  
### Locação de Veículos 
- Um cliente pode alugar um veículo por um período específico.
- O sistema deve calcular o valor total da locação com base no número de dias e na tarifa diária do veículo.
- Deve verificar se o veículo está disponível antes de alugar.

### Serviços de Luxo
- Apenas veículos premium (CarroPremium e SUV) podem oferecer serviços adicionais. **(`VeiculoLuxo -> oferecerServicoPremium()`)**

### Relatórios e Consultas
- Listagem de veículos disponíveis.
- Listagem de veículos alugados.
- Listagem de veículos de luxo.
