package br.com.locadorafilmes.models;

/**
 * Created by ives on 04/02/17.
 */

public class Titulo
{
    private String nomeTitulo;
    private String isbn;
    private int ano;
    private int exemplares;
    private String descricao;
    private String tipo;
    private int maxloc;

    public Titulo(String nomeTitulo, String isbn, int ano, int exemplares, String descricao, String tipo, int maxloc)
    {
        this.ano = ano;
        this.descricao = descricao;
        this.exemplares = exemplares;
        this.isbn = isbn;
        this.descricao = descricao;
        this.tipo = tipo;
        this.maxloc = maxloc;
    }

    public Titulo()
    {
        this("", "", 0, 0, "", "", 0);
    }

    public String getNomeTitulo() {
        return nomeTitulo;
    }

    public void setNomeTitulo(String nomeTitulo) {
        this.nomeTitulo = nomeTitulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getExemplares() {
        return exemplares;
    }

    public void setExemplares(int exemplares) {
        this.exemplares = exemplares;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getMaxloc() {
        return maxloc;
    }

    public void setMaxloc(int maxloc) {
        this.maxloc = maxloc;
    }
}
