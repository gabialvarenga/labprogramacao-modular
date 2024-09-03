package br.lpm.business;

public class Dataset {
    private static final int MAX_PESSOAS = 100;
    private Pessoa[] pessoas = new Pessoa[MAX_PESSOAS];
    private int pessoasCadastradas = 0;

    public void addPessoa(Pessoa pessoa) {
        if (pessoa == null || pessoasCadastradas >= MAX_PESSOAS) {
            return;
        }
        for (int i = 0; i < pessoasCadastradas; i++) {
            if (pessoas[i].equals(pessoa)) {
                return;
            }
        }
        pessoas[pessoasCadastradas] = pessoa;
        pessoasCadastradas++;
    }

    public void removePessoa(Pessoa pessoa) {
        for (int i = 0; i < pessoasCadastradas; i++) {
            if (pessoas[i] != null && pessoas[i].equals(pessoa)) {
                pessoas[i] = pessoas[pessoasCadastradas - 1];
                pessoas[pessoasCadastradas - 1] = null;
                pessoasCadastradas--;
            }
        }
    }

    public void removePessoaByName(String nome) {
        for (int i = 0; i < pessoasCadastradas; i++) {
            if (pessoas[i] != null && pessoas[i].getNome().equalsIgnoreCase(nome)) {
                pessoas[i] = pessoas[pessoasCadastradas - 1];
                pessoas[pessoasCadastradas - 1] = null;
                pessoasCadastradas--;
                return;
            }
        }
    }

    public void replacePessoa(Pessoa pessoaAntiga, Pessoa novaPessoa) {
        if (pessoaAntiga == null || novaPessoa == null) {
        }
        for (int i = 0; i < pessoasCadastradas; i++) {
            if (pessoas[i] != null &&
                    pessoas[i].getNome().equals(pessoaAntiga.getNome())) {
                pessoas[i] = novaPessoa;
                return;
            }
        }
    }

    public Pessoa getPessoaByName(String nome) {
        for (int i = 0; i < pessoasCadastradas; i++) {
            if (pessoas[i] != null && pessoas[i].getNome().equalsIgnoreCase(nome)) {
                return pessoas[i];
            }
        }
        return null;
    }

    public Pessoa[] getAll() {
        Pessoa[] pessoasValidas = new Pessoa[pessoasCadastradas];
        for (int i = 0; i < pessoasCadastradas; i++) {
            pessoasValidas[i] = pessoas[i];
        }
        return pessoasValidas;
    }

    public void removeAll() {
        for (int i = 0; i < pessoasCadastradas; i++) {
            pessoas[i] = null;
        }
        pessoasCadastradas = 0;
    }

    public int size() {
        return pessoasCadastradas;
    }

    public float maxAltura() {
        if (pessoasCadastradas == 0) {
            return 0;
        }
        float alturaMaxima = pessoas[0].getAltura();
        for (int i = 1; i < pessoasCadastradas; i++) {
            if (pessoas[i].getAltura() > alturaMaxima) {
                alturaMaxima = pessoas[i].getAltura();
            }
        }
        return alturaMaxima;
    }

    public float minAltura() {
        if (pessoasCadastradas == 0) {
            return 0;
        }
        float alturaMinima = pessoas[0].getAltura();
        for (int i = 1; i < pessoasCadastradas; i++) {
            if (pessoas[i].getAltura() < alturaMinima) {
                alturaMinima = pessoas[i].getAltura();
            }
        }
        return alturaMinima;
    }

    public float avgAltura() {
        if (pessoasCadastradas == 0) {
            return 0;
        }
        float mediaAltura = 0.0f;
        for (int i = 0; i < pessoasCadastradas; i++) {
            mediaAltura += pessoas[i].getAltura();
        }
        return mediaAltura / pessoasCadastradas;
    }

    public int maxPeso() {
        if (pessoasCadastradas == 0) {
            return 0;
        }
        int pesoMaximo = pessoas[0].getPeso();
        for (int i = 1; i < pessoasCadastradas; i++) {
            if (pessoas[i].getPeso() > pesoMaximo) {
                pesoMaximo = pessoas[i].getPeso();
            }
        }
        return pesoMaximo;
    }

    public int minPeso() {
        if (pessoasCadastradas == 0) {
            return 0;
        }
        int pesoMinimo = pessoas[0].getPeso();
        for (int i = 1; i < pessoasCadastradas; i++) {
            if (pessoas[i].getPeso() < pesoMinimo) {
                pesoMinimo = pessoas[i].getPeso();
            }
        }
        return pesoMinimo;
    }

    public int avgPeso() {
        if (pessoasCadastradas == 0) {
            return 0;
        }
        int mediaPeso = 0;
        for (int i = 0; i < pessoasCadastradas; i++) {
            mediaPeso += pessoas[i].getPeso();
        }
        return mediaPeso / pessoasCadastradas;
    }

    private float calcularPercentual(int quantidade) {
        if (pessoasCadastradas == 0) {
            return 0;
        }
        return ((float) quantidade / pessoasCadastradas) * 100;
    }

    public float percentAdult() {
        int totalAdultos = 0;
        for (int i = 0; i < pessoasCadastradas; i++) {
            if (pessoas[i].getAge() >= 18) {
                totalAdultos++;
            }
        }
        return calcularPercentual(totalAdultos);
    }

