package br.com.locadorafilmes.models;

/**
 * Created by ives on 04/02/17.
 */

public class Exemplar
{
    private long id;
    private String situacao;
    private Titulo titulo;

    public Exemplar(long id, String situacao, Titulo titulo)
    {
        this.id = id;
        this.situacao = situacao;
        this.titulo = titulo;
    }

    public Exemplar()
    {
        this(-1, "", new Titulo());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Titulo getTitulo() {
        return titulo;
    }

    public void setTitulo(Titulo titulo) {
        this.titulo = titulo;
    }
}
