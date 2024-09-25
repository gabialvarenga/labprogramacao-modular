package br.lpm.main;


import java.util.Scanner;

import br.lpm.business.Frota;
import br.lpm.business.Mecanico;
import br.lpm.business.Motorista;
import br.lpm.business.Oficina;

import br.lpm.business.Veiculo;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    private static Frota frota = new Frota();

    public static void main(String[] args) {
        System.out.println("Bem-vindo ao sistema de cadastro de frota!");
        System.out.println("Quantos cadastros deseja fazer?");
        int numCadastros = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < numCadastros; i++) {
            Oficina oficina = cadastrarOficina();
            cadastrarMecanico(oficina);
            cadastrarMotorista();
            cadastrarVeiculo();
        }

        System.out.println(frota);
    }

    private static void cadastrarVeiculo() {
        System.out.print("Digite o modelo do veículo: ");
        String modelo = sc.next();
        System.out.print("Digite o ano do veículo: ");
        int ano = sc.nextInt();
        System.out.print("Digite a placa do veículo: ");
        String placa = sc.next();
        System.out.print("Digite a quilometragem do veículo: ");
        int km = sc.nextInt();

        Veiculo veiculo = new Veiculo(modelo, ano, placa, km);
        frota.addVeiculo(veiculo);
        System.out.println("Veículo cadastrado com sucesso!");
    }

    private static void cadastrarMotorista() {
        System.out.print("Digite o nome do motorista: ");
        String nome = sc.next();
        System.out.print("Digite o ID do motorista: ");
        int id = sc.nextInt();

        Motorista motorista = new Motorista(nome, id);
        frota.addMotorista(motorista);
        System.out.println("Motorista cadastrado com sucesso!");
    }

    private static void cadastrarMecanico(Oficina oficina) {
        System.out.print("Digite o nome do mecânico: ");
        String nome = sc.next();
        System.out.print("Digite o ID do mecânico: ");
        int id = sc.nextInt();

        Mecanico mecanico = new Mecanico(nome, id, oficina);
        oficina.addMecanico(mecanico);
        System.out.println("Mecânico cadastrado com sucesso!");
    }

    private static Oficina cadastrarOficina() {
        System.out.println("Digite o nome da oficina: ");
        String nome = sc.nextLine();
        System.out.println("Digite o endereço da oficina: ");
        String endereco = sc.nextLine();
        Oficina oficina = new Oficina(nome, endereco);
        frota.addOficina(oficina);
        System.out.println("Oficina cadastrada com sucesso!");
        System.out.println();
        return oficina;
    }

   
}
