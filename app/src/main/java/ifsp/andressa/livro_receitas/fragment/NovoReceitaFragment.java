package ifsp.andressa.livro_receitas.fragment;

import android.Manifest;
import android.graphics.Color;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.widget.Button;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import ifsp.andressa.livro_receitas.MainActivity;
import ifsp.andressa.livro_receitas.R;
import ifsp.andressa.livro_receitas.domain.Receita;
import ifsp.andressa.livro_receitas.service.ReceitaService;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.R.attr.data;

/**
 * Created by Andressa on 05/12/2016.
 */

public class NovoReceitaFragment extends Fragment{
    private ImageView mImageView;
    private Context context;
    private String resultado;

    public NovoReceitaFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_novo_receita, container, false);
        Button btGravarReceita = (Button) view.findViewById((R.id.btGravarReceita));
        btGravarReceita.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                gravarReceita();
                Toast.makeText(getContext(),"Receita gravada com sucesso", Toast.LENGTH_SHORT).show();
            }
        });
        context = container.getContext();

        return view;
    }

    public void gravarReceita(){
        String baseURL = "http://10.0.3.2:8080/";
        EditText eTitulo = (EditText) getView().findViewById(R.id.eTitulo);
        EditText eIngredientes = (EditText) getView().findViewById(R.id.eIngredientes);
        EditText ePasso_passo = (EditText) getView().findViewById(R.id.ePasso_passo);

        Receita receita = new Receita();
        receita.setTitulo(eTitulo.getText().toString());
        receita.setIngredientes(eIngredientes.getText().toString());
        receita.setPasso_passo(ePasso_passo.getText().toString());

        eTitulo.setText("");
        eIngredientes.setText("");
        ePasso_passo.setText("");

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
        ReceitaService service = retrofit.create(ReceitaService.class);

        Call<Receita> call = service.criarReceitas(receita);

        call.enqueue(new Callback<Receita>(){
            @Override
            public void onResponse(Call<Receita> call, Response<Receita> response){
            }

            @Override
            public void onFailure(Call<Receita> call, Throwable t){
                t.printStackTrace();

            }
        });

    }
}
