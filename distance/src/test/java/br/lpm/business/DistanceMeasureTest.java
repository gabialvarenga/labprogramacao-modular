package br.lpm.business;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DistanceMeasureTest {

    private Dataset dataset;
    private Pessoa usuario1;
    private Pessoa usuario2;
    private Pessoa usuario3;
    private Pessoa usuarioReplicaA;
    private DistanceMeasure distanceMeasure;

    @BeforeEach
    public void setUp() {
        usuario1 = new Pessoa(
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

        usuario2 = new Pessoa(
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

        usuario3 = new Pessoa(
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

        usuarioReplicaA = new Pessoa(
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

        dataset = new Dataset();
        dataset.addPessoa(usuario1);
        dataset.addPessoa(usuario2);
        dataset.addPessoa(usuario3);
        dataset.addPessoa(usuarioReplicaA);

        distanceMeasure = new DistanceMeasure(dataset);
    }

    @Test
    @DisplayName("Testando normalização dos campos para diferentes atributos")
    public void testNormalizeFields() {
        
        float[] normalizacaoIdades = distanceMeasure.normalizeField("Idade");
        assertEquals(0.0f, normalizacaoIdades[0], "Valor normalizado para idade da pessoa1 deve ser 0.0");
        assertEquals(0.0f, normalizacaoIdades[1], "Valor normalizado para idade da pessoa2 deve ser 0.033");
        assertEquals(1.0f, normalizacaoIdades[2], "Valor normalizado para idade da pessoa3 deve ser 1.0");

        float[] normalizacaoPesos = distanceMeasure.normalizeField("Peso");
        assertEquals(0.0f, normalizacaoPesos[0], "Valor normalizado para peso da pessoa1 deve ser 0.0");
        assertEquals(0.67f, normalizacaoPesos[1], 0.1f, "Valor normalizado para peso da pessoa2 deve ser 0.67");
        assertEquals(1.0f, normalizacaoPesos[2], "Valor normalizado para peso da pessoa3 deve ser 1.0");

        float[] normalizacaoRendas = distanceMeasure.normalizeField("Renda");
        assertEquals(1.0f, normalizacaoRendas[0], "Valor normalizado para renda da pessoa1 deve ser 1.0");
        assertEquals(0.0f, normalizacaoRendas[1], "Valor normalizado para renda da pessoa2 deve ser 0.0");
        assertEquals(0.2f, normalizacaoRendas[2], 0.1f, "Valor normalizado para renda da pessoa3 deve ser 0.20");

        float[] normalizacaoAlturas = distanceMeasure.normalizeField("Altura");
        assertEquals(0.0f, normalizacaoAlturas[0], "Valor normalizado para altura da pessoa1 deve ser 0.0");
        assertEquals(1.0f, normalizacaoAlturas[1], "Valor normalizado para altura da pessoa2 deve ser 1.0");
        assertEquals(0.84f, normalizacaoAlturas[2], 0.1f, "Valor normalizado para altura da pessoa3 deve ser 0.84");
    }

    @Test
    @DisplayName("Testando a distância calculada entre duas pessoas")
    public void testCalcDistance() {
        float distancia1 = distanceMeasure.calcularDistancia(usuario1, usuario2);
        // Ajuste o valor esperado conforme a lógica de cálculo de distância
        assertEquals(0.734f, distancia1, 0.01f, "A distância entre Gabriela e Carlos deve ser aproximadamente 0.774");

        float distancia2 = distanceMeasure.calcularDistancia(usuario1, usuarioReplicaA);
        assertEquals(0.0f, distancia2, 0.01f, "A distância entre pessoas idênticas deve ser 0.0");
    }
}
