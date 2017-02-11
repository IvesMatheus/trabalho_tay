package br.com.locadorafilmes.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.com.locadorafilmes.R;
import br.com.locadorafilmes.dao.FuncionarioDAO;
import br.com.locadorafilmes.models.Funcionario;

public class CriarContaActivity extends AppCompatActivity
{

    private EditText edtNome;
    private EditText edtLogin;
    private EditText edtSenha;
    private EditText edtConfirmaSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_conta);

        setLayout();
    }

    private void setLayout()
    {
        edtNome = (EditText)findViewById(R.id.edtNomeFuncionario);
        edtLogin = (EditText)findViewById(R.id.edtLogin);
        edtSenha = (EditText)findViewById(R.id.edtSenha);
        edtConfirmaSenha = (EditText)findViewById(R.id.edtConfirmaSenha);
    }

    public void cancelarCriarConta_onClick(View view)
    {
        finish();
    }

    public void criarConta_onClick(View view)
    {
        if(!edtNome.getText().equals("")
                && edtLogin.getText().equals("")
                && edtSenha.getText().equals("")
                && edtConfirmaSenha.getText().equals(""))
        {
            if(edtSenha.getText().equals(edtConfirmaSenha.getText()))
            {
                Funcionario funcionario = new Funcionario(
                        edtNome.getText().toString(),
                        edtLogin.getText().toString(),
                        edtSenha.getText().toString()
                );

                FuncionarioDAO funcionarioDAO = new FuncionarioDAO(getApplicationContext());
                funcionarioDAO.inserirFuncionario(funcionario);

                Toast.makeText(getApplicationContext(), "Conta criada com sucesso", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }
}
