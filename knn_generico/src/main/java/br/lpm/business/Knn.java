package br.lpm.business;

public class Knn {

    private int k;
    private Dataset dataset;

    public Knn(int k, Dataset dataset) {
        this.k = k;
        this.dataset = dataset;
    }

    public boolean classifyFeliz(Pessoa pessoa) {
        Pessoa[] vizinhosProximos = dataset.getSimilar(pessoa, k);


        int totalFelizes = 0;
        int totalNaoFelizes = 0;

        for (int i = 0; i < vizinhosProximos.length; i++) {
            Pessoa vizinho = vizinhosProximos[i];

            if (vizinho != null) {
                if (vizinho.isFeliz()) {
                    totalFelizes++;
                } else {
                    totalNaoFelizes++;
                }
            }
        }

        return totalFelizes > totalNaoFelizes;
    }
}
