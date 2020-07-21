package sg.edu.rp.c346.id19004781.mymovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    ListView lvMovie;
    ArrayList<Movie> alMovieList;
    CustomAdapter caMovie;
    ImageView ivMovie;
    TextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMovie = findViewById(R.id.listViewMovie);

        alMovieList = new ArrayList<>();
        final Calendar date1 = Calendar.getInstance();
        date1.set(2014, 11, 15);
        Movie movie1 = new Movie("The Avengers", 2012, "PG13", "Action | Sci-Fi", date1, "Golden Village - Bishan", "Nick Fury of S.H.I.E.L.D. assembles a team of superheroes to save the planet from Loki and his army.");
        alMovieList.add(movie1);

        Calendar date2 = Calendar.getInstance();
        date2.set(2015, 05, 15);
        Movie movie2 = new Movie("Planes", 2013, "PG", "Animation | Comedy", date2, "Cathay - AMK Hub", "A crop-dusting plane with a fear of heights lives his dream of competing in a famous around-the-world aerial race.");
        alMovieList.add(movie2);

        caMovie = new CustomAdapter(this, R.layout.row, alMovieList);
        lvMovie.setAdapter(caMovie);

        //Intent Passing
        lvMovie.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, MovieDetails.class);

                Movie currentMovie = alMovieList.get(position);
                intent .putExtra("title", currentMovie.getTitle());
                intent .putExtra("year", currentMovie.getYear());
                intent .putExtra("rated", currentMovie.getRated());
                intent .putExtra("genre", currentMovie.getGenre());
                intent .putExtra("watchDate", currentMovie.getWatched_on());
                intent .putExtra("theatre", currentMovie.getIn_theatre());
                intent .putExtra("description", currentMovie.getDescription());
                startActivity(intent);
            }
        });

    }
}
