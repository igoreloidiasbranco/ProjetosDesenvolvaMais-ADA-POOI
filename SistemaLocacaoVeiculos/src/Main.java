import Cliente.Cliente;
import Cliente.PessoaFisica;
import Cliente.PessoaJuridica;
import Locadora.Locadora;
import Veiculo.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String respostaUsuario;
        String funcionalidade;
        Locadora locadora = new Locadora();

        System.out.println();
        System.out.println("----- SISTEMA DE LOCAÇÂO DE VEÌCULOS -----");
        System.out.println();

        do {
            System.out.printf(
                    "Funcionalidades do Sistema: \n" +
                            "(1) - Cadastro de Veículo \n" +
                            "(2) - Cadastro de Cliente \n" +
                            "(3) - Locação de Veículo \n" +
                            "(4) - Consultar veículos disponíves \n" +
                            "(5) - Consultar veículos alugados \n" +
                            "(6) - Consultar veículos de luxo \n" +
                            "(7) - Consultar clientes \n" +
                            "Digite a funcionalidade que deseja realizar: \n");

            funcionalidade = scanner.nextLine();

            switch (funcionalidade) {
                case "1":
                    System.out.println("Digite o tipo de veículo (CarroComum, CarroPremium, SUV, Moto, Caminhao):");
                    String tipoVeiculo = scanner.nextLine().toUpperCase();

                    System.out.print("Digite o modelo do veículo: ");
                    String modelo = scanner.nextLine();
                    System.out.print("Digite a placa do veículo: ");
                    String placa = scanner.nextLine();
                    System.out.print("Digite o valor da diária: ");
                    double diaria = Double.parseDouble(scanner.nextLine());

                    Veiculo veiculo = null;
                    switch (tipoVeiculo) {
                        case "CARROCOMUM":
                            veiculo = new CarroComum(modelo, placa, diaria);
                            break;
                        case "CARROPREMIUM":
                            veiculo = new CarroPremium(modelo, placa, diaria);
                            break;
                        case "SUV":
                            veiculo = new SUV(modelo, placa, diaria);
                            break;
                        case "MOTO":
                            veiculo = new Moto(modelo, placa, diaria);
                            break;
                        case "CAMINHAO":
                            veiculo = new Caminhao(modelo, placa, diaria);
                            break;
                        default:
                            System.out.println("Tipo de veículo inválido.");
                            break;
                    }

                    if (veiculo != null) {
                        locadora.cadastrarVeiculo(veiculo);
                        System.out.println("Veículo cadastrado com sucesso!");
                    }
                    break;


                case "2":
                    System.out.print("Digite o nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o endereço: ");
                    String endereco = scanner.nextLine();
                    System.out.print("Digite o telefone: ");
                    String telefone = scanner.nextLine();

                    String cliente;
                    String mensagem;
                    do {
                        System.out.println("Digite (PF) para Pessoa Física ou (PJ) para Pessoa Jurídica");
                        cliente = scanner.nextLine().toUpperCase();
                    } while (!(cliente.equals("PF") || cliente.equals("PJ")));

                    if (cliente.equals("PF")) {
                        System.out.print("Digite o CPF: ");
                        String cpf = scanner.nextLine();
                        PessoaFisica clientePF = new PessoaFisica(nome, endereco, telefone, cpf);
                        System.out.println(mensagem = clientePF.cadastrarCliente(clientePF));

                    } else {
                        System.out.print("Digite o CNPJ: ");
                        String cnpj = scanner.nextLine();
                        PessoaJuridica clientePJ = new PessoaJuridica(nome, endereco, telefone, cnpj);
                        System.out.println(mensagem = clientePJ.cadastrarCliente(clientePJ));
                    }
                    break;

                case "3":
                    do {
                        System.out.println("Digite (PF) para Pessoa Física ou (PJ) para Pessoa Jurídica");
                        cliente = scanner.nextLine().toUpperCase();
                    } while (!(cliente.equals("PF") || cliente.equals("PJ")));

                    System.out.print("Digite o nome do cliente: ");
                    String nomeCliente = scanner.nextLine();

                    Cliente clienteLocacao;

                    if (cliente.equals("PF")) {
                        clienteLocacao = PessoaFisica.buscarCliente(nomeCliente);
                    } else {
                        clienteLocacao = PessoaJuridica.buscarCliente(nomeCliente);
                    }

                    if (clienteLocacao != null) {
                        System.out.print("Digite o modelo do veículo para locação: ");
                        String modeloLocacao = scanner.nextLine();
                        Veiculo veiculoLocacao = locadora.buscarVeiculo(modeloLocacao);

                        if (veiculoLocacao != null && veiculoLocacao.isDisponibilidade()) {
                            System.out.print("Digite o número de dias para locação: ");
                            int dias = Integer.parseInt(scanner.nextLine());

                            locadora.realizarLocacao(clienteLocacao, veiculoLocacao, dias);
                            System.out.println("Locação realizada com sucesso!");
                            System.out.println("Valor total: " + veiculoLocacao.calcularCusto(dias));
                            if (veiculoLocacao instanceof CarroPremium) {
                                ((CarroPremium) veiculoLocacao).oferecerServicoPremium();
                            }
                        } else {
                            System.out.println("Veículo não encontrado ou não disponível.");
                        }
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;

                case "4":
                    System.out.println("Veículos disponíveis:");
                    locadora.exibirVeiculosDisponiveis();
                    break;

                case "5":
                    System.out.println("Veículos alugados:");
                    locadora.exibirVeiculosAlugados();
                    break;

                case "6":
                    System.out.println("Veículos de luxo:");
                    locadora.exibirVeiculosDeLuxo();
                    break;

                case "7":
                    for(Cliente clientePF : PessoaFisica.listaClientesPF){
                        System.out.println(clientePF);
                    }

                    for(Cliente clientePJ : PessoaJuridica.listaClientesPJ){
                        System.out.println(clientePJ);
                    }
                    break;

                default:
                    System.out.println("Digite uma funcionalidade válida");
                    break;
            }

            System.out.printf("Deseja realizar uma nova funcionalidade: \n" +
                    "Digite (S) para continuar ou qualquer outra tecla para sair \n");
            respostaUsuario = scanner.nextLine().toUpperCase();

        } while (respostaUsuario.equals("S"));

        scanner.close();
    }
}