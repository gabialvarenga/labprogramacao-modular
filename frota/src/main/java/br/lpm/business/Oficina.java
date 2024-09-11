package br.lpm.business;
import java.time.LocalDate;

public class Oficina {
    private String nome;
    private String endereco;
    private Veiculo[] veiculosEmManutencao;
    private LocalDate[] datasPrevistasTermino;
    private int capacidadeAtual = 0;
    private int capacidadeMaxima;

    public Oficina(String nome, String endereco, int capacidadeMaxima) {
        this.nome = nome;
        this.endereco = endereco;
        this.capacidadeMaxima = capacidadeMaxima;
        this.veiculosEmManutencao = new Veiculo[capacidadeMaxima];
        this.datasPrevistasTermino = new LocalDate[capacidadeMaxima];
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getEndereco() {
        return endereco;
    }


    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }


    public void adicionarVeiculo(Veiculo veiculo, LocalDate dataPrevistaTermino) {
        if (capacidadeAtual < capacidadeMaxima) {
            veiculosEmManutencao[capacidadeAtual] = veiculo;
            datasPrevistasTermino[capacidadeAtual] = dataPrevistaTermino;
            capacidadeAtual++;
        } else {
            System.out.println("Oficina cheia! Não é possível adicionar mais veículos.");
        }
    }

    public void removerVeiculo(Veiculo veiculo) {
        boolean encontrado = false;
        for (int i = 0; i < capacidadeAtual; i++) {
            if (veiculosEmManutencao[i].equals(veiculo)) {
                encontrado = true;
                
                for (int j = i; j < capacidadeAtual - 1; j++) {
                    veiculosEmManutencao[j] = veiculosEmManutencao[j + 1];
                    datasPrevistasTermino[j] = datasPrevistasTermino[j + 1];
                }
                capacidadeAtual--;
                veiculosEmManutencao[capacidadeAtual] = null;
                datasPrevistasTermino[capacidadeAtual] = null;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Veículo não encontrado na oficina.");
        }
    }

    // Exemplo de um método para listar veículos em manutenção
    public void listarVeiculosEmManutencao() {
        for (int i = 0; i < capacidadeAtual; i++) {
            System.out.println("Veículo: " + veiculosEmManutencao[i].getModelo() +
                               ", Data prevista de término: " + datasPrevistasTermino[i]);
        }
    }
}
