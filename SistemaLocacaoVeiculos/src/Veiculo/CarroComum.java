package Veiculo;

public class CarroComum extends Veiculo {
    public CarroComum(String modelo, String placa, double diaria) {
        super(modelo, placa, diaria);
    }

    @Override
    public double calcularCusto(int dias) {
        return getDiaria() * dias;
    }
}
