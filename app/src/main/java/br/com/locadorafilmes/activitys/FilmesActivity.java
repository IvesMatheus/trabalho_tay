package br.com.locadorafilmes.activitys;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.locadorafilmes.R;
import br.com.locadorafilmes.TaynahLOCUtil;
import br.com.locadorafilmes.adapters.TituloAdapter;
import br.com.locadorafilmes.dao.TituloDAO;
import br.com.locadorafilmes.models.Titulo;

public class FilmesActivity extends AppCompatActivity
{

    private ListView lstTitulo;
    private List<Titulo> preLocados = new ArrayList<Titulo>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filmes);

        setLayout();
    }

    private void setLayout()
    {
        TaynahLOCUtil.ocultarTeclado(this);
        lstTitulo = (ListView)findViewById(R.id.lstTitulo);
        List<Titulo> titulos = new ArrayList<>();

        TituloDAO tituloDAO = new TituloDAO(getApplicationContext());
        titulos = tituloDAO.listTodosTitulos();

        TituloAdapter tituloAdapter = new TituloAdapter(getApplicationContext(), titulos, new TituloAdapter.TituloAdapterListener() {
            @Override
            public void marcar(Titulo titulo) {
                if(!preLocados.contains(titulo))
                    preLocados.add(titulo);
            }

            @Override
            public void desmarcar(Titulo titulo) {
                if(preLocados.contains(titulo))
                    preLocados.remove(titulo);
            }
        });
        lstTitulo.setAdapter(tituloAdapter);
    }

    public void confirmar_onClick(View view)
    {
        Intent intent = new Intent(getApplicationContext(), ConfirmacaoActivity.class);
        Bundle extras = new Bundle();
        extras.putSerializable("pre_locados", (Serializable) preLocados);
        intent.putExtras(extras);
        startActivity(intent);
    }

    public void cancelar_onClick(View view)
    {
        finish();
    }

    public void visualizarPreLocados_onClick(View view)
    {
        Intent intent = new Intent(getApplicationContext(), PreLocadosActivity.class);
        Bundle extras = new Bundle();
        extras.putSerializable("pre_locados", (Serializable) preLocados);
        intent.putExtras(extras);
        startActivityForResult(intent, 0);
    }

    @Override
    protected void onRestart()
    {
        super.onRestart();
        SharedPreferences preferences = this.getSharedPreferences(TaynahLOCUtil.TAYNAH_LOC_CODE, MODE_PRIVATE);
        if(preferences.getBoolean(TaynahLOCUtil.CANCEL_CONFIRM_ACTIVITY_CODE, false)
        || preferences.getBoolean(TaynahLOCUtil.CONFIRM_CONFIRM_ACTIVITY_CODE, false)) {
            finish();
        }
    }
}
