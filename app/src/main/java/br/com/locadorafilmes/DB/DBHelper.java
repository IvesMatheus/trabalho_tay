package br.com.locadorafilmes.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static final String TAG = DBHelper.class.getName();
    private static final String DATABASE_NAME = "TaynahLOCDB";
    private static final int DATABASE_VERSION = 1;

    private static DBHelper mDbHelper;


    public static synchronized DBHelper getInstance(Context context) {
        if (mDbHelper == null) {
            mDbHelper = new DBHelper(context.getApplicationContext());
        }
        return mDbHelper;
    }

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USERDETAIL_TABLE = "CREATE TABLE " + Funcionario.TABLE_FUNCIONARIO +
                "(" +
                Funcionario.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                Funcionario.COLUMN_NOME + " TEXT," +
                Funcionario.COLUMN_LOGIN + " TEXT," +
                Funcionario.COLUMN_SENHA + " TEXT," +
                ")";
        db.execSQL(CREATE_USERDETAIL_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Funcionario.TABLE_FUNCIONARIO);

        onCreate(db);
    }

    public static class Funcionario
    {
        public static final String TABLE_FUNCIONARIO = "funcionario";

        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_NOME = "nome";
        public static final String COLUMN_LOGIN = "login";
        public static final String COLUMN_SENHA = "senha";
    }

}
