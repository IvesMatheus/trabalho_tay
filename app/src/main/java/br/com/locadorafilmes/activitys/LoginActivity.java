package br.com.locadorafilmes.activitys;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.SQLException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.com.locadorafilmes.R;
import br.com.locadorafilmes.dao.FuncionarioDAO;
import br.com.locadorafilmes.models.Funcionario;

public class LoginActivity extends AppCompatActivity {
    EditText edtLogin;
    EditText edtSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        SharedPreferences preferences = getSharedPreferences("taynahloc_preferences", MODE_PRIVATE);
        if(preferences.getBoolean("isLogin", false))
        {
            Funcionario funcionario = new Funcionario();
            funcionario.setLogin(preferences.getString("login", ""));
            funcionario.setSenha(preferences.getString("senha", ""));

            FuncionarioDAO funcionarioDAO = new FuncionarioDAO(getApplicationContext());
            funcionario = funcionarioDAO.verificaLogin(funcionario);

            Intent intent = new Intent(getApplicationContext(), LocacoesActivity.class);
            Bundle extras = new Bundle();
            extras.putSerializable("funcionario", funcionario);
            intent.putExtras(extras);
            startActivity(intent);
            finish();
        }

        setLayout();
    }

    public void setLayout()
    {
        setTitle(getString(R.string.activity_login));
        edtLogin = (EditText)findViewById(R.id.edtLogin);
        edtSenha = (EditText)findViewById(R.id.edtSenha);
    }

    public void login_onClick(View view) {
        String login = edtLogin.getText().toString();
        String senha = edtSenha.getText().toString();

        if(!login.equals("") && !senha.equals(""))
        {
            FuncionarioDAO funcionarioDAO = new FuncionarioDAO(getApplicationContext());

            try
            {
                Funcionario funcionario = funcionarioDAO.verificaLogin(new Funcionario("", login, senha));

                if (funcionario != null)
                {
                    SharedPreferences sharedPreferences = getSharedPreferences("taynahloc_preferences", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("login", login);
                    editor.putString("senha", senha);
                    editor.putBoolean("isLogin", true);
                    editor.commit();

                    Intent intent = new Intent(getApplicationContext(), LocacoesActivity.class);
                    Bundle extras = new Bundle();
                    extras.putSerializable("funcionario", funcionario);
                    intent.putExtras(extras);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Login ou Senha incorreto", Toast.LENGTH_SHORT).show();
                }
            }
            catch (SQLException e)
            {
                Toast.makeText(getApplicationContext(), "Login ou Senha incorreto", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void criarConta_onClick(View view)
    {
        Intent intent = new Intent(getApplicationContext(), CriarContaActivity.class);
        startActivity(intent);
    }
}
