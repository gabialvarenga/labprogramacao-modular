package br.lpm.main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import javax.swing.JOptionPane;

import br.lpm.business.Escolaridade;
import br.lpm.business.EstadoCivil;
import br.lpm.business.Genero;
import br.lpm.business.Hobby;
import br.lpm.business.Moradia;
import br.lpm.business.Pessoa;

public class App {

    public static final int TAM_VETOR = 100;
    public static Pessoa[] vect = new Pessoa[TAM_VETOR];

    public static void main(String[] args) throws Exception {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("-------------Cadastro de pessoas-------------");
        Pessoa pessoa = new Pessoa();

        for (int i = 0; i < TAM_VETOR; i++) {
            String valor;
            
            System.out.print("Nome: ");
            pessoa.setNome(sc.nextLine());

            valor = JOptionPane.showInputDialog("Nome: ");
            if (valor !=null){
                pessoa.setNome(valor);
            } 

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            valor = JOptionPane.showInputDialog("Data de nascimento (dd/MM/yyyy):");
            if (valor != null) {
                LocalDate dataNascimento = LocalDate.parse(valor, formatter);
                pessoa.setDataNascimento(dataNascimento);
            }

            valor = JOptionPane.showInputDialog("Gênero (MASCULINO, FEMININO, NAO_BINARIO, NAO_RESPONDER):");
            if (valor !=null){
                pessoa.setGenero(Genero.valueOf(valor.trim().toUpperCase()));
            } 

            valor = JOptionPane.showInputDialog("Altura: ");
            float altura = Float.parseFloat(valor);
            if (valor !=null){
                pessoa.setAltura(altura);
            }

            valor = JOptionPane.showInputDialog("Peso: ");
            int peso = Integer.parseInt(valor);
            if (valor !=null){
                pessoa.setPeso(peso);
            }

            valor = JOptionPane.showInputDialog("Renda: ");
            float renda = Float.parseFloat(valor);
            if (valor !=null){
                pessoa.setRenda(renda);
            }

            sc.nextLine();  

            valor = JOptionPane.showInputDialog("Naturalidade: ");
            if (valor !=null){
                pessoa.setNaturalidade(valor);
            } 

            valor = JOptionPane.showInputDialog("Hobby(ARTE, ESPORTE, CINEMA, LIVRO, MÚSICA, CULINÁRIA, GAME, NENHUMA): )");
            if (valor !=null){
                pessoa.setHobby(Hobby.valueOf(sc.nextLine().toUpperCase()));
            } 

            valor = JOptionPane.showInputDialog("Estado civil(SOLTEIRO, CASADO, VIUVO, SEPARADO, DIVORCIADO: ");
            if (valor !=null){
                pessoa.setEstadoCivil(EstadoCivil.valueOf(sc.nextLine().toUpperCase()));
            }

            valor = JOptionPane.showInputDialog("Grau de escolaridade(NENHUMA, FUNDAMENTAL, MEDIO, SUPERIOR, POS_GRADUACAO): ");
            if (valor !=null){
                pessoa.setEscolaridade(Escolaridade.valueOf(sc.nextLine().toUpperCase()));
            }

            valor = JOptionPane.showInputDialog("Feliz (true/false): ");
            boolean feliz = Boolean.parseBoolean(valor);
            if (valor !=null){
                pessoa.setFeliz(feliz);
            }

            sc.nextLine();  

            valor = JOptionPane.showInputDialog("Moradia(COM_FAMILIA, ALUGUEL, CASA_PROPRIA): ");
            if (valor !=null){
                pessoa.setMoradia(Moradia.valueOf(sc.nextLine().toUpperCase()));
            }

            vect[i] = pessoa;
        }

        JOptionPane.showMessageDialog(null, pessoa.toString());

        sc.close();
    }}
