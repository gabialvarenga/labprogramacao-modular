package br.lpm.business;

public class PF extends Pessoa {
    private String cpf;

    public PF(String nome, String endereco, String telefone, String cep, String cidade, String uf, String cpf) {
        super(nome, endereco, telefone, cep, cidade, uf);
        this.cpf = cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    // Essa classes herda diretamente de Pessoa, então usamos super.toString()
    @Override
    public String toString() {
        return super.toString() + " PF [cpf=" + cpf + "]";
    }

}
