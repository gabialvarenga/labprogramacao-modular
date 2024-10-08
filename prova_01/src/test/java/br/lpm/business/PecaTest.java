package br.lpm.business;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PecaTest {
    private Peca peca1;
    private Peca peca2;
    @BeforeEach
    public void setUp(){
        peca1 = new Peca(Marca.FIAT, "motor", false);
        peca2 = new Peca(Marca.FIAT, "motor", true);
    }

    @Test
    void testGarantia() {
        assertEquals(30, peca1.Garantia(),"Testando o metodo garantia");
    }

    @Test
    void testGarantiaInvalida() {
        assertEquals(365, peca2.Garantia(),"Testando o metodo garantia inválida");
    }
}
