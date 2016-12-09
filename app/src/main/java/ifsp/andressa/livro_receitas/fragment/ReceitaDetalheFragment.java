package ifsp.andressa.livro_receitas.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import ifsp.andressa.livro_receitas.R;
import ifsp.andressa.livro_receitas.domain.Receita;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReceitaDetalheFragment extends Fragment {
    public static final String ARG_RECEITA = "receita";
    private Receita mReceita;
    private TextView mPassoAPasso;
    private TextView mTitulo;
    private TextView mIngredientes;


    public ReceitaDetalheFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_receita_detalhe, container, false);

        mTitulo = (TextView) view.findViewById(R.id.titul_detalhe);
        mTitulo.setText("Nome: " + mReceita.getTitulo());

        mIngredientes = (TextView) view.findViewById(R.id.ing_detalhe);
        mIngredientes.setText("Ingrediente: " +mReceita.getIngredientes());


        mPassoAPasso = (TextView) view.findViewById(R.id.passo_a_passo);
        mPassoAPasso.setText("Passos: " +mReceita.getPasso_passo());


        return  view;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mReceita = getArguments().getParcelable(ARG_RECEITA);
        }
    }

    public static ReceitaDetalheFragment newInstance(Receita receita) {
        ReceitaDetalheFragment fragment = new ReceitaDetalheFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_RECEITA, receita);

        fragment.setArguments(args);
        return fragment;
    }

}
