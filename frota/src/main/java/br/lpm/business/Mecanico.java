package br.lpm.business;

public class Mecanico extends Pessoa {
    private Oficina oficina;

    public Mecanico(String nome, int id, Oficina oficina) {
        super(nome, id);
        this.oficina = oficina;
    }

    public Oficina getOficina() {
        return oficina;
    }

    @Override
    public String toString() {
        return "Mecanico [" + super.toString() + "oficina=" + oficina + "]";
    }

    
}
