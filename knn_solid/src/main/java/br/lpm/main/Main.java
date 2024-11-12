package br.lpm.main;

import br.lpm.business.KnnClassifier;
import br.lpm.business.KnnRegressor;
import br.lpm.data_structures.Attribute;
import br.lpm.data_structures.DataPoint;
import br.lpm.data_structures.DataSet;
import br.lpm.loaders.CsvLoader;
import br.lpm.loaders.DataLoader;
import br.lpm.metrics.EuclideanDistanceMetric;
import br.lpm.metrics.Metric;

public class Main {
        private static final String BASE_DIRECTORY = "C:\\Users\\Gabriela\\OneDrive\\Documentos\\GitHub\\programacao-modular\\programacao-modular\\knn_solid";
        private static final String TEST_CSV_FILE = BASE_DIRECTORY + "\\LPM - Turma 1 - Cadastro de Pessoas (1).csv";
    
        public static void main(String[] args) {
            DataSet dataSet = new DataSet();
            DataLoader dataLoader = new CsvLoader(';');
            dataLoader.load(TEST_CSV_FILE, dataSet);
            System.out.println("Conjunto de dados carregado:\n" + dataSet);
    
            Metric metric = new EuclideanDistanceMetric();
            
            System.out.println("Comparação entre pontos do conjunto de dados:");
            for (int i = 0; i < dataSet.getDataPoints().size(); i++) {
                DataPoint dp1 = dataSet.getDataPoints().get(i);
                for (int j = i + 1; j < dataSet.getDataPoints().size(); j++) {
                    DataPoint dp2 = dataSet.getDataPoints().get(j);
                    double distancia = metric.distance(dp1, dp2);
                    System.out.println("Distância entre DataPoint " + i + " e DataPoint " + j + ": " + distancia);
                }
            }
    
    
            KnnClassifier classifier = new KnnClassifier(dataSet, 3, metric);
            KnnRegressor regressor = new KnnRegressor(dataSet, 3, metric);
    
           
            DataPoint exemplo = dataSet.getDataPoints().get(0);
    
            Attribute predictedClass = classifier.predict(exemplo);
            System.out.println("Classe prevista para o ponto de exemplo: " + predictedClass.getValue());
    
            Attribute predictedValue = regressor.predict(exemplo);
            System.out.println("Valor previsto para o ponto de exemplo: " + predictedValue.getValue());
        }
    }
    