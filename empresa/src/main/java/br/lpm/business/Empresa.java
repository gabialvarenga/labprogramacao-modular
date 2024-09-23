package br.lpm.business;

public class Empresa {
    private Cliente[] clientes = new Cliente[10];
    private Funcionario[] funcionarios = new Funcionario[10];
    private Funcionario presidente;
    private int numClientes = 0, numFuncionarios = 0;

    // Métodos de acesso (getters e setters)
    public Cliente[] getClientes() {
        return clientes;
    }

    public void setClientes(Cliente[] clientes) {
        this.clientes = clientes;
    }

    public Funcionario[] getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(Funcionario[] funcionarios) {
        this.funcionarios = funcionarios;
    }

    public Funcionario getPresidente() {
        return presidente;
    }

    public void setPresidente(Funcionario presidente) {
        this.presidente = presidente;
    }

    // Métodos para adicionar clientes e funcionários
    public void addCliente(Cliente cliente) {
        if (numClientes < clientes.length) {
            clientes[numClientes++] = cliente;
        }
    }

    public void addFuncionario(Funcionario funcionario) {
        if (numFuncionarios < funcionarios.length) {
            funcionarios[numFuncionarios++] = funcionario;
        }
    }

    // Método para retornar um funcionário específico pelo índice
    public Funcionario getFuncionario(int index) {
        if (index >= 0 && index < numFuncionarios) {
            return funcionarios[index];
        }
        return null; // ou lançar uma exceção se o índice estiver fora do limite
    }

    // Método para retornar um cliente específico pelo índice
    public Cliente getCliente(int index) {
        if (index >= 0 && index < numClientes) {
            return clientes[index];
        }
        return null; // ou lançar uma exceção se o índice estiver fora do limite
    }
}
