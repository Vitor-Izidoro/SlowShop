import dao.*;
import dao.ClienteDAO;
import models.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {

//        private static boolean isAdmin = false;
//        private static boolean isVendedor = false;
//        private static boolean isCliente = false;
//        private static boolean isLoggedIn = false;
//        private static String loggedInEmail = "";

        ClienteDAO cDAO = new ClienteDAO();
    //    private static void listarClientes(ClienteDAO clienteDAO) {
    //        List<Cliente> clientes = clienteDAO.listarClientes();
    //        for (Cliente cliente : clientes) {
    //            System.out.println(cliente.getNome() + " " + cliente.getSobrenome());
    //        }
    //    }
        //listar cliente
        ResultSet rs = cDAO.listarClientes();
        try {
            while(rs.next()) {
                System.out.println("nome: " + rs.getString("nome"));
                System.out.println("sobrenome: " + rs.getString("sobrenome"));

            }
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }}}

//
//        private static void listarFornecedores(FornecedorDAO fornecedorDAO) {
//            List<Fornecedor> fornecedores = fornecedorDAO.listarFornecedores();
//            for (Fornecedor fornecedor : fornecedores) {
//                System.out.println(fornecedor.getNomeFantasia());
//            }
//        }
//
//        private static void listarProdutos(ProdutoDAO produtoDAO) {
//            List<Produto> produtos = produtoDAO.listarProdutos();
//            for (Produto produto : produtos) {
//                System.out.println(produto.getDescricao());
//            }
//        }
//
//        private static void listarVendedores(VendedorDAO vendedorDAO) {
//            List<Vendedor> vendedores = vendedorDAO.listarVendedores();
//            for (Vendedor vendedor : vendedores) {
//                System.out.println(vendedor.getNome() + " " + vendedor.getSobrenome());
//            }
//        }
//
//        public static void main(String[] args) {
//            Scanner sc = new Scanner(System.in);
//            System.out.print("Email: ");
//            String email = sc.nextLine();
//            System.out.print("Senha: ");
//            String senha = sc.nextLine();
//
//            AdminDAO adminDAO = new AdminDAO();
//            VendedorDAO vendedorDAO = new VendedorDAO();
//            ClienteDAO clienteDAO = new ClienteDAO();
//
//            isAdmin = adminDAO.verificarAdmin(email, senha);
//            isVendedor = vendedorDAO.verificarVendedor(email, senha);
//            isCliente = clienteDAO.verificarCliente(email, senha);
//            isLoggedIn = isAdmin || isVendedor || isCliente;
//            loggedInEmail = isLoggedIn ? email : "";
//
//            if (!isLoggedIn) {
//                System.out.println("Login falhou! Verifique suas credenciais.");
//                return;
//            }
//
//            int opcaoMenu = 0;
//            while (true) {
//                System.out.println("\n* Menu de Controle * ");
//                System.out.println("(1) Cadastrar Admin");
//                System.out.println("(2) Cadastrar Vendedor");
//                System.out.println("(3) Cadastrar Cliente");
//                System.out.println("(4) Cadastrar Fornecedor");
//                System.out.println("(5) Cadastrar Produto");
//                System.out.println("(6) Listar Vendedor");
//                System.out.println("(7) Listar Cliente");
//                System.out.println("(8) Listar Fornecedor");
//                System.out.println("(9) Listar Produto");
//                System.out.println("(10) Deletar Usuario");
//                System.out.println("(11) Sair");
//
//
//                if (sc.hasNextInt()) {
//                    opcaoMenu = sc.nextInt();
//                    sc.nextLine(); // Consume the newline character
//
//                    switch (opcaoMenu) {
//                        case 1:
//                            if (!isAdmin) {
//                                System.out.println("Acesso negado. Apenas administradores podem cadastrar novos administradores.");
//                                break;
//                            }
//                            System.out.print("Nome do Admin: ");
//                            String nomeAdmin = sc.nextLine();
//                            System.out.print("Email do Admin: ");
//                            String emailAdmin = sc.nextLine();
//                            System.out.print("Senha do Admin: ");
//                            String senhaAdmin = sc.nextLine();
//
//                            Admin admin = new Admin(nomeAdmin, emailAdmin, senhaAdmin);
//                            adminDAO.inserirAdmin(admin);
//                            System.out.println("Admin cadastrado com sucesso!");
//                            break;
//                        case 2:
//                            if (!isAdmin) {
//                                System.out.println("Acesso negado. Apenas administradores podem cadastrar novos administradores.");
//                                break;
//                            }
//                            System.out.print("Nome: ");
//                            String nome = sc.nextLine();
//                            System.out.print("Sobrenome: ");
//                            String sobrenome = sc.nextLine();
//                            System.out.print("Data de Nascimento: ");
//                            String dataNascimento = sc.nextLine();
//                            System.out.print("Telefone: ");
//                            String telefone = sc.nextLine();
//                            System.out.print("CPF: ");
//                            String cpf = sc.nextLine();
//                            System.out.print("Cidade: ");
//                            String cidade = sc.nextLine();
//                            System.out.print("Estado: ");
//                            String estado = sc.nextLine();
//                            System.out.print("País: ");
//                            String pais = sc.nextLine();
//                            System.out.print("Endereço: ");
//                            String endereco = sc.nextLine();
//                            System.out.print("Número: ");
//                            int numero = sc.nextInt();
//                            sc.nextLine(); // Consume the newline character
//                            System.out.print("Data de Cadastro: ");
//                            String dataCadastro = sc.nextLine();
//                            System.out.print("Email: ");
//                            String emailVendedor = sc.nextLine();
//                            System.out.print("Senha: ");
//                            String senhaVendedor = sc.nextLine();
//
//                            Vendedor vendedor = new Vendedor(nome, sobrenome, dataNascimento, telefone, cpf, cidade, estado, pais, endereco, numero, dataCadastro, emailVendedor, senhaVendedor);
//                            vendedorDAO.inserirVendedor(vendedor);
//                            System.out.println("Vendedor cadastrado com sucesso!");
//                            break;
//                        case 3:
//                            if (!isAdmin && !isVendedor) {
//                                System.out.println("Acesso negado. Apenas administradores podem cadastrar novos administradores.");
//                                break;
//                            }
//                            System.out.print("Nome: ");
//                            String nomeCliente = sc.nextLine();
//                            System.out.print("Sobrenome: ");
//                            String sobrenomeCliente = sc.nextLine();
//                            System.out.print("Data de Nascimento: ");
//                            String dataNascimentoCliente = sc.nextLine();
//                            System.out.print("Telefone: ");
//                            String telefoneCliente = sc.nextLine();
//                            System.out.print("CPF: ");
//                            String cpfCliente = sc.nextLine();
//                            System.out.print("Cidade: ");
//                            String cidadeCliente = sc.nextLine();
//                            System.out.print("Estado: ");
//                            String estadoCliente = sc.nextLine();
//                            System.out.print("País: ");
//                            String paisCliente = sc.nextLine();
//                            System.out.print("Endereço: ");
//                            String enderecoCliente = sc.nextLine();
//                            System.out.print("Número: ");
//                            String numeroCliente = sc.nextLine();
//                            System.out.print("Email: ");
//                            String emailCliente = sc.nextLine();
//                            System.out.print("Senha: ");
//                            String senhaCliente = sc.nextLine();
//                            System.out.print("Data de Cadastro: ");
//                            String dataCadastroCliente = sc.nextLine();
//
//                            Cliente cliente = new Cliente(nomeCliente, sobrenomeCliente, dataNascimentoCliente, telefoneCliente, cpfCliente, cidadeCliente, estadoCliente, paisCliente, enderecoCliente, numeroCliente, emailCliente, senhaCliente, dataCadastroCliente);
//                            ClienteDAO cDao = new ClienteDAO();
//                            cDao.inserirCliente(cliente);
//                            System.out.println("Cliente cadastrado com sucesso!");
//                            break;
//                        case 4:
//                            if (!isAdmin && !isVendedor) {
//                                System.out.println("Acesso negado. Apenas administradores podem cadastrar novos administradores.");
//                                break;
//                            }
//                            System.out.print("Nome Fantasia: ");
//                            String nomeFantasia = sc.nextLine();
//                            System.out.print("Razão Social: ");
//                            String razaoSocial = sc.nextLine();
//                            System.out.print("CNPJ: ");
//                            String cnpj = sc.nextLine();
//                            System.out.print("Email: ");
//                            String emailFornecedor = sc.nextLine();
//                            System.out.print("Telefone: ");
//                            String telefoneFornecedor = sc.nextLine();
//                            System.out.print("Cidade: ");
//                            String cidadeFornecedor = sc.nextLine();
//                            System.out.print("Estado: ");
//                            String estadoFornecedor = sc.nextLine();
//                            System.out.print("País: ");
//                            String paisFornecedor = sc.nextLine();
//                            System.out.print("Endereço: ");
//                            String enderecoFornecedor = sc.nextLine();
//                            System.out.print("Número: ");
//                            String numeroFornecedor = sc.nextLine();
//                            System.out.print("Data de Cadastro: ");
//                            String dataCadastroFornecedor = sc.nextLine();
//
//                            Fornecedor fornecedor = new Fornecedor(nomeFantasia, razaoSocial, cnpj, emailFornecedor, telefoneFornecedor, cidadeFornecedor, estadoFornecedor, paisFornecedor, enderecoFornecedor, numeroFornecedor, dataCadastroFornecedor, senha);
//                            FornecedorDAO fDao = new FornecedorDAO();
//                            fDao.inserirFornecedor(fornecedor);
//                            System.out.println("Fornecedor cadastrado com sucesso!");
//                            break;
//                        case 5:
//                            if (!isAdmin && !isVendedor) {
//                                System.out.println("Acesso negado. Apenas administradores podem cadastrar novos administradores.");
//                                break;
//                            }
//                            System.out.print("Descrição: ");
//                            String descricao = sc.nextLine();
//                            System.out.print("Quantidade: ");
//                            int quantidade = sc.nextInt();
//                            sc.nextLine(); // Consume the newline character
//                            System.out.print("Preço: ");
//                            double preco = sc.nextDouble();
//                            sc.nextLine(); // Consume the newline character
//                            System.out.print("Fornecedor: ");
//                            int fornecedorId = sc.nextInt();
//                            sc.nextLine(); // Consume the newline character
//
//                            Produto produto = new Produto(descricao, quantidade, preco, fornecedorId);
//                            ProdutoDAO pDao = new ProdutoDAO();
//                            pDao.inserirProduto(produto);
//                            System.out.println("Produto cadastrado com sucesso!");
//                            break;
//                        case 6:
//                            List<Vendedor> vendedores = vendedorDAO.listarVendedores(loggedInEmail, isAdmin);
//                            for (Vendedor v : vendedores) {
//                                System.out.println(v.getNome() + " " + v.getSobrenome());
//                            }
//                            break;
//                        case 7:
//                            listarClientes(clienteDAO);
//                            break;
//                        case 8:
//                            //listarFornecedores();
//                            break;
//                        case 9:
//                            //listarProdutos();
//                            break;
//                        case 10:
//                            if (!isAdmin && !isVendedor) {
//                                System.out.println("Acesso negado. Apenas administradores ou vendedores podem deletar clientes.");
//                                break;
//                            }
//                            System.out.print("Email do Cliente a ser deletado: ");
//                            String emailClienteDeletar = sc.nextLine();
//                            boolean clienteDeletado = clienteDAO.deletarCliente(emailClienteDeletar);
//                            if (clienteDeletado) {
//                                System.out.println("Cliente deletado com sucesso!");
//                            } else {
//                                System.out.println("Falha ao deletar cliente. Verifique se o email está correto.");
//                            }
//                            break;
//                        case 11:
//                            System.out.println("Saindo...");
//                            sc.close();
//                            System.exit(0);
//                        default:
//                            System.out.println("Opção inválida, tente novamente.");
//                            break;
//                    }
//                } else {
//                    System.out.println("Entrada inválida. Por favor, insira um número.");
//                    sc.next(); // Consume the invalid input
//                }
//            }
//        }
//
//    }
//}

