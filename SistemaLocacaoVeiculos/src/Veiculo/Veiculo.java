package Veiculo;

public abstract class Veiculo {
    private String modelo;
    private String placa;
    private double diaria;
    private boolean disponibilidade;

    public Veiculo(String modelo, String placa, double diaria) {
        this.modelo = modelo;
        this.placa = placa;
        this.diaria = diaria;
        this.disponibilidade = true;
    }

    public abstract double calcularCusto(int dias);


    public String getModelo() {
        return modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public double getDiaria() {
        return diaria;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void alugar() {
        this.disponibilidade = false;
    }

    public void devolver() {
        this.disponibilidade = true;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }
}
