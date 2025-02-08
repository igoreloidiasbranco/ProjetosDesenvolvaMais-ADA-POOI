package Veiculo;

public class Moto extends Veiculo {
    public Moto(String modelo, String placa, double diaria) {
        super(modelo, placa, diaria);
    }

    @Override
    public double calcularCusto(int dias) {
        return getDiaria() * dias;
    }
}
