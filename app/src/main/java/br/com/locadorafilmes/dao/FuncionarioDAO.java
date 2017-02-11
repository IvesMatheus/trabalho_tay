package br.com.locadorafilmes.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import br.com.locadorafilmes.DB.DBHelper;
import br.com.locadorafilmes.models.Funcionario;

public class FuncionarioDAO
{
    private String TAG = FuncionarioDAO.class.getName();
    private DBHelper dbHelper;

    public FuncionarioDAO(Context context)
    {
        dbHelper = DBHelper.getInstance(context);
    }

    public void inserirFuncionario(Funcionario funcionario) throws SQLException
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.beginTransaction();

        ContentValues values = new ContentValues();
        values.put(DBHelper.Funcionario.COLUMN_LOGIN, funcionario.getLogin());
        values.put(DBHelper.Funcionario.COLUMN_NOME, funcionario.getNome());
        values.put(DBHelper.Funcionario.COLUMN_SENHA, funcionario.getSenha());

        db.insertOrThrow(DBHelper.Funcionario.TABLE_FUNCIONARIO, null, values);
        db.setTransactionSuccessful();
        db.endTransaction();
    }

    public boolean verificaLogin(Funcionario funcionario) throws SQLException
    {
        String sql = "SELECT * FROM " + DBHelper.Funcionario.TABLE_FUNCIONARIO +
                " WHERE " + DBHelper.Funcionario.COLUMN_LOGIN + "= '" + funcionario.getLogin() + "' " +
                " AND " + DBHelper.Funcionario.COLUMN_SENHA + "= '" + funcionario.getSenha() + "'";

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        return cursor.moveToFirst();

    }
}
