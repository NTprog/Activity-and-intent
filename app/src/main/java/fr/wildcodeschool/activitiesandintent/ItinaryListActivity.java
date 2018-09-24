package fr.wildcodeschool.activitiesandintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ItinaryListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinary_list);

        ListView listTrip = findViewById(R.id.listView);

        ArrayList<TripModel> results = genererTweets();

        TripAdapter adapter = new TripAdapter(this, results);
        listTrip.setAdapter(adapter);

        Intent intent = getIntent();
        String departure = intent.getStringExtra("key_depart");
        String destination = intent.getStringExtra("key_arrive");

        setTitle(departure + " >> " + destination);

    }

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy-kk:mm");

    private ArrayList<TripModel> genererTweets() {
        ArrayList<TripModel> results = new ArrayList<>();

        try {
            results.add(new TripModel("Eric", "Cartman", sdf.parse("21/02/2017-15:30"), 15));
            results.add(new TripModel("Stan", "Marsh", sdf.parse("21/02/2017-16:00"), 20));
            results.add(new TripModel("Kenny", "Broflovski", sdf.parse("21/02/2017-16:30"), 16));
            results.add(new TripModel("Kyle", "McCormick", sdf.parse("21/02/2017-17:00"), 40));
            results.add(new TripModel("Wendy", "Testaburger", sdf.parse("21/02/2017-17:30"), 20));
        } catch (ParseException e) {
        }
        return results;
    }
}
