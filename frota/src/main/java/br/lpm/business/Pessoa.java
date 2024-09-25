package br.lpm.business;

public class Pessoa {
    private String nome;
    private int id;
    private int cont;

    public Pessoa(String nome, int id) {
        this.nome = nome;
        this.id = id;
        this.cont = 0; 
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public int getCont() {
        return cont;
    }

    public void incrementarCont() {
        this.cont++;
    }

    @Override
    public String toString() {
        return "Pessoa [nome=" + nome + ", id=" + id + ", cont=" + cont + "]";
    }

    
}