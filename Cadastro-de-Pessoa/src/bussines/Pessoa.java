package bussines;

public class Pessoa {
    String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
       if ((!nome.matches("[a-zA-Z ]*"))){
        throw new IllegalArgumentException("Nome deve conter apenas letras e espaços");
        }  else {
         this.nome = nome;
    }
}

}
