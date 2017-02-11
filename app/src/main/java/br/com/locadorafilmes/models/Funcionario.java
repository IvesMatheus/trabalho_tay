package br.com.locadorafilmes.models;

import java.io.Serializable;

/**
 * Created by ives on 04/02/17.
 */

public class Funcionario implements Serializable
{
    private int id;
    private String nome;
    private String login;
    private String senha;

    public Funcionario(int id, String nome, String login, String senha)
    {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.login = login;
    }

    public Funcionario(String nome, String login, String senha)
    {
        this(0, nome, login, senha);
    }

    public Funcionario()
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
