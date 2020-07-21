package sg.edu.rp.c346.id19004781.mymovies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<Movie> movieList;

    public CustomAdapter(Context context, int resource, ArrayList<Movie> objects){
        super(context, resource, objects);
        parent_context = context;
        layout_id = resource;
        movieList = objects;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(layout_id, parent, false);

        ImageView  ivRated = rowView.findViewById(R.id.imageViewRated);
        TextView tvTitle = rowView.findViewById(R.id.textViewTitle);
        TextView tvYearGenre = rowView.findViewById(R.id.textViewYearGenre);

        Movie currentMovie = movieList.get(position);
        tvTitle.setText(currentMovie.getTitle());
        tvYearGenre.setText(currentMovie.getYear() + " - " + currentMovie.getGenre());

        if(currentMovie.getRated().equalsIgnoreCase("pg13")){
            ivRated.setImageResource(R.drawable.rating_pg13);
        }
        else {
            ivRated.setImageResource(R.drawable.rating_pg);
        }
//        else if(currentMovie.getRated().equalsIgnoreCase("pg13")){
//            ivRated.setImageResource(R.drawable.rating_pg13);
//        }
//        else if(currentMovie.getRated().equalsIgnoreCase("m18")){
//            ivRated.setImageResource(R.drawable.rating_m18);
//        }
//        else if(currentMovie.getRated().equalsIgnoreCase("nc16")){
//            ivRated.setImageResource(R.drawable.rating_nc16);
//        }
//        else {
//            ivRated.setImageResource(R.drawable.rating_r21);
//        }

        return rowView;
    }

}
