//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        int opcao;

        do {
            System.out.println("\n==== MENU ====");
            System.out.println("1 - Adicionar gerente");
            System.out.println("2 - Adicionar atendente");
            System.out.println("3 - Listar todos os funcionários");
            System.out.println("4 - Mostrar salário de funcionário (buscar por CPF)");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nomeG = sc.nextLine();
                    System.out.print("CPF: ");
                    String cpfG = sc.nextLine();
                    System.out.print("Salário base: ");
                    double salarioG = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Data de nascimento: ");
                    String dataG = sc.nextLine();

                    funcionarios.add(new Gerente(nomeG, cpfG, salarioG, dataG));
                    System.out.println("Gerente adicionado com sucesso!");
                    break;

                case 2:
                    System.out.print("Nome: ");
                    String nomeA = sc.nextLine();
                    System.out.print("CPF: ");
                    String cpfA = sc.nextLine();
                    System.out.print("Salário base: ");
                    double salarioA = sc.nextDouble();
                    System.out.print("Comissão: ");
                    double comissaoA = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Data de nascimento: ");
                    String dataA = sc.nextLine();

                    funcionarios.add(new Atendente(nomeA, cpfA, salarioA, dataA, comissaoA));
                    System.out.println("Atendente adicionado com sucesso!");
                    break;

                case 3:
                    System.out.println("\n--- Lista de Funcionários ---");
                    if (funcionarios.isEmpty()) {
                        System.out.println("Nenhum funcionário cadastrado.");
                    } else {
                        for (Funcionario f : funcionarios) {
                            System.out.println(f);
                        }
                    }
                    break;

                case 4:
                    System.out.print("Informe o CPF do funcionário: ");
                    String cpfBusca = sc.nextLine();
                    boolean encontrado = false;

                    for (Funcionario f : funcionarios) {
                        if (f.getCpf().equals(cpfBusca)) {
                            System.out.println("Funcionário: " + f.nome);
                            System.out.println("Salário total: R$ " + String.format("%.2f", f.getSalario()));
                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("Funcionário não encontrado!");
                    }
                    break;

                case 0:
                    System.out.println("Encerrando o programa...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        sc.close();
    }
}
