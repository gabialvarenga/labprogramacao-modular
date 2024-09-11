package br.lpm.business;
import java.time.LocalDate;

public class Rota {
    private String origem;
    private String destino;
    private LocalDate dataTransporte;

    public Rota(String origem, String destino, LocalDate dataTransporte) {
        this.origem = origem;
        this.destino = destino;
        this.dataTransporte = dataTransporte;
    }

    public String getOrigem() {
        return origem;
    }
    public void setOrigem(String origem) {
        this.origem = origem;
    }
    public String getDestino() {
        return destino;
    }
    public void setDestino(String destino) {
        this.destino = destino;
    }
    public LocalDate getDataTransporte() {
        return dataTransporte;
    }
    public void setDataTransporte(LocalDate dataTransporte) {
        this.dataTransporte = dataTransporte;
    }

    
}
