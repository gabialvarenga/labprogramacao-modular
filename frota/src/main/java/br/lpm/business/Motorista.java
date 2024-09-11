package br.lpm.business;

public class Motorista {
    private String nome;
    private int id;
    private Veiculo veiculoAtual;

    public Motorista(String nome, int id) {
        this.nome = nome;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public int getId() {
        return id;
    }

    public void setVeiculoAtual(Veiculo veiculoAtual) {
        this.veiculoAtual = veiculoAtual;
    }

    public Veiculo getVeiculoAtual() {
        return veiculoAtual;
    }

    public void atribuirVeiculo(Veiculo veiculo) {
        this.veiculoAtual = veiculo;
    }

    public void removerVeiculo() {
        this.veiculoAtual = null;
    }
    
}
