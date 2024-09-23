package br.lpm.main;

import java.time.LocalDate;

import br.lpm.business.Motorista;
import br.lpm.business.Oficina;
import br.lpm.business.Rota;
import br.lpm.business.Veiculo;

public class Main {

    public static void main(String[] args) {
        Oficina oficina1 = new Oficina("Oficina Central", "Rua A, 123", 5);

        Motorista motorista1 = new Motorista("João Silva", 1001);
        Motorista motorista2 = new Motorista("Maria Souza", 1002);

        Veiculo veiculo1 = new Veiculo("Caminhão", 2020, "ABC-1234", 50000);
        Veiculo veiculo2 = new Veiculo("Van", 2019, "XYZ-5678", 80000);

        Rota rota1 = new Rota("São Paulo", "Rio de Janeiro", LocalDate.of(2024, 9, 15));

   
        motorista1.atribuirVeiculo(veiculo1);
        motorista2.atribuirVeiculo(veiculo2);

        veiculo1.iniciarManutencao(oficina1);
        oficina1.adicionarVeiculo(veiculo1, LocalDate.of(2024, 9, 30));

        veiculo2.iniciarTransito(rota1);

        System.out.println("Motorista 1: " + motorista1.getNome() + " está dirigindo o veículo: " + motorista1.getVeiculoAtual().getModelo());
        System.out.println("Motorista 2: " + motorista2.getNome() + " está dirigindo o veículo: " + motorista2.getVeiculoAtual().getModelo());

        System.out.println("Veículo 1 em manutenção na oficina: " + veiculo1.getOficinaAtual().getNome());
        System.out.println("Veículo 2 em trânsito na rota: " + veiculo2.getRotaAtual().getOrigem() + " para " + veiculo2.getRotaAtual().getDestino());
     
        oficina1.listarVeiculosEmManutencao();
    }
   
}
