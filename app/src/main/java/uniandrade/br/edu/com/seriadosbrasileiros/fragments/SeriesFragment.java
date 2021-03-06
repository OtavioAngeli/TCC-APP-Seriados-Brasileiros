package uniandrade.br.edu.com.seriadosbrasileiros.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import uniandrade.br.edu.com.seriadosbrasileiros.R;
import uniandrade.br.edu.com.seriadosbrasileiros.adapter.ListaSerieAdapter;
import uniandrade.br.edu.com.seriadosbrasileiros.api.SeriesResults;
import uniandrade.br.edu.com.seriadosbrasileiros.api.ApiInterface;

/**
 * A simple {@link Fragment} subclass.
 */
public class SeriesFragment extends Fragment {

    public static String BASE_URL = "https://api.themoviedb.org";
    public static String API_KEY = "042df6719b1c27335641d1d7a9e2e66e";
    public static String LANGUAGE = "pt-BR";
    public static int ID_LISTA = 32339;

    private RecyclerView recyclerView;
    private ListaSerieAdapter listaSerieAdapter;

    public SeriesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_series, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        listaSerieAdapter = new ListaSerieAdapter(getContext());
        recyclerView.setAdapter(listaSerieAdapter);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface myInterface = retrofit.create(ApiInterface.class);

        Call<SeriesResults> call = myInterface.getSeries(ID_LISTA, LANGUAGE, API_KEY);

        call.enqueue(new Callback<SeriesResults>() {
            @Override
            public void onResponse(Call<SeriesResults> call, Response<SeriesResults> response) {
                if (response.isSuccessful()){
                    SeriesResults results = response.body();
                    List<SeriesResults.ItemsBean> listSeries = results.getItems();

                    listaSerieAdapter.adicionarListaSeries(listSeries);
                }else {

                }

            }
            @Override
            public void onFailure(Call<SeriesResults> call, Throwable t) {
                t.printStackTrace();
            }
        });
        return view;
    }
}
