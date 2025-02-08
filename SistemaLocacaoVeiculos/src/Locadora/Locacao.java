package Locadora;

import Cliente.Cliente;
import Veiculo.Veiculo;

import java.util.Date;

public class Locacao {
    private Cliente cliente;
    private Veiculo veiculo;
    private int dias;
    private Date dataInicio;
    private Date dataFim;

    public Locacao(Cliente cliente, Veiculo veiculo, int dias) {
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.dias = dias;
        this.dataInicio = new Date();
        this.dataFim = new Date(this.dataInicio.getTime() + (dias * 24 * 60 * 60 * 1000));
    }

    public double calcularValorTotal() {
        return veiculo.calcularCusto(dias);
    }


    public Cliente getCliente() {
        return cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }
}

