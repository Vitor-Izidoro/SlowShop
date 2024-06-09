import java.util.Scanner;

public class Main {
    private static boolean isAdmin = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Senha: ");
        String senha = sc.nextLine();

        if (login(email, senha)) {
            int opcaoMenu = 0;

            while (opcaoMenu != 7) {
                System.out.println("\n* Menu de Controle * ");
                System.out.println("(1) Cadastrar Admin");
                System.out.println("(2) Cadastrar Vendedor");
                System.out.println("(3) Cadastrar Cliente");
                System.out.println("(4) Cadastrar Fornecedor");
                System.out.println("(5) Cadastrar Produto");
                System.out.println("(6) Listar Vendedor");
                System.out.println("(7) Sair");
                opcaoMenu = sc.nextInt();
                sc.nextLine();

                switch (opcaoMenu) {
                    case 1:
                        if (isAdmin) {
                            cadastrarAdmin(sc);
                        } else {
                            System.out.println("Acesso negado. Apenas administradores podem acessar esta opção.");
                        }
                        break;
                    case 2:
                        if (isAdmin) {
                            cadastrarVendedor(sc);
                        } else {
                            System.out.println("Acesso negado. Apenas administradores podem acessar esta opção.");
                        }
                        break;
//* adicionar outros cases
                    case 7:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida, tente novamente.");
                }
            }
        } else {
            System.out.println("Login falhou. Email ou senha incorretos.");
        }
        sc.close();
    }

    private static boolean login(String email, String senha) {
        // * substituir esta parte pela verificação no banco de dados
        if (email.equals("admin@admin.com") && senha.equals("admin")) {
            isAdmin = true;
            return true;
        } else if (email.equals("user@user.com") && senha.equals("user")) {
            isAdmin = false;
            return true;
        }
        return false;
    }

    private static void cadastrarAdmin(Scanner sc) {
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Senha: ");
        String senha = sc.nextLine();

        Admin admin = new Admin();
        admin.setNome(nome);
        admin.setEmail(email);
        admin.setSenha(senha);

        AdminDAO adminDAO = new AdminDAO();
        adminDAO.cadastrarAdmin(admin);

        System.out.println("Admin cadastrado com sucesso!");
    }

    private static void cadastrarVendedor(Scanner sc) {
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        Vendedor vendedor = new Vendedor();
        vendedor.setNome(nome);

        VendedorDAO vendedorDAO = new VendedorDAO();
        vendedorDAO.cadastrarVendedor(vendedor);

        System.out.println("Vendedor cadastrado com sucesso!");
    }

    // Fazer métodos para cadastrarCliente, cadastrarFornecedor, cadastrarProduto, listarVendedor e outros
}