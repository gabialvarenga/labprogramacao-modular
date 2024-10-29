package br.lpm.business;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.text.DecimalFormatSymbols;
import java.text.DecimalFormat;

public class Dataset {
  private List<DataPoint> dataPoints = new ArrayList<>();
  private List<String> attributeNames = new ArrayList<>();
  private String stateName;

  public void addDataPoint(DataPoint dataPoint) {
    dataPoints.add(dataPoint);
  }

  public void addDataPoints(List<DataPoint> dataPoints) {
    this.dataPoints.addAll(dataPoints);
  }

  public void addAttributeName(String attributeName) {
    attributeNames.add(attributeName);
  }

  public void addAttributeNames(List<String> attributeNames) {
    this.attributeNames.addAll(attributeNames);
  }

  public DataPoint getDataPoint(int index) {
    return dataPoints.get(index);
  }

  public List<DataPoint> getDataPoints() {
    return dataPoints;
  }

  public String getStateName() {
    return stateName;
  }

  public String getAttributeName(int index) {
    return attributeNames.get(index);
  }

  public List<String> getAttributeNames() {
    return attributeNames;
  }

  public int numDataPoints() {
    return dataPoints.size();
  }

  public int size() {
    return attributeNames.size();
  }

  public void removeAttribute(int index) {
    attributeNames.remove(index);
  }

  public void removeDataPoint(int index) {
    dataPoints.remove(index);
  }

  public void removeDataPoint(DataPoint dataPoint) {
    dataPoints.remove(dataPoint);
  }

  public void removeDataPoints(List<DataPoint> dataPoints) {
    this.dataPoints.removeAll(dataPoints);
  }

  public void removeAttributeName(String attributeName) {
    attributeNames.remove(attributeName);
  }

  public void removeAttributeNames(List<String> attributeNames) {
    this.attributeNames.removeAll(attributeNames);
  }

  public void setStateName(String stateName) {
    this.stateName = stateName;
  }

  public String getSateName() {
    return stateName;
  }

  public void removeAllDataPoints() {
    dataPoints.clear();
  }

  public void removeAllAttributeNames() {
    attributeNames.clear();
  }

  public void loadDataFromCSV(String filename) throws IOException {
    try (BufferedReader fileReader = new BufferedReader(new FileReader(filename))) {
        String line = fileReader.readLine();
        if (line == null) {
            throw new IOException("O arquivo CSV está vazio.");
        }

        String[] attributes = line.split(";");
        for (int i = 0; i < attributes.length - 1; i++) {
            addAttributeName(attributes[i].trim());
        }

        setStateName(attributes[attributes.length - 1].trim());

        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator(',');
        DecimalFormat format = new DecimalFormat("0.#");
        format.setDecimalFormatSymbols(symbols);

        while ((line = fileReader.readLine()) != null) {
            String[] fields = line.split(";");
            DataPoint dataPoint = new DataPoint();

            for (int i = 0; i < fields.length - 1; i++) {
                try {
                    dataPoint.addAttribute(new Attribute(dataPoint.parse(fields[i].trim())));
                } catch (Exception e) {
                    throw new IOException("Formato inválido no campo: " + fields[i]);
                }
            }

            dataPoint.setState(fields[fields.length - 1].trim());
            addDataPoint(dataPoint);
        }
    }
}

@Override
public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("Atributos: ");
    for (String name : attributeNames) {
        builder.append(name).append(", ");
    }
    builder.append("\nNome do Estado: ").append(stateName).append("\nData Points:\n");
    for (DataPoint dataPoint : dataPoints) {
        builder.append(dataPoint).append("\n");
    }
    return builder.toString();
}
}