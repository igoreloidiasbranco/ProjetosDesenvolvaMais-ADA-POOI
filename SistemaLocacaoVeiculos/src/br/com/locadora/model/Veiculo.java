package br.com.locadora.model;

public class Veiculo {
    private String modelo;
    private String placa;
    private double valorDiaria;
    private boolean disponibilidade;

    public Veiculo(String modelo, String placa, double valorDiaria, boolean disponibilidade) {
        this.modelo = modelo;
        this.placa = placa;
        this.valorDiaria = valorDiaria;
        this.disponibilidade = disponibilidade;
    }

    public Veiculo() {

    }

    public String getModelo() { return modelo; }
    public String getPlaca() { return placa; }
    public double getValorDiaria() { return valorDiaria; }
    public boolean isDisponibilidade() { return disponibilidade; }

    public void setDisponibilidade(boolean disponibilidade) { this.disponibilidade = disponibilidade; }

    @Override
    public String toString() {
        return "Modelo: " + modelo + ", Placa: " + placa + ", Valor Diária: R$ " + valorDiaria + ", Disponível: " + disponibilidade;
    }
}
