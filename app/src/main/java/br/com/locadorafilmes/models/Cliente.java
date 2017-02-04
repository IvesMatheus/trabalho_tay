package br.com.locadorafilmes.models;

/**
 * Created by ives on 04/02/17.
 */

public class Cliente
{
    private int id;
    private String nome;
    private String endereco;
    private String telefone;

    public Cliente(int id, String nome, String endereco, String telefone)
    {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public Cliente()
    {
        this(-1, "", "", "");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
