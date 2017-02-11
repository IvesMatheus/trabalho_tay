package br.com.locadorafilmes.activitys;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.List;

import br.com.locadorafilmes.R;
import br.com.locadorafilmes.TaynahLOCUtil;
import br.com.locadorafilmes.dao.ClienteDAO;
import br.com.locadorafilmes.models.Cliente;
import br.com.locadorafilmes.models.Funcionario;
import br.com.locadorafilmes.models.Titulo;

public class ConfirmacaoActivity extends AppCompatActivity {

    private List<Titulo> preLocados;
    private Spinner spnClientes;
    private List<Cliente> clientes;
    private String[] nomeClientes;
    private Cliente cliente;
    private Funcionario funcionario;
    private TextView txtFuncionario;
    private TextView txtDataLocacao;
    private TextView txtDataDevolucao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacao);

        Bundle extras = getIntent().getExtras();
        preLocados = (List<Titulo>)extras.get("pre_locados");
        funcionario = (Funcionario)extras.get("funcionario");

        ClienteDAO clienteDAO = new ClienteDAO(getApplicationContext());
        clientes = clienteDAO.listTodosClientes();

        int i = 0;
        if(clientes.size() > 0) {
            cliente = clientes.get(0);
            nomeClientes = new String[clientes.size()];
            for (Cliente cliente : clientes) {
                nomeClientes[i] = cliente.getNome();
                i++;
            }
        }
        else
        {
            nomeClientes = new String[1];
            nomeClientes[0] = "Nenhum Cliente Cadastrado";
        }

        setLayout();
    }

    private void setLayout() {
        spnClientes = (Spinner)findViewById(R.id.spnCliente);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_spinner_item, nomeClientes);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnClientes.setAdapter(adapter);
        spnClientes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                cliente = clientes.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        long date = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("d/M/yyyy");
        String dateString = sdf.format(date);

        txtFuncionario = (TextView)findViewById(R.id.txtFuncionario);
        txtFuncionario.setText(funcionario.getNome());
        txtDataDevolucao = (TextView)findViewById(R.id.txtDataDevolucao);
        //txtDataDevolucao
        txtDataLocacao = (TextView)findViewById(R.id.txtDataLocacao);
        txtDataLocacao.setText(dateString);
    }

    public void confirmLocacao_onClick(View view)
    {
        SharedPreferences sharedPreferences = this.getSharedPreferences(TaynahLOCUtil.TAYNAH_LOC_CODE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(TaynahLOCUtil.CONFIRM_CONFIRM_ACTIVITY_CODE, true);
        editor.apply();

        finish();
    }

    public void cancelarLocacao_onClick(View view)
    {
        SharedPreferences sharedPreferences = this.getSharedPreferences(TaynahLOCUtil.TAYNAH_LOC_CODE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(TaynahLOCUtil.CANCEL_CONFIRM_ACTIVITY_CODE, true);
        editor.apply();

        finish();
    }
}
