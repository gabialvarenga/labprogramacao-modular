package br.lpm.business;

public class Funcionario {
    private PF dados;
    private String cargo;
    private float salario;

    public Funcionario(PF dados, String cargo, float salario) {
        this.dados = dados;
        this.cargo = cargo;
        this.setSalario(salario);
    }

    public void setDados(PF dados) {
        this.dados = dados;
    }

    public PF getDados() {
        return dados;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        if (salario >= 0) {
            this.salario = salario;
        }
    }

    @Override
    public String toString() {
        return "Funcionario [" + dados.toString() + ", cargo=" + cargo + ", salário=" + salario + "]";
    }

}
