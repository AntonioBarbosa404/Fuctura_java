package view;

import service.*;
import model.*;
import java.util.Scanner;

public class FrenteDeLoja {
    private static VeiculoService veiculoService = new VeiculoService();
    private static LojaService lojaService = new LojaService();
    private static VendedorService vendedorService = new VendedorService();
    private static ClienteService clienteService = new ClienteService();
    private static VendaService vendaService = new VendaService();

    public static void menu(Scanner scanner) {
        boolean running = true;

        while (running) {
            System.out.println("Frente de Loja:");
            System.out.println("1. Gerenciar Veículo");
            System.out.println("2. Gerenciar Loja");
            System.out.println("3. Gerenciar Vendedor");
            System.out.println("4. Gerenciar Cliente");
            System.out.println("5. Gerenciar Venda");
            System.out.println("6. Voltar para o menu principal");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    gerenciarVeiculo(scanner);
                    break;
                case 2:
                    gerenciarLoja(scanner);
                    break;
                case 3:
                    gerenciarVendedor(scanner);
                    break;
                case 4:
                    gerenciarCliente(scanner);
                    break;
                case 5:
                    gerenciarVenda(scanner);
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void gerenciarVeiculo(Scanner scanner) {
        boolean running = true;

        while (running) {
            System.out.println("Gerenciar Veículo:");
            System.out.println("1. Consultar Veículo por Placa");
            System.out.println("2. Voltar para o menu anterior");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite a placa do veículo: ");
                    String placa = scanner.next();
                    Veiculo veiculo = veiculoService.consultarVeiculoPorPlaca(placa);
                    if (veiculo != null) {
                        System.out.println("Veículo encontrado: " + veiculo.getMarca() + " " + veiculo.getModelo());
                    } else {
                        System.out.println("Veículo não encontrado.");
                    }
                    break;
                case 2:
                    running = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void gerenciarLoja(Scanner scanner) {
        boolean running = true;

        while (running) {
            System.out.println("Gerenciar Loja:");
            System.out.println("1. Listar todas as Lojas");
            System.out.println("2. Voltar para o menu anterior");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Lista de Lojas:");
                    for (Loja loja : lojaService.listarLojas()) {
                        System.out.println("Nome: " + loja.getNome() + ", Endereço: " + loja.getEndereco());
                    }
                    break;
                case 2:
                    running = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void gerenciarVendedor(Scanner scanner) {
        boolean running = true;

        while (running) {
            System.out.println("Gerenciar Vendedor:");
            System.out.println("1. Consultar Vendedor por Nome");
            System.out.println("2. Voltar para o menu anterior");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do vendedor: ");
                    String nome = scanner.next();
                    Vendedor vendedor = vendedorService.consultarVendedorPorNome(nome);
                    if (vendedor != null) {
                        System.out.println("Vendedor encontrado: " + vendedor.getNome() + ", CPF: " + vendedor.getCpf());
                    } else {
                        System.out.println("Vendedor não encontrado.");
                    }
                    break;
                case 2:
                    running = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void gerenciarCliente(Scanner scanner) {
        boolean running = true;

        while (running) {
            System.out.println("Gerenciar Cliente:");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Consultar Cliente por CPF");
            System.out.println("3. Voltar para o menu anterior");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do cliente: ");
                    String nome = scanner.next();
                    System.out.print("Digite o CPF do cliente: ");
                    String cpf = scanner.next();
                    System.out.print("Digite o telefone do cliente: ");
                    String telefone = scanner.next();
                    Cliente cliente = new Cliente();
                    cliente.setNome(nome);
                    cliente.setCpf(cpf);
                    cliente.setTelefone(telefone);
                    clienteService.cadastrarCliente(cliente);
                    System.out.println("Cliente cadastrado com sucesso!");
                    break;
                case 2:
                    System.out.print("Digite o CPF do cliente: ");
                    cpf = scanner.next();
                    cliente = clienteService.consultarClientePorCPF(cpf);
                    if (cliente != null) {
                        System.out.println("Cliente encontrado: " + cliente.getNome() + ", Telefone: " + cliente.getTelefone());
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void gerenciarVenda(Scanner scanner) {
        boolean running = true;

        while (running) {
            System.out.println("Gerenciar Venda:");
            System.out.println("1. Cadastrar Venda");
            System.out.println("2. Voltar para o menu anterior");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite a placa do veículo: ");
                    String placa = scanner.next();
                    Veiculo veiculo = veiculoService.consultarVeiculoPorPlaca(placa);
                    if (veiculo == null) {
                        System.out.println("Veículo não encontrado.");
                        break;
                    }

                    System.out.print("Digite o nome do vendedor: ");
                    String nomeVendedor = scanner.next();
                    Vendedor vendedor = vendedorService.consultarVendedorPorNome(nomeVendedor);
                    if (vendedor == null) {
                        System.out.println("Vendedor não encontrado.");
                        break;
                    }

                    System.out.print("Digite o CPF do cliente: ");
                    String cpfCliente = scanner.next();
                    Cliente cliente = clienteService.consultarClientePorCPF(cpfCliente);
                    if (cliente == null) {
                        System.out.println("Cliente não encontrado.");
                        break;
                    }

                    Venda venda = new Venda();
                    venda.setVeiculo(veiculo);
                    venda.setVendedor(vendedor);
                    venda.setCliente(cliente);
                    venda.setDataVenda(new java.util.Date());

                    vendaService.cadastrarVenda(venda);
                    System.out.println("Venda cadastrada com sucesso!");
                    break;
                case 2:
                    running = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
