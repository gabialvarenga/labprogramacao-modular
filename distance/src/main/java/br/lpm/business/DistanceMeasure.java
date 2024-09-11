package br.lpm.business;

public class DistanceMeasure {
    private Dataset dataset;

    public DistanceMeasure(Dataset dataset) {
        this.dataset = dataset;
    }

    public float calcDistance(Pessoa first, Pessoa second) {
        if (first == null || second == null) {
            return 0.0f;
        }

        float somaDosQuadrados = 0.0f;
        int contadorAtributos = 0;

        if (first.getRenda() != 0 && second.getRenda() != 0) {
            float distanciaRenda = calcDistanceNumerico(first.getRenda(), second.getRenda(), dataset.minRenda(), dataset.maxRenda());
            somaDosQuadrados += distanciaRenda;
            contadorAtributos++;
        }

        if (first.getPeso() != 0 && second.getPeso() != 0) {
            float distanciaPeso = calcDistanceNumerico(first.getPeso(), second.getPeso(), dataset.minPeso(), dataset.maxPeso());
            somaDosQuadrados += distanciaPeso;
            contadorAtributos++;
        }

        if (first.getIdade() != 0 && second.getIdade() != 0) {
            float distanciaIdade = calcDistanceNumerico(first.getIdade(), second.getIdade(), dataset.minIdade(), dataset.maxIdade());
            somaDosQuadrados += distanciaIdade;
            contadorAtributos++;
        }

        if (first.getAltura() != 0 && second.getAltura() != 0) {
            float distanciaAltura = calcDistanceNumerico(first.getAltura(), second.getAltura(), dataset.minAltura(), dataset.maxAltura());
            somaDosQuadrados += distanciaAltura;
            contadorAtributos++;
        }

        float distanciaFeliz = calcDistanceBoolean(first.isFeliz(), second.isFeliz());
        somaDosQuadrados += distanciaFeliz * distanciaFeliz;
        contadorAtributos++;
        
        if (first.getEstadoCivil() != null && second.getEstadoCivil() != null) {
            float distanciaEstadoCivil = calcDistanceEnum(first.getEstadoCivil(), second.getEstadoCivil());
            somaDosQuadrados += distanciaEstadoCivil * distanciaEstadoCivil;
            contadorAtributos++;
        }

        if (first.getHobby() != null && second.getHobby() != null) {
            float distanciaHobby = calcDistanceEnum(first.getHobby(), second.getHobby());
            somaDosQuadrados += distanciaHobby * distanciaHobby;
            contadorAtributos++;
        }

        if (first.getEscolaridade() != null && second.getEscolaridade() != null) {
            float distanciaEscolaridade = calcDistanceEnum(first.getEscolaridade(), second.getEscolaridade());
            somaDosQuadrados += distanciaEscolaridade * distanciaEscolaridade;
            contadorAtributos++;
        }

        if (first.getGenero() != null && second.getGenero() != null) {
            float distanciaGenero = calcDistanceEnum(first.getGenero(), second.getGenero());
            somaDosQuadrados += distanciaGenero * distanciaGenero;
            contadorAtributos++;
        }

        if (first.getMoradia() != null && second.getMoradia() != null) {
            float distanciaMoradia = calcDistanceEnum(first.getMoradia(), second.getMoradia());
            somaDosQuadrados += distanciaMoradia * distanciaMoradia;
            contadorAtributos++;
        }

        if (contadorAtributos == 0) {
            return 0.0f; 
        }

        return (float) Math.sqrt(somaDosQuadrados / contadorAtributos);
    }

    private float calcDistanceNumerico(float valor1, float valor2, float min, float max) {
        if (max == min) {
            return 0.0f;
        }
        float normalizacao1 = dataset.ajustarValor(valor1, min, max);
        float normalizacao2 = dataset.ajustarValor(valor2, min, max);
        return (normalizacao1 - normalizacao2) * (normalizacao1 - normalizacao2);
    }

    private float calcDistanceBoolean(boolean first, boolean second) {
        return (first == second) ? 0.0f : 1.0f;
    }

    private float calcDistanceEnum(Enum<?> first, Enum<?> second) {
        return (first == second) ? 0.0f : 1.0f;
    }
}