/*
import dao.AdminDAO;
import dao.ClienteDAO;
import dao.VendedorDAO;
import dao.FornecedorDAO;
import dao.ProdutoDAO;
import models.Admin;
import models.Cliente;
import models.Vendedor;
import models.Fornecedor;
import models.Produto;

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
            System.out.println("(7) Listar Cliente");
            System.out.println("(8) Listar Fornecedor");
            System.out.println("(9) Listar Produto");
            System.out.println("(10) Sair");

            if (sc.hasNextInt()) {
                opcaoMenu = sc.nextInt();
                sc.nextLine(); // Consume the newline character

                switch (opcaoMenu) {
                    case 1:
                        cadastrarAdmin(sc, adminDAO);
                        break;
                    case 2:
                        cadastrarVendedor(sc, vendedorDAO);
                        break;
                    case 3:
                        cadastrarCliente(sc, clienteDAO);
                        break;
                    case 4:
                        cadastrarFornecedor(sc);
                        break;
                    case 5:
                        cadastrarProduto(sc);
                        break;
                    case 6:
                        listarVendedores(vendedorDAO);
                        break;
                    case 7:
                        listarClientes(clienteDAO);
                        break;
                    case 8:
                        listarFornecedores();
                        break;
                    case 9:
                        listarProdutos();
                        break;
                    case 10:
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

    private static void cadastrarAdmin(Scanner sc, AdminDAO adminDAO) {
        if (!isAdmin) {
            System.out.println("Acesso negado. Apenas administradores podem cadastrar novos administradores.");
            return;
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
    }

    private static void cadastrarVendedor(Scanner sc, VendedorDAO vendedorDAO) {
        if (!isAdmin) {
            System.out.println("Acesso negado. Apenas administradores podem cadastrar novos administradores.");
            return;
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
    }

    private static void cadastrarCliente(Scanner sc, ClienteDAO clienteDAO) {
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
        clienteDAO.inserirCliente(cliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    private static void cadastrarFornecedor(Scanner sc) {
        if (!isAdmin && !isVendedor) {
            System.out.println("Acesso negado. Apenas administradores e vendedores podem cadastrar fornecedores.");
            return;
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
        System.out.print("Senha: ");
        String senhaFornecedor = sc.nextLine();

        Fornecedor fornecedor = new Fornecedor(nomeFantasia, razaoSocial, cnpj, emailFornecedor, telefoneFornecedor, cidadeFornecedor, estadoFornecedor, paisFornecedor, enderecoFornecedor, numeroFornecedor, dataCadastroFornecedor, senhaFornecedor);
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        fornecedorDAO.inserirFornecedor(fornecedor);
        System.out.println("Fornecedor cadastrado com sucesso!");
    }

    private static void cadastrarProduto(Scanner sc) {
        if (!isAdmin && !isVendedor) {
            System.out.println("Acesso negado. Apenas administradores e vendedores podem cadastrar produtos.");
            return;
        }
        System.out.print("Descrição: ");
        String descricao = sc.nextLine();
        System.out.print("Quantidade: ");
        int quantidade = sc.nextInt();
        sc.nextLine(); // Consume the newline character
        System.out.print("Preço: ");
        double preco = sc.nextDouble();
        sc.nextLine(); // Consume the newline character

        Produto produto = new Produto(descricao, quantidade, preco);
        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtoDAO.inserirProduto(produto);
        System.out.println("Produto cadastrado com sucesso!");
    }

    private static void listarVendedores(VendedorDAO vendedorDAO) {
        if (!isAdmin) {
            System.out.println("Acesso negado. Apenas administradores podem listar vendedores.");
            return;
        }
        List<Vendedor> vendedores = vendedorDAO.listarVendedores();
        System.out.println("\n* Lista de Vendedores *");
        for (Vendedor v : vendedores) {
            System.out.println("ID: " + v.getId() + ", Nome: " + v.getNome() + ", Email: " + v.getEmail());
        }
    }

    private static void listarClientes(ClienteDAO clienteDAO) {
        if (!isAdmin && !isVendedor) {
            System.out.println("Acesso negado. Apenas administradores e vendedores podem listar clientes.");
            return;
        }
        List<Cliente> clientes = clienteDAO.listarClientes();
        System.out.println("\n* Lista de Clientes *");
        for (Cliente c : clientes) {
            System.out.println("ID: " + c.getId() + ", Nome: " + c.getNome() + ", Email: " + c.getEmail());
        }
    }

    private static void listarFornecedores() {
        if (!isAdmin && !isVendedor) {
            System.out.println("Acesso negado. Apenas administradores e vendedores podem listar fornecedores.");
            return;
        }
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        List<Fornecedor> fornecedores = fornecedorDAO.listarFornecedores();
        System.out.println("\n* Lista de Fornecedores *");
        for (Fornecedor f : fornecedores) {
            System.out.println("ID: " + f.getId() + ", Nome Fantasia: " + f.getNomeFantasia() + ", Email: " + f.getEmail());
        }
    }

    private static void listarProdutos() {
        if (!isAdmin && !isVendedor) {
            System.out.println("Acesso negado. Apenas administradores e vendedores podem listar produtos.");
            return;
        }
        ProdutoDAO produtoDAO = new ProdutoDAO();
        List<Produto> produtos = produtoDAO.listarProdutos();
        System.out.println("\n* Lista de Produtos *");
        for (Produto p : produtos) {
            System.out.println("ID: " + p.getId() + ", Descrição: " + p.getDescricao() + ", Preço: " + p.getPreco());
        }
    }
}

 */
