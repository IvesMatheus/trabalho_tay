package br.com.locadorafilmes.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import br.com.locadorafilmes.R;

public class LoginActivity extends AppCompatActivity {
    EditText edtLogin;
    EditText edtSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle(getString(R.string.activity_login));
        setLayout();
    }

    public void setLayout()
    {
        edtLogin = (EditText)findViewById(R.id.edtLogin);
        edtSenha = (EditText)findViewById(R.id.edtSenha);
    }

    public void login_onClick(View view)
    {
        String login = edtLogin.getText().toString();
        String senha = edtSenha.getText().toString();

        Intent i = new Intent(getApplicationContext(), LocacoesActivity.class);
        startActivity(i);
    }

    public void criarConta_onClick(View view)
    {
        Intent intent = new Intent(getApplicationContext(), CriarContaActivity.class);
        startActivity(intent);
    }
}
