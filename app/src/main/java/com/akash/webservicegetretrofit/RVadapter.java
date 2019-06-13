package com.akash.webservicegetretrofit;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class RVadapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<Movies> list;

    public RVadapter(Context context, List<Movies> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View layoutInflater = LayoutInflater.from(context).inflate(R.layout.fragment_output,viewGroup,false);

 MoviesViewHolder moviesViewHolder = new MoviesViewHolder(layoutInflater);
  return moviesViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

      Movies movies=  list.get(i);

     MoviesViewHolder holder=(MoviesViewHolder)viewHolder;

     holder.movie_name.setText(movies.getTitile());
     holder.ratings.setText(movies.getRating());
     holder.year.setText(movies.getReleaseYear());
     //holder.imageView.setImageResource(movies.getImage());


        UniversalImageLoader universalImageLoader = new UniversalImageLoader(context);
        ImageLoader.getInstance().init(universalImageLoader.getConfig());


        holder.imageView.setImageResource(R.drawable.ic_launcher_background);

        UniversalImageLoader.setImage(movies.getImage(),holder.imageView,null,"");



    }

    @Override
    public int getItemCount() {

        return  list.size();
    }

 class MoviesViewHolder extends RecyclerView.ViewHolder {




     public MoviesViewHolder(@NonNull View itemView, View view) {
         super(itemView);

     }

     ImageView imageView = itemView.findViewById(R.id.img_view);
        TextView movie_name = itemView.findViewById(R.id.name);
        TextView ratings = itemView.findViewById(R.id.country);
        TextView year = itemView.findViewById(R.id.city);

    public MoviesViewHolder(@NonNull View itemView) {
        super(itemView);

    }

    public void init(String img,String movie,String ratings, String year){



            movie_name.setText(movie);
            this.ratings.setText(ratings);
            this.year.setText(year);






        }



    }

}
