package br.lpm.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FrotaTest {

    private static Frota frota;
    private static Veiculo veiculo;
    private static String placa;
    private static Oficina oficina;
    private static Mecanico mecanico;
    private static Motorista motorista;



    @BeforeEach
    public void setUp() {
        placa = "A32J4B";
        frota = new Frota();
        veiculo = new Veiculo("Shulambs", 2024, placa, 19999);
        oficina = new Oficina("Oficina 1", "Rua B");
        mecanico = new Mecanico("Mecânico 1", 1, oficina);
        motorista = new Motorista("José Shulambs da Silva", 1);

    }

    @Test
    void testAddVeiculo() {
        int numVeiculos = frota.getNumVeiculos();
        frota.addVeiculo(veiculo);
        assertEquals(numVeiculos + 1, frota.getNumVeiculos(), "Adicionando novo veículo na Frota.");
    }

    @Test
    void testGetVeiculoByPlaca() {
        frota.addVeiculo(veiculo);
        assertEquals(veiculo, frota.getVeiculoByPlaca("A32J4B"), "Recupera veículo adicionado.");
        assertNull(frota.getVeiculoByPlaca("XXXXXX"), "Recupera veículo inexistente.");
    }

    @Test
    void testGetAllVeiculos() {
        frota.addVeiculo(veiculo);
        Veiculo[] veiculos = frota.getAllVeiculos();
        assertEquals(veiculo, veiculos[0], "Verificando veículos na Frota.");
    }

    @Test
    void testNewRota() {
        int numRotas = frota.getNumRotas();
        frota.newRota(motorista, veiculo, "Belo Horizonte", "Nova Lima");
        assertEquals(numRotas + 1, frota.getNumRotas(), "Adicionando nova rota para veículo.");
    }

    @Test
    void testRemoveVeiculoByPlaca() {
        int numVeiculos = frota.getNumVeiculos();
        frota.addVeiculo(veiculo);
        frota.removeVeiculoByPlaca("XXXXXX");
        assertEquals(numVeiculos + 1, frota.getNumVeiculos(), "Removendo veículo inexistente da Frota.");
        frota.removeVeiculoByPlaca(placa);
        assertEquals(numVeiculos, frota.getNumVeiculos(), "Removendo veículo da Frota.");
    }

    @Test
    void testReplaceVeiculo() {
        frota.addVeiculo(veiculo);
        Veiculo newVeiculo = new Veiculo("Novo Shulambs", 2025, placa, 19999);
        frota.replaceVeiculo(veiculo, newVeiculo);

        assertEquals(newVeiculo, frota.getVeiculoByPlaca(placa), "Substituindo veículo na Frota.");
    }

    @Test
    void testAddOficina() {
        frota.addOficina(oficina);
        assertEquals(1, frota.getAllOficinas().length, "Adicionando nova oficina.");
    }

    @Test
    void testGetOficinaByNome() {
 
        frota.addOficina(oficina);
        assertEquals(oficina, frota.getOficinaByNome("Oficina 1"), "Recupera oficina adicionada.");
        assertNull(frota.getOficinaByNome("Oficina Inexistente"), "Recupera oficina inexistente.");
    }

    @Test
    void testAddMecanico() {
        frota.addMecanico(mecanico);
        assertEquals(1, frota.getAllMecanicos().length, "Adicionando novo mecânico.");
    }

    @Test
    void testAddMotorista() {
        Motorista motorista = new Motorista("Motorista 1", 1);
        frota.addMotorista(motorista);
        assertEquals(1, frota.getAllMotoristas().length, "Adicionando novo motorista.");
    }

    @Test
    void testGetMotoristaById() {
        Motorista motorista = new Motorista("Motorista 1", 1);
        frota.addMotorista(motorista);
        assertEquals(motorista, frota.getMotoristaById(1), "Recupera motorista pelo ID.");
        assertNull(frota.getMotoristaById(2), "Recupera motorista inexistente pelo ID.");
    }

}
