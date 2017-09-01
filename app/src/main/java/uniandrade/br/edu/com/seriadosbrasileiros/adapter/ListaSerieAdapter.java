package uniandrade.br.edu.com.seriadosbrasileiros.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import uniandrade.br.edu.com.seriadosbrasileiros.R;
import uniandrade.br.edu.com.seriadosbrasileiros.api.SeriesResults;

/**
 * Created by oangeli on 31/08/17.
 */

public class ListaSerieAdapter extends RecyclerView.Adapter<ListaSerieAdapter.ViewHolder> {

    private List<SeriesResults.ItemsBean> mSerieList;
    private Context mContext;

    public ListaSerieAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public ListaSerieAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_series, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListaSerieAdapter.ViewHolder holder, int position) {
        SeriesResults.ItemsBean seriesResults = mSerieList.get(position);
        Picasso.with(mContext)
                .load(seriesResults.getPoster_path())
                .into(holder.imgCapaSerie);
        holder.txtNomeSerie.setText(seriesResults.getName());
        if (seriesResults.getFirst_air_date().equals("")){
            holder.txtReleaseDate.setText("Release Date: Desconhecido" );
        }else{
            holder.txtReleaseDate.setText("Release Date: " + seriesResults.getFirst_air_date());
        }
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
        private TextView txtReleaseDate;

        public ViewHolder(View ItemView){
            super(ItemView);

            imgCapaSerie = itemView.findViewById(R.id.imgCapaSerie);
            txtNomeSerie = itemView.findViewById(R.id.txtNomeSerie);
            txtReleaseDate = itemView.findViewById(R.id.txtReleaseDate);

        }
    }

}
