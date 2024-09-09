package br.lpm.business;

public class DistanceMeasure {
    private Dataset dataset;

    public DistanceMeasure(Dataset dataset) {
        this.dataset = dataset;
    }

    public float[] normalizeField(String fieldName) {
        Pessoa[] pessoas = dataset.getAll();
        float[] campoNormalizado = new float[dataset.size()];

        for (int i = 0; i < dataset.size(); i++) {
            campoNormalizado[i] = calcularNormalizacao(pessoas[i], fieldName);
        }
        return campoNormalizado;
    }

    private float calcularNormalizacao(Pessoa pessoa, String nomeCampo) {
        switch (nomeCampo.toUpperCase()) {
            case "RENDA":
                return ajustarValor(pessoa.getRenda(), dataset.minRenda(), dataset.maxRenda());
            case "PESO":
                return ajustarValor(pessoa.getPeso(), dataset.minPeso(), dataset.maxPeso());
            case "IDADE":
                return ajustarValor(pessoa.getIdade(), dataset.minIdade(), dataset.maxIdade());
            case "ALTURA":
                return ajustarValor(pessoa.getAltura(), dataset.minAltura(), dataset.maxAltura());
            default:
                return 0.0f;
        }
    }

    private float ajustarValor(float x, float minimo, float maximo) {
        return (x - minimo) / (maximo - minimo);
    }

    public float calcularDistancia(Pessoa first, Pessoa second) {
        if (first == null || second == null) {
            return 0.0f;
        }

        float somaDosQuadrados = 0.0f;
        int contadorAtributos = 0;

        if (first.getRenda() != 0 && second.getRenda() != 0) {
            float distanciaRenda = calcularDistanciaNumerico(first.getRenda(), second.getRenda(), dataset.minRenda(), dataset.maxRenda());
            somaDosQuadrados += distanciaRenda;
            contadorAtributos++;
        }

        if (first.getPeso() != 0 && second.getPeso() != 0) {
            float distanciaPeso = calcularDistanciaNumerico(first.getPeso(), second.getPeso(), dataset.minPeso(), dataset.maxPeso());
            somaDosQuadrados += distanciaPeso;
            contadorAtributos++;
        }

        if (first.getIdade() != 0 && second.getIdade() != 0) {
            float distanciaIdade = calcularDistanciaNumerico(first.getIdade(), second.getIdade(), dataset.minIdade(), dataset.maxIdade());
            somaDosQuadrados += distanciaIdade;
            contadorAtributos++;
        }

        if (first.getAltura() != 0 && second.getAltura() != 0) {
            float distanciaAltura = calcularDistanciaNumerico(first.getAltura(), second.getAltura(), dataset.minAltura(), dataset.maxAltura());
            somaDosQuadrados += distanciaAltura;
            contadorAtributos++;
        }

        float distanciaFeliz = calcularDistanciaBoolean(first.isFeliz(), second.isFeliz());
        somaDosQuadrados += distanciaFeliz * distanciaFeliz;
        contadorAtributos++;

        if (first.getEstadoCivil() != null && second.getEstadoCivil() != null) {
            float distanciaEstadoCivil = calcularDistanciaEnum(first.getEstadoCivil(), second.getEstadoCivil());
            somaDosQuadrados += distanciaEstadoCivil * distanciaEstadoCivil;
            contadorAtributos++;
        }

        if (first.getHobby() != null && second.getHobby() != null) {
            float distanciaHobby = calcularDistanciaEnum(first.getHobby(), second.getHobby());
            somaDosQuadrados += distanciaHobby * distanciaHobby;
            contadorAtributos++;
        }

        if (first.getEscolaridade() != null && second.getEscolaridade() != null) {
            float distanciaEscolaridade = calcularDistanciaEnum(first.getEscolaridade(), second.getEscolaridade());
            somaDosQuadrados += distanciaEscolaridade * distanciaEscolaridade;
            contadorAtributos++;
        }

        if (first.getGenero() != null && second.getGenero() != null) {
            float distanciaGenero = calcularDistanciaEnum(first.getGenero(), second.getGenero());
            somaDosQuadrados += distanciaGenero * distanciaGenero;
            contadorAtributos++;
        }

        if (first.getMoradia() != null && second.getMoradia() != null) {
            float distanciaMoradia = calcularDistanciaEnum(first.getMoradia(), second.getMoradia());
            somaDosQuadrados += distanciaMoradia * distanciaMoradia;
            contadorAtributos++;
        }

        if (contadorAtributos == 0) {
            return 0.0f; 
        }

        return (float) Math.sqrt(somaDosQuadrados / contadorAtributos);
    }

    private float calcularDistanciaNumerico(float valor1, float valor2, float min, float max) {
        if (max == min) {
            return 0.0f;
        }
        float normalizacao1 = ajustarValor(valor1, min, max);
        float normalizacao2 = ajustarValor(valor2, min, max);
        return (normalizacao1 - normalizacao2) * (normalizacao1 - normalizacao2);
    }

    private float calcularDistanciaBoolean(boolean first, boolean second) {
        return (first == second) ? 0.0f : 1.0f;
    }

    private float calcularDistanciaEnum(Enum<?> first, Enum<?> second) {
        return (first == second) ? 0.0f : 1.0f;
    }
}
