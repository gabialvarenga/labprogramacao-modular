package main;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import business.Escolaridade;
import business.EstadoCivil;
import business.Genero;
import business.Hobby;
import business.Moradia;
import business.Pessoa;

 

public class App {

    public static final int TAM_VETOR = 100;
    public static Pessoa[] vect = new Pessoa[TAM_VETOR];

    public static void main(String[] args) throws Exception {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("-------------Cadastro de pessoas-------------");
        

        for (int i = 0; i < TAM_VETOR; i++) {
            System.out.print("Deseja continuar com o cadastro? (S/N): ");
            String continuar = sc.nextLine().trim().toUpperCase();

            if (continuar.equals("N")) {
                System.out.println("Cadastro finalizado. Você cadastrou " + i + " pessoa(s).");
                break;
            }

            Pessoa pessoa = new Pessoa();

            System.out.println("Cadastro n°" + (i + 1) + ":");
            

            System.out.print("Nome: ");
            pessoa.setNome(sc.nextLine());

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            System.out.print("Data de nascimento (dd/MM/yyyy): ");
            String dataNascimentoStr = sc.nextLine();

            LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr, formatter);
            pessoa.setDataNascimento(dataNascimento);


            System.out.print("Gênero (MASCULINO, FEMININO, NAO_BINARIO, NAO_RESPONDER): ");
            pessoa.setGenero(Genero.valueOf(sc.nextLine().toUpperCase()));

            System.out.print("Altura: ");
            pessoa.setAltura(sc.nextFloat());

            System.out.print("Peso: ");
            pessoa.setPeso(sc.nextInt());

            System.out.print("Renda: ");
            pessoa.setRenda(sc.nextFloat());

            sc.nextLine();  

            System.out.print("Naturalidade: ");
            pessoa.setNaturalidade(sc.nextLine());

            System.out.print("Hobby(ARTE, ESPORTE, CINEMA, LIVRO, MÚSICA, CULINÁRIA, GAME, NENHUMA): ");
            pessoa.setHobby(Hobby.valueOf(sc.nextLine().toUpperCase()));

            System.out.print("Estado civil(SOLTEIRO, CASADO, VIUVO, SEPARADO, DIVORCIADO: ");
            pessoa.setEstadoCivil(EstadoCivil.valueOf(sc.nextLine().toUpperCase()));

            System.out.print("Grau de escolaridade(NENHUMA, FUNDAMENTAL, MEDIO, SUPERIOR, POS_GRADUACAO): ");
            pessoa.setEscolaridade(Escolaridade.valueOf(sc.nextLine().toUpperCase()));

            System.out.print("Feliz (true/false): ");
            pessoa.setFeliz((sc.nextBoolean()));

            sc.nextLine();  

            System.out.print("Moradia(COM_FAMILIA, ALUGUEL, CASA_PROPRIA): ");
            pessoa.setMoradia(Moradia.valueOf(sc.nextLine().toUpperCase()));

            vect[i] = pessoa;

            System.out.println("Cadastro da pessoa n°" + (i + 1) + " com sucesso!");
        }
        sc.close();
    }
}
