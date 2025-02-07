import Cliente.Cliente;
import Cliente.PessoaFisica;
import Cliente.PessoaJuridica;
import br.com.locadora.model.CarroPremium;
import br.com.locadora.model.Veiculo;
import br.com.locadora.service.VeiculoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String respostaUsuario;
        String funcionalidade;

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

                    class CadastroVeiculos {
                        public static void main(String[] args) {
                            Scanner scanner = new Scanner(System.in);
                            VeiculoService veiculoService = new VeiculoService();

                            System.out.println("=== Cadastro de Veículo ===");
                            System.out.print("Digite o modelo do veículo: ");
                            String modelo = scanner.nextLine();

                            System.out.print("Digite a placa do veículo: ");
                            String placa = scanner.nextLine();

                            System.out.print("Digite o valor da diária: ");
                            double valorDiaria = scanner.nextDouble();
                            scanner.nextLine(); // Consumir a quebra de linha

                            System.out.print("O veículo é premium? (S/N): ");
                            String tipoVeiculo = scanner.nextLine().toUpperCase();

                            if (tipoVeiculo.equals("S")) {
                                List<String> servicosLuxo = new ArrayList<>();
                                System.out.println("Digite os serviços de luxo separados por vírgula (ex: ASSISTENCIA_VIP, INTERNET_WIFI, SISTEMA_MULTIMIDIA): ");
                                String servicos = scanner.nextLine();
                                for (String servico : servicos.split(",")) {
                                    servicosLuxo.add(servico.trim());
                                }

                                CarroPremium carroPremium = new CarroPremium(modelo, placa, valorDiaria, true);
                                veiculoService.cadastrarVeiculo(carroPremium);
                                System.out.println("Carro premium cadastrado com sucesso!");
                            } else {
                                CarroPremium carroComum = new CarroPremium(modelo, placa, valorDiaria, true);
                                veiculoService.cadastrarVeiculo(carroComum);
                                System.out.println("Carro comum cadastrado com sucesso!");
                            }
                        }
                    }


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
                    //implementar
                    break;

                case "4":
                    //implementar
                    break;

                case "5":
                    //implementar
                    break;

                case "6":
                    //implementar
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