package Veiculo;

public class Caminhao extends Veiculo {
    public Caminhao(String modelo, String placa, double diaria) {
        super(modelo, placa, diaria);
    }

    @Override
    public double calcularCusto(int dias) {
        return getDiaria() * dias;
    }
}

