package br.com.locadorafilmes.activitys;

import android.database.SQLException;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.com.locadorafilmes.R;
import br.com.locadorafilmes.dao.ClienteDAO;
import br.com.locadorafilmes.models.Cliente;

public class AddClienteActivity extends AppCompatActivity {

    private String TAG = AddClienteActivity.class.getName();

    private EditText edtNome;
    private EditText edtTelefone;
    private EditText edtEndereco;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cliente);

        setLayout();
    }

    private void setLayout()
    {
        setTitle("Adiconar Cliente");
        edtNome = (EditText)findViewById(R.id.edtNomeCliente);
        edtEndereco = (EditText)findViewById(R.id.edtEndereco);
        edtTelefone = (EditText)findViewById(R.id.edtTelefone);
    }

    public void cancelarAddCliente_onClick(View view)
    {
        finish();
    }

    public void addCliente_onClick(View view)
    {
        if(!edtNome.getText().toString().equals("")
                && !edtTelefone.getText().toString().equals("")
                && !edtEndereco.getText().toString().equals("")) {
            ClienteDAO clienteDAO = new ClienteDAO(getApplicationContext());

            try
            {
                Cliente cliente = new Cliente(
                        edtNome.getText().toString(),
                        edtEndereco.getText().toString(),
                        edtTelefone.getText().toString()
                );

                clienteDAO.inserirCliente(cliente);
                Toast.makeText(getApplicationContext(), "Cliente " + cliente.getNome() + " inserido com sucesso", Toast.LENGTH_SHORT).show();
            }
            catch (SQLException e)
            {
                Log.e(TAG, "Erro ao inserir cliente novo " + e.getMessage());
                Toast.makeText(getApplicationContext(), "Erro ao inserir cliente", Toast.LENGTH_SHORT).show();
            }
            finally
            {
                finish();
            }
        }
    }
}
