import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String respostaUsuario = "S";
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
                    //implementar
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