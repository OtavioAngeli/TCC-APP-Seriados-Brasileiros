package uniandrade.br.edu.com.seriadosbrasileiros.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import uniandrade.br.edu.com.seriadosbrasileiros.R;
import uniandrade.br.edu.com.seriadosbrasileiros.api.SeriesResults;

/**
 * Created by oangeli on 31/08/17.
 */

public class ListaSerieAdapter extends RecyclerView.Adapter<ListaSerieAdapter.ViewHolder> {

    private List<SeriesResults.ItemsBean> mSerieList;

    @Override
    public ListaSerieAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_series, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListaSerieAdapter.ViewHolder holder, int position) {
        SeriesResults.ItemsBean seriesResults = mSerieList.get(position);
        holder.txtNomeSerie.setText(seriesResults.getName());
    }

    @Override
    public int getItemCount() {
        return (mSerieList == null) ? 0 : mSerieList.size();
    }

    public void adicionarListaSeries(List<SeriesResults.ItemsBean> listSeries) {
        mSerieList = new ArrayList<>();
        mSerieList.addAll(listSeries);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgCapaSerie;
        private TextView txtNomeSerie;

        public ViewHolder(View ItemView){
            super(ItemView);

            imgCapaSerie = itemView.findViewById(R.id.imgCapaSerie);
            txtNomeSerie = itemView.findViewById(R.id.txtNomeSerie);

        }
    }

}
