package sg.edu.rp.c346.id19004781.mymovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Calendar;

public class MovieDetails extends AppCompatActivity {

    TextView tvdisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        tvdisplay = findViewById(R.id.textViewDisplay);

        Intent intentReceived = getIntent();
        String description = intentReceived.getStringExtra("description");
        String date = intentReceived.getStringExtra("watchDate");
        String theatre = intentReceived.getStringExtra("theatre");

        tvdisplay.setText(description + "\n Watch on: " + date + "\n In Theatre: " + theatre);


    }
}
