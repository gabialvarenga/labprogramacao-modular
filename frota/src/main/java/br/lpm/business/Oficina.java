package br.lpm.business;

import java.time.LocalDate;
import java.util.Arrays;


public class Oficina {
    private String nome;
    private String endereco;
    private static final int MAX_VEICULOS = 1000;
    private static final int MAX_MECANICOS = 500; 
    private Manutencao[] manutencoes = new Manutencao[Oficina.MAX_VEICULOS];
    private Mecanico[] mecanicos = new Mecanico[Oficina.MAX_MECANICOS]; 
    private int numManutencoes = 0;
    private int numMecanicos = 0;


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

    public int getNumManutencoes() {
        return numManutencoes;
    }

    public Manutencao[] getAllManutencoes() {
        return manutencoes;
    }

    public Manutencao getLastManutencaoFromVeiculo(Veiculo veiculo) {
        if (numManutencoes == 0) {
            return null;
        } else {
            for (int i = numManutencoes - 1; i >= 0; i++) {
                if (manutencoes[i].getVeiculo().equals(veiculo)) {
                    return manutencoes[i];
                }
            }
            return null;
        }
    }

    public void addVeiculoToManutencao(Veiculo veiculo) {
        if (numManutencoes < Oficina.MAX_VEICULOS) {
            if (veiculo.getEstado().equals(Estado.MANUTENCAO)) {
                return;
            } else {
                veiculo.setEstado(Estado.MANUTENCAO);
                Manutencao manutencao = new Manutencao(veiculo, LocalDate.now().plusDays(7));
                manutencoes[numManutencoes++] = manutencao;
            }
        }
    }

    public void removeVeiculoFromManutencao(Veiculo veiculo) {
        for (int i = 0; i < numManutencoes; i++) {
            if (manutencoes[i].getVeiculo().equals(veiculo)) {
                veiculo.setEstado(Estado.TRANSITO);
                for (int j = i + 1; j < numManutencoes; j++) {
                    manutencoes[j - 1] = manutencoes[j];
                }
                manutencoes[numManutencoes--] = null;
                return;
            }
        }
    }

    public Oficina(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    public void addMecanico(Mecanico mecanico) { 
        if(numMecanicos < Oficina.MAX_MECANICOS){ 
            mecanicos[numMecanicos++] = mecanico;
        }
    }
    

    public Mecanico[] getMecanicos() {
        Mecanico[] mecanicosAtuais = new Mecanico[numMecanicos];
        for (int i = 0; i < numMecanicos; i++) {
            mecanicosAtuais[i] = mecanicos[i];
        }
        return mecanicosAtuais; 
    }

    public static int getMaxMecanicos() {
        return MAX_MECANICOS;
    }

    @Override
    public String toString() {
        return "Oficina [nome=" + nome + ", endereco=" + endereco + ", manutencoes=" + Arrays.toString(manutencoes)
                + ", mecanicos=" + Arrays.toString(mecanicos) + ", numManutencoes=" + numManutencoes + ", numMecanicos="
                + numMecanicos + "]";
    }
    
    

}
