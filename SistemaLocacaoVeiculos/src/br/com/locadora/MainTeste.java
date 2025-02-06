package br.com.locadora;

import br.com.locadora.model.CarroComum;
import br.com.locadora.model.CarroPremium;
import br.com.locadora.model.ServicoLuxo;
import br.com.locadora.service.VeiculoService;

import java.util.Arrays;

public class MainTeste {
    public static void main(String[] args) {
        VeiculoService service = new VeiculoService();

        // Criando carros comuns (Onix, T-Cross, HB20)
        CarroComum onix = new CarroComum("Onix", "ABC-1234", 120.0, true);
        CarroComum tCross = new CarroComum("T-Cross", "DEF-5678", 150.0, true);
        CarroComum hb20 = new CarroComum("HB20 Hyundai", "GHI-9012", 110.0, true);

        // Criando carros de luxo (Ferrari, Porsche, BMW)
        CarroPremium ferrari = new CarroPremium("Ferrari", "JKL-3456", 800.0, true,
                Arrays.asList(ServicoLuxo.MOTORISTA_PARTICULAR, ServicoLuxo.INTERNET_WIFI));

        CarroPremium porsche = new CarroPremium("Porsche", "MNO-7890", 750.0, true,
                Arrays.asList(ServicoLuxo.BEBIDAS_CORTESIA, ServicoLuxo.SISTEMA_MULTIMIDIA));

        CarroPremium bmw = new CarroPremium("BMW", "PQR-1122", 700.0, true,
                Arrays.asList(ServicoLuxo.ASSISTENCIA_VIP, ServicoLuxo.INTERNET_WIFI, ServicoLuxo.SISTEMA_MULTIMIDIA));

        // Adicionando os veículos ao serviço
        service.adicionarVeiculo(onix);
        service.adicionarVeiculo(tCross);
        service.adicionarVeiculo(hb20);
        service.adicionarVeiculo(ferrari);
        service.adicionarVeiculo(porsche);
        service.adicionarVeiculo(bmw);

        // Exibindo os veículos cadastrados
        System.out.println("=== Veículos Cadastrados ===");
        for (var veiculo : service.listarVeiculos()) {
            System.out.println(veiculo);
        }
    }
}
