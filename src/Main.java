import dao.AdminDAO;
import dao.ClienteDAO;
import dao.VendedorDAO;
import dao.FornecedorDAO;
import dao.ProdutoDAO;
import models.Admin;
import models.Vendedor;
import models.Cliente;
import models.Fornecedor;
import models.Produto;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static boolean isAdmin = false;
    private static boolean isLoggedIn = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Senha: ");
        String senha = sc.nextLine();

        // Verifique se o usuário é admin e está logado
        AdminDAO adminDAO = new AdminDAO();
        isAdmin = adminDAO.verificarAdmin(email, senha);
        isLoggedIn = isAdmin || verificarLogin(email, senha); // Considerando que vendedores e clientes também podem logar

        if (!isLoggedIn) {
            System.out.println("Credenciais inválidas. Encerrando o sistema.");
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
                        cadastrarAdmin(sc);
                        break;
                    case 2:
                        if (isAdmin) {
                            cadastrarVendedor(sc);
                        } else {
                            System.out.println("Apenas admin pode adicionar vendedores.");
                        }
                        break;
                    case 3:
                        cadastrarCliente(sc);
                        break;
                    case 4:
                        cadastrarFornecedor(sc);
                        break;
                    case 5:
                        cadastrarProduto(sc);
                        break;
                    case 6:
                        listarVendedores();
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

    private static boolean verificarLogin(String email, String senha) {
        // Verifique se o usuário é um cliente ou vendedor e está logado
        // Por simplicidade, assumindo que qualquer email e senha válidos logam o usuário.
        return true;
    }

    private static void cadastrarAdmin(Scanner sc) {
        System.out.print("Nome do Admin: ");
        String nomeAdmin = sc.nextLine();
        System.out.print("Email do Admin: ");
        String emailAdmin = sc.nextLine();
        System.out.print("Senha do Admin: ");
        String senhaAdmin = sc.nextLine();

        Admin admin = new Admin(nomeAdmin, emailAdmin, senhaAdmin);
        AdminDAO aDao = new AdminDAO();
        aDao.inserirAdmin(admin);
        System.out.println("Admin cadastrado com sucesso!");
    }

    private static void cadastrarVendedor(Scanner sc) {
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
        System.out.print("Data de Cadastro: ");
        String dataCadastro = sc.nextLine();
        System.out.print("Email: ");
        String emailVendedor = sc.nextLine();
        System.out.print("Senha: ");
        String senhaVendedor = sc.nextLine();

        Vendedor vendedor = new Vendedor(nome, sobrenome, dataNascimento, telefone, cpf, cidade, estado, pais, endereco, dataCadastro, emailVendedor, senhaVendedor);
        VendedorDAO vDao = new VendedorDAO();
        vDao.inserirVendedor(vendedor);
        System.out.println("Vendedor cadastrado com sucesso!");
    }

    private static void cadastrarCliente(Scanner sc) {
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
    }

    private static void cadastrarFornecedor(Scanner sc) {
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

        Fornecedor fornecedor = new Fornecedor(nomeFantasia, razaoSocial, cnpj, emailFornecedor, telefoneFornecedor, cidadeFornecedor, estadoFornecedor, paisFornecedor, enderecoFornecedor, numeroFornecedor, dataCadastroFornecedor);
        FornecedorDAO fDao = new FornecedorDAO();
        fDao.inserirFornecedor(fornecedor);
        System.out.println("Fornecedor cadastrado com sucesso!");
    }

    private static void cadastrarProduto(Scanner sc) {
        System.out.print("Descrição: ");
        String descricao = sc.nextLine();
        System.out.print("Quantidade: ");
        int quantidade = sc.nextInt();
        sc.nextLine(); // Consume the newline character
        System.out.print("Preço: ");
        double preco = sc.nextDouble();
        sc.nextLine(); // Consume the newline character
        System.out.print("Fornecedor (ID): ");
        int fornecedorId = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        Produto produto = new Produto(descricao, quantidade, preco, fornecedorId);
        ProdutoDAO pDao = new ProdutoDAO();
        pDao.inserirProduto(produto);
        System.out.println("Produto cadastrado com sucesso!");
    }

    private static void listarVendedores() {
        VendedorDAO vendedorDao = new VendedorDAO();
        List<Vendedor> vendedores = vendedorDao.listarVendedores();
        for (Vendedor v : vendedores) {
            System.out.println(v.getNome() + " " + v.getSobrenome());
        }
    }
}
