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
    }

    @Test
    @DisplayName("Testando addPessoa")
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
    @DisplayName("Testando removePessoa")
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

    @Test
    @DisplayName("Testando removePessoaByName")
    void testRemovePessoaByName() {
        dataset.addPessoa(pessoa1);
        dataset.addPessoa(pessoa2);

        dataset.removePessoaByName("Laura");
        assertEquals(2, dataset.size(), "Tamanho não muda com pessoa inexistente");

        dataset.removePessoaByName("Gabriela");
        assertEquals(1, dataset.size(), "Pessoa removida de acordo com o nome");

        dataset.removePessoaByName("Carlos");
        assertEquals(0, dataset.size(), "Tamanho é 0 porque todas as pessoas foram removidas");

    }

    @Test
    @DisplayName("Testando replacePessoa")
    void testReplacePessoa() {
        pessoa1.setNome("Gabriela");
        pessoa2.setNome("Carlos");
        pessoa3.setNome("Laura");

        dataset.addPessoa(pessoa1);
        dataset.addPessoa(pessoa2);

        dataset.replacePessoa(pessoa1, pessoa3);
        assertEquals(null, dataset.getPessoaByName("Gabriela"),
                "A pessoa com nome 'Gabriela' deveria ter sido substituída");

        assertEquals(pessoa3, dataset.getPessoaByName("Laura"), "A pessoa com nome 'Laura' deveria estar na lista.");
    }

    @Test
    @DisplayName("Testando getPessoaByName")
    void testGetPessoaByName() {
        dataset.addPessoa(pessoa2);

        assertEquals(pessoa2, dataset.getPessoaByName("Carlos"), "Pessoa encontrada pelo nome.");

        assertEquals(null, dataset.getPessoaByName("Laura"), "Tamanho não muda com pessoa inexistente.");

    }

    @Test
    @DisplayName("Testando getAll")
    void testGetAll() {
        dataset.removeAll();
        Pessoa[] pessoas = dataset.getAll();
        assertEquals(0, pessoas.length, "Vetor não se encontra vazio");

        dataset.addPessoa(pessoa2);
        Pessoa[] pessoas1 = dataset.getAll();
        assertEquals(1, pessoas1.length, "Uma pessoa adicionada ao vetor");
        assertEquals(pessoa2, pessoas1[0], "Nao sei o comentário");
    }

    @Test
    @DisplayName("Testando removeAll")
    void testRemoveAll() {
        dataset.addPessoa(pessoa1);
        dataset.addPessoa(pessoa2);

        dataset.removeAll();
        Pessoa[] pessoas = dataset.getAll();
        assertEquals(0, pessoas.length, "Vetor não se encontra vazio");
    }

    @Test
    @DisplayName("Testando size")
    void testSize() {
        dataset.addPessoa(pessoa1);
        assertEquals(1, dataset.size(), "Tamanho acad após adicionar uma pessoa");
        dataset.addPessoa(pessoa2);
        assertEquals(2, dataset.size(), "Tamanho cac após adicionar segunda pessoa");
        dataset.removePessoa(pessoa1);
        assertEquals(1, dataset.size(), "Tamanho caca após remover uma pessoa");
        dataset.removeAll();
        assertEquals(0, dataset.size(), "Tamanho cacac após remover todas");
    }

    @Test
    @DisplayName("Testando maxAltura")
    void testMaxAltura() {
        dataset.addPessoa(pessoa2);
        assertEquals(1.72f, dataset.maxAltura(), 0.01f, "Altura máxima deve ser 1.72");

        dataset.addPessoa(pessoa1);
        assertEquals(1.72f, dataset.maxAltura(), 0.01f, "Altura máxima não se altera");

        dataset.addPessoa(pessoa3);
        assertEquals(1.72f, dataset.maxAltura(), 0.01f, "Altura máxima final deve ser 1.72");
    }

    @Test
    @DisplayName("Testando minAltura")
    void testMinAltura() {
        dataset.addPessoa(pessoa3);
        assertEquals(1.65f, dataset.minAltura(), 0.01f, "Altura mínima deve ser 1.65");

        dataset.addPessoa(pessoa2);
        assertEquals(1.65f, dataset.minAltura(), 0.01f, "Altura mínima deve manter como 1.65");

        dataset.addPessoa(pessoa1);
        assertEquals(1.53f, dataset.minAltura(), 0.01f, "Altura mínima deve alterar para ser 1.53");
    }

    @Test
    @DisplayName("Testando avgAltura")
    void testAvgAltura() {
        dataset.addPessoa(pessoa1);
        dataset.addPessoa(pessoa2);
        dataset.addPessoa(pessoa3);

        assertEquals(1.63F, dataset.avgAltura(), 0.01f, "A média entre os 3 pesos deve ser 1,63");
    }

    @Test
    @DisplayName("Testando maxPeso")
    void testMaxPeso() {
        dataset.addPessoa(pessoa2);
        assertEquals(62, dataset.maxPeso(), "Peso máximo deve ser 62kg");

        dataset.addPessoa(pessoa1);
        assertEquals(62, dataset.maxPeso(), "Peso máximo não se altera");

        dataset.addPessoa(pessoa3);
        assertEquals(62, dataset.maxPeso(), "Peso máximo final deve ser 62");
    }

    @Test
    @DisplayName("Testando minPeso")
    void testMinPeso() {
        dataset.addPessoa(pessoa2);
        assertEquals(62, dataset.minPeso(), "Peso mínimo deve ser 62");

        dataset.addPessoa(pessoa3);
        assertEquals(57, dataset.minPeso(), "Peso mínimo deve ser 57");

        dataset.addPessoa(pessoa1);
        assertEquals(57, dataset.minPeso(), "Peso mínimo final deve se manter 57");
    }

    @Test
    @DisplayName("Testando avgPeso")
    void testAvgPeso() {
        dataset.removeAll();
        assertEquals(0, dataset.avgPeso(), "Peso médio deve ser 0");
        dataset.addPessoa(pessoa1);
        dataset.addPessoa(pessoa2);
        dataset.addPessoa(pessoa3);

        assertEquals(59, dataset.avgPeso(), "A média entre os pesos deve ser 59");
    }

    @Test
    @DisplayName("Testando percentAdult")
    void testPercentAdult() {
        dataset.addPessoa(pessoa2);
        dataset.addPessoa(pessoa3);
        dataset.addPessoa(pessoa1);

        assertEquals(100, dataset.percentAdult(), "Percentual de adulto deve ser 100%");

        dataset.removePessoa(pessoa1);
        assertEquals(100, dataset.percentAdult(), "Percentual de adulto deve continuar sendo 100%");

    }

    @Test
    @DisplayName("Testando método percentEstadoCivil")
    public void testPercentEstadoCivil() {
        dataset.addPessoa(pessoa1);
        dataset.addPessoa(pessoa2);
        dataset.addPessoa(pessoa3);
        assertEquals(66.67f, dataset.percentEstadoCivil(EstadoCivil.CASADO), 0.01f,
                "A porcentagem de casados deve ser 66.67%");
    }

    @Test
    @DisplayName("Testando método modeEstadoCivil")
    public void testModeEstadoCivil() {
        dataset.addPessoa(pessoa1);
        dataset.addPessoa(pessoa2);
        dataset.addPessoa(pessoa3);
        assertEquals(EstadoCivil.CASADO, dataset.modeEstadoCivil(),
                "O estado civil mais frequente deveria ser CASADO");
    }

    @Test
    @DisplayName("Testando método percentEscolaridade")
    public void testPercentEscolaridade() {
        dataset.addPessoa(pessoa1);
        dataset.addPessoa(pessoa2);
        dataset.addPessoa(pessoa3);
        assertEquals(
                66.67f,
                dataset.percentEscolaridade(Escolaridade.MEDIO),
                0.01f,
                "A porcentagem de pessoas com ensino médio deveria ser 66.67% ");
    }

    @Test
    @DisplayName("Testando método modeEscolaridade")
    public void testModeEscolaridade() {
        dataset.addPessoa(pessoa1);
        dataset.addPessoa(pessoa2);
        dataset.addPessoa(pessoa3);
        assertEquals(
                Escolaridade.MEDIO,
                dataset.modeEscolaridade(),"A escolaridade mais frequente deveria ser MEDIO");
    }

    @Test
    @DisplayName("Testando método percentMoradia")
    public void testPercentMoradia() {
        dataset.addPessoa(pessoa1);
        dataset.addPessoa(pessoa2);
        dataset.addPessoa(pessoa3);
        assertEquals(
                0.0f,
                dataset.percentMoradia(Moradia.ALUGUEL),
                0.01f,
                "A porcentagem de pessoas que moram de aluguel deveria ser 0.00%");

                assertEquals(
                    33.33f,
                    dataset.percentMoradia(Moradia.COM_FAMILIA),
                    0.01f,
                    "A porcentagem de pessoas que moram com a família deveria ser 33.33%");
    }

    @Test
    @DisplayName("Testando método modeMoradia")
    public void testModeMoradia() {
        dataset.addPessoa(pessoa1);
        dataset.addPessoa(pessoa2);
        dataset.addPessoa(pessoa3);
        assertEquals(
                Moradia.CASA_PROPRIA, dataset.modeMoradia(), "A moradia mais frequente deveria ser CASA PRÓPRIA");
    }

    @Test
    @DisplayName("Testando método percentHobby")
    public void testPercentHobby() {
        dataset.addPessoa(pessoa1);
        dataset.addPessoa(pessoa2);
        dataset.addPessoa(pessoa3);
        assertEquals(
                100.0f,
                dataset.percentHobby(),
                0.01f,
                "A porcentagem de pessoas com hobbies deveria ser 100%");
    }

    @Test
    @DisplayName("Testando método percentFeliz")
    public void testPercentFeliz() {
        dataset.addPessoa(pessoa1);
        dataset.addPessoa(pessoa2);
        dataset.addPessoa(pessoa3);
        assertEquals(
                100.0f,
                dataset.percentFeliz(),
                0.01f,
                "A porcentagem de pessoas felizes deveria ser 100.0%");
    }
}
