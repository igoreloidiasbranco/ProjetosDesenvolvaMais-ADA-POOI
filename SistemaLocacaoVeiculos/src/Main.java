import Cliente.Cliente;
import Cliente.PessoaFisica;
import Cliente.PessoaJuridica;
import Locadora.Locadora;
import Veiculo.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Locadora locadora = new Locadora();

        System.out.println();
        System.out.println("----- SISTEMA DE LOCAÇÃO DE VEÍCULOS -----");
        System.out.println();

        while (true) { // Loop infinito no menu principal
            System.out.printf(
                    "Funcionalidades do Sistema: \n" +
                            "(1) - Cadastro de Veículo \n" +
                            "(2) - Cadastro de Cliente \n" +
                            "(3) - Locação de Veículo \n" +
                            "(4) - Consultar veículos disponíveis \n" +
                            "(5) - Consultar veículos alugados \n" +
                            "(6) - Consultar veículos de luxo \n" +
                            "(7) - Consultar clientes \n" +
                            "(0) - Sair \n" +
                            "Digite a funcionalidade que deseja realizar: \n");

            String funcionalidade = scanner.nextLine();

            switch (funcionalidade) {
                case "1":
                    cadastrarVeiculo(scanner, locadora);
                    break;
                case "2":
                    cadastrarCliente(scanner);
                    break;
                case "3":
                    realizarLocacao(scanner, locadora);
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
                    System.out.println("Clientes cadastrados:");
                    listarClientes();
                    break;
                case "0":
                    System.out.println("Saindo do sistema...");
                    scanner.close();
                    return; // Sai do programa
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }

        }
    }

    private static void cadastrarVeiculo(Scanner scanner, Locadora locadora) {
        System.out.println("Selecione o tipo de veículo:");
        System.out.println("(1) - Carro Comum");
        System.out.println("(2) - Carro Premium");
        System.out.println("(3) - SUV");
        System.out.println("(4) - Moto");
        System.out.println("(5) - Caminhão");
        System.out.println("(0) - Voltar ao menu principal");
        System.out.print("Digite o número correspondente ao tipo de veículo: ");
        int tipoVeiculo = Integer.parseInt(scanner.nextLine());

        if (tipoVeiculo == 0) {
            System.out.println("Voltando ao menu principal...");
            return;
        }

        System.out.print("Digite o modelo do veículo: ");
        String modelo = scanner.nextLine();
        System.out.print("Digite a placa do veículo: ");
        String placa = scanner.nextLine();
        System.out.print("Digite o valor da diária: ");
        double diaria = Double.parseDouble(scanner.nextLine());

        Veiculo veiculo = null;
        switch (tipoVeiculo) {
            case 1:
                veiculo = new CarroComum(modelo, placa, diaria);
                break;
            case 2:
                veiculo = new CarroPremium(modelo, placa, diaria);
                break;
            case 3:
                veiculo = new SUV(modelo, placa, diaria);
                break;
            case 4:
                veiculo = new Moto(modelo, placa, diaria);
                break;
            case 5:
                veiculo = new Caminhao(modelo, placa, diaria);
                break;
            default:
                System.out.println("Tipo de veículo inválido.");
                return;
        }

        if (veiculo != null) {
            locadora.cadastrarVeiculo(veiculo);
            System.out.println("Veículo cadastrado com sucesso!");
        }
    }

    private static void cadastrarCliente(Scanner scanner) {
        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o endereço: ");
        String endereco = scanner.nextLine();
        System.out.print("Digite o telefone: ");
        String telefone = scanner.nextLine();

        String tipoCliente;
        do {
            System.out.println("Digite (PF) para Pessoa Física ou (PJ) para Pessoa Jurídica");
            tipoCliente = scanner.nextLine().toUpperCase();
        } while (!(tipoCliente.equals("PF") || tipoCliente.equals("PJ")));

        if (tipoCliente.equals("PF")) {
            System.out.print("Digite o CPF: ");
            String cpf = scanner.nextLine();
            PessoaFisica clientePF = new PessoaFisica(nome, endereco, telefone, cpf);
            System.out.println(clientePF.cadastrarCliente(clientePF));
        } else {
            System.out.print("Digite o CNPJ: ");
            String cnpj = scanner.nextLine();
            PessoaJuridica clientePJ = new PessoaJuridica(nome, endereco, telefone, cnpj);
            System.out.println(clientePJ.cadastrarCliente(clientePJ));
        }
    }

    private static void realizarLocacao(Scanner scanner, Locadora locadora) {
        System.out.println("Clientes cadastrados:");
        listarClientes();

        System.out.println("Veículos disponíveis:");
        locadora.exibirVeiculosDisponiveis();

        System.out.print("Digite o nome do cliente: ");
        String nomeCliente = scanner.nextLine();

        Cliente clienteLocacao = PessoaFisica.buscarCliente(nomeCliente);
        if (clienteLocacao == null) {
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
    }

    private static void listarClientes() {
        for (Cliente clientePF : PessoaFisica.listaClientesPF) {
            System.out.println(clientePF);
        }

        for (Cliente clientePJ : PessoaJuridica.listaClientesPJ) {
            System.out.println(clientePJ);
        }
    }
}