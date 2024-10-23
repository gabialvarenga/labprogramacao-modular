package br.lpm.business;

public class Servico {
    private String descricao;
    private int horasTrabalhadas;

    public Servico(String descricao, int horasTrabalhadas) {
        this.setDescricao(descricao);
        this.setHorasTrabalhadas(horasTrabalhadas);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(int horasTrabalhadas) {
        if (horasTrabalhadas >=1){
              this.horasTrabalhadas = horasTrabalhadas;
    }

}

    @Override
    public String toString() {
        return "descricao:" + descricao + ", Horas trabalhadas:" + horasTrabalhadas ;
    }



}