import java.util.ArrayList;
import java.util.List;

public class PacoteServico {
    private String nome;
    private String descricao;
    private List<ItemServico> itens = new ArrayList<>();

    public PacoteServico(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    /*
     * public float calcularCustoTotal(){
     * 
     * }
     */

    /*
     * public List<ItemServico> ordenarItensPorCusto(){
     * 
     * }
     */

    public List<ItemServico> filtrarItensPorTipo(String tipo){
        List<ItemServico> filtrados = new ArrayList<>();
        for(ItemServico i : itens){
            if(i.getTipo().equalsIgnoreCase(tipo)){
                filtrados.add(i);
            }
        }
        return filtrados;
    }
}
