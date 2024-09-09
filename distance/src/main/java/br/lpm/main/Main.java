package br.lpm.main;

import br.lpm.business.Dataset;
import br.lpm.business.Escolaridade;
import br.lpm.business.EstadoCivil;
import br.lpm.business.Genero;
import br.lpm.business.Hobby;
import br.lpm.business.Moradia;
import br.lpm.business.Pessoa;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class Main {

    public static Dataset dataset = new Dataset();

    public static void main(String[] args) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        while (true) {
            Pessoa pessoa = new Pessoa();
            String valor;

            valor = JOptionPane.showInputDialog("Nome:");
            if (valor != null && !valor.trim().isEmpty()) {
                pessoa.setNome(valor);
            }

            valor = JOptionPane.showInputDialog("Data de nascimento (dd/MM/yyyy):");
            if (valor != null && !valor.trim().isEmpty()) {
                LocalDate dataNascimento = LocalDate.parse(valor, formatter);
                pessoa.setDataNascimento(dataNascimento);
            }

            valor = JOptionPane.showInputDialog("Gênero (MASCULINO, FEMININO, NAO_BINARIO, NAO_RESPONDER):");
            if (valor != null && !valor.trim().isEmpty()) {
                pessoa.setGenero(Genero.valueOf(valor.trim().toUpperCase()));
            }

            valor = JOptionPane.showInputDialog("Altura:");
            if (valor != null && !valor.trim().isEmpty()) {
                pessoa.setAltura(Float.parseFloat(valor));
            }

            valor = JOptionPane.showInputDialog("Peso:");
            if (valor != null && !valor.trim().isEmpty()) {
                pessoa.setPeso(Integer.parseInt(valor));
            }

            valor = JOptionPane.showInputDialog("Renda:");
            if (valor != null && !valor.trim().isEmpty()) {
                pessoa.setRenda(Float.parseFloat(valor));
            }

            valor = JOptionPane.showInputDialog("Naturalidade:");
            if (valor != null && !valor.trim().isEmpty()) {
                pessoa.setNaturalidade(valor);
            }

            valor = JOptionPane
                    .showInputDialog("Hobby (ARTE, ESPORTE, CINEMA, LIVRO, MÚSICA, CULINÁRIA, GAME, NENHUMA):");
            if (valor != null && !valor.trim().isEmpty()) {
                pessoa.setHobby(Hobby.valueOf(valor.trim().toUpperCase()));
            }

            valor = JOptionPane.showInputDialog("Estado civil (SOLTEIRO, CASADO, VIUVO, SEPARADO, DIVORCIADO):");
            if (valor != null && !valor.trim().isEmpty()) {
                pessoa.setEstadoCivil(EstadoCivil.valueOf(valor.trim().toUpperCase()));
            }

            valor = JOptionPane
                    .showInputDialog("Grau de escolaridade (NENHUMA, FUNDAMENTAL, MEDIO, SUPERIOR, POS_GRADUACAO):");
            if (valor != null && !valor.trim().isEmpty()) {
                pessoa.setEscolaridade(Escolaridade.valueOf(valor.trim().toUpperCase()));
            }

            valor = JOptionPane.showInputDialog("Feliz (true/false):");
            if (valor != null && !valor.trim().isEmpty()) {
                pessoa.setFeliz(Boolean.parseBoolean(valor));
            }

            valor = JOptionPane.showInputDialog("Moradia (COM_FAMILIA, ALUGUEL, CASA_PROPRIA):");
            if (valor != null && !valor.trim().isEmpty()) {
                pessoa.setMoradia(Moradia.valueOf(valor.trim().toUpperCase()));
            }

            dataset.addPessoa(pessoa);

            JOptionPane.showMessageDialog(null, pessoa.toString());

            int continuarCadastro = JOptionPane.showConfirmDialog(null, "Deseja cadastrar outra pessoa?", "Continuar?",
                    JOptionPane.YES_NO_OPTION);
            if (continuarCadastro == JOptionPane.NO_OPTION) {
                break;
            }
        }

        Pessoa ultimaPessoaCadastrada = dataset.getAll()[dataset.getAll().length - 1];

        Pessoa[] similares = dataset.getSimilar(ultimaPessoaCadastrada, 3);

        String resultado = "As 3 pessoas mais similares:\n";
        for (Pessoa p : similares) {
            resultado += p.toString() + "\n";
        }

        JOptionPane.showMessageDialog(null, resultado);

        histogramFormacaoAcademica();
        pieProfissao();
    }

    public static void histogramFormacaoAcademica() {
        int[] frequencias = new int[Escolaridade.values().length];
        Pessoa[] pessoas = dataset.getAll();

        for (int i = 0; i < pessoas.length; i++) {
            Escolaridade escolaridade = pessoas[i].getEscolaridade();
            if (escolaridade != null) {
                switch (escolaridade) {
                    case NENHUMA:
                        frequencias[0]++;
                        break;
                    case FUNDAMENTAL:
                        frequencias[1]++;
                        break;
                    case MEDIO:
                        frequencias[2]++;
                        break;
                    case SUPERIOR:
                        frequencias[3]++;
                        break;
                    case POS_GRADUACAO:
                        frequencias[4]++;
                        break;
                }
            }
        }

        DefaultCategoryDataset datasetGrafico = new DefaultCategoryDataset();

        for (int i = 0; i < Escolaridade.values().length; i++) {
            Escolaridade escolaridade = Escolaridade.values()[i];
            datasetGrafico.addValue(frequencias[i], "Formação Acadêmica", escolaridade.name());
        }

        JFreeChart graficoJFree = ChartFactory.createBarChart(
                "Distribuição das Formações Acadêmicas",
                "Escolaridade",
                "Quantidade de pesoas",
                datasetGrafico,
                PlotOrientation.VERTICAL,
                true,
                true,
                false);

        ChartPanel painelDeDados = new ChartPanel(graficoJFree);
        painelDeDados.setPreferredSize(new java.awt.Dimension(800, 600));

        JFrame telaGrafico = new JFrame("Histograma de Formação Acadêmica");
        telaGrafico.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        telaGrafico.add(painelDeDados);
        telaGrafico.pack();
        telaGrafico.setVisible(true);
    }

    public static void pieProfissao() {
        DefaultPieDataset<String> datasetGraficoPie = new DefaultPieDataset<>();
        datasetGraficoPie.setValue("Solteiro", dataset.percentEstadoCivil(EstadoCivil.SOLTEIRO));
        datasetGraficoPie.setValue("Casado", dataset.percentEstadoCivil(EstadoCivil.CASADO));
        datasetGraficoPie.setValue("Divorciado", dataset.percentEstadoCivil(EstadoCivil.DIVORCIADO));
        datasetGraficoPie.setValue("Viúvo", dataset.percentEstadoCivil(EstadoCivil.VIUVO));
        datasetGraficoPie.setValue("Separado", dataset.percentEstadoCivil(EstadoCivil.SEPARADO));

        JFreeChart graficoPieChart = ChartFactory.createPieChart(
                "Distribuição do Estado Civil",
                datasetGraficoPie,
                true,
                true,
                false);

        ChartPanel painelDeDados = new ChartPanel(graficoPieChart);
        painelDeDados.setPreferredSize(new java.awt.Dimension(800, 600));

        JFrame telaGrafico = new JFrame("Gráfico - Estado Civil");
        telaGrafico.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        telaGrafico.add(painelDeDados);
        telaGrafico.pack();
        telaGrafico.setVisible(true);

    }

}