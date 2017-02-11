package br.com.locadorafilmes.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.locadorafilmes.R;
import br.com.locadorafilmes.models.Titulo;

/**
 * Created by ives on 05/02/17.
 */

public class TituloAdapter extends BaseAdapter
{
    private List<Titulo> titulos;
    private Context context;
    private TituloAdapterListener tituloAdapterListener;

    public TituloAdapter(Context context, List<Titulo> titulos, TituloAdapterListener tituloAdapterListener)
    {
        this.context = context;
        this.titulos = titulos;
        this.tituloAdapterListener = tituloAdapterListener;
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
    public View getView(final int position, final View convertView, ViewGroup parent)
    {
        final Titulo titulo = titulos.get(position);
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_lista_filme, null);

        //CARREGAR IMAGEVIEW

        TextView txtNomeTitulo = (TextView) view.findViewById(R.id.txtNomeTitulo);
        txtNomeTitulo.setText(titulo.getNomeTitulo());

        TextView txtDescricao = (TextView) view.findViewById(R.id.txtDescricao);
        txtDescricao.setText(titulo.getDescricao());

        final ImageView imgDesmarcar = (ImageView) view.findViewById(R.id.imgDesMarcar);
        imgDesmarcar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tituloAdapterListener.desmarcar(titulo);
            }
        });

        ImageView imgMarcar = (ImageView) view.findViewById(R.id.imgMarcar);
        imgMarcar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tituloAdapterListener.marcar(titulo);
            }
        });

        return view;
    }

    public interface TituloAdapterListener
    {
        void marcar(Titulo titulo);
        void desmarcar(Titulo titulo);
    }
}
