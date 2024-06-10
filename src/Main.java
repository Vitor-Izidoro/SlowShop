import dao.*;
import models.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.sql.Date;
import java.time.LocalDate;

public class Main {
    private static boolean isAdmin = false;
    private static boolean isVendedor = false;
    private static boolean isCliente = false;
    private static boolean isLoggedIn = false;
    private static String loggedInEmail = "";

    private static void listarVendedores(VendedorDAO vendedorDAO) {
        List<Vendedor> vendedores = vendedorDAO.listarVendedores();
        for (Vendedor vendedor : vendedores) {
            System.out.println(
                    "ID: " + vendedor.getId() + "\n" +
                            "Nome: " + vendedor.getNome() + "\n" +
                            "Sobrenome: " + vendedor.getSobrenome() + "\n" +
                            "Data de Nascimento: " + vendedor.getDataNascimento() + "\n" +
                            "Telefone: " + vendedor.getTelefone() + "\n" +
                            "CPF: " + vendedor.getCpf() + "\n" +
                            "Cidade: " + vendedor.getCidade() + "\n" +
                            "Estado: " + vendedor.getEstado() + "\n" +
                            "País: " + vendedor.getPais() + "\n" +
                            "Endereço: " + vendedor.getEndereco() + "\n" +
                            "Número: " + vendedor.getNumero() + "\n" +
                            "Data de Cadastro: " + vendedor.getDataCadastro() + "\n" +
                            "Email: " + vendedor.getEmail() + "\n" +
                            "Senha: " + vendedor.getSenha() + "\n"
            );
            System.out.println("-----------------------------------");
        }
    }

