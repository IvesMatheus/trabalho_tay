package br.com.locadorafilmes.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import br.com.locadorafilmes.R;
import br.com.locadorafilmes.models.Titulo;

/**
 * Created by ives on 05/02/17.
 */

public class PreLocacaoAdapter extends BaseAdapter
{
    private List<Titulo> titulos;
    private Context context;

    public PreLocacaoAdapter(List<Titulo> titulos, Context context)
    {
        this.titulos = titulos;
        this.context = context;
    }

    @Override
    public int getCount()
    {
        return titulos.size();
    }

    @Override
    public Object getItem(int position)
    {
        return titulos.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        Titulo titulo = titulos.get(position);
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_lista_pre_locacao, null);

        //SETAR IMAGEM

        TextView txtNomeTitulo = (TextView)view.findViewById(R.id.txtNomeTitulo);
        txtNomeTitulo.setText(titulo.getNomeTitulo());

        ImageView imgDesmarcar = (ImageView)view.findViewById(R.id.imgDesMarcar);
        imgDesmarcar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(context, "Desmacar", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