    public float percentEstadoCivil(EstadoCivil estadoCivil) {
        int totalPorEstadoCivil = 0;
        for (int i = 0; i < pessoasCadastradas; i++) {
            if (pessoas[i].getEstadoCivil().equals(estadoCivil)) {
                totalPorEstadoCivil++;
            }
        }
        return calcularPercentual(totalPorEstadoCivil);
    }

    public EstadoCivil modeEstadoCivil() {
        int[] contador = new int[5];

        for (int i = 0; i < pessoasCadastradas; i++) {
            EstadoCivil estado = pessoas[i].getEstadoCivil();
            if (estado == EstadoCivil.CASADO) {
                contador[0]++;
            } else if (estado == EstadoCivil.DIVORCIADO) {
                contador[1]++;
            } else if (estado == EstadoCivil.SEPARADO) {
                contador[2]++;
            } else if (estado == EstadoCivil.SOLTEIRO) {
                contador[3]++;
            } else if (estado == EstadoCivil.VIUVO) {
                contador[4]++;
            }
        }

        int max = contador[0];
        EstadoCivil maisComum = EstadoCivil.CASADO;

        if (contador[1] > max) {
            max = contador[1];
            maisComum = EstadoCivil.DIVORCIADO;
        }
        if (contador[2] > max) {
            max = contador[2];
            maisComum = EstadoCivil.SEPARADO;
        }
        if (contador[3] > max) {
            max = contador[3];
            maisComum = EstadoCivil.SOLTEIRO;
        }
        if (contador[4] > max) {
            max = contador[4];
            maisComum = EstadoCivil.VIUVO;
        }

        return maisComum;
    }

    public float percentEscolaridade(Escolaridade escolaridade) {
        int totalPorEscolaridade = 0;
        for (int i = 0; i < pessoasCadastradas; i++) {
            if (pessoas[i].getEscolaridade().equals(escolaridade)) {
                totalPorEscolaridade++;
            }
        }
        return calcularPercentual(totalPorEscolaridade);
    }

    public Escolaridade modeEscolaridade() {
        int[] contador = new int[6];

        for (int i = 0; i < pessoasCadastradas; i++) {
            Escolaridade escolaridade = pessoas[i].getEscolaridade();
            if (escolaridade == Escolaridade.FUNDAMENTAL) {
                contador[0]++;
            } else if (escolaridade == Escolaridade.NENHUMA) {
                contador[1]++;
            } else if (escolaridade == Escolaridade.FUNDAMENTAL) {
                contador[2]++;
            } else if (escolaridade == Escolaridade.MEDIO) {
                contador[3]++;
            } else if (escolaridade == Escolaridade.SUPERIOR) {
                contador[4]++;

            } else if (escolaridade == Escolaridade.POS_GRADUACAO) {
                contador[5]++;
            }
        }

        int max = contador[0];
        Escolaridade maisComum = Escolaridade.FUNDAMENTAL;

        if (contador[1] > max) {
            max = contador[1];
            maisComum = Escolaridade.NENHUMA;
        }
        if (contador[2] > max) {
            max = contador[2];
            maisComum = Escolaridade.FUNDAMENTAL;
        }
        if (contador[3] > max) {
            max = contador[3];
            maisComum = Escolaridade.MEDIO;
        }
        if (contador[4] > max) {
            max = contador[4];
            maisComum = Escolaridade.SUPERIOR;
        }
        if (contador[5] > max) {
            max = contador[5];
            maisComum = Escolaridade.POS_GRADUACAO;
        }

        return maisComum;
    }

    public float percentMoradia(Moradia moradia) {
        int totalPorMoradia = 0;
        for (int i = 0; i < pessoasCadastradas; i++) {
            if (pessoas[i].getMoradia().equals(moradia)) {
                totalPorMoradia++;
            }
        }
        return calcularPercentual(totalPorMoradia);
    }

    public Moradia modeMoradia() {
        int[] contador = new int[3];

        for (int i = 0; i < pessoasCadastradas; i++) {
            Moradia moradia = pessoas[i].getMoradia();
            if (moradia == Moradia.COM_FAMILIA) {
                contador[0]++;
            } else if (moradia == Moradia.ALUGUEL) {
                contador[1]++;
            } else if (moradia == Moradia.CASA_PROPRIA) {
                contador[2]++;
            }
        }

        int max = contador[0];
        Moradia maisComum = Moradia.COM_FAMILIA;

        if (contador[1] > max) {
            max = contador[1];
            maisComum = Moradia.ALUGUEL;
        }
        if (contador[2] > max) {
            max = contador[2];
            maisComum = Moradia.CASA_PROPRIA;
        }

        return maisComum;
    }

    public float percentHobby() {
        int totalHobby = 0;
        for (int i = 0; i < pessoasCadastradas; i++) {
            if (!(pessoas[i].getHobby().equals(Hobby.NENHUM))) {
                totalHobby++;
            }
        }
        return calcularPercentual(totalHobby);
    }

    public float percentFeliz() {
        int totalFeliz = 0;
        for (int i = 0; i < pessoasCadastradas; i++) {
            if (pessoas[i].isFeliz()) {
                totalFeliz++;
            }
        }
        return calcularPercentual(totalFeliz);
    }
}
