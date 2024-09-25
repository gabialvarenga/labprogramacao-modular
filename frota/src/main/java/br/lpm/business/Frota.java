package br.lpm.business;

import java.time.LocalDate;
import java.util.Arrays;

public class Frota {

    private static final int MAX_VEICULOS = 1000;
    private static final int MAX_ROTAS = 10000;
    private static final int MAX_OFICINAS = 100;
    private static final int MAX_MECANICOS = Oficina.getMaxMecanicos();
    private static final int MAX_MOTORISTAS = 200;
    private Veiculo[] veiculos = new Veiculo[Frota.MAX_VEICULOS];
    private Rota[] rotas = new Rota[Frota.MAX_ROTAS];
    private Oficina[] oficinas = new Oficina[Frota.MAX_OFICINAS];
    private Mecanico[] mecanicos = new Mecanico[Oficina.getMaxMecanicos()];
    private Motorista[] motoristas = new Motorista[Frota.MAX_MOTORISTAS];
    private int numVeiculos = 0;
    private int numRotas = 0;
    private int numOficinas = 0;
    private int numMecanicos = 0;
    private int numMotoristas = 0;

    public int getNumVeiculos() {
        return numVeiculos;
    }

    public int getNumRotas() {
        return numRotas;
    }

    public Veiculo[] getAllVeiculos() {
        return veiculos;
    }

    public void addVeiculo(Veiculo veiculo) {
        if (numVeiculos < Frota.MAX_VEICULOS) {
            veiculos[numVeiculos++] = veiculo;
        }
    }

    public Veiculo getVeiculoByPlaca(String placa) {
        for (int i = 0; i < numVeiculos; i++) {
            if (veiculos[i].getPlaca().equalsIgnoreCase(placa)) {
                return veiculos[i];
            }
        }
        return null;
    }

    public void removeVeiculoByPlaca(String placa) {
        for (int i = 0; i < numVeiculos; i++) {
            if (veiculos[i].getPlaca().equalsIgnoreCase(placa)) {
                for (int j = i + 1; j < numVeiculos; j++) {
                    veiculos[j - 1] = veiculos[j];
                }
                this.veiculos[numVeiculos--] = null;
                return;
            }
        }
    }

    public void replaceVeiculo(Veiculo oldVeiculo, Veiculo newVeiculo) {
        for (int i = 0; i < numVeiculos; i++) {
            if (veiculos[i].getPlaca().equalsIgnoreCase(oldVeiculo.getPlaca())) {
                veiculos[i] = newVeiculo;
                return;
            }
        }
    }

    public void newRota(Motorista motorista, Veiculo veiculo, String origem, String destino) {
        var today = LocalDate.now();
        if (veiculo.getEstado() == Estado.TRANSITO) {
            for (int i = 0; i < numRotas; i++) {
                if (rotas[i].getVeiculo().equals(veiculo) && rotas[i].getData().equals(today)) {
                    return;
                }
            }
            rotas[numRotas++] = new Rota(veiculo, motorista, origem, destino, today);
        }
    }

    public Oficina[] getAllOficinas() {
        return oficinas;
    }

    public void addOficina(Oficina oficina) { 
        if (numOficinas < MAX_OFICINAS) {
            oficinas[numOficinas++] = oficina;
        }
    }

    public Oficina getOficinaByNome(String nome) {
        for (int i = 0; i < numOficinas; i++) {
            if (oficinas[i].getNome().equalsIgnoreCase(nome)) {
                return oficinas[i];
            }
        }
        return null;
    }

    public void addMecanico(Mecanico mecanico) { // UML
        if (numMecanicos < MAX_MECANICOS) {
            mecanicos[numMecanicos++] = mecanico;
        }
    }

    public Mecanico[] getAllMecanicos() {
        Mecanico[] result = new Mecanico[numMecanicos];
        for (int i = 0; i < numMecanicos; i++) {
            result[i] = mecanicos[i];
        }
        return result;
    }
    
    public void addMotorista(Motorista motorista) {
        if (numMotoristas < MAX_MOTORISTAS) {
            motoristas[numMotoristas++] = motorista;
        }
    }

    public Motorista[] getAllMotoristas() {
        Motorista[] result = new Motorista[numMotoristas];
        for (int i = 0; i < numMotoristas; i++) {
            result[i] = motoristas[i];
        }
        return result;
    }
    

    public Motorista getMotoristaById(int id) {
        for (int i = 0; i < numMotoristas; i++) {
            if (motoristas[i].getId() == id) {
                return motoristas[i];
            }
        }
        return null;
    }


    public Rota[] getAllRotas() {
        Rota[] result = new Rota[numRotas];
        for (int i = 0; i < numRotas; i++) {
            result[i] = rotas[i];
        }
        return result;
    }


    @Override
    public String toString() {
        return "Frota [veiculos=" + Arrays.toString(veiculos) + ", rotas=" + Arrays.toString(rotas) + ", oficinas="
                + Arrays.toString(oficinas) + ", mecanicos=" + Arrays.toString(mecanicos) + ", motoristas="
                + Arrays.toString(motoristas) + "]";
    }

}