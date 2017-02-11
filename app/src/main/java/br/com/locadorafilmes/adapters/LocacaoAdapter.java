package br.com.locadorafilmes.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import br.com.locadorafilmes.R;
import br.com.locadorafilmes.models.Locacao;

/**
 * Created by ives on 05/02/17.
 */

public class LocacaoAdapter extends BaseAdapter
{
    private List<Locacao> locacoes;
    private Context context;

    public LocacaoAdapter(Context context, List<Locacao> locacoes)
    {
        this.locacoes = locacoes;
        this.context = context;
    }

    @Override
    public int getCount()
    {
        return locacoes.size();
    }

    @Override
    public Object getItem(int position)
    {
        return locacoes.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        Locacao locacao = locacoes.get(position);
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.item_lista_locacoes, null);

        TextView txtNomeCliente = (TextView)view.findViewById(R.id.txtNomeCliente);
        txtNomeCliente.setText(locacao.getCliente().getNome());

        TextView txtNomeFuncionario = (TextView)view.findViewById(R.id.txtNomeFuncionario);
        txtNomeFuncionario.setText("por: " + locacao.getFuncionario().getNome());

        TextView txtDataDevolucao = (TextView)view.findViewById(R.id.txtDataDevolucao);
        txtDataDevolucao.setText(locacao.getData_dev());

        TextView txtDataLocacao = (TextView)view.findViewById(R.id.txtDataLocacao);
        txtDataLocacao.setText(locacao.getData_loc());

        return view;
    }
}
