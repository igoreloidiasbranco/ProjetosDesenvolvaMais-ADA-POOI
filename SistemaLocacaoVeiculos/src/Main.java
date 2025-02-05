import Cliente.Cliente;
import Cliente.PessoaFisica;
import Cliente.PessoaJuridica;

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
                            "Digite a funcionalidade que deseja realizar: \n");

            funcionalidade = scanner.nextLine();

            switch (funcionalidade) {
                case "1":
                    //implementar
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