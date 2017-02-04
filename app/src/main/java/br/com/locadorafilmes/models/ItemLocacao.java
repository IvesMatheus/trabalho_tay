package br.com.locadorafilmes.models;

/**
 * Created by ives on 04/02/17.
 */

public class ItemLocacao
{
    private Locacao locacao;
    private Exemplar exemplar;
    private int qtd;

    public ItemLocacao(Locacao locacao, Exemplar exemplar, int qtd)
    {
        this.locacao = locacao;
        this.exemplar = exemplar;
        this.qtd = qtd;
    }

    public ItemLocacao()
    {
        this(new Locacao(), new Exemplar(), 0);
    }

    public Locacao getLocacao() {
        return locacao;
    }

    public void setLocacao(Locacao locacao) {
        this.locacao = locacao;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
}
