package br.lpm.business;

public class Motorista extends Pessoa {
    public Motorista(String nome, int id) {
        super(nome, id);
    }

    @Override
    public String toString() {
        return "Motorista [" + super.toString() + "]";
    }
    
}

