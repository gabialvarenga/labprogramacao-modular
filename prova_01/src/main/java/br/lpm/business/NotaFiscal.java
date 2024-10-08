package br.lpm.business;

public class NotaFiscal {
    private static int contador = 0;
    private int numero;
    private String cliente;
    private Automovel[] automoveis = new Automovel[10];
    private Peca[] pecas = new Peca[10];
    private Servico[] servicos = new Servico[10];
    private int numAutomoveis = 0, numPecas = 0, numServicos = 0;

    public NotaFiscal(String cliente) {
        this.numero = contador++;
        this.cliente = cliente;

    }

    public void addAutomovel(Automovel a) {
        if (numAutomoveis < automoveis.length) {
            automoveis[numAutomoveis++] = a;
        }
    }

    public void addServico(Servico s) {
        if (numServicos < servicos.length) {
            servicos[numServicos++] = s;
        }
    }

    public void addPeca(Peca p) {
        if (numPecas < pecas.length) {
            pecas[numPecas++] = p;
        }
    }

    public double calcularTotal() {
        double total = 0;
        for(int i = 0; i < numAutomoveis ; i++){
            total += 1000;
        } 

        for(int i = 0; i < numPecas ; i++){
            if(pecas[i].isNova()){
                total += 500;
            } else {
                total += 250;
            }
        } 

        for(int i = 0; i < numServicos ; i++){
            total += servicos[i].getHorasTrabalhadas()*100;
        } 
        return total;
    }

    public void exibirNota(){
        System.out.println("Número da nota fiscal: " + numero);
        System.out.println("/nNome do cliente: " + cliente);

        
        System.out.println("/nAutomóveis: ");
        for(int i=0;i<numAutomoveis;i++){
            System.out.println(automoveis[i].toString());
        }

        System.out.println("/nPeças: ");
        for(int i=0;i<numPecas;i++){
            System.out.println(pecas[i].toString());
        }

        System.out.println("/nServiços: ");
        for(int i=0;i<numServicos; i++){
            System.out.println(servicos[i].toString());
        }

        System.out.println("/nTotal: " + calcularTotal());
    }

    public int getNumAutomoveis() {
        return numAutomoveis;
    }


    public int getNumPecas() {
        return numPecas;
    }


    public int getNumServicos() {
        return numServicos;
    }
    
}
