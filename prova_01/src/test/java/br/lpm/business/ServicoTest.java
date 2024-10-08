package br.lpm.business;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ServicoTest {
    private Servico servico;

    @BeforeEach
    public void setUp(){
        servico = new Servico("Consertar carro", 2);
    }

    @Test
    void testGetHorasTrabalhadas() {
        servico.setHorasTrabalhadas(-1);
        assertEquals(2, servico.getHorasTrabalhadas(), "Testando com valor negativo");

        servico.setHorasTrabalhadas(0);
        assertEquals(2, servico.getHorasTrabalhadas(),"Testando com valor 0");
    }
}
