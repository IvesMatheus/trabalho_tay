package br.com.locadorafilmes.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import br.com.locadorafilmes.R;

public class AddClienteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cliente);
    }

    public void cancelarAddCliente_onClick(View view)
    {
        finish();
    }
}
