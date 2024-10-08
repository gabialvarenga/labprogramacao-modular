import static org.junit.jupiter.api.Assertions.assertEquals;

import br.lpm.business.Dataset;
import br.lpm.business.Escolaridade;
import br.lpm.business.EstadoCivil;
import br.lpm.business.Genero;
import br.lpm.business.Hobby;
import br.lpm.business.Knn;
import br.lpm.business.Moradia;
import br.lpm.business.Pessoa;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class KnnTest {
  public Knn knn;
  private Dataset dataset;
  private Pessoa pessoa1;
  private Pessoa pessoa2;
  private Pessoa pessoa3;

   @BeforeEach
    public void setUp() {
        pessoa1 = new Pessoa(
                "Gabriela",
                LocalDate.of(2006, 1, 15),
                Genero.FEMININO,
                1.53f,
                58,
                6000.54f,
                "Belo Horizonte",
                Hobby.LIVRO,
                EstadoCivil.CASADO,
                Escolaridade.MEDIO,
                true,
                Moradia.CASA_PROPRIA);

        pessoa2 = new Pessoa(
                "Carlos",
                LocalDate.of(2005, 10, 20),
                Genero.MASCULINO,
                1.72f,
                62,
                1000.12f,
                "Almenara",
                Hobby.ESPORTE,
                EstadoCivil.CASADO,
                Escolaridade.MEDIO,
                true,
                Moradia.ALUGUEL);

        pessoa3 = new Pessoa(
                "Leonardo",
                LocalDate.of(1976, 9, 4),
                Genero.MASCULINO,
                1.69f,
                64,
                2000.12f,
                "Licínio de Almeida",
                Hobby.ESPORTE,
                EstadoCivil.SOLTEIRO,
                Escolaridade.POS_GRADUACAO,
                false,
                Moradia.CASA_PROPRIA);

        dataset = new Dataset();
        dataset.addPessoa(pessoa1);
        dataset.addPessoa(pessoa2);
        dataset.addPessoa(pessoa3);

        knn = new Knn(2,dataset);
    }

  
  @Test
  @DisplayName("Testando o método classifyFeliz")
  public void testClassifyFeliz() {
    assertEquals(false, knn.classifyFeliz(pessoa1));
    assertEquals(false, knn.classifyFeliz(pessoa2));
    assertEquals(true, knn.classifyFeliz(pessoa3));
  }
  
}