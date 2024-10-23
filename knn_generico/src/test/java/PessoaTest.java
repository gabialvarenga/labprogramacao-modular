import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.lpm.business.Pessoa;

public class PessoaTest {
    public static Pessoa pessoa;

    @BeforeEach
    public void setUp() throws Exception {
        pessoa = new Pessoa();
    }

    @Test
    public void testSetNome() {
        pessoa.setNome("Gabr232!");
        assertEquals(null, pessoa.getNome(), "Atribuição de nome inválido");

        pessoa.setNome("José");
        assertEquals("José", pessoa.getNome(), "Atribuição de nome válido");

    }

    @Test
    public void testSetAltura() {
        pessoa.setAltura(-1);
        assertEquals(0.0, pessoa.getAltura(), 0.1f, "Atribuição de altura inválida");

        pessoa.setAltura(2.61F);
        assertEquals(0.0, pessoa.getAltura(), 0.1f, "Atribuição de altura inválida");

        pessoa.setAltura(1.54F);
        assertEquals(1.54, pessoa.getAltura(), 0.1f, "Atribuição de altura válida");

    }

    @Test
    public void testSetDataNascimento() {
        LocalDate hoje = LocalDate.now();
    
        pessoa.setDataNascimento(hoje);
        assertEquals(null, pessoa.getDataNascimento(), "Atribuição de data inválida (data atual)");
    
        pessoa.setDataNascimento(hoje.plusYears(5));
        assertEquals(null, pessoa.getDataNascimento(), "Atribuição de data inválida (data futura)");
    
        LocalDate dataPassada = hoje.minusYears(5);
        
        pessoa.setDataNascimento(dataPassada);
        assertEquals(dataPassada, pessoa.getDataNascimento(), "Atribuição de data válida");
    }

    @Test
    public void testSetPeso() {
        pessoa.setPeso(-1);
        assertEquals(0.0, pessoa.getPeso(), 0.1f, "Atribuição de peso inválida");

        pessoa.setPeso(601);
        assertEquals(0.0, pessoa.getPeso(), 0.1f, "Atribuição de peso inválida");

        pessoa.setPeso(60);
        assertEquals(60, pessoa.getPeso(), 0.1f, "Atribuição de peso válida");
    }

    @Test
    public void testSetRenda() {
        pessoa.setRenda(-1F);
        assertEquals(0.0, pessoa.getRenda(), 0.1f, "Atribuição de renda inválida");

        pessoa.setRenda(2565.43F);
        assertEquals(2565.43, pessoa.getRenda(), 0.1f, "Atribuição de renda válida");
    }

    @Test
    public void testSetNaturalidade(){
        pessoa.setNaturalidade("Minei@!");
        assertEquals(null, pessoa.getNaturalidade(), "Atribuição de naturalidade inválida");

        pessoa.setNaturalidade("Mineira");
        assertEquals("Mineira", pessoa.getNaturalidade(), "Atribuição de naturalidade válida");
    }

}