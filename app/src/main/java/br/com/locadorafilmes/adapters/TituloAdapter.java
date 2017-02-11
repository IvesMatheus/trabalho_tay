package br.com.locadorafilmes.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

import br.com.locadorafilmes.R;
import br.com.locadorafilmes.models.Locacao;
import br.com.locadorafilmes.models.Titulo;

/**
 * Created by ives on 05/02/17.
 */

public class TituloAdapter extends BaseAdapter
{
    private List<Titulo> titulos;
    private Context context;

    public TituloAdapter(Context context, List<Titulo> titulos)
    {
        this.context = context;
        this.titulos = titulos;
    }

    @Override
    public int getCount() {
        return titulos.size();
    }

    @Override
    public Object getItem(int position) {
        return titulos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, final View convertView, ViewGroup parent)
    {
        Titulo titulo = titulos.get(position);
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_lista_filme, null);

        //CARREGAR IMAGEVIEW

        TextView txtNomeTitulo = (TextView) view.findViewById(R.id.txtNomeTitulo);
        txtNomeTitulo.setText(titulo.getNomeTitulo());

        TextView txtDescricao = (TextView) view.findViewById(R.id.txtDescricao);
        txtDescricao.setText(titulo.getDescricao());

        ImageView imgDesmarcar = (ImageView) view.findViewById(R.id.imgDesMarcar);
        imgDesmarcar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Desmarcado", Toast.LENGTH_SHORT).show();
            }
        });

        ImageView imgMarcar = (ImageView) view.findViewById(R.id.imgMarcar);
        imgMarcar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Marcado", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
