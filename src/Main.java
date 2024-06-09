import dao.AdminDAO;
import dao.ClienteDAO;
import models.Admin;
import models.Cliente;

import java.util.Scanner;

public class Main {
    private static boolean isAdmin = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Senha: ");
        String senha = sc.nextLine();

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
                        AdminDAO aDao = new AdminDAO();
                        aDao.inserirAdmin(admin);
                        System.out.println("Admin cadastrado com sucesso!");
                        break;
                    case 2:
                        // Implementar cadastro de vendedor
                        System.out.println("Cadastro de Vendedor ainda não implementado.");
                        break;
                    case 3:
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
                        String numero = sc.nextLine();
                        System.out.print("Email: ");
                        String emailCliente = sc.nextLine();
                        System.out.print("Senha: ");
                        String senhaCliente = sc.nextLine();
                        System.out.print("Data de Cadastro: ");
                        String dataCadastro = sc.nextLine();

                        Cliente cliente = new Cliente(nome, sobrenome, dataNascimento, telefone, cpf, cidade, estado, pais, endereco, numero, emailCliente, senhaCliente, dataCadastro);
                        ClienteDAO cDAO = new ClienteDAO();
                        cDAO.inserirCliente(cliente);
                        System.out.println("Cliente cadastrado com sucesso!");
                        break;
                    case 4:
                        // Implementar cadastro de fornecedor
                        System.out.println("Cadastro de Fornecedor ainda não implementado.");
                        break;
                    case 5:
                        // Implementar cadastro de produto
                        System.out.println("Cadastro de Produto ainda não implementado.");
                        break;
                    case 6:
                        // Implementar listagem de vendedor
                        System.out.println("Listagem de Vendedor ainda não implementado.");
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
