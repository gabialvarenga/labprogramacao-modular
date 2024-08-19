package test;

import bussines.Pessoa;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;

public class PessoaTest {

    @Test
 
    public void testGetNome(){
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Carlos");
        assertEquals("Carlos", pessoa.getNome());
    }
}