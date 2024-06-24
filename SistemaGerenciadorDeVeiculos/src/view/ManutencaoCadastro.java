package view;

import service.*;
import model.*;
import java.util.Scanner;

public class ManutencaoCadastro {
    private static VeiculoService veiculoService = new VeiculoService();
    private static LojaService lojaService = new LojaService();
    private static VendedorService vendedorService = new VendedorService();
    private static ClienteService clienteService = new ClienteService();
    private static VendaService vendaService = new VendaService();

    public static void menu(Scanner scanner) {
        boolean running = true;

        while (running) {
            System.out.println("Manutenção no Cadastro:");
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
            System.out.println("1. Cadastrar Veículo");
            System.out.println("2. Excluir Veículo");
            System.out.println("3. Alterar Dados do Veículo");
            System.out.println("4. Voltar para o menu anterior");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite a marca do veículo: ");
                    String marca = scanner.next();
                    System.out.print("Digite o modelo do veículo: ");
                    String modelo = scanner.next();
                    System.out.print("Digite o ano do veículo: ");
                    int ano = scanner.nextInt();
                    System.out.print("Digite a placa do veículo: ");
                    String placa = scanner.next();
                    System.out.print("Digite o preço do veículo: ");
                    double preco = scanner.nextDouble();
                    Veiculo veiculo = new Veiculo();
                    veiculo.setMarca(marca);
                    veiculo.setModelo(modelo);
                    veiculo.setAno(ano);
                    veiculo.setPlaca(placa);
                    veiculo.setPreco(preco);
                    veiculoService.cadastrarVeiculo(veiculo);
                    System.out.println("Veículo cadastrado com sucesso!");
                    break;
                case 2:
                    System.out.print("Digite a placa do veículo a ser excluído: ");
                    placa = scanner.next();
                    veiculoService.excluirVeiculo(placa);
                    System.out.println("Veículo excluído com sucesso!");
                    break;
                case 3:
                    System.out.print("Digite a placa do veículo a ser alterado: ");
                    placa = scanner.next();
                    Veiculo veiculoExistente = veiculoService.consultarVeiculoPorPlaca(placa);
                    if (veiculoExistente == null) {
                        System.out.println("Veículo não encontrado.");
                        break;
                    }
                    System.out.print("Digite a nova marca do veículo: ");
                    marca = scanner.next();
                    System.out.print("Digite o novo modelo do veículo: ");
                    modelo = scanner.next();
                    System.out.print("Digite o novo ano do veículo: ");
                    ano = scanner.nextInt();
                    System.out.print("Digite o novo preço do veículo: ");
                    preco = scanner.nextDouble();
                    Veiculo novoVeiculo = new Veiculo();
                    novoVeiculo.setMarca(marca);
                    novoVeiculo.setModelo(modelo);
                    novoVeiculo.setAno(ano);
                    novoVeiculo.setPlaca(placa);
                    novoVeiculo.setPreco(preco);
                    veiculoService.alterarVeiculo(placa, novoVeiculo);
                    System.out.println("Dados do veículo alterados com sucesso!");
                    break;
                case 4:
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
            System.out.println("1. Cadastrar Loja");
            System.out.println("2. Excluir Loja");
            System.out.println("3. Alterar Dados da Loja");
            System.out.println("4. Voltar para o menu anterior");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome da loja: ");
                    String nome = scanner.next();
                    System.out.print("Digite o endereço da loja: ");
                    String endereco = scanner.next();
                    System.out.print("Digite o telefone da loja: ");
                    String telefone = scanner.next();
                    Loja loja = new Loja();
                    loja.setNome(nome);
                    loja.setEndereco(endereco);
                    loja.setTelefone(telefone);
                    lojaService.cadastrarLoja(loja);
                    System.out.println("Loja cadastrada com sucesso!");
                    break;
                case 2:
                    System.out.print("Digite o nome da loja a ser excluída: ");
                    nome = scanner.next();
                    lojaService.excluirLoja(nome);
                    System.out.println("Loja excluída com sucesso!");
                    break;
                case 3:
                    System.out.print("Digite o nome da loja a ser alterada: ");
                    nome = scanner.next();
                    Loja lojaExistente = lojaService.listarLojas().stream().filter(l -> l.getNome().equals(nome)).findFirst().orElse(null);
                    if (lojaExistente == null) {
                        System.out.println("Loja não encontrada.");
                        break;
                    }
                    System.out.print("Digite o novo endereço da loja: ");
                    endereco = scanner.next();
                    System.out.print("Digite o novo telefone da loja: ");
                    telefone = scanner.next();
                    Loja novaLoja = new Loja();
                    novaLoja.setNome(nome);
                    novaLoja.setEndereco(endereco);
                    novaLoja.setTelefone(telefone);
                    lojaService.alterarLoja(nome, novaLoja);
                    System.out.println("Dados da loja alterados com sucesso!");
                    break;
                case 4:
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
            System.out.println("1. Cadastrar Vendedor");
            System.out.println("2. Excluir Vendedor");
            System.out.println("3. Alterar Dados do Vendedor");
            System.out.println("4. Voltar para o menu anterior");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do vendedor: ");
                    String nome = scanner.next();
                    System.out.print("Digite o CPF do vendedor: ");
                    String cpf = scanner.next();
                    System.out.print("Digite o telefone do vendedor: ");
                    String telefone = scanner.next();
                    Vendedor vendedor = new Vendedor();
                    vendedor.setNome(nome);
                    vendedor.setCpf(cpf);
                    vendedor.setTelefone(telefone);
                    vendedorService.cadastrarVendedor(vendedor);
                    System.out.println("Vendedor cadastrado com sucesso!");
                    break;
                case 2:
                    System.out.print("Digite o nome do vendedor a ser excluído: ");
                    nome = scanner.next();
                    vendedorService.excluirVendedor(nome);
                    System.out.println("Vendedor excluído com sucesso!");
                    break;
                case 3:
                    System.out.print("Digite o nome do vendedor a ser alterado: ");
                    nome = scanner.next();
                    Vendedor vendedorExistente = vendedorService.consultarVendedorPorNome(nome);
                    if (vendedorExistente == null) {
                        System.out.println("Vendedor não encontrado.");
                        break;
                    }
                    System.out.print("Digite o novo CPF do vendedor: ");
                    cpf = scanner.next();
                    System.out.print("Digite o novo telefone do vendedor: ");
                    telefone = scanner.next();
                    Vendedor novoVendedor = new Vendedor();
                    novoVendedor.setNome(nome);
                    novoVendedor.setCpf(cpf);
                    novoVendedor.setTelefone(telefone);
                    vendedorService.alterarVendedor(nome, novoVendedor);
                    System.out.println("Dados do vendedor alterados com sucesso!");
                    break;
                case 4:
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
            System.out.println("2. Excluir Cliente");
            System.out.println("3. Alterar Dados do Cliente");
            System.out.println("4. Voltar para o menu anterior");
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
                    System.out.print("Digite o CPF do cliente a ser excluído: ");
                    cpf = scanner.next();
                    clienteService.excluirCliente(cpf);
                    System.out.println("Cliente excluído com sucesso!");
                    break;
                case 3:
                    System.out.print("Digite o CPF do cliente a ser alterado: ");
                    cpf = scanner.next();
                    Cliente clienteExistente = clienteService.consultarClientePorCPF(cpf);
                    if (clienteExistente == null) {
                        System.out.println("Cliente não encontrado.");
                        break;
                    }
                    System.out.print("Digite o novo nome do cliente: ");
                    nome = scanner.next();
                    System.out.print("Digite o novo telefone do cliente: ");
                    telefone = scanner.next();
                    Cliente novoCliente = new Cliente();
                    novoCliente.setNome(nome);
                    novoCliente.setCpf(cpf);
                    novoCliente.setTelefone(telefone);
                    clienteService.alterarCliente(cpf, novoCliente);
                    System.out.println("Dados do cliente alterados com sucesso!");
                    break;
                case 4:
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
            System.out.println("2. Excluir Venda");
            System.out.println("3. Voltar para o menu anterior");
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
                    System.out.print("Digite a placa do veículo da venda a ser excluída: ");
                    placa = scanner.next();
                    veiculo = veiculoService.consultarVeiculoPorPlaca(placa);
                    if (veiculo == null) {
                        System.out.println("Venda não encontrada.");
                        break;
                    }

                    System.out.print("Digite o nome do vendedor da venda a ser excluída: ");
                    nomeVendedor = scanner.next();
                    vendedor = vendedorService.consultarVendedorPorNome(nomeVendedor);
                    if (vendedor == null) {
                        System.out.println("Venda não encontrada.");
                        break;
                    }

                    System.out.print("Digite o CPF do cliente da venda a ser excluída: ");
                    cpfCliente = scanner.next();
                    cliente = clienteService.consultarClientePorCPF(cpfCliente);
                    if (cliente == null) {
                        System.out.println("Venda não encontrada.");
                        break;
                    }

                    vendaService.excluirVenda(veiculo, vendedor, cliente);
                    System.out.println("Venda excluída com sucesso!");
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
