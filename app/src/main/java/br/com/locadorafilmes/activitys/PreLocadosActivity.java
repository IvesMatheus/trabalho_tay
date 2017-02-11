package br.com.locadorafilmes.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import br.com.locadorafilmes.R;

public class PreLocadosActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_locados);
    }

    public void confirmarLocacao_onClick(View view)
    {
        Intent intent = new Intent(getApplicationContext(), ConfirmacaoActivity.class);
        startActivity(intent);
    }
}
