package br.com.locadorafilmes.activitys;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.com.locadorafilmes.R;
import br.com.locadorafilmes.TaynahLOCUtil;
import br.com.locadorafilmes.adapters.TituloAdapter;
import br.com.locadorafilmes.models.Titulo;

public class FilmesActivity extends AppCompatActivity
{

    ListView lstTitulo;

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
        titulos.add(new Titulo("Star Wars Episódio VI", "", 2015, 4, "Este é o sétimo capítulo da saga cinematográfica e é uma sequência da trilogia original (Uma nova esperança, O Império contra-ataca e O retorno de Jedi). A segunda trilogia foi uma prequela, mostrando a transformação de Anakin Skywalker no vilão Darth Vader (A ameaça fantasma, O ataque dos clones e A vingança dos Sith), mas de maneira geral recebeu muitas críticas.", "", 4));
        titulos.add(new Titulo("Star Wars Episódio VI", "", 2015, 4, "Este é o sétimo capítulo da saga cinematográfica e é uma sequência da trilogia original (Uma nova esperança, O Império contra-ataca e O retorno de Jedi). A segunda trilogia foi uma prequela, mostrando a transformação de Anakin Skywalker no vilão Darth Vader (A ameaça fantasma, O ataque dos clones e A vingança dos Sith), mas de maneira geral recebeu muitas críticas.", "", 4));
        TituloAdapter tituloAdapter = new TituloAdapter(getApplicationContext(), titulos);
        lstTitulo.setAdapter(tituloAdapter);
    }

    public void confirmar_onClick(View view)
    {
        Intent intent = new Intent(getApplicationContext(), ConfirmacaoActivity.class);
        startActivity(intent);
    }

    public void cancelar_onClick(View view)
    {
        finish();
    }

    public void visualizarPreLocados_onClick(View view)
    {
        Intent intent = new Intent(getApplicationContext(), PreLocadosActivity.class);
        startActivity(intent);
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
