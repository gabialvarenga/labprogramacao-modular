package br.lpm.business;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AutomovelTest {
    private Automovel automovel;

    @BeforeEach
    public void setUp(){
        automovel = new Automovel("BMW", Cor.AZUL, 2024);
    }

    @Test
    void testGetAno() {
        automovel.setAno(1885);
        assertEquals(2024, automovel.getAno(), "Testando data anterior a 1886");
        automovel.setAno(1886);
        assertEquals(1886, automovel.getAno(), "Testando a data limite 1886");
    }
}
