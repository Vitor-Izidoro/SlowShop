import dao.*;
import models.*;

import java.util.Scanner;
import java.util.List;

public class Main {
    private static boolean isAdmin = false;
    private static boolean isVendedor = false;
    private static boolean isCliente = false;
    private static boolean isLoggedIn = false;
    private static String loggedInEmail = "";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Senha: ");
        String senha = sc.nextLine();

        AdminDAO adminDAO = new AdminDAO();
        VendedorDAO vendedorDAO = new VendedorDAO();
        ClienteDAO clienteDAO = new ClienteDAO();

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
            System.out.println("(7) Sair");

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
                        System.out.print("Data de Nascimento: ");
                        String dataNascimento = sc.nextLine();
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
                        sc.nextLine(); // Consume the newline character
                        System.out.print("Data de Cadastro: ");
                        String dataCadastro = sc.nextLine();
                        System.out.print("Email: ");
                        String emailVendedor = sc.nextLine();
                        System.out.print("Senha: ");
                        String senhaVendedor = sc.nextLine();

                        Vendedor vendedor = new Vendedor(nome, sobrenome, dataNascimento, telefone, cpf, cidade, estado, pais, endereco, numero, dataCadastro, emailVendedor, senhaVendedor);
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
                        String sobrenomeCliente = sc.nextLine();
                        System.out.print("Data de Nascimento: ");
                        String dataNascimentoCliente = sc.nextLine();
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
                        String numeroCliente = sc.nextLine();
                        System.out.print("Email: ");
                        String emailCliente = sc.nextLine();
                        System.out.print("Senha: ");
                        String senhaCliente = sc.nextLine();
                        System.out.print("Data de Cadastro: ");
                        String dataCadastroCliente = sc.nextLine();

                        Cliente cliente = new Cliente(nomeCliente, sobrenomeCliente, dataNascimentoCliente, telefoneCliente, cpfCliente, cidadeCliente, estadoCliente, paisCliente, enderecoCliente, numeroCliente, emailCliente, senhaCliente, dataCadastroCliente);
                        ClienteDAO cDao = new ClienteDAO();
                        cDao.inserirCliente(cliente);
                        System.out.println("Cliente cadastrado com sucesso!");
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
                        String dataCadastroFornecedor = sc.nextLine();

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
                        List<Vendedor> vendedores = vendedorDAO.listarVendedores(loggedInEmail, isAdmin);
                        for (Vendedor v : vendedores) {
                            System.out.println(v.getNome() + " " + v.getSobrenome());
                        }
                        break;
                    case 7:
                        System.out.println("Saindo...");
                        sc.close();
                        System.exit(0);
                    default:
                        System.out.println("Opção inválida, tente novamente.");
                        break;
                }
            } else {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                sc.next(); // Consume the invalid input
            }
        }
    }
}
