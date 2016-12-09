package ifsp.andressa.livro_receitas.service;

import ifsp.andressa.livro_receitas.domain.Receita;
import java.util.List;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by Andressa on 05/12/2016.
 */

public interface ReceitaService {
    @GET("receita/list")
    Call<List<Receita>> listarReceitas();

    @POST("receita/add")
    Call<Receita> criarReceitas(@Body Receita receita);
}