    private static void listarCliente(ClienteDAO clienteDAO) {
        List<Cliente> cliente = clienteDAO.listarCliente();
        for (Cliente clientes : cliente) {
            System.out.println(
                    "ID: " + clientes.getId() + "\n" +
                            "Nome: " + clientes.getNome() + "\n" +
                            "Sobrenome: " + clientes.getSobrenome() + "\n" +
                            "Data de Nascimento: " + clientes.getDataNascimento() + "\n" +
                            "Telefone: " + clientes.getTelefone() + "\n" +
                            "CPF: " + clientes.getCpf() + "\n" +
                            "Cidade: " + clientes.getCidade() + "\n" +
                            "Estado: " + clientes.getEstado() + "\n" +
                            "País: " + clientes.getPais() + "\n" +
                            "Endereço: " + clientes.getEndereco() + "\n" +
                            "Número: " + clientes.getNumero() + "\n" +
                            "Data de Cadastro: " + clientes.getDataCadastro() + "\n" +
                            "Email: " + clientes.getEmail() + "\n" +
                            "Senha: " + clientes.getSenha() + "\n"
            );
            System.out.println("-----------------------------------");
        }
    }
    private static void listarFornecedor(FornecedorDAO fornecedorDAO) {
        List<Fornecedor> fornecedores = fornecedorDAO.listarFornecedores();
        for (Fornecedor fornecedor : fornecedores) {
            System.out.println(
                    "Nome Fantasia: " + fornecedor.getNomeFantasia() + "\n" +
                            "Razao Social: " + fornecedor.getRazaoSocial() + "\n" +
                            "CNPJ: " + fornecedor.getCnpj() + "\n" +
                            "email: " + fornecedor.getEmail() + "\n" +
                            "telefone: " + fornecedor.getTelefone() + "\n" +
                            "cidade: " + fornecedor.getCidade() + "\n" +
                            "estado: " + fornecedor.getEstado() + "\n" +
                            "país: " + fornecedor.getPais() + "\n" +
                            "endereço: " + fornecedor.getEndereco() + "\n" +
                            "número: " + fornecedor.getNumero() + "\n" +
                            "data de cadastro: " + fornecedor.getDataCadastro() + "\n"
            );
            System.out.println("-----------------------------------");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Senha: ");
        String senha = sc.nextLine();

        AdminDAO adminDAO = new AdminDAO();
        VendedorDAO vendedorDAO = new VendedorDAO();
        ClienteDAO clienteDAO = new ClienteDAO();
        ProdutoDAO produtoDAO = new ProdutoDAO();
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        VendasDAO vendasDAO = new VendasDAO();

        isAdmin = adminDAO.verificarAdmin(email, senha);
        isVendedor = vendedorDAO.verificarVendedor(email, senha);
        isCliente = clienteDAO.verificarCliente(email, senha);
        isLoggedIn = isAdmin || isVendedor || isCliente;
        loggedInEmail = isLoggedIn ? email : "";

        if (!isLoggedIn) {
            System.out.println("Login falhou! Verifique suas credenciais.");
            return;
        }

        int opcaoMenu = 0;
        while (true) {
            System.out.println("\n* Menu de Controle * ");
            System.out.println("(1) Cadastrar Admin");
            System.out.println("(2) Cadastrar Vendedor");
            System.out.println("(3) Cadastrar Cliente");
            System.out.println("(4) Cadastrar Fornecedor");
            System.out.println("(5) Cadastrar Produto");
            System.out.println("(6) Listar Vendedor");
            System.out.println("(7) Listar Cliente");
            System.out.println("(8) Listar Fornecedor");
            System.out.println("(9) Listar Produto");
            System.out.println("(10) Deletar Usuario");
            System.out.println("(11) Deletar Vendedor");
            System.out.println("(12) Deletar Fornecedor");
            System.out.println("(13) Deletar Produto");
            System.out.println("(14) Alterar Cliente");
            System.out.println("(15) Registrar Compra");
            System.out.println("(16) Sair");

            if (sc.hasNextInt()) {
                opcaoMenu = sc.nextInt();
                sc.nextLine(); // Consume the newline character

                switch (opcaoMenu) {
                    case 1:
                        if (!isAdmin) {
                            System.out.println("Acesso negado. Apenas administradores podem cadastrar novos administradores.");
                            break;
                        }
                        System.out.print("Nome do Admin: ");
                        String nomeAdmin = sc.nextLine();
                        System.out.print("Email do Admin: ");
                        String emailAdmin = sc.nextLine();
                        System.out.print("Senha do Admin: ");
                        String senhaAdmin = sc.nextLine();

                        Admin admin = new Admin(nomeAdmin, emailAdmin, senhaAdmin);
                        adminDAO.inserirAdmin(admin);
                        System.out.println("Admin cadastrado com sucesso!");
                        break;
                    case 2:
                        if (!isAdmin) {
                            System.out.println("Acesso negado. Apenas administradores podem cadastrar novos administradores.");
                            break;
                        }
                        System.out.print("Nome: ");
                        String nome = sc.nextLine();
                        System.out.print("Sobrenome: ");
                        String sobrenome = sc.nextLine();
                        System.out.print("Data de Nascimento (formato YYYY-MM-DD): ");
                        String dataNascimentoStr = sc.nextLine();
                        LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr);
                        System.out.print("Telefone: ");
                        String telefone = sc.nextLine();
                        System.out.print("CPF: ");
                        String cpf = sc.nextLine();
                        System.out.print("Cidade: ");
                        String cidade = sc.nextLine();
                        System.out.print("Estado: ");
                        String estado = sc.nextLine();
                        System.out.print("País: ");
                        String pais = sc.nextLine();
                        System.out.print("Endereço: ");
                        String endereco = sc.nextLine();
                        System.out.print("Número: ");
                        int numero = sc.nextInt();
                        sc.nextLine(); // Consumindo a quebra de linha
                        LocalDate dataCadastro = LocalDate.now(); // Definindo a data de cadastro como a data atual
                        System.out.print("Email: ");
                        String emailVendedor = sc.nextLine();
                        System.out.print("Senha: ");
                        String senhaVendedor = sc.nextLine();

                        Vendedor vendedor = new Vendedor( nome, sobrenome, dataNascimento, telefone, cpf, cidade, estado, pais, endereco, numero, dataCadastro, emailVendedor, senhaVendedor);
                        vendedorDAO.inserirVendedor(vendedor);
                        System.out.println("Vendedor cadastrado com sucesso!");
                        break;
                    case 3:
                        if (!isAdmin && !isVendedor) {
                            System.out.println("Acesso negado. Apenas administradores podem cadastrar novos administradores.");
                            break;
                        }
                        System.out.print("Nome: ");
                        String nomeCliente = sc.nextLine();
                        System.out.print("Sobrenome: ");
                        String sobrenomeCliente= sc.nextLine();
                        System.out.print("Data de Nascimento (formato YYYY-MM-DD): ");
                        String dataNascimentoStrCliente = sc.nextLine();
                        LocalDate dataNascimentoCliente = LocalDate.parse(dataNascimentoStrCliente);
                        System.out.print("Telefone: ");
                        String telefoneCliente = sc.nextLine();
                        System.out.print("CPF: ");
                        String cpfCliente = sc.nextLine();
                        System.out.print("Cidade: ");
                        String cidadeCliente = sc.nextLine();
                        System.out.print("Estado: ");
                        String estadoCliente = sc.nextLine();
                        System.out.print("País: ");
                        String paisCliente = sc.nextLine();
                        System.out.print("Endereço: ");
                        String enderecoCliente = sc.nextLine();
                        System.out.print("Número: ");
                        int numeroCliente = sc.nextInt();
                        sc.nextLine(); // Consumindo a quebra de linha
                        LocalDate dataCadastroCliente = LocalDate.now(); // Definindo a data de cadastro como a data atual
                        System.out.print("Email: ");
                        String emailCliente = sc.nextLine();
                        System.out.print("Senha: ");
                        String senhaCliente = sc.nextLine();

                        Cliente cliente = new Cliente(nomeCliente, sobrenomeCliente, dataNascimentoCliente, telefoneCliente, cpfCliente, cidadeCliente, estadoCliente, paisCliente, enderecoCliente, numeroCliente, dataCadastroCliente, emailCliente, senhaCliente);
                        ClienteDAO cDao = new ClienteDAO();
                        cDao.inserirCliente(cliente);
                        System.out.println("Cliente cadastrado com sucesso!");
                        break;
                    case 4:
                        if (!isAdmin && !isVendedor) {
                            System.out.println("Acesso negado. Apenas administradores podem cadastrar novos administradores.");
                            break;
                        }
                        System.out.print("Nome Fantasia: ");
                        String nomeFantasia = sc.nextLine();
                        System.out.print("Razão Social: ");
                        String razaoSocial = sc.nextLine();
                        System.out.print("CNPJ: ");
                        String cnpj = sc.nextLine();
                        System.out.print("Email: ");
                        String emailFornecedor = sc.nextLine();
                        System.out.print("Telefone: ");
                        String telefoneFornecedor = sc.nextLine();
                        System.out.print("Cidade: ");
                        String cidadeFornecedor = sc.nextLine();
                        System.out.print("Estado: ");
                        String estadoFornecedor = sc.nextLine();
                        System.out.print("País: ");
                        String paisFornecedor = sc.nextLine();
                        System.out.print("Endereço: ");
                        String enderecoFornecedor = sc.nextLine();
                        System.out.print("Número: ");
                        String numeroFornecedor = sc.nextLine();
                        System.out.print("Data de Cadastro: ");
                        LocalDate dataCadastroFornecedor = LocalDate.now();

                        Fornecedor fornecedor = new Fornecedor(nomeFantasia, razaoSocial, cnpj, emailFornecedor, telefoneFornecedor, cidadeFornecedor, estadoFornecedor, paisFornecedor, enderecoFornecedor, numeroFornecedor, dataCadastroFornecedor, senha);
                        FornecedorDAO fDao = new FornecedorDAO();
                        fDao.inserirFornecedor(fornecedor);
                        System.out.println("Fornecedor cadastrado com sucesso!");
                        break;
                    case 5:
                        if (!isAdmin && !isVendedor) {
                            System.out.println("Acesso negado. Apenas administradores podem cadastrar novos administradores.");
                            break;
                        }
                        System.out.print("Descrição: ");
                        String descricao = sc.nextLine();
                        System.out.print("Quantidade: ");
                        int quantidade = sc.nextInt();
                        sc.nextLine(); // Consume the newline character
                        System.out.print("Preço: ");
                        double preco = sc.nextDouble();
                        sc.nextLine(); // Consume the newline character
                        System.out.print("Fornecedor: ");
                        int fornecedorId = sc.nextInt();
                        sc.nextLine(); // Consume the newline character

                        Produto produto = new Produto(descricao, quantidade, preco, fornecedorId);
                        ProdutoDAO pDao = new ProdutoDAO();
                        pDao.inserirProduto(produto);
                        System.out.println("Produto cadastrado com sucesso!");
                        break;
                    case 6:
                        if (!isAdmin) {
                            System.out.println("Acesso negado. Apenas administradores podem acessar essa opção.");
                            break;
                        }
                        listarVendedores(vendedorDAO);
                        break;
                    case 7:
                        listarCliente(clienteDAO);
                        break;
                    case 8:
                        listarFornecedor(fornecedorDAO);
                        break;
                    case 9:
                        //listarProdutos();
                        break;
                    case 10:
                        if (!isAdmin && !isVendedor) {
                            System.out.println("Acesso negado. Apenas administradores ou vendedores podem deletar clientes.");
                            break;
                        }
                        System.out.print("Email do Cliente a ser deletado: ");
                        String emailClienteDeletar = sc.nextLine();
                        boolean clienteDeletado = clienteDAO.deletarCliente(emailClienteDeletar);
                        if (clienteDeletado) {
                            System.out.println("Cliente deletado com sucesso!");
                        } else {
                            System.out.println("Falha ao deletar cliente. Verifique se o email está correto.");
                        }
                        break;
                    case 11:
                        if (!isAdmin) {
                            System.out.println("Acesso negado. Apenas administradores ou vendedores podem deletar clientes.");
                            break;
                        }
                        System.out.print("Email do Vendedor a ser deletado: ");
                        String emailVendedorDeletar = sc.nextLine();
                        boolean vendedorDeletado = vendedorDAO.deletarVendedor(emailVendedorDeletar);
                        if (vendedorDeletado) {
                            System.out.println("vendedor deletado com sucesso!");
                        } else {
                            System.out.println("Falha ao deletar vendedor. Verifique se o email está correto.");
                        }
                        break;
                    case 12:
                        if (!isAdmin) {
                            System.out.println("Acesso negado. Apenas administradores ou vendedores podem deletar clientes.");
                            break;
                        }
                        System.out.print("Email do fonecedor a ser deletado: ");
                        String emailFornecedorDeletar = sc.nextLine();

                        // FornecedorDAO fornecedorDAO = new FornecedorDAO(); // Criar uma instância de FornecedorDAO
                        boolean fornecedorDeletado = fornecedorDAO.deletarFornecedor(emailFornecedorDeletar);

                        if (fornecedorDeletado) {
                            System.out.println("vendedor deletado com sucesso!");
                        } else {
                            System.out.println("Falha ao deletar vendedor. Verifique se o email está correto.");
                        }
                        break;
                    case 13:
                        if (!isAdmin) {
                            System.out.println("Acesso negado. Apenas administradores ou vendedores podem deletar clientes.");
                            break;
                        }
                        System.out.print("descriçao do produto a ser deletado: ");
                        String descricaoProdutoDeletar = sc.nextLine();

                        ProdutoDAO produtoDAO1 = new ProdutoDAO(); // Criar uma instância de FornecedorDAO
                        boolean produtoDeletado = produtoDAO.deletarProduto(descricaoProdutoDeletar);

                        if (produtoDeletado) {
                            System.out.println("produto deletado com sucesso!");
                        } else {
                            System.out.println("Falha ao deletar produto. Verifique se a descricao está correto.");
                        }
                        break;
                    case 14:
                        if (!isVendedor) {
                            System.out.println("Acesso negado. Apenas vendedores podem registrar vendas.");
                            break;
                        }
                        System.out.println("Editar cliente");

                        // Solicitando o email do cliente a ser editado
                        System.out.print("Informe o email do cliente que deseja editar: ");
                        String emailClienteEditar = sc.nextLine();

                        // Verificar se o cliente existe antes de tentar editar
                        if (clienteDAO.verificarCliente(emailClienteEditar, "")) { // Assumindo que a senha não é necessária para verificação
                            // Coletar os novos dados do cliente
                            System.out.print("Informe o novo nome: ");
                            String novoNome = sc.nextLine();
                            System.out.print("Informe o novo sobrenome: ");
                            String novoSobrenome = sc.nextLine();
                            System.out.print("Informe a nova data de nascimento (AAAA-MM-DD): ");
                            String novaDataNascimento = sc.nextLine();
                            System.out.print("Informe o novo telefone: ");
                            String novoTelefone = sc.nextLine();
                            System.out.print("Informe o novo CPF: ");
                            String novoCpf = sc.nextLine();
                            System.out.print("Informe a nova cidade: ");
                            String novaCidade = sc.nextLine();
                            System.out.print("Informe o novo estado: ");
                            String novoEstado = sc.nextLine();
                            System.out.print("Informe o novo país: ");
                            String novoPais = sc.nextLine();
                            System.out.print("Informe o novo endereço: ");
                            String novoEndereco = sc.nextLine();
                            System.out.print("Informe o novo número: ");
                            int novoNumero = sc.nextInt();
                            sc.nextLine(); // Consumir a quebra de linha
                            System.out.print("Informe a nova data de cadastro (AAAA-MM-DD): ");
                            String novaDataCadastro = sc.nextLine();
                            System.out.print("Informe a nova senha: ");
                            String novaSenha = sc.nextLine();

                            // Criar um novo objeto Cliente com os dados atualizados
                            Cliente novocliente = new Cliente( novoNome, novoSobrenome, LocalDate.parse(novaDataNascimento), novoTelefone, novoCpf, novaCidade, novoEstado, novoPais, novoEndereco, novoNumero, LocalDate.parse(novaDataCadastro), emailClienteEditar, novaSenha);

                            // Atualizar o cliente no banco de dados
                            boolean sucesso = clienteDAO.editarCliente(emailClienteEditar, novocliente);

                            if (sucesso) {
                                System.out.println("Cliente editado com sucesso!");
                            } else {
                                System.out.println("Erro ao editar cliente.");
                            }
                        } else {
                            System.out.println("Cliente não encontrado.");
                        }
                        break;


                    case 15:
                  /*      if (!isVendedor) {
                            System.out.println("Acesso negado. Apenas vendedores podem registrar vendas.");
                            break;
                        }
                        System.out.println("Registrar Venda:");

                        // Solicitar ID do Cliente
                        System.out.print("ID do Cliente: ");
                        int clienteId = sc.nextInt();
                        sc.nextLine(); // Consumir a quebra de linha

                        // Solicitar ID do Produto
                        System.out.print("ID do Produto: ");
                        int produtoId = sc.nextInt();
                        sc.nextLine(); // Consumir a quebra de linha

                        // Solicitar quantidade do produto
                        System.out.print("Quantidade: ");
                        int vendaquantidade = sc.nextInt();
                        sc.nextLine(); // Consumir a quebra de linha

                        // Buscar o produto para obter o preço
                        Produto vendaproduto = produtoDAO.buscarProdutoPorId(produtoId);
                        if (vendaproduto == null || vendaproduto.getQuantidade() < vendaquantidade) {
                            System.out.println("Produto não encontrado ou quantidade insuficiente em estoque.");
                            break;
                        }

                        // Calcular o total da compra
                        double precoProduto = vendaproduto.getPreco();
                        int total = (int) (precoProduto * vendaquantidade);

                        // Solicitar tipo de pagamento
                        System.out.println("Tipo de Pagamento:");
                        System.out.println("(1) Crédito");
                        System.out.println("(2) Débito");
                        System.out.println("(3) Dinheiro");
                        int tipoPagamento = sc.nextInt();
                        double parcelas = 1; // Número padrão de parcelas é 1
                        if (tipoPagamento == 1) { // Se o pagamento for em crédito
                            System.out.print("Total da Compra: ");
                            double totalCompra = sc.nextDouble();
                            if (totalCompra > 1000) { // Se a compra for acima de 1000 reais
                                System.out.println("Deseja parcelar em quantas vezes? (Máximo de 5 vezes)");
                                parcelas = sc.nextDouble();
                                if (parcelas > 5) {
                                    System.out.println("Parcelamento máximo permitido é de 5 vezes.");
                                    break;
                                }
                                if (parcelas > 1) {
                                    // Aplicar acréscimo de juros de 5% para parcelamento acima de 1 vez
                                    total *= 1.05; // Acréscimo de 5% no total da compra
                                } else {
                                    System.out.println("Número inválido de parcelas.");
                                    break;
                                }
                            }
                        } */
/*
                        // Reduzir a quantidade do produto no estoque
                        vendaproduto.setQuantidade(vendaproduto.getQuantidade() - vendaquantidade);
                        produtoDAO.atualizarProduto(vendaproduto);

                        // Obter a data e hora atuais
                        LocalDateTime dataAtual = LocalDateTime.now();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                        String dataFormatada = dataAtual.format(formatter);

                        // Criar um novo objeto Vendas com os dados coletados
                        Vendas venda = new Vendas(0, clienteId, vendedorDAO.buscarVendedorPorEmail(loggedInEmail).getId(),
                                dataAtual.toString(), tipoPagamento, parcelas, total);

                        // Registrar a venda no banco de dados
                        vendasDAO.inserirVenda(venda);

                        System.out.println("Venda registrada com sucesso!");
                        break;
                    */case 16:
                        System.out.println("Saindo...");
                        sc.close();
                        System.exit(0);
                    default:
                        System.out.println("Opção inválida, tente novamente.");
                        break;
                }
            } else {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                sc.next(); // Consumir a entrada inválida
            }
        }
    }

    private static int calcularTotalCompra(ArrayList<Produto> itens) {
        int total = 0;
        for (Produto item : itens) {
            total += item.getPreco() * item.getQuantidade();
        }
        return total;
    }
}

