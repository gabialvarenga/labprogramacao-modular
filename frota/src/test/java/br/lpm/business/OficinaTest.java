package br.lpm.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OficinaTest {

    private Oficina oficina;

    @BeforeEach
    public void setUp() {
        oficina = new Oficina("Shulambs", "Rua Shulambs, 0");
    }

    @Test
    void testAddVeiculoToManutencao() {
        Veiculo veiculo = new Veiculo("Shulambs", 2024, "A32J4B", 19999);
        int numManutencoes = oficina.getNumManutencoes();
        oficina.addVeiculoToManutencao(veiculo);
        int expectedNumManutencoes = numManutencoes + 1;
        assertEquals(expectedNumManutencoes, oficina.getNumManutencoes(), "Adicionando novo veículo em manutenção.");
        assertEquals(Estado.MANUTENCAO, veiculo.getEstado(), "Estado do veículo deve estar em MANUTENÇÃO.");
        oficina.addVeiculoToManutencao(veiculo);
        assertEquals(expectedNumManutencoes, oficina.getNumManutencoes(), "Veiculo já está em manutenção.");
    }

    @Test
    void testGetLastManutencaoFromVeiculo() {
        Veiculo veiculo = new Veiculo("Shulambs", 2024, "A32J4B", 19999);
        assertNull(oficina.getLastManutencaoFromVeiculo(veiculo), "Veículo ainda não possui manutenção.");
        oficina.addVeiculoToManutencao(veiculo);
        assertEquals(veiculo, oficina.getLastManutencaoFromVeiculo(veiculo).getVeiculo(),
                "Última manutenção do veículo.");
    }

    @Test
    void testRemoveVeiculoFromManutencao() {
        Veiculo veiculo = new Veiculo("Shulambs", 2024, "A32J4B", 19999);
        oficina.addVeiculoToManutencao(veiculo);
        assertEquals(1, oficina.getNumManutencoes(), "Antes de remover, deve haver 1 manutenção.");
        oficina.removeVeiculoFromManutencao(veiculo);
        assertEquals(0, oficina.getNumManutencoes(), "Após remover, não deve haver manutenção.");
        assertEquals(Estado.TRANSITO, veiculo.getEstado(), "Estado do veículo deve estar em TRÂNSITO após remoção.");
    }

    @Test
    void testRemoveVeiculoNotInManutencao() {
        Veiculo veiculo = new Veiculo("Shulambs", 2024, "A32J4B", 19999);
        Veiculo veiculoInexistente = new Veiculo("Outro Veículo", 2024, "B32J4C", 19999);
        oficina.addVeiculoToManutencao(veiculo);
        assertEquals(1, oficina.getNumManutencoes(), "Deve haver 1 manutenção antes da tentativa de remoção.");
        oficina.removeVeiculoFromManutencao(veiculoInexistente);
        assertEquals(1, oficina.getNumManutencoes(), "Após tentativa de remover veículo inexistente, deve haver 1 manutenção.");
    }
}
