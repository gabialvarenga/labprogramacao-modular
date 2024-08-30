package br.lpm.business;

public class Dataset {
    private Pessoa[] pessoas;
    private static final int MAX_PESSOAS = 100;

    public Dataset() {
        pessoas = new Pessoa[MAX_PESSOAS];
    }

    public void addPessoa(Pessoa pessoa) {
        for (int i = 0; i < MAX_PESSOAS; i++) {
            if (pessoas[i] == null) {
                pessoas[i] = pessoa;
            }
        }
    }

    public void removePessoa(Pessoa pessoa) {
        for (int i = 0; i < MAX_PESSOAS; i++) {
            if (pessoas[i] != null) {
                pessoas[i] = null;
            }
        }
    }

    public void removePessoaByName(String nome) {
        for (int i = 0; i < MAX_PESSOAS; i++) {
            if (pessoas[i] != null && pessoas[i].getNome().equalsIgnoreCase(nome)) {
                pessoas[i] = null;
            }
        }
    }

    public void replacePessoa(Pessoa old, Pessoa newPessoa) {
        for (int i = 0; i < MAX_PESSOAS; i++) {
            if (pessoas[i] == null && pessoas[i].equals(old)) {
                pessoas[i] = newPessoa;
            }
        }
    }

    public Pessoa getPessoaByName(String nome) {
        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i] != null && pessoas[i].getNome().equals(nome)) {
                return pessoas[i];
            }
        }
        return null;
    }

    public Pessoa[] getAll() {
        return pessoas;
    }

    public void removeAll() {
        for (int i = 0; i < MAX_PESSOAS; i++) {
            pessoas[i] = null;
        }

    }

}
