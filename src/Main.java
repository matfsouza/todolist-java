import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TarefaServico tarefaServico = new TarefaServico();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n---- Menu ToDoList ----");
            System.out.println("1. Adicionar Nova Tarefa");
            System.out.println("2. Listar Todas as Tarefas");
            System.out.println("3. Marcar Tarefa como Concluída");
            System.out.println("4. Remover Tarefa");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();

            if (opcao == 0) {
                System.out.println("Saindo do programa...");
                break;
            } else if (opcao == 1) {
                scanner.nextLine(); // Limpeza de buffer

                System.out.print("Digite o título da tarefa: ");
                String titulo = scanner.nextLine();

                System.out.print("Digite a descrição da tarefa: ");
                String descricao = scanner.nextLine();

                tarefaServico.criarTarefa(titulo, descricao);

                System.out.println("Tarefa adicionada com sucesso!");
            } else if (opcao == 2) {
                ArrayList<Tarefa> listaDeTarefas = tarefaServico.listarTarefas();
                if (listaDeTarefas.isEmpty()) {
                    System.out.println("Nenhuma tarefa cadastrada.");
                } else {
                    System.out.println("---- Lista de Tarefas ----");
                    DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

                    for (Tarefa tarefa : listaDeTarefas) {
                        String status = tarefa.isCompleta() ? "[Concluída]" : "[Pendente]";
                        String dataFormatada = tarefa.getDataAgora().format(formatador);

                        System.out.println("ID: " + tarefa.getId() + " | Título: " + tarefa.getTitulo() + " | Status: " + status);
                        System.out.println("   Descrição: " + tarefa.getDescricao());
                        System.out.println("   Criada em: " + dataFormatada);
                        System.out.println("--------------------------");
                    }
                }
            } else if (opcao == 3) {
                System.out.print("Digite o ID da tarefa para marcar como concluída: ");
                int idParaMarcar = scanner.nextInt();
                tarefaServico.marcarTarefaComoConcluida(idParaMarcar);
                System.out.println("Tarefa marcada como concluída!");
            } else if (opcao == 4) {
                System.out.print("Digite o ID da tarefa para remover: ");
                int idParaRemover = scanner.nextInt();
                tarefaServico.removerTarefa(idParaRemover);
                System.out.println("Tarefa removida com sucesso!");
            } else {
                System.out.println("Opção inválida! Tente novamente.");
            }
        }
        scanner.close();
    }
}