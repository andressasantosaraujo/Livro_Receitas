package ifsp.andressa.livro_receitas.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import ifsp.andressa.livro_receitas.R;
import ifsp.andressa.livro_receitas.adapter.ReceitaAdapter;
import ifsp.andressa.livro_receitas.domain.Receita;
import ifsp.andressa.livro_receitas.presenter.ListarReceitasPresenter;
import ifsp.andressa.livro_receitas.service.ReceitaService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Andressa on 05/12/2016.
 */

public class ListarReceitasFragment extends Fragment{
    private ListView mList;
    private Context context;
    public static String baseURL = "http://10.0.3.2:8080/";
    private OnReceitaClickListner onReceitaClickListner;

    public ListarReceitasFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_listar_receitas, container, false);
        mList = (ListView) view.findViewById(R.id.listView);
        context = getActivity();
        listarReceitas();

        return view;
    }

    private void listarTitulosReceitas(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ReceitaService service = retrofit.create(ReceitaService.class);
        Call<List<Receita>> call = service.listarReceitas();

        call.enqueue(new Callback<List<Receita>>(){
            @Override
            public void onResponse(Call<List<Receita>> call, Response<List<Receita>> response){
                final List<Receita> list = response.body();

                mList.setAdapter(new ReceitaAdapter(context, list));


                mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Receita receita = list.get(position);
                        onReceitaClickListner.onReceitaClickListner(receita);

                    }
                });
            }

            @Override
            public void onFailure(Call<List<Receita>> call, Throwable t){

            }
        });
    }


    private void listarReceitas(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ReceitaService service = retrofit.create(ReceitaService.class);
        Call<List<Receita>> call = service.listarReceitas();

        call.enqueue(new Callback<List<Receita>>(){
            @Override
            public void onResponse(Call<List<Receita>> call, Response<List<Receita>> response){
                final List<Receita> list = response.body();

                mList.setAdapter(new ReceitaAdapter(context, list));


                mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Receita receita = list.get(position);
                        onReceitaClickListner.onReceitaClickListner(receita);

                    }
                });
            }

            @Override
            public void onFailure(Call<List<Receita>> call, Throwable t){

            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        onReceitaClickListner = (OnReceitaClickListner) getActivity();
    }

    public interface OnReceitaClickListner{
        void onReceitaClickListner(Receita receita);
    }
}
