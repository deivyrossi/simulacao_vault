import java.util.*;

public class Main {
    public static void main(String[] args) {
        Vault vault = new Vault();
        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("MENU: ");
            System.out.println("================================");
            System.out.println("1. Cadastrar sobrevivente");
            System.out.println("2. Adicionar habilidade a um sobrevivente");
            System.out.println("3. Remover habilidade de um sobrevivente");
            System.out.println("4. Adicionar recurso ao Vault");
            System.out.println("5. Consumir recurso do Vault");
            System.out.println("6. Registrar Missão");
            System.out.println("7. Adicionar sobrevivente a uma missão");
            System.out.println("8. Exibir sobreviventes do Vault");
            System.out.println("9. Exibir recursos do Vault");
            System.out.println("10. Exibir missões realizadas");
            System.out.println("11. Exibir sobreviventes cadastrados em uma missão");
            System.out.println("12. Sair do sistema");
            System.out.print("Escolha uma opção: ");
            System.out.println();
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do sobrevivente: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite a idade do sobrevivente: ");
                    int idade = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Digite o identificador do sobrevivente: ");
                    String identificador = scanner.nextLine();
                    System.out.print("Digite o status do sobrevivente: ");
                    String status = scanner.nextLine();
                    vault.cadastrarSobrevivente(nome, idade, identificador, status);
                    break;

                case 2:
                    System.out.print("Digite o identificador do sobrevivente: ");
                    identificador = scanner.nextLine();
                    Sobrevivente s = vault.getSobrevivente(identificador);
                    if (s != null) {
                        System.out.print("Digite a habilidade a ser adicionada: ");
                        String habilidade = scanner.nextLine();
                        System.out.println(s.addHabilidade(habilidade));
                    } else {
                        System.out.println("Sobrevivente não encontrado.");
                    }
                    break;

                case 3:
                    System.out.print("Digite o identificador do sobrevivente: ");
                    identificador = scanner.nextLine();
                    s = vault.getSobrevivente(identificador);
                    if (s != null) {
                        System.out.print("Digite a habilidade a ser removida: ");
                        String habilidade = scanner.nextLine();
                        System.out.println(s.removeHabilidade(habilidade));
                    } else {
                        System.out.println("Sobrevivente não encontrado.");
                    }
                    break;

                    case 4:
                    System.out.print("Digite o nome do recurso: ");
                    String nomeRecurso = scanner.nextLine();
                    System.out.print("Digite a unidade do recurso (ex.: litros, peças, único): ");
                    String unidade = scanner.nextLine();
                    int quantidade = 0;
                    if (!unidade.equals("único")) {
                        System.out.print("Digite a quantidade do recurso: ");
                        quantidade = scanner.nextInt();
                        scanner.nextLine();
                    }
                    vault.addRecurso(nomeRecurso, quantidade, unidade);
                    break;
                
                
                case 5:
                    System.out.print("Digite o nome do recurso: ");
                    String recurso = scanner.nextLine();
                    System.out.print("Digite a quantidade a consumir: ");
                    int quantidadeConsumir = scanner.nextInt();
                    scanner.nextLine();
                    if (!vault.consumirRecurso(recurso, quantidadeConsumir)) {
                        System.out.println("Não foi possível consumir o recurso.");
                    }
                    break;
                case 6:
                    System.out.println("1. Registrar nova missão");
                    System.out.println("2. Atualizar status de missão existente");
                    System.out.print("Escolha uma subopção: ");
                    int subopcao = scanner.nextInt();
                    scanner.nextLine();
                    if (subopcao == 1) {
                        System.out.print("Digite o nome da missão: ");
                        String nomeMissao1 = scanner.nextLine();
                        System.out.print("Digite o objetivo: ");
                        String objetivo = scanner.nextLine();
                        System.out.print("Digite o local: ");
                        String local = scanner.nextLine();
                        vault.cadastrarMissao(nomeMissao1, objetivo, local);
                    } else if (subopcao == 2) {
                       
                        System.out.print("Digite o nome da missão: ");
                        String nomeMissao = scanner.nextLine();
                        System.out.print("Digite o novo status (Em andamento, Sucesso, Fracasso): ");
                        String novoStatus = scanner.nextLine();
                        vault.atualizarMissao(nomeMissao, novoStatus);
                        if (novoStatus.equals("Sucesso")) {
                            System.out.print("Digite o nome dos recursos ganhos: ");
                            String nomeRecurso2 = scanner.nextLine();
                            System.out.print("Digite a quantidade do recurso: ");
                            int quantidadeRecurso2 = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Digite a unidade do recurso: ");
                            String unRecurso2 = scanner.nextLine();
                            vault.addRecurso(nomeRecurso2, quantidadeRecurso2, unRecurso2);
                            System.out.print("Digite o identificador dos sobrevivente(s) que participaram da missão: ");
                            identificador = scanner.nextLine();
                    
                        }
                    } else {
                        System.out.println("Subopção inválida.");
                    }
                    break;

                case 7:
                    System.out.print("Digite o nome da missão: ");
                    String nomeMissao = scanner.nextLine();
                    System.out.print("Digite o identificador do sobrevivente: ");
                    identificador = scanner.nextLine();
                    vault.adicionarSobreviventeAM(nomeMissao, identificador);
                    break;

                case 8:
                    vault.listasobreviventes();
                    System.out.println("Deseja atualizar o status de algum sobrevivente: ");
                    System.out.println("1. Sim");
                    System.out.println("2. Não");
                    int escolha = scanner.nextInt();
                    scanner.nextLine();
                    if (escolha == 1) {
                        System.out.print("Digite o identificador do sobrevivente: ");
                        identificador = scanner.nextLine();
                        System.out.print("Digite o novo status (Ativo, Morto, Ferido, Doente): ");
                        String novoStatus = scanner.nextLine();
                        vault.atualizarStatusSobrevivente(novoStatus, identificador);
                    }
                    break;

                case 9:
                    vault.mostrarRecursos();
                    break;

                case 10:
                    vault.mostrarMissoes();
                    break;

                case 11:
                    System.out.print("Digite o nome da missão: ");
                    nomeMissao = scanner.nextLine();
                    vault.mostrarsobreviventesM(nomeMissao);
                    break;

                case 12:
                    System.out.println("Saindo.");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 12);

        scanner.close();
    }
}
