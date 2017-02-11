package br.com.locadorafilmes.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static final String TAG = DBHelper.class.getName();
    private static final String DATABASE_NAME = "TaynahLOCDB";
    private static final int DATABASE_VERSION = 7;

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
        String CREATE_FUNCIONARIO_TABLE = "CREATE TABLE " + Funcionario.TABLE_FUNCIONARIO +
                "(" +
                Funcionario.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                Funcionario.COLUMN_NOME + " TEXT," +
                Funcionario.COLUMN_LOGIN + " TEXT," +
                Funcionario.COLUMN_SENHA + " TEXT" +
                ")";

        String CREATE_CLIENTE_TABLE = "CREATE TABLE " + Cliente.TABLE_CLIENTE +
                "(" +
                Cliente.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                Cliente.COLUMN_NOME + " TEXT," +
                Cliente.COLUMN_TELEFONE + " TEXT," +
                Cliente.COLUMN_ENDERECO + " TEXT" +
                ")";

        String CREATE_TITULO_TABLE = "CREATE TABLE " + Titulo.TABLE_TITULO +
                "(" +
                Titulo.COLUMN_ISBN + " TEXT PRIMARY KEY," +
                Titulo.COLUMN_ANO + " INTEGER," +
                Titulo.COLUMN_DESCRICAO + " TEXT," +
                Titulo.COLUMN_EXEMPLARES + " INTEGER," +
                Titulo.COLUMN_NOME + " TEXT," +
                Titulo.COLUMN_TIPO + " TEXT" +
                ")";

        String CREATE_EXEMPLAR_TABLE = "CREATE TABLE " + Exemplar.TABLE_EXEMPLAR +
                "(" +
                Exemplar.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                Exemplar.COLUMN_ID_TITULO + " TEXT," +
                Exemplar.COLUMN_SITUACAO + " TEXT" +
                ")";

        db.execSQL(CREATE_FUNCIONARIO_TABLE);
        db.execSQL(CREATE_CLIENTE_TABLE);
        db.execSQL(CREATE_TITULO_TABLE);
        db.execSQL(CREATE_EXEMPLAR_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Funcionario.TABLE_FUNCIONARIO);
        db.execSQL("DROP TABLE IF EXISTS " + Cliente.TABLE_CLIENTE);
        db.execSQL("DROP TABLE IF EXISTS " + Titulo.TABLE_TITULO);
        db.execSQL("DROP TABLE IF EXISTS " + Exemplar.TABLE_EXEMPLAR);

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

    public static class Cliente
    {
        public static final String TABLE_CLIENTE = "cliente";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_NOME = "nome";
        public static final String COLUMN_ENDERECO = "endereco";
        public static final String COLUMN_TELEFONE = "telefone";
    }

    public static class Titulo
    {
        public static final String TABLE_TITULO =  "titulo";
        public static final String COLUMN_ISBN = "isbn";
        public static final String COLUMN_NOME = "nome";
        public static final String COLUMN_ANO = "ano";
        public static final String COLUMN_EXEMPLARES = "exemplares";
        public static final String COLUMN_DESCRICAO = "descricao";
        public static final String COLUMN_TIPO = "tipo";
    }

    public static class Exemplar
    {
        public static final String TABLE_EXEMPLAR = "exemplar";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_ID_TITULO = "id_titulo";
        public static final String COLUMN_SITUACAO = "situacao";
    }
}
