public abstract class ItemServico {
    private String tipo;
    private float custo;
    private int quantidade;
    private String descricao;

    public abstract float calcularCustoTotal();

    public ItemServico(String tipo, float custo, int quantidade, String descricao) {
        this.tipo = tipo;
        this.custo = custo;
        this.quantidade = quantidade;
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public float getCusto() {
        return custo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

}
