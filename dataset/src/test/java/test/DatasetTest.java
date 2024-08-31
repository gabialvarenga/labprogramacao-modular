package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.lpm.business.Dataset;
import br.lpm.business.Pessoa;

public class DatasetTest {

    private static Dataset dataset;
    private static Pessoa pessoa1;
    private static Pessoa pessoa2;
    private static Pessoa pessoa3;

    @BeforeEach
    public void setUp() throws Exception {
        dataset = new Dataset();
        pessoa1 = new Pessoa();
        pessoa2 = new Pessoa();
        pessoa3 = new Pessoa();

    }

    @Test
    public void testAddPessoa() {
        dataset.addPessoa(pessoa1);
        assertEquals(1, dataset.size(), "Pessoa adicionada");

        dataset.addPessoa(pessoa2);
        assertEquals(2, dataset.size(), "Pessoa adicionada");

        dataset.addPessoa(null);
        assertEquals(2, dataset.size(), "Pessoa nula não foi adicionada");

        dataset.addPessoa(pessoa2);
        assertEquals(2, dataset.size(), "Pessoa duplicada não foi adicionada");

        dataset.removeAll();
        assertEquals(0, dataset.size(), "Dataset foi esvaziado");

        dataset.addPessoa(null);
        assertEquals(0, dataset.size(), "Pessoa nula não foi adicionada");
    }

    @Test
    public void testRemovePessoa() {
        dataset.addPessoa(pessoa1);
        dataset.addPessoa(pessoa3);
    
        dataset.removePessoa(pessoa1);
        assertEquals(1, dataset.size(), "Pessoa removida");
    
        dataset.removePessoa(pessoa2);
        assertEquals(1, dataset.size(), "Pessoa removida");
    
        dataset.removePessoa(pessoa3);
        assertEquals(0, dataset.size(), "Tamanho é 0 porque todos foram removidos");
    }

    
}
