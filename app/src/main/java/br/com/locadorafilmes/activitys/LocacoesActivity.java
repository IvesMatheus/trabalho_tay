package br.com.locadorafilmes.activitys;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.com.locadorafilmes.R;
import br.com.locadorafilmes.TaynahLOCUtil;
import br.com.locadorafilmes.adapters.LocacaoAdapter;
import br.com.locadorafilmes.models.Cliente;
import br.com.locadorafilmes.models.Funcionario;
import br.com.locadorafilmes.models.Locacao;

public class LocacoesActivity extends AppCompatActivity {
    private ListView lstLocacoes;
    private Funcionario funcionario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locacoes);

        Bundle extras = getIntent().getExtras();
        if(extras != null)
        {
            this.funcionario = (Funcionario)extras.get("funcionario");
        }
        else
        {
            Log.e("LocacoesActivity", " Não passou funcionário logado");
        }

        setLayout();
    }

    private void setLayout()
    {
        setTitle(getString(R.string.app_name) + " - " + funcionario.getLogin());

        List<Locacao> list = new ArrayList<Locacao>();
        list.add(new Locacao(1, new Funcionario(1, "Joao Silva", "", ""), new Cliente(1, "Roberta Kathleen", "", ""), "20/02/2017", "18/02/2017", 8.00f));
        LocacaoAdapter locacaoAdapter = new LocacaoAdapter(getApplicationContext(), list);

        lstLocacoes = (ListView) findViewById(R.id.lstLocacoes);
        lstLocacoes.setAdapter(locacaoAdapter);
    }

    public void novaLocacao_onClick(View view)
    {
        Intent intent = new Intent(getApplicationContext(), FilmesActivity.class);
        Bundle extras = new Bundle();
        extras.putSerializable("funcionario", funcionario);
        intent.putExtras(extras);
        startActivity(intent);
    }

    public void addCliente_onClick(View view)
    {
        Intent intent = new Intent(getApplicationContext(), AddClienteActivity.class);
        startActivity(intent);
    }

    public void addTitulo_onClick(View view)
    {
        Intent intent = new Intent(getApplicationContext(), AddTituloActivity.class);
        startActivity(intent);
    }

    public void resetConfig()
    {
        SharedPreferences sharedPreferences = this.getSharedPreferences(TaynahLOCUtil.TAYNAH_LOC_CODE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(TaynahLOCUtil.CANCEL_CONFIRM_ACTIVITY_CODE, false);
        editor.putBoolean(TaynahLOCUtil.CONFIRM_CONFIRM_ACTIVITY_CODE, false);
        editor.apply();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.locacao_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        switch (id)
        {
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        resetConfig();
    }
}


