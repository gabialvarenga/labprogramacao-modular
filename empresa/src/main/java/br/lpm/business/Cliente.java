package br.lpm.business;

public class Cliente {
    private Pessoa dados;
    private float credito;

    public Cliente(Pessoa dados, float credito) {
        super();
        this.dados = dados;
        this.credito = credito;
    }

    public Pessoa getDados() {
        return dados;
    }

    public void setDados(Pessoa dados) {
        this.dados = dados;
    }

    public float getCredito() {
        return credito;
    }

    public void setCredito(float credito) {
        if (credito >= 0) {
            this.credito = credito;
        }
    }

    /*
     * dados.toString() é usado quando a classe não herda diretamente de Pessoa,
     * mas contém uma composição de uma instância de Pessoa
     */
    @Override
    public String toString() {
        return "Cliente [" + dados.toString() + ", credito=" + credito + "]";
    }

}
