package br.lpm.business;

public class Automovel {
    private String modelo;
    private Cor cor;
    private int ano;

    public Automovel(String modelo, Cor cor, int ano) {
        this.setModelo(modelo);
        this.setCor(cor);
        this.setAno(ano);
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        if (ano >= 1886) {
            this.ano = ano;
        }
    }

    @Override
    public String toString() {
        return "modelo:" + modelo + ", cor:" + cor + ", ano:" + ano;
    }

}
