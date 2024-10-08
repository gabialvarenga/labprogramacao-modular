package br.lpm.business;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NotaFiscalTest {
    private NotaFiscal notaFiscal;
    private Automovel automovel;
    private Peca peca;
    private Servico servico;


    @BeforeEach
    public void setUp(){
        notaFiscal = new NotaFiscal("Carlos");
        automovel = new Automovel("BMW", Cor.AZUL, 2024);
        peca = new Peca(Marca.FIAT, "motor", false);
        servico = new Servico("Consertar carro", 2);
    }

    @Test
    public void TestAddAutomovel(){
    notaFiscal.addAutomovel(automovel);
    assertEquals(1, notaFiscal.getNumAutomoveis(), "Testando adicionar veículo");
    }




    @Test
    public void TestAddPeca(){
        notaFiscal.addPeca(peca);
        assertEquals(1, notaFiscal.getNumPecas(), "Testando adicionar peças");
    }


    @Test
    public void TestAddServico(){
        notaFiscal.addServico(servico);
        assertEquals(1, notaFiscal.getNumServicos(), "Testando adicionar serviços");
    }


    @Test
    public void TestCalcularTotal(){
        notaFiscal.addAutomovel(automovel);
        notaFiscal.addPeca(peca);
        notaFiscal.addServico(servico);
        assertEquals(1450, notaFiscal.calcularTotal(), "Testando o valor total");
    }


   
}
