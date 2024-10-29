package br.lpm.main;


import br.lpm.business.Attribute;
import br.lpm.business.DataPoint;
import br.lpm.business.Dataset;
import br.lpm.business.FelizMetric;
import br.lpm.business.Knn;
import br.lpm.business.Metric;
import br.lpm.business.EuclideanDistanceMetric;

public class Main {

        public static void main(String[] args) throws Exception {
                Dataset conjuntoDeDados = new Dataset();
                conjuntoDeDados.loadDataFromCSV(
                  "C:\\Users\\Gabriela\\OneDrive\\Documentos\\GitHub\\programacao-modular\\programacao-modular\\knn_pessoa\\LPM -"
                  + " Turma 1 - Cadastro de Pessoas.csv");

                DataPoint p1 = conjuntoDeDados.getDataPoints().get(0);
                DataPoint p2 = conjuntoDeDados.getDataPoints().get(5);

                displayDistancesAndClassifications(conjuntoDeDados, p1, p2);

                classifyAdditionalPoints(conjuntoDeDados);
        }

        private static void displayDistancesAndClassifications(Dataset conjuntoDeDados, DataPoint p1,
                        DataPoint p2) {

                Metric metricaEuclidiana = new EuclideanDistanceMetric();
                Knn classificadorKnnEuclidiano = new Knn(conjuntoDeDados, metricaEuclidiana, 1);

                System.out.printf("Distância Euclidiana - Mesmo Ponto (A): %.2f%n",
                                metricaEuclidiana.distance(p1, p1));
                System.out.printf("Distância Euclidiana - Mesmo Ponto (B): %.2f%n",
                                metricaEuclidiana.distance(p2, p2));
                System.out.printf("Distância Euclidiana entre Ponto A e B: %.2f%n",
                                metricaEuclidiana.distance(p1, p2));

                System.out.println("Classificação de Ponto A usando Métrica Euclidiana: "
                                + getClassificationResult(classificadorKnnEuclidiano, p1));
                System.out.println("Classificação de Ponto B usando Métrica Euclidiana: "
                                + getClassificationResult(classificadorKnnEuclidiano, p2));

                Metric metricaFeliz = new FelizMetric();
                Knn classificadorKnnFeliz = new Knn(conjuntoDeDados, metricaFeliz, 1);

                System.out.printf("Distância (FelizMetric) - Mesmo Ponto (A): %.2f%n",
                                metricaFeliz.distance(p1, p1));
                System.out.printf("Distância (FelizMetric) - Mesmo Ponto (B): %.2f%n",
                                metricaFeliz.distance(p2, p2));
                System.out.printf("Distância entre Ponto A e B (FelizMetric): %.2f%n",
                                metricaFeliz.distance(p1, p2));

                System.out.println("Classificação de Ponto A usando FelizMetric: "
                                + getClassificationResult(classificadorKnnFeliz, p1));
                System.out.println("Classificação de Ponto B usando FelizMetric: "
                                + getClassificationResult(classificadorKnnFeliz, p2));
        }

        private static void classifyAdditionalPoints(Dataset conjuntoDeDados) {  
          DataPoint pessoaCarlos = createDataPoint("Carlos", "10/3/2000", "Masculino", 1.75, 75, 2500.00,  
                          "Almenara", "Sozinho", "Solteiro",  
                          "Ensino Médio", "Futebol", "Sim");  
          DataPoint pessoaGabriela = createDataPoint("Gabriela", "3/1/1998", "Feminino", 1.65, 55, 3000.00,  
                          "Belo Horizonte", "Com amigos", "Solteira",  
                          "Ensino Superior", "Dançar", "Sim");  
      
          System.out.printf("Distância Euclidiana entre Carlos e Gabriela: %.2f%n",  
                          new EuclideanDistanceMetric().distance(pessoaCarlos, pessoaGabriela));  
      }
      
        private static DataPoint createDataPoint(String nome, String dataNascimento, String genero, double altura,
                        int peso, double renda, String cidade, String moradia,
                        String estadoCivil, String escolaridade, String hobby, String feliz) {
                DataPoint ponto = new DataPoint();
                ponto.addAttribute(new Attribute(nome));
                ponto.addAttribute(new Attribute(dataNascimento));
                ponto.addAttribute(new Attribute(genero));
                ponto.addAttribute(new Attribute(altura));
                ponto.addAttribute(new Attribute(peso));
                ponto.addAttribute(new Attribute(renda));
                ponto.addAttribute(new Attribute(cidade));
                ponto.addAttribute(new Attribute(moradia));
                ponto.addAttribute(new Attribute(estadoCivil));
                ponto.addAttribute(new Attribute(escolaridade));
                ponto.addAttribute(new Attribute(hobby));
                ponto.addAttribute(new Attribute(feliz));
                return ponto;
        }

        private static String getClassificationResult(Knn classificador, DataPoint ponto) {
                String result = (String) classificador.classify(ponto);
                return result != null ? result : "Classe Indefinida";
        }
}