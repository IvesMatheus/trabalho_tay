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
import br.com.locadorafilmes.models.Exemplar;
import br.com.locadorafilmes.models.Titulo;

/**
 * Created by ives on 10/02/17.
 */

public class ExemplarDAO
{
    private String TAG = ExemplarDAO.class.getName();
    private DBHelper dbHelper;

    public ExemplarDAO(Context context)
    {
        dbHelper = DBHelper.getInstance(context);
    }

    public void inserirExemplar(Exemplar exemplar) throws SQLException
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.beginTransaction();

        ContentValues values = new ContentValues();
        values.put(DBHelper.Exemplar.COLUMN_ID_TITULO, exemplar.getTitulo().getIsbn());
        values.put(DBHelper.Exemplar.COLUMN_SITUACAO, exemplar.getSituacao());

        db.insertOrThrow(DBHelper.Exemplar.TABLE_EXEMPLAR, null, values);
        db.setTransactionSuccessful();
        db.endTransaction();
    }

    public List<Titulo> listTodosTitulos() throws SQLException {
        String sql = "SELECT * FROM " + DBHelper.Titulo.TABLE_TITULO;

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        List<Titulo> clientes = null;
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

                //clientes.add(cliente);
            } while(cursor.moveToNext());
        }

        return null;
    }
}
