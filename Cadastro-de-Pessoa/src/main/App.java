package main;

import bussines.Pessoa;


public class App {
   // public static Pessoa[] pessoas = new Pessoa[10];
    public static void main(String[] args) throws Exception {
        Pessoa pessoa = new Pessoa();
        System.out.println("Cadastro de pessoas ");
        pessoa.setNome("Gabriela Alvarenga");
        
       // pessoas[0] = pessoa;

        System.out.println("Nome: " + pessoa.getNome());
        
    }
}
