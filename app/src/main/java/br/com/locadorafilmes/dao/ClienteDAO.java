package br.com.locadorafilmes.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.locadorafilmes.DB.DBHelper;
import br.com.locadorafilmes.models.Cliente;

public class ClienteDAO
{
    private String TAG = ClienteDAO.class.getName();
    private DBHelper dbHelper;

    public ClienteDAO(Context context)
    {
        dbHelper = DBHelper.getInstance(context);
    }

    public void inserirCliente(Cliente cliente) throws SQLException
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.beginTransaction();

        ContentValues values = new ContentValues();
        values.put(DBHelper.Cliente.COLUMN_NOME, cliente.getNome());
        values.put(DBHelper.Cliente.COLUMN_ENDERECO, cliente.getEndereco());
        values.put(DBHelper.Cliente.COLUMN_TELEFONE, cliente.getTelefone());

        db.insertOrThrow(DBHelper.Cliente.TABLE_CLIENTE, null, values);
        db.setTransactionSuccessful();
        db.endTransaction();
    }

    public List<Cliente> listTodosClientes() throws SQLException {
        String sql = "SELECT * FROM " + DBHelper.Funcionario.TABLE_FUNCIONARIO;

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        List<Cliente> clientes = null;
        if (cursor.moveToFirst())
        {
            clientes = new ArrayList<>();
            do
            {
                Cliente cliente = new Cliente();
                cliente.setId(cursor.getInt(cursor.getColumnIndex(DBHelper.Cliente.COLUMN_ID)));
                cliente.setNome(cursor.getString(cursor.getColumnIndex(DBHelper.Cliente.COLUMN_NOME)));
                cliente.setEndereco(cursor.getString(cursor.getColumnIndex(DBHelper.Cliente.COLUMN_ENDERECO)));
                cliente.setTelefone(cursor.getString(cursor.getColumnIndex(DBHelper.Cliente.COLUMN_TELEFONE)));

                clientes.add(cliente);
            } while(cursor.moveToNext());
        }

        return clientes;
    }
}
