package br.lpm.business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Knn {
    private Dataset dataset;
    private int k;
    private Metric metric;

    public Knn(Dataset dataset, Metric metric, int k) {
        this.setDataset(dataset);
        this.setMetric(metric);
        this.setK(k);
    }

    private List<Double> calculateDistances(DataPoint testPoint) {

        List<Double> distances = new ArrayList<Double>(dataset.size());

        List<DataPoint> dpList = dataset.getDataPoints();
        for (DataPoint dp : dpList) {
            distances.add(metric.distance(dp, testPoint));
        }
        return distances;
    }

    public Object classify(DataPoint testPoint) {

        List<DataPoint> dp = dataset.getDataPoints();
        int size = dataset.size();
        List<Double> distances = this.calculateDistances(testPoint);

        Integer[] indices = new Integer[size];
        for (int i = 0; i < size; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices, Comparator.comparingDouble(i -> distances.get(i)));

        Map<Object, Integer> stateCount = new HashMap<Object, Integer>();

        for (int n = 0; n < k; n++) {
            Integer f = stateCount.get(dp.get(n).getState());
            if (f == null) {
                stateCount.put(dp.get(n).getState(), 1);
            } else {
                stateCount.put(dp.get(n).getState(), f++);
            }
        }

        Set<Map.Entry<Object, Integer>> states = stateCount.entrySet();

        Map.Entry<Object, Integer> winner = states.stream()
                .max((e1, e2) -> e1.getValue().compareTo(e2.getValue()))
                .get();

        return winner.getKey();
    }

    public Object predict(DataPoint testPoint) {

        List<DataPoint> dp = dataset.getDataPoints();
        int size = dataset.size();
        List<Double> distances = this.calculateDistances(testPoint);

        Integer[] indices = new Integer[size];
        for (int i = 0; i < size; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices, Comparator.comparingDouble(i -> distances.get(i)));

        double sumState = 0;
        for (int n = 0; n < k; n++) {
            sumState += (double) dp.get(n).getState();
        }

        return sumState / k;
    }


    public void setK(int k) {
        if (k <= 0 || k > dataset.getDataPoints().size()) {
            return;
        }
        this.k = k;
    }

    public int getK() {
        return k;
    }

    public Dataset getDataset() {
        return dataset;
    }

    public void setDataset(Dataset dataset) {
        if (dataset == null) {
            return;
        }
        this.dataset = dataset;
    }

    public Metric getMetric() {
        return metric;
    }

    public void setMetric(Metric metric) {
        if (metric == null) {
            return;
        }
        this.metric = metric;
    }



    @Override
    public String toString() {
        return "Knn [dataset=" + dataset + ", metric=" + metric + ", k=" + k + "]";
    }
}