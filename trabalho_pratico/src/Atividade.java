import java.util.ArrayList;
import java.util.List;

class Atividade {
    private String tipo;
    private String data;
    private String local;
    private int qtdParticipantes;
    private List<Profissional> profissionais = new ArrayList<>();

    public Atividade(String tipo, String data, String local, int qtdParticipantes, List<Profissional> profissionais) {
        this.tipo = tipo;
        this.data = data;
        this.local = local;
        this.qtdParticipantes = qtdParticipantes;
    }

    public void addProfissional(Profissional profissional) {
        profissionais.add(profissional);
    }

    public List<Profissional> filtrarProfissionaisPorPapel(String papel) {
        List<Profissional> filtrados = new ArrayList<>();
        for (Profissional p : profissionais) {
            if (p.getPapel().equalsIgnoreCase(papel)) {
                filtrados.add(p);
            }
        }
        return filtrados;
    }

    public List<Profissional> ordenarProfissionaisPorAlocacaoTempo(){
        return null;
    }

    public String getTipo() {
        return tipo;
    }

    public String getData() {
        return data;
    }

    public String getLocal() {
        return local;
    }

    public int getQtdParticipantes() {
        return qtdParticipantes;
    }

}