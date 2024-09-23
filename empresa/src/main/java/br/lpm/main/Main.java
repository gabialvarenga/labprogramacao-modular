package br.lpm.main;

import br.lpm.business.Cliente;
import br.lpm.business.Empresa;
import br.lpm.business.Funcionario;
import br.lpm.business.PF; 
import br.lpm.business.PJ;

public class Main {
    public static void main(String[] args) {
            // Criando uma empresa
            Empresa empresa = new Empresa();
        
            // Criando uma pessoa física (PF)
            PF joao = new PF("João", "Av. Rios, 121", "Diadema", "SP", "11222-333", "(11) 1234-5678", "443434533553");
            
            // Criando uma pessoa jurídica (PJ)
            PJ empresaX = new PJ("Empresa X", "Rua das Flores, 456", "(11) 9876-5432", "22333-444", "São Paulo", "SP", "12.345.678/0001-90");
        
            // Exibindo dados de João
            System.out.println("Dados de João (Pessoa Física):");
            System.out.println(joao);
            
            // Exibindo dados da Empresa X
            System.out.println("\nDados da Empresa X (Pessoa Jurídica):");
            System.out.println(empresaX);
        
            // Adicionando João como funcionário e cliente
            Funcionario funcionarioJoao = new Funcionario(joao, "Operário", 32000);
            Cliente clienteJoao = new Cliente(joao, 50000);
            Cliente clienteEmpresaX = new Cliente(empresaX, 100000); // Cliente como PJ
        
            empresa.addFuncionario(funcionarioJoao);
            empresa.addCliente(clienteJoao);
            empresa.addCliente(clienteEmpresaX); // Adicionando Empresa X como cliente
        
            // Exibindo o primeiro funcionário e cliente adicionados
            System.out.println("\nPrimeiro funcionário adicionado:");
            System.out.println(empresa.getFuncionario(0)); // Funcionario João
        
            System.out.println("\nPrimeiro cliente adicionado:");
            System.out.println(empresa.getCliente(0));     // Cliente João
        
            System.out.println("\nSegundo cliente adicionado:");
            System.out.println(empresa.getCliente(1));     // Cliente Empresa X
        
            // Alterando o telefone de João e verificando a atualização nos dados
            System.out.println("\nAlterando telefone de João para (31) 97733-8899...");
            empresa.getFuncionario(0).getDados().setTelefone("(31) 97733-8899");
        
            // Exibindo os dados novamente após a alteração
            System.out.println("\nDados do funcionário João após alteração de telefone:");
            System.out.println(empresa.getFuncionario(0)); // Funcionario João com telefone alterado
        
            System.out.println("\nDados do cliente João após alteração de telefone:");
            System.out.println(empresa.getCliente(0));     // Cliente João (reflete as mudanças)
        
            // Exibindo os dados da empresa X
            System.out.println("\nDados da Empresa X como cliente:");
            System.out.println(empresa.getCliente(1));     // Cliente Empresa X
        
            // Definindo João como o presidente da empresa
            empresa.setPresidente(empresa.getFuncionario(0));
        
            // Exibindo o presidente da empresa
            System.out.println("\nPresidente da Empresa: ");
            System.out.println(empresa.getPresidente()); 
    }
}    