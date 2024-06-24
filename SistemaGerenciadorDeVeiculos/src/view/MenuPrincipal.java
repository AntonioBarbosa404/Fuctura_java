package view;

import java.util.Scanner;

public class MenuPrincipal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Menu Principal:");
            System.out.println("1. Frente de Loja");
            System.out.println("2. Manutenção no Cadastro");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    FrenteDeLoja.menu(scanner);
                    break;
                case 2:
                    ManutencaoCadastro.menu(scanner);
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
        scanner.close();
    }
}
