package br.lpm.business;

public class PJ extends Pessoa {
    private String cnpj;

    public PJ(String nome, String endereco, String telefone, String cep, String cidade, String uf, String cnpj) {
        super(nome, endereco, telefone, cep, cidade, uf);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    //Essa classes herda diretamente de Pessoa, então usamos super.toString()
    @Override
    public String toString() {
        return super.toString() + " PJ [cnpj=" + cnpj + "]";
    }
      
    
}
