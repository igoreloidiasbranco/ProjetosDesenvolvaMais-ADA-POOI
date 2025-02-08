package Locadora;

import Cliente.Cliente;
import Veiculo.*;

import java.util.ArrayList;
import java.util.List;

public class Locadora {
    private List<Veiculo> veiculos;
    private List<Locacao> locacoes;

    public Locadora() {
        veiculos = new ArrayList<>();
        locacoes = new ArrayList<>();
    }

    public void cadastrarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
    }


    public void realizarLocacao(Cliente cliente, Veiculo veiculo, int dias) {
        if (veiculo.isDisponibilidade()) {
            Locacao locacao = new Locacao(cliente, veiculo, dias);
            veiculo.alugar();
            locacoes.add(locacao);

        } else {
            System.out.println("Veículo não disponível para locação.");
        }
    }

    public void exibirVeiculosDisponiveis() {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.isDisponibilidade()) {
                System.out.println("Veículo disponível: " + veiculo.getModelo() + " - " + veiculo.getPlaca());
            }
        }
    }

    public void exibirVeiculosAlugados() {
        for (Veiculo veiculo : veiculos) {
            if (! veiculo.isDisponibilidade()) {
                System.out.println("Veículo alugado: " + veiculo.getModelo() + " - " + veiculo.getPlaca());
            }
        }
    }

    public void exibirVeiculosDeLuxo() {
        for (Veiculo veiculo : veiculos) {
            if (veiculo instanceof VeiculoLuxo) {
                System.out.println("Veículo de luxo: " + veiculo.getModelo() + " - " + veiculo.getPlaca());
            }
        }
    }

    public Veiculo buscarVeiculo(String modeloLocacao) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getModelo().equalsIgnoreCase(modeloLocacao) && veiculo.isDisponibilidade()) {
                return veiculo;
            }
        }
        return null;
    }
}


