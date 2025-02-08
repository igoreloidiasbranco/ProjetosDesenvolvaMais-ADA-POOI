package Veiculo;

public class SUV extends VeiculoLuxo {
    public SUV(String modelo, String placa, double diaria) {
        super(modelo, placa, diaria);
    }

    @Override
    public double calcularCusto(int dias) {
        return getDiaria() * dias;
    }

    @Override
    public void oferecerServicoPremium() {
        System.out.println("Oferecendo serviços premium: motorista, guia turístico, etc.");
    }
}

