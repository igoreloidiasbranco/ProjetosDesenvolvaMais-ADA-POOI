package Veiculo;

public abstract class VeiculoLuxo extends Veiculo {
    public VeiculoLuxo(String modelo, String placa, double diaria) {
        super(modelo, placa, diaria);
    }

    public abstract void oferecerServicoPremium();
}

