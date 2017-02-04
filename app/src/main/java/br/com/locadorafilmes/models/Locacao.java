package br.com.locadorafilmes.models;

import android.location.Location;

/**
 * Created by ives on 04/02/17.
 */

public class Locacao
{
    private int id;
    private Funcionario funcionario;
    private Cliente cliente;
    private String data_loc;
    private String data_dev;
    private float valor_total;

    public Locacao(int id, Funcionario funcionario, Cliente cliente, String data_dev, String data_loc, float valor_total)
    {
        this.id = id;
        this.funcionario = funcionario;
        this.cliente = cliente;
        this.data_dev = data_dev;
        this.data_loc = data_loc;
        this.valor_total = valor_total;
    }

    public Locacao()
    {
        this(-1, new Funcionario(), new Cliente(), "", "", 0.0f);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getData_loc() {
        return data_loc;
    }

    public void setData_loc(String data_loc) {
        this.data_loc = data_loc;
    }

    public String getData_dev() {
        return data_dev;
    }

    public void setData_dev(String data_dev) {
        this.data_dev = data_dev;
    }

    public float getValor_total() {
        return valor_total;
    }

    public void setValor_total(float valor_total) {
        this.valor_total = valor_total;
    }
}
