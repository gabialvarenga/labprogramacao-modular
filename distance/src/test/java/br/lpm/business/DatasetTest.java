package br.lpm.business;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DatasetTest {

    private static Dataset dataset;
    private static Pessoa pessoa1;
    private static Pessoa pessoa2;
    private static Pessoa pessoa3;
    private Pessoa pessoaReplicaDaPessoa1;

    @BeforeEach
    public void setUp() throws Exception {
        dataset = new Dataset();

        pessoa1 = new Pessoa("Gabriela", LocalDate.of(2006, 01, 15), Genero.FEMININO, 1.53f, 58, 30000.00f,
                "Belo Horizonte", Hobby.LIVRO, EstadoCivil.CASADO, Escolaridade.MEDIO, true, Moradia.COM_FAMILIA);

        pessoa2 = new Pessoa("Carlos", LocalDate.of(2005, 10, 20), Genero.MASCULINO, 1.72f, 62, 40000.00f,
                "Almenara", Hobby.ESPORTE, EstadoCivil.CASADO, Escolaridade.MEDIO, true, Moradia.CASA_PROPRIA);

        pessoa3 = new Pessoa("Laura", LocalDate.of(2000, 06, 11), Genero.FEMININO, 1.65f, 57, 25000.00f,
                "Almenara", Hobby.ESPORTE, EstadoCivil.SOLTEIRO, Escolaridade.POS_GRADUACAO, true,
                Moradia.CASA_PROPRIA);

        pessoaReplicaDaPessoa1 = new Pessoa("Gabriela", LocalDate.of(2006, 01, 15), Genero.FEMININO, 1.53f, 58,
                30000.00f,
                "Belo Horizonte", Hobby.LIVRO, EstadoCivil.CASADO, Escolaridade.MEDIO, true, Moradia.COM_FAMILIA);
    }

    @Test
    @DisplayName("Testando addPessoa")
    public void testAddPessoa() {
        dataset.addPessoa(pessoa1);
        assertEquals(1, dataset.size(), "Deve aumentar o tamanho ao adicionar uma pessoa válida.");

        dataset.addPessoa(pessoa2);
        assertEquals(2, dataset.size(), "Deve aumentar o tamanho ao adicionar uma segunda pessoa válida.");

        dataset.addPessoa(null);
        assertEquals(2, dataset.size(), "Não deve adicionar uma pessoa nula, o tamanho permanece inalterado.");

        dataset.addPessoa(pessoa2);
        assertEquals(2, dataset.size(), "Não deve adicionar uma pessoa duplicada, o tamanho permanece inalterado.");

        dataset.removeAll();
        assertEquals(0, dataset.size(), "O tamanho deve ser 0 após remover todas as pessoas.");

        dataset.addPessoa(null);
        assertEquals(0, dataset.size(), "Não deve adicionar uma pessoa nula, mesmo com o dataset vazio.");
    }

    @Test
    @DisplayName("Testando removePessoa")
    public void testRemovePessoa() {
        dataset.addPessoa(pessoa1);
        dataset.addPessoa(pessoa3);

        dataset.removePessoa(pessoa1);
        assertEquals(1, dataset.size(), "Deve reduzir o tamanho ao remover uma pessoa existente.");

        dataset.removePessoa(pessoa2);
        assertEquals(1, dataset.size(), "Remover uma pessoa inexistente não altera o tamanho.");

        dataset.removePessoa(pessoa3);
        assertEquals(0, dataset.size(), "O tamanho deve ser 0 após remover todas as pessoas.");
    }

    @Test
    @DisplayName("Testando removePessoaByName")
    void testRemovePessoaByName() {
        dataset.addPessoa(pessoa1);
        dataset.addPessoa(pessoa2);

        dataset.removePessoaByName("Laura");
        assertEquals(2, dataset.size(), "Remover uma pessoa pelo nome inexistente não altera o tamanho.");

        dataset.removePessoaByName("Gabriela");
        assertEquals(1, dataset.size(), "Deve reduzir o tamanho ao remover uma pessoa pelo nome existente.");

        dataset.removePessoaByName("Carlos");
        assertEquals(0, dataset.size(), "O tamanho deve ser 0 após remover todas as pessoas.");
    }

    @Test
    @DisplayName("Testando replacePessoa")
    void testReplacePessoa() {
        dataset.addPessoa(pessoa1);
        dataset.addPessoa(pessoa2);

        dataset.replacePessoa(pessoa1, pessoa3);
        assertEquals(null, dataset.getPessoaByName("Gabriela"),
                "A pessoa 'Gabriela' deve ser substituída e não mais encontrada.");
        assertEquals(pessoa3, dataset.getPessoaByName("Laura"),
                "A pessoa 'Laura' deve estar na lista após substituição.");
    }

    @Test
    @DisplayName("Testando getPessoaByName")
    void testGetPessoaByName() {
        dataset.addPessoa(pessoa2);
        assertEquals(pessoa2, dataset.getPessoaByName("Carlos"), "Deve encontrar a pessoa pelo nome 'Carlos'.");
        assertEquals(null, dataset.getPessoaByName("Laura"), "Não deve encontrar uma pessoa com nome inexistente.");
    }

    @Test
    @DisplayName("Testando getAll")
    void testGetAll() {
        dataset.removeAll();
        Pessoa[] pessoas = dataset.getAll();
        assertEquals(0, pessoas.length, "O vetor deve estar vazio após remover todas as pessoas.");

        dataset.addPessoa(pessoa2);
        Pessoa[] pessoas1 = dataset.getAll();
        assertEquals(1, pessoas1.length, "O vetor deve conter uma pessoa após adicionar.");
        assertEquals(pessoa2, pessoas1[0], "A pessoa adicionada deve ser igual à recuperada.");
    }

    @Test
    @DisplayName("Testando removeAll")
    void testRemoveAll() {
        dataset.addPessoa(pessoa1);
        dataset.addPessoa(pessoa2);

        dataset.removeAll();
        Pessoa[] pessoas = dataset.getAll();
        assertEquals(0, pessoas.length, "O vetor deve estar vazio após chamar removeAll.");
    }

    @Test
    @DisplayName("Testando size")
    void testSize() {
        dataset.addPessoa(pessoa1);
        assertEquals(1, dataset.size(), "O tamanho deve ser 1 após adicionar uma pessoa.");
        dataset.addPessoa(pessoa2);
        assertEquals(2, dataset.size(), "O tamanho deve ser 2 após adicionar outra pessoa.");
        dataset.removePessoa(pessoa1);
        assertEquals(1, dataset.size(), "O tamanho deve ser 1 após remover uma pessoa.");
        dataset.removeAll();
        assertEquals(0, dataset.size(), "O tamanho deve ser 0 após remover todas as pessoas.");
    }

    @Test
    @DisplayName("Testando maxAltura")
    void testMaxAltura() {
        dataset.addPessoa(pessoa2);
        assertEquals(1.72f, dataset.maxAltura(), 0.01f, "A altura máxima deve ser 1.72.");

        dataset.addPessoa(pessoa1);
        assertEquals(1.72f, dataset.maxAltura(), 0.01f,
                "A altura máxima deve permanecer 1.72 após adicionar uma pessoa mais baixa.");

        dataset.addPessoa(pessoa3);
        assertEquals(1.72f, dataset.maxAltura(), 0.01f, "A altura máxima deve continuar 1.72.");
    }

    @Test
    @DisplayName("Testando minAltura")
    void testMinAltura() {
        dataset.addPessoa(pessoa3);
        assertEquals(1.65f, dataset.minAltura(), 0.01f, "A altura mínima deve ser 1.65.");

        dataset.addPessoa(pessoa2);
        assertEquals(1.65f, dataset.minAltura(), 0.01f, "A altura mínima deve permanecer 1.65.");

        dataset.addPessoa(pessoa1);
        assertEquals(1.53f, dataset.minAltura(), 0.01f,
                "A altura mínima deve ser 1.53 após adicionar uma pessoa mais baixa.");
    }

    @Test
    @DisplayName("Testando avgAltura")
    void testAvgAltura() {
        dataset.addPessoa(pessoa1);
        dataset.addPessoa(pessoa2);
        dataset.addPessoa(pessoa3);

        assertEquals(1.63f, dataset.avgAltura(), 0.01f, "A média de altura deve ser 1.63.");
    }

    @Test
    @DisplayName("Testando maxPeso")
    void testMaxPeso() {
        dataset.addPessoa(pessoa2);
        assertEquals(62, dataset.maxPeso(), "O peso máximo deve ser 62kg.");

        dataset.addPessoa(pessoa1);
        assertEquals(62, dataset.maxPeso(), "O peso máximo deve permanecer 62kg.");

        dataset.addPessoa(pessoa3);
        assertEquals(62, dataset.maxPeso(), "O peso máximo final deve continuar sendo 62kg.");
    }

    @Test
    @DisplayName("Testando minPeso")
    void testMinPeso() {
        dataset.addPessoa(pessoa2);
        assertEquals(62, dataset.minPeso(), "O peso mínimo deve ser 62kg.");

        dataset.addPessoa(pessoa3);
        assertEquals(57, dataset.minPeso(), "O peso mínimo deve ser 57kg após adicionar uma pessoa mais leve.");

        dataset.addPessoa(pessoa1);
        assertEquals(57, dataset.minPeso(), "O peso mínimo deve permanecer 57kg.");
    }

    @Test
    @DisplayName("Testando avgPeso")
    void testAvgPeso() {
        dataset.removeAll();
        assertEquals(0, dataset.avgPeso(), "A média de peso deve ser 0 quando o vetor está vazio.");

        dataset.addPessoa(pessoa1);
        dataset.addPessoa(pessoa2);
        dataset.addPessoa(pessoa3);

        assertEquals(59, dataset.avgPeso(), "A média de peso deve ser 59kg.");
    }

    @Test
    @DisplayName("Testando percentAdult")
    void testPercentAdult() {
        dataset.addPessoa(pessoa2);
        dataset.addPessoa(pessoa3);
        dataset.addPessoa(pessoa1);

        assertEquals(100, dataset.percentAdult(), "A porcentagem de adultos deve ser 100%.");

        dataset.removePessoa(pessoa1);
        assertEquals(100, dataset.percentAdult(), "A porcentagem de adultos deve continuar sendo 100%.");
    }

    @Test
    @DisplayName("Testando método percentEstadoCivil")
    public void testPercentEstadoCivil() {
        dataset.addPessoa(pessoa1);
        dataset.addPessoa(pessoa2);
        dataset.addPessoa(pessoa3);

        assertEquals(66.67f, dataset.percentEstadoCivil(EstadoCivil.CASADO), 0.01f,
                "A porcentagem de pessoas casadas deve ser 66.67%.");
    }

    @Test
    @DisplayName("Testando método modeEstadoCivil")
    public void testModeEstadoCivil() {
        dataset.addPessoa(pessoa1);
        dataset.addPessoa(pessoa2);
        dataset.addPessoa(pessoa3);

        assertEquals(EstadoCivil.CASADO, dataset.modeEstadoCivil(),
                "O estado civil mais frequente deve ser CASADO.");
    }

    @Test
    @DisplayName("Testando método percentEscolaridade")
    public void testPercentEscolaridade() {
        dataset.addPessoa(pessoa1);
        dataset.addPessoa(pessoa2);
        dataset.addPessoa(pessoa3);

        assertEquals(66.67f, dataset.percentEscolaridade(Escolaridade.MEDIO), 0.01f,
                "A porcentagem de pessoas com ensino médio deve ser 66.67%.");
    }

    @Test
    @DisplayName("Testando método modeEscolaridade")
    public void testModeEscolaridade() {
        dataset.addPessoa(pessoa1);
        dataset.addPessoa(pessoa2);
        dataset.addPessoa(pessoa3);

        assertEquals(Escolaridade.MEDIO, dataset.modeEscolaridade(),
                "A escolaridade mais frequente deve ser MEDIO.");
    }

    @Test
    @DisplayName("Testando método percentMoradia")
    public void testPercentMoradia() {
        dataset.addPessoa(pessoa1);
        dataset.addPessoa(pessoa2);
        dataset.addPessoa(pessoa3);

        assertEquals(0.0f, dataset.percentMoradia(Moradia.ALUGUEL), 0.01f,
                "A porcentagem de pessoas que moram de aluguel deve ser 0.00%.");

        assertEquals(33.33f, dataset.percentMoradia(Moradia.COM_FAMILIA), 0.01f,
                "A porcentagem de pessoas que moram com a família deve ser 33.33%.");
    }

    @Test
    @DisplayName("Testando método modeMoradia")
    public void testModeMoradia() {
        dataset.addPessoa(pessoa1);
        dataset.addPessoa(pessoa2);
        dataset.addPessoa(pessoa3);

        assertEquals(Moradia.CASA_PROPRIA, dataset.modeMoradia(),
                "A moradia mais frequente deve ser CASA PRÓPRIA.");
    }

    @Test
    @DisplayName("Testando método percentHobby")
    public void testPercentHobby() {
        dataset.addPessoa(pessoa1);
        dataset.addPessoa(pessoa2);
        dataset.addPessoa(pessoa3);

        assertEquals(100.0f, dataset.percentHobby(), 0.01f,
                "A porcentagem de pessoas com hobbies deve ser 100%.");
    }

    @Test
    @DisplayName("Testando método percentFeliz")
    public void testPercentFeliz() {
        dataset.addPessoa(pessoa1);
        dataset.addPessoa(pessoa2);
        dataset.addPessoa(pessoa3);

        assertEquals(100.0f, dataset.percentFeliz(), 0.01f,
                "A porcentagem de pessoas felizes deve ser 100%.");
    }

    @Test
    @DisplayName("Testando vetor de distâncias calculadas")
    public void testCalcDistanceVector() {
        dataset.addPessoa(pessoa1);
        dataset.addPessoa(pessoa2);
        dataset.addPessoa(pessoa3);
        dataset.addPessoa(pessoaReplicaDaPessoa1);

        float[] distanceVector = dataset.calcDistanceVector(pessoa1);

        assertEquals(0.0f, distanceVector[0], "A distância entre pessoa1 e ela mesma deve ser 0.");
        assertEquals(0.79f, distanceVector[1], 0.1f,
                "A distância entre pessoa1 e pessoa2 deve ser aproximadamente 0.79.");
        assertEquals(0.0f, distanceVector[3], 0.1f, "A distância entre pessoa1 e pessoaReplicaDaPessoa1 deve ser 0.");
    }

    @Test
    @DisplayName("Testando matriz de distâncias calculadas")
    public void testCalcDistanceMatrix() {
        dataset.addPessoa(pessoa1);
        dataset.addPessoa(pessoa2);
        dataset.addPessoa(pessoa3);
        dataset.addPessoa(pessoaReplicaDaPessoa1);
        float[][] distanceMatrix = dataset.calcDistanceMatrix();
        assertEquals(0f, distanceMatrix[1][1], "A distância entre pessoa2 e ela mesma deve ser 0.");
        assertEquals(
                0.79f,
                distanceMatrix[1][3],
                0.1f,
                "A distância entre pessoa2 e pessoaIdenticaApessoa1 deve ser aproximadamente 0.79.");
        assertEquals(
                0.0f,
                distanceMatrix[0][3],
                "A distância entre pessoa1 e pessoaIdenticaApessoa1 deve ser 0.");
    }

    @Test
    @DisplayName("Testando obtenção das pessoas mais similares")
    public void testGetSimilar() {
        dataset.addPessoa(pessoa1);
        dataset.addPessoa(pessoa2);
        dataset.addPessoa(pessoa3);
        dataset.addPessoa(pessoaReplicaDaPessoa1);

        Pessoa[] similares = dataset.getSimilar(pessoa1, 2);

        assertEquals(2, similares.length, "O array deve conter 2 pessoas mais similares.");

        assertEquals(pessoaReplicaDaPessoa1, similares[0],
                "A pessoa mais similar a pessoa1 deve ser pessoaReplicaDaPessoa1.");

        assertEquals(pessoa2, similares[1], "A segunda pessoa mais similar a pessoa1 deve ser pessoa2.");
    }

}
