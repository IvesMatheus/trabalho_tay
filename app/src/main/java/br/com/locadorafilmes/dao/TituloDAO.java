package br.com.locadorafilmes.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.locadorafilmes.DB.DBHelper;
import br.com.locadorafilmes.models.Titulo;

/**
 * Created by ives on 10/02/17.
 */

public class TituloDAO
{
    private String TAG = TituloDAO.class.getName();
    private DBHelper dbHelper;

    public TituloDAO(Context context)
    {
        dbHelper = DBHelper.getInstance(context);
    }

    public void inserirTitulo(Titulo titulo) throws SQLException
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.beginTransaction();

        ContentValues values = new ContentValues();
        values.put(DBHelper.Titulo.COLUMN_ISBN, titulo.getIsbn());
        values.put(DBHelper.Titulo.COLUMN_ANO, titulo.getAno());
        values.put(DBHelper.Titulo.COLUMN_DESCRICAO, titulo.getDescricao());
        values.put(DBHelper.Titulo.COLUMN_EXEMPLARES, titulo.getExemplares());
        values.put(DBHelper.Titulo.COLUMN_NOME, titulo.getNomeTitulo());
        values.put(DBHelper.Titulo.COLUMN_TIPO, titulo.getTipo());

        db.insertOrThrow(DBHelper.Titulo.TABLE_TITULO, null, values);
        db.setTransactionSuccessful();
        db.endTransaction();
    }

    public List<Titulo> listTodosTitulos() throws SQLException {
        String sql = "SELECT * FROM " + DBHelper.Titulo.TABLE_TITULO + " LEFT JOIN " + DBHelper.Exemplar.TABLE_EXEMPLAR
                + " ON " + DBHelper.Exemplar.COLUMN_ID_TITULO + " = " + DBHelper.Titulo.COLUMN_ISBN
                + " WHERE " + DBHelper.Exemplar.TABLE_EXEMPLAR + "." + DBHelper.Exemplar.COLUMN_SITUACAO + " = 'A'";

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        List<Titulo> titulos = null;
        if (cursor.moveToFirst())
        {
            titulos = new ArrayList<>();
            do
            {
                Titulo titulo = new Titulo();
                titulo.setAno(cursor.getInt(cursor.getColumnIndex(DBHelper.Titulo.COLUMN_ANO)));
                titulo.setDescricao(cursor.getString(cursor.getColumnIndex(DBHelper.Titulo.COLUMN_DESCRICAO)));
                titulo.setExemplares(cursor.getInt(cursor.getColumnIndex(DBHelper.Titulo.COLUMN_EXEMPLARES)));

                titulo.setIsbn(cursor.getString(cursor.getColumnIndex(DBHelper.Titulo.COLUMN_ISBN)));
                titulo.setNomeTitulo(cursor.getString(cursor.getColumnIndex(DBHelper.Titulo.COLUMN_NOME)));
                titulo.setTipo(cursor.getString(cursor.getColumnIndex(DBHelper.Titulo.COLUMN_TIPO)));

                if(!titulos.contains(titulo))
                    titulos.add(titulo);
            } while(cursor.moveToNext());
        }

        return titulos;
    }
}
