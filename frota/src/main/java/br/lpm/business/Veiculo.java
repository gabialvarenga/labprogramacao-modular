package br.lpm.business;

public class Veiculo {
    private String modelo;
    private int ano;
    private int placa;
    private int km;
    private Motorista motoristaAtual;
    private Oficina oficinaAtual;
    private Rota rotaAtual;

    public Veiculo(String modelo, int ano, int placa, int km) {
        this.modelo = modelo;
        this.ano = ano;
        this.placa = placa;
        this.km = km;
    }
    
    public Motorista getMotoristaAtual() {
        return motoristaAtual;
    }

    public void setMotoristaAtual(Motorista motoristaAtual) {
        this.motoristaAtual = motoristaAtual;
    }

    public Oficina getOficinaAtual() {
        return oficinaAtual;
    }

    public void setOficinaAtual(Oficina oficinaAtual) {
        this.oficinaAtual = oficinaAtual;
    }

    public Rota getRotaAtual() {
        return rotaAtual;
    }

    public void setRotaAtual(Rota rotaAtual) {
        this.rotaAtual = rotaAtual;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public int getPlaca() {
        return placa;
    }

    public int getkm() {
        return km;
    }

    public void dirigir(double km) {
        this.km += km;
    }

    public void iniciarManutencao(Oficina oficina) {
        this.oficinaAtual = oficina;
    }

    public void iniciarTransito(Rota rota) {
        this.rotaAtual = rota;
    }

}