public class Fornecedor extends Pessoa {

    private String tipoServico;

    public Fornecedor(String nome, String tipoServico) {
        super(nome);
        this.tipoServico = tipoServico;
    }

    public String getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }

}
