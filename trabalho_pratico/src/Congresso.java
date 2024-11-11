import java.util.ArrayList;
import java.util.List;

public class Congresso {
    private String setor;
    private double valorContratado;
    private String especificacoes;
    private List<Atividade> atividades = new ArrayList<>();
    private List<Fornecedor> fornecedores = new ArrayList<>();

    public Congresso(String setor, double valorContratado, String especificacoes) {
        this.setor = setor;
        this.valorContratado = valorContratado;
        this.especificacoes = especificacoes;
    }

    public void addAtividade(Atividade atividade) {
        atividades.add(atividade);
    }

    public void addFornecedor(Fornecedor fornecedor) {
        fornecedores.add(fornecedor);
    }

    public List<Atividade> filtrarAtividadesPorData(String data) {
        List<Atividade> filtradas = new ArrayList<>();
        for (Atividade a : atividades) {
            if (a.getData().equalsIgnoreCase(data)) {
                filtradas.add(a);
            }
        }

        return filtradas;
    }

    public String getSetor() {
        return setor;
    }

    public double getValorContratado() {
        return valorContratado;
    }

    public String getEspecificacoes() {
        return especificacoes;
    }

}
