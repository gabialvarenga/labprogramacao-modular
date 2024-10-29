package br.lpm.business;

import java.util.List;

public class EuclideanDistanceMetric implements Metric {

  private static final double MAX_ALTURA = 2.60;
  private static final double MAX_PESO = 600.00;
  private static final double MAX_RENDA = 10000.00;

  @Override
  public double distance(DataPoint p1, DataPoint p2) {
    List<Attribute> attp1 = p1.getAttributes();
    List<Attribute> attp2 = p2.getAttributes();

    double distance = 0;

    for (int i = 0; i < attp1.size(); i++) {
      Object v1 = attp1.get(i).getValue();
      Object v2 = attp2.get(i).getValue();

      if (v1 instanceof Number && v2 instanceof Number) {
        double d1 = ((Number) v1).doubleValue();
        double d2 = ((Number) v2).doubleValue();

  
        if (i == 3) {
          distance += Math.pow((d1 - d2) / MAX_ALTURA, 2);
        } else if (i == 4) {
          distance += Math.pow((d1 - d2) / MAX_PESO, 2);
        } else if (i == 5) {
          distance += Math.pow((d1 - d2) / MAX_RENDA, 2);
        } else {
          distance += Math.pow(d1 - d2, 2);
        }
      } else {
        distance += v1.equals(v2) ? 0 : 1;
      }
    }
    return Math.sqrt(distance / attp1.size());
  }
}