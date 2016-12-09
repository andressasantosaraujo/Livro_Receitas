package ifsp.andressa.livro_receitas.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.pm.LauncherApps;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;
import ifsp.andressa.livro_receitas.adapter.ReceitaAdapter;
import ifsp.andressa.livro_receitas.domain.Receita;
import ifsp.andressa.livro_receitas.service.ReceitaService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Andressa on 05/12/2016.
 */

public class ListarReceitasPresenter {
    public static String baseURL = "http://10.0.3.2:8080/";
    OnReceitaClickListner onReceitaClickListner;

    public void ListarReceitas(final Context context, final ListView listView, final Activity activity){
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
                listView.setAdapter(new ReceitaAdapter(context, list));
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Receita receita = list.get(position);



                    }
                });
            }

            @Override
            public void onFailure(Call<List<Receita>> call, Throwable t){

            }
        });
    }

    public interface OnReceitaClickListner{
        void onReceitaClickListner();
    }
}
