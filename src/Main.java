import dao.AdminDAO;
import dao.VendedorDAO;
import models.Admin;
import models.Vendedor;
import java.util.Scanner;
import java.util.List;

public class Main {
    private static boolean isAdmin = false;
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

        isAdmin = adminDAO.verificarAdmin(email, senha);
        isLoggedIn = isAdmin || vendedorDAO.verificarVendedor(email, senha);
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
