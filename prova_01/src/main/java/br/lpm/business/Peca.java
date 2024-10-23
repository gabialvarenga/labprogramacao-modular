package br.lpm.business;

public class Peca {
    private Marca marca;
    private String descricao;
    private boolean isNova;
    
    public Peca(Marca marca, String descricao, boolean isNova) {
        this.setMarca(marca);
        this.setDescricao(descricao);
        this.setNova(isNova);
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int Garantia(){
        if(isNova){ //se for true vai retornar que a garantia é de 365 dias
            return 365;
        } else {
            return 30;
        }
    }

    public boolean isNova() {
        return isNova; // true
    }

    public void setNova(boolean isNova) {
        this.isNova = isNova;
    }

    @Override
    public String toString() {
        return "marca:" + marca + ", descricao:" + descricao + ", isNova:" + isNova ;
    }

    

    
}
