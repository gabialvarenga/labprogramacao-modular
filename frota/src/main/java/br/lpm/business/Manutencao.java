package br.lpm.business;

import java.time.LocalDate;

public class Manutencao {
    private LocalDate previsao;

    public Manutencao(LocalDate previsao) {
        this.previsao = previsao;
    }

    public LocalDate getPrevisao() {
        return previsao;
    }

    public void setPrevisao(LocalDate previsao) {
        this.previsao = previsao;
    }

    
}
