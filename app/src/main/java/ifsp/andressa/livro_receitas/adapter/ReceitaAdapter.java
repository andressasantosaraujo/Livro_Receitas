package ifsp.andressa.livro_receitas.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;
import java.util.List;
import java.util.Objects;
import ifsp.andressa.livro_receitas.R;
import ifsp.andressa.livro_receitas.domain.Receita;
import ifsp.andressa.livro_receitas.presenter.ListarReceitasPresenter;

/**
 * Created by Andressa on 04/12/2016.
 */

public class ReceitaAdapter extends BaseAdapter{
    private final Context context;
    private final List<Receita> receitas;

    public ReceitaAdapter(Context context, List receitas){
        this.context = context;
        this.receitas = receitas;
    }

    @Override
    public int getCount() {return receitas != null ? receitas.size() : 0;}

    @Override
    public Object getItem(int position){return receitas.get(position);}

    @Override
    public long getItemId(int position) {return receitas.get(position).getId();}

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_receitas, parent, false);

        TextView tTitulo = (TextView) view.findViewById(R.id.tTitulo);
        TextView tIngredientes = (TextView) view.findViewById(R.id.tIngredientes);
        TextView tPasso_passo = (TextView) view.findViewById(R.id.tPasso_passo);

        Receita receita = receitas.get(position);
            tTitulo.setText(receita.getTitulo());
            tIngredientes.setText(receita.getIngredientes());
            tPasso_passo.setText(receita.getPasso_passo());

        return view;
    }

}
