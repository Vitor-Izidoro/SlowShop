import dao.*;
import models.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;
import dao.*;
import models.*;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.List;

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
        List<Cliente> clientes = clienteDAO.listarCliente();
        for (Cliente cliente : clientes) {
            System.out.println(
                    "ID: " + cliente.getId() + "\n" +
                            "Nome: " + cliente.getNome() + "\n" +
                            "Sobrenome: " + cliente.getSobrenome() + "\n" +
                            "Data de Nascimento: " + cliente.getDataNascimento() + "\n" +
                            "Telefone: " + cliente.getTelefone() + "\n" +
                            "CPF: " + cliente.getCpf() + "\n" +
                            "Cidade: " + cliente.getCidade() + "\n" +
                            "Estado: " + cliente.getEstado() + "\n" +
                            "País: " + cliente.getPais() + "\n" +
                            "Endereço: " + cliente.getEndereco() + "\n" +
                            "Número: " + cliente.getNumero() + "\n" +
                            "Data de Cadastro: " + cliente.getDataCadastro() + "\n" +
                            "Email: " + cliente.getEmail() + "\n" +
                            "Senha: " + cliente.getSenha() + "\n"
            );
            System.out.println("-----------------------------------");
        }
    }

    private static void listarProdutos(ProdutoDAO produtoDAO) {
        List<Produto> produtos = produtoDAO.listarProdutos();
        for (Produto produto : produtos) {
            System.out.println(
                    "ID: " + produto.getId_produto() + "\n" +
                            "Descrição: " + produto.getDescricao() + "\n" +
                            "Quantidade: " + produto.getQuantidade() + "\n" +
                            "Preço: " + produto.getPreco() + "\n" +
                            "ID do Fornecedor: " + produto.getFornecedorId() + "\n"
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
                            "Email: " + fornecedor.getEmail() + "\n" +
                            "Telefone: " + fornecedor.getTelefone() + "\n" +
                            "Cidade: " + fornecedor.getCidade() + "\n" +
                            "Estado: " + fornecedor.getEstado() + "\n" +
                            "País: " + fornecedor.getPais() + "\n" +
                            "Endereço: " + fornecedor.getEndereco() + "\n" +
                            "Número: " + fornecedor.getNumero() + "\n" +
                            "Data de Cadastro: " + fornecedor.getDataCadastro() + "\n"
            );
            System.out.println("-----------------------------------");
        }
    }

    private static void alterarVendedor(VendedorDAO vendedorDAO, String emailVendedorEditar) {
        Scanner sc = new Scanner(System.in);

        if (!isAdmin && !emailVendedorEditar.equals(loggedInEmail)) {
            System.out.println("Acesso negado. Você só pode editar seus próprios dados.");
            return;
        }

        Vendedor vendedor = vendedorDAO.buscarVendedorPorEmail(emailVendedorEditar);
        if (vendedor == null) {
            System.out.println("Vendedor não encontrado.");
            return;
        }

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

        Vendedor novoVendedor = new Vendedor(vendedor.getId(), novoNome, novoSobrenome, LocalDate.parse(novaDataNascimento), novoTelefone, novoCpf, novaCidade, novoEstado, novoPais, novoEndereco, novoNumero, LocalDate.parse(novaDataCadastro), emailVendedorEditar, novaSenha);
        boolean sucesso = vendedorDAO.editarVendedor(emailVendedorEditar, novoVendedor);
        if (sucesso) {
            System.out.println("Vendedor editado com sucesso!");
        } else {
            System.out.println("Erro ao editar vendedor.");
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
            System.out.println("(15) Alterar produto");
            System.out.println("(16) Alterar fornecedor");
            System.out.println("(17) Alterar Vendedor");
            System.out.println("(18) Registrar Compra");
            System.out.println("(19) Fechamento do dia");
            System.out.println("(20) Sair");

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
                            System.out.println("Acesso negado. Apenas administradores e vendedores podem cadastrar novos clientes.");
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
                        clienteDAO.inserirCliente(cliente);
                        System.out.println("Cliente cadastrado com sucesso!");
                        break;
                    case 4:
                        if (!isAdmin && !isVendedor) {
                            System.out.println("Acesso negado. Apenas administradores e vendedores podem cadastrar novos fornecedores.");
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
                        LocalDate dataCadastroFornecedor = LocalDate.now(); // Definindo a data de cadastro como a data atual
                        System.out.print("Senha: ");
                        String senhaFornecedor = sc.nextLine();

                        System.out.println("Debug Info: Nome Fantasia = " + nomeFantasia); // Debug statement

                        Fornecedor fornecedor = new Fornecedor(nomeFantasia, razaoSocial, cnpj, emailFornecedor, telefoneFornecedor, cidadeFornecedor, estadoFornecedor, paisFornecedor, enderecoFornecedor, numeroFornecedor, dataCadastroFornecedor, senhaFornecedor);
                        fornecedorDAO.inserirFornecedor(fornecedor);
                        System.out.println("Fornecedor cadastrado com sucesso!");
                        break;
                    case 5:
                        if (!isAdmin && !isVendedor) {
                            System.out.println("Acesso negado. Apenas administradores e vendedores podem cadastrar novos produtos.");
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
                        produtoDAO.inserirProduto(produto);
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
                        listarProdutos(produtoDAO);
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
                            System.out.println("Acesso negado. Apenas administradores podem deletar vendedores.");
                            break;
                        }
                        System.out.print("Email do Vendedor a ser deletado: ");
                        String emailVendedorDeletar = sc.nextLine();
                        boolean vendedorDeletado = vendedorDAO.deletarVendedor(emailVendedorDeletar);
                        if (vendedorDeletado) {
                            System.out.println("Vendedor deletado com sucesso!");
                        } else {
                            System.out.println("Falha ao deletar vendedor. Verifique se o email está correto.");
                        }
                        break;
                    case 12:
                        if (!isAdmin) {
                            System.out.println("Acesso negado. Apenas administradores podem deletar fornecedores.");
                            break;
                        }
                        System.out.print("Email do Fornecedor a ser deletado: ");
                        String emailFornecedorDeletar = sc.nextLine();
                        boolean fornecedorDeletado = fornecedorDAO.deletarFornecedor(emailFornecedorDeletar);
                        if (fornecedorDeletado) {
                            System.out.println("Fornecedor deletado com sucesso!");
                        } else {
                            System.out.println("Falha ao deletar fornecedor. Verifique se o email está correto.");
                        }
                        break;
                    case 13:
                        if (!isAdmin) {
                            System.out.println("Acesso negado. Apenas administradores podem deletar produtos.");
                            break;
                        }
                        System.out.print("Descrição do produto a ser deletado: ");
                        String descricaoProdutoDeletar = sc.nextLine();
                        boolean produtoDeletado = produtoDAO.deletarProduto(descricaoProdutoDeletar);
                        if (produtoDeletado) {
                            System.out.println("Produto deletado com sucesso!");
                        } else {
                            System.out.println("Falha ao deletar produto. Verifique se a descrição está correta.");
                        }
                        break;
                    case 14:
                        if (!isAdmin && !isVendedor) {
                            System.out.println("Acesso negado. Apenas administradores e vendedores podem editar clientes.");
                            break;
                        }
                        System.out.println("Editar cliente");
                        System.out.print("Informe o email do cliente que deseja editar: ");
                        String emailClienteEditar = sc.nextLine();
                        if (clienteDAO.verificarCliente(emailClienteEditar, "")) {
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
                            Cliente novocliente = new Cliente(novoNome, novoSobrenome, LocalDate.parse(novaDataNascimento), novoTelefone, novoCpf, novaCidade, novoEstado, novoPais, novoEndereco, novoNumero, LocalDate.parse(novaDataCadastro), emailClienteEditar, novaSenha);
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
                        if (!isAdmin) {
                            System.out.println("Acesso negado. Apenas administradores podem alterar produtos.");
                            break;
                        }
                        System.out.println("Editar produto");
                        System.out.print("Informe o id do produto que deseja editar: ");
                        String idProdutoEditar = sc.nextLine();
                        if (produtoDAO.verificarProduto(Integer.parseInt(idProdutoEditar), "")) {
                            System.out.print("Informe a nova descricao: ");
                            String novoNome = sc.nextLine();
                            System.out.print("Informe a nova quantidade: ");
                            int novaQuantidade = sc.nextInt();
                            sc.nextLine(); // Consumir a quebra de linha
                            System.out.print("Informe o novo preço: ");
                            double novoValor = sc.nextInt();
                            sc.nextLine(); // Consumir a quebra de linha
                            System.out.print("Informe o novo id do fornecedor: ");
                            int novoIdFornecedor = sc.nextInt();
                            sc.nextLine(); // Consumir a quebra de linha
                            Produto novoProduto = new Produto(novoNome, novaQuantidade, novoValor, novoIdFornecedor);
                            boolean sucesso = produtoDAO.atualizarProduto(Integer.parseInt(idProdutoEditar), novoProduto);
                            if (sucesso) {
                                System.out.println("Produto editado com sucesso!");
                            } else {
                                System.out.println("Erro ao editar produto.");
                            }
                        } else {
                            System.out.println("Cliente não encontrado.");
                        }
                        break;
                    case 16:
                        if (!isAdmin && !isVendedor) {
                            System.out.println("Acesso negado. Apenas administradores e vendedores podem editar fornecedores.");
                            break;
                        }
                        System.out.println("Editar fornecedor");
                        System.out.print("Informe o ID do fornecedor que deseja editar: ");
                        int idFornecedorEditar = sc.nextInt();
                        sc.nextLine(); // Consumir a quebra de linha
                        FornecedorDAO fornecedorDAO1 = new FornecedorDAO();
                        Fornecedor fornecedorExistente = fornecedorDAO.buscarFornecedorPorId(idFornecedorEditar);
                        if (fornecedorExistente != null) {
                            System.out.print("Informe o novo nome fantasia: ");
                            String novoNomeFantasia = sc.nextLine();
                            System.out.print("Informe a nova razão social: ");
                            String novaRazaoSocial = sc.nextLine();
                            System.out.print("Informe o novo CNPJ: ");
                            String novoCnpj = sc.nextLine();
                            System.out.print("Informe o novo telefone: ");
                            String novoTelefone = sc.nextLine();
                            System.out.print("Informe a nova cidade: ");
                            String novaCidade = sc.nextLine();
                            System.out.print("Informe o novo estado: ");
                            String novoEstado = sc.nextLine();
                            System.out.print("Informe o novo país: ");
                            String novoPais = sc.nextLine();
                            System.out.print("Informe o novo endereço: ");
                            String novoEndereco = sc.nextLine();
                            System.out.print("Informe o novo número: ");
                            String novoNumero = sc.nextLine();
                            System.out.print("Informe a nova data de cadastro (AAAA-MM-DD): ");
                            String novaDataCadastro = sc.nextLine();
                            System.out.print("Informe a nova senha: ");
                            String novaSenha = sc.nextLine();

                            Fornecedor novoFornecedor = new Fornecedor(novoNomeFantasia, novaRazaoSocial, novoCnpj, fornecedorExistente.getEmail(), novoTelefone, novaCidade, novoEstado, novoPais, novoEndereco, novoNumero, LocalDate.parse(novaDataCadastro), novaSenha);
                            boolean sucesso = fornecedorDAO.editarFornecedor(idFornecedorEditar, novoFornecedor);
                            if (sucesso) {
                                System.out.println("Fornecedor editado com sucesso!");
                            } else {
                                System.out.println("Erro ao editar fornecedor.");
                            }
                        } else {
                            System.out.println("Fornecedor não encontrado.");
                        }
                        break;


                    case 17:
                        if (isAdmin) {
                            System.out.println("Editar vendedor (Administrador)");
                            System.out.print("Informe o email do vendedor que deseja editar: ");
                            String emailVendedorEditar = sc.nextLine();
                            alterarVendedor(vendedorDAO, emailVendedorEditar);
                        } else if (isVendedor) {
                            System.out.println("Editar seus próprios dados (Vendedor)");
                            alterarVendedor(vendedorDAO, loggedInEmail);
                        } else {
                            System.out.println("Acesso negado. Apenas vendedores ou administradores podem editar vendedores.");
                        }
                        break;



                    case 18:
                        if (!isVendedor) {
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
                        double total = precoProduto * vendaquantidade;

                        // Solicitar tipo de pagamento
                        System.out.println("Tipo de Pagamento:");
                        System.out.println("(1) Crédito");
                        System.out.println("(2) Débito");
                        System.out.println("(3) Dinheiro");
                        int tipoPagamento = sc.nextInt();
                        double parcelas = 1; // Número padrão de parcelas é 1
                        if (tipoPagamento == 1) { // Se o pagamento for em crédito
                            System.out.print("Número de parcelas: ");
                            parcelas = sc.nextInt();
                        }

                        // Obter o ID do vendedor logado
                        int vendedorId = vendedorDAO.getVendedorLogado().getId();

                        // Registrar a venda no banco de dados
                        Vendas venda = new Vendas(0, clienteId, vendedorId, java.time.LocalDate.now().toString(), tipoPagamento, parcelas, total);
                        vendasDAO.inserirVenda(venda);

                        // Atualizar a quantidade do produto no estoque
                        int novaQuantidade = vendaproduto.getQuantidade() - vendaquantidade;
                        boolean atualizado = produtoDAO.atualizarQuantidadeProduto(produtoId, novaQuantidade);
                        if (atualizado) {
                            System.out.println("Venda registrada com sucesso e quantidade do produto atualizada!");
                        } else {
                            System.out.println("Erro ao atualizar a quantidade do produto.");
                        }
                        break;

                    case 19:
                        if (!isAdmin && !isVendedor) {
                            System.out.println("Acesso negado. Apenas administradores e vendedores podem acessar o fechamento do dia.");
                            break;
                        }

                        LocalDate today = LocalDate.now();
                        double totalDinheiro = 0;
                        double totalDebito = 0;

                        try (Connection conn = Conexao.getConexao().getConnection()) {
                            String query = "SELECT pagamento, total FROM vendas WHERE DATE(data) = ?";
                            try (PreparedStatement ps = conn.prepareStatement(query)) {
                                ps.setDate(1, java.sql.Date.valueOf(today));
                                try (ResultSet rs = ps.executeQuery()) {
                                    while (rs.next()) {
                                        int pagamento = rs.getInt("pagamento");
                                        double valorTotal = rs.getDouble("total");
                                        if (pagamento == 2) { // Débito
                                            totalDebito += valorTotal;
                                        } else if (pagamento == 3) { // Dinheiro
                                            totalDinheiro += valorTotal;
                                        }
                                    }
                                }
                            }
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }

                        System.out.println("Fechamento do Dia:");
                        System.out.println("Total em Dinheiro: R$ " + totalDinheiro);
                        System.out.println("Total em Débito: R$ " + totalDebito);
                        break;


                    case 20:
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

