package br.com.locadora.model;

import java.util.List;

public class CarroPremium extends br.com.locadora.model.Veiculo {
    private List<ServicoLuxo> servicosLuxo;

    public CarroPremium(String modelo, String placa, double valorDiaria, boolean disponibilidade, List<ServicoLuxo> servicosLuxo) {
        super(modelo, placa, valorDiaria, disponibilidade);
        this.servicosLuxo = servicosLuxo;
    }

    public CarroPremium(String modelo, String placa, double valorDiaria, boolean disponibilidade) {
        super();
    }

    public List<ServicoLuxo> getServicosLuxo() { return servicosLuxo; }
    public void setServicosLuxo(List<ServicoLuxo> servicosLuxo) { this.servicosLuxo = servicosLuxo; }

    @Override
    public String toString() {
        return super.toString() + ", Serviços de Luxo: " + servicosLuxo;
    }
}
