package br.com.locadorafilmes.activitys;

import android.database.SQLException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.com.locadorafilmes.R;
import br.com.locadorafilmes.dao.ExemplarDAO;
import br.com.locadorafilmes.dao.TituloDAO;
import br.com.locadorafilmes.models.Exemplar;
import br.com.locadorafilmes.models.Titulo;

public class AddTituloActivity extends AppCompatActivity {
    private EditText edtISBN;
    private EditText edtNome;
    private EditText edtDescricao;
    private EditText edtAno;
    private EditText edtExemplares;
    private EditText edtTipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_titulo);

        setLayout();
    }

    private void setLayout() {
        setTitle("Inserir Título");

        edtAno = (EditText) findViewById(R.id.edtAno);
        edtNome = (EditText) findViewById(R.id.edtNomeTitulo);
        edtDescricao = (EditText) findViewById(R.id.edtDescricao);
        edtExemplares = (EditText) findViewById(R.id.edtExemplares);
        edtISBN = (EditText) findViewById(R.id.edtISBN);
        edtTipo = (EditText) findViewById(R.id.edtTipo);
    }

    public void cancelarAddTitulo_onClick(View view) {
        finish();
    }

    public void addTitulo_onClick(View view)
    {
        if(!edtISBN.getText().toString().equals("")
                && !edtTipo.getText().toString().equals("")
                && !edtExemplares.getText().toString().equals("")
                && !edtDescricao.getText().toString().equals("")
                && !edtAno.getText().toString().equals("")
                && !edtNome.getText().toString().equals("")) {
            Titulo titulo = new Titulo(edtNome.getText().toString(), edtISBN.getText().toString(), Integer.valueOf(edtAno.getText().toString()), Integer.valueOf(edtExemplares.getText().toString()), edtDescricao.getText().toString(), edtTipo.getText().toString(), "");

            TituloDAO tituloDAO = new TituloDAO(getApplicationContext());

            try
            {
                tituloDAO.inserirTitulo(titulo);

                ExemplarDAO exemplarDAO = new ExemplarDAO(getApplicationContext());
                for(int i = 0; i < titulo.getExemplares(); i++)
                {
                    exemplarDAO.inserirExemplar(new Exemplar(0, "A", titulo));
                }

                Toast.makeText(getApplicationContext(), "Título " + titulo.getNomeTitulo() + " inserido com sucesso", Toast.LENGTH_SHORT).show();
            }
            catch (SQLException e)
            {
                Log.e("AddTituloActivity", "Não foi possível inserir novo título " + e.getMessage());
                Toast.makeText(getApplicationContext(), "Não foi possível inserir novo título", Toast.LENGTH_SHORT).show();
            }
            finally {
                finish();
            }
        }
    }
}
