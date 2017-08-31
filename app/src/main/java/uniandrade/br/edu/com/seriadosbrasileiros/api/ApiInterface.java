package uniandrade.br.edu.com.seriadosbrasileiros.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by oangeli on 30/08/17.
 */

public interface ApiInterface {

    @GET("/3/list/{idlista}")
    Call<SeriesResults> getSeries(
            @Path("idlista") int idlista,
            @Query("language") String language,
            @Query("api_key") String api_key
    );

    //https://api.themoviedb.org/3/list/32339?api_key=042df6719b1c27335641d1d7a9e2e66e&language=pt-BR
}
