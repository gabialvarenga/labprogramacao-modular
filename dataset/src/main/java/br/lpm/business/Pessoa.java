package br.lpm.business;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pessoa {
    private String nome;
    private LocalDate dataNascimento;
    private Genero genero;
    private float altura;
    private int peso;
    private float renda;
    private String naturalidade;
    private Hobby hobby;
    private EstadoCivil estadoCivil;
    private Escolaridade escolaridade;
    private boolean feliz;
    private Moradia moradia;

    public Pessoa() {
    }

    public Pessoa(String nome, LocalDate dataNascimento, Genero genero, float altura, int peso, float renda,
            String naturalidade, Hobby hobby, EstadoCivil estadoCivil, Escolaridade escolaridade,
            boolean feliz, Moradia moradia) {
        this.setNome(nome);
        this.setDataNascimento(dataNascimento);
        this.setGenero(genero);
        this.setAltura(altura);
        this.setPeso(peso);
        this.setRenda(renda);
        this.setNaturalidade(naturalidade);
        this.setHobby(hobby);
        this.setEstadoCivil(estadoCivil);
        this.setEscolaridade(escolaridade);
        this.setFeliz(feliz);
        this.setMoradia(moradia);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String novoNome) {
        if (novoNome != null && !novoNome.trim().isEmpty()) {
            boolean nomeAceito = true;

            for (int i = 0; i < novoNome.length(); i++) {
                char caractere = novoNome.charAt(i);
                if (!((caractere >= 'a' && caractere <= 'z') ||
                        (caractere >= 'A' && caractere <= 'Z') ||
                        caractere == ' ')) {
                    nomeAceito = false;
                    break;
                }
            }

            if (nomeAceito) {
                this.nome = novoNome;
            } else {
                System.out.println("O nome fornecido é inválido.");
            }
        }
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        if (dataNascimento != null) {
            LocalDate hoje = LocalDate.now();
            if (dataNascimento.isBefore(hoje)) {
                this.dataNascimento = dataNascimento;
            } else {
                System.out.println("A data de nascimento é inválida.");
            }
        }
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        if (altura > 0 && altura < 2.60) {
            this.altura = altura;
        } else {
            System.out.println("A altura fornecida é inválida.");
        }
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        if (peso > 0 && peso < 600) {
            this.peso = peso;
        } else {
            System.out.println("O peso fornecido é inválido.");
        }
    }

    public float getRenda() {
        return renda;
    }

    public void setRenda(float renda) {
        if (renda >= 0) {
            this.renda = renda;
        } else {
            System.out.println("A renda fornecida é inválida.");
        }
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        if (naturalidade != null && !naturalidade.trim().isEmpty()) {
            boolean naturalidadeValida = true;

            for (int i = 0; i < naturalidade.length(); i++) {
                char caractere = naturalidade.charAt(i);
                if (!((caractere >= 'a' && caractere <= 'z') ||
                        (caractere >= 'A' && caractere <= 'Z') ||
                        caractere == ' ')) {
                    naturalidadeValida = false;
                    break;
                }
            }

            if (naturalidadeValida) {
                this.naturalidade = naturalidade;
            } else {
                System.out.println("A naturalidade fornecida é inválida.");
            }
        }
    }

    public Hobby getHobby() {
        return hobby;
    }

    public void setHobby(Hobby hobby) {
        this.hobby = hobby;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Escolaridade getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(Escolaridade escolaridade) {
        this.escolaridade = escolaridade;
    }

    public boolean isFeliz() {
        return feliz;
    }

    public void setFeliz(boolean feliz) {
        this.feliz = feliz;
    }

    public Moradia getMoradia() {
        return moradia;
    }

    public void setMoradia(Moradia moradia) {
        this.moradia = moradia;
    }

    @Override
    public String toString() {
        return "Pessoa [" +
                "nome=" + (nome != null ? nome : "Não informado") +
                ", dataNascimento="
                + (dataNascimento != null ? dataNascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                        : "Não informada")
                +
                ", genero=" + genero +
                ", altura=" + altura +
                ", peso=" + peso + "kg" +
                ", renda=R$" + renda +
                ", naturalidade=" + (naturalidade != null ? naturalidade : "Não informada") +
                ", hobby=" + hobby +
                ", estadoCivil=" + estadoCivil +
                ", escolaridade=" + escolaridade +
                ", feliz=" + (feliz ? "Sim" : "Não") +
                ", moradia=" + moradia +
                "]";
    }
}
