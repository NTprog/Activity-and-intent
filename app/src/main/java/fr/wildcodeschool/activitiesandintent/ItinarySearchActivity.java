package fr.wildcodeschool.activitiesandintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class ItinarySearchActivity extends AppCompatActivity {

    EditText depart;
    EditText arrive;
    Button   find;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinary_search);

        depart = (EditText) findViewById(R.id.depart);
        arrive = (EditText) findViewById(R.id.arrive);
        find   = (Button) findViewById(R.id.find);

        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(depart.getText().toString().isEmpty() || arrive.getText().toString().isEmpty()){

                    Toast toast = Toast.makeText(ItinarySearchActivity.this,
                    "replie",
                    Toast.LENGTH_LONG);
                    toast.show();

                }else{
                    Intent i = new Intent(getApplicationContext(), ItinaryListActivity.class);
                    i.putExtra("key_depart",depart.getText().toString());
                    i.putExtra("key_arrive",arrive.getText().toString());
                    startActivity(i);
                }
            }
        });

    }



    public void finish(){
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }


}
