package LocacaoVeiculos;

import com.locadora.clientes.Cliente;
import com.locadora.locacao.Locacao;
import com.locadora.veiculos.Veiculo;
import com.locadora.veiculos.VeiculoLuxo;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class LocacaoVeiculos {
    private List<Veiculo> veiculos = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();c
    private List<Locacao> locacoes = new ArrayList<>();

 public void cadastrarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
    }

 public void cadastrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

  public Cliente buscarClientePorDocumento(String documento) {
        for (Cliente cliente : clientes) {
            if (cliente.getDocumento().equals(documento)) {
                return cliente;
            }
        }
        return null;
    }

  public Veiculo buscarVeiculoPorPlaca(String placa) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getPlaca().equals(placa)) {
                return veiculo;
            }
        }
        return null;
    }

    public void realizarLocacao(Cliente cliente, Veiculo veiculo, LocalDateTime dataInicio, LocalDateTime dataFim) {
        if (veiculo.isDisponivel()) {
            Locacao locacao = new Locacao(cliente, veiculo, dataInicio, dataFim);
            locacoes.add(locacao);
            veiculo.setDisponivel(false);
        }
    }

    public List<Veiculo> listarVeiculosDisponiveis() {
        List<Veiculo> disponiveis = new ArrayList<>();
        for (Veiculo veiculo : veiculos) {
            if (veiculo.isDisponivel()) {
                disponiveis.add(veiculo);
            }
        }
        return disponiveis;
    }

    public List<Veiculo> listarVeiculosAlugados() {
        List<Veiculo> alugados = new ArrayList<>();
        for (Locacao locacao : locacoes) {
            alugados.add(locacao.getVeiculo());
        }
        return alugados;
    }

    public List<Veiculo> listarVeiculosLuxo() {
        List<Veiculo> luxo = new ArrayList<>();
        for (Veiculo veiculo : veiculos) {
            if (veiculo instanceof VeiculoLuxo) {
                luxo.add(veiculo);
            }
        }
        return luxo;
    }
}
   
 
