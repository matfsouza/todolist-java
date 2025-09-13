import java.util.ArrayList;

public class TarefaServico {

    private ArrayList<Tarefa> listaDeTarefas = new ArrayList<>();
    private int proximoId = 1;


    public void criarTarefa(String titulo, String descricao){
        Tarefa novaTarefa = new Tarefa(proximoId, titulo, descricao);
        listaDeTarefas.add(novaTarefa);
        proximoId++;
    }


    public ArrayList<Tarefa> listarTarefas() {
        return listaDeTarefas;
    }


    public void marcarTarefaComoConcluida(int id) {
        for (Tarefa tarefa : listaDeTarefas) {
            if (tarefa.getId() == id) {
                tarefa.setCompleta(true);
                break;
            }
        }
    }


    public void removerTarefa(int id) {
        Tarefa tarefaParaRemover = null;
        for (Tarefa tarefa : listaDeTarefas) {
            if (tarefa.getId() == id) {
                tarefaParaRemover = tarefa;
                break;
            }
        }

        if (tarefaParaRemover != null) {
            listaDeTarefas.remove(tarefaParaRemover);
        }
    }
}
