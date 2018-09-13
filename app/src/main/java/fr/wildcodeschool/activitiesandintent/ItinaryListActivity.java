package fr.wildcodeschool.activitiesandintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ItinaryListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinary_list);

        Intent intent = getIntent();
        String departure = intent.getStringExtra("key_depart");
        String destination = intent.getStringExtra("key_arrive");

        setTitle(departure + " >> " + destination);
    }
}
