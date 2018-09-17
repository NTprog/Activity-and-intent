package fr.wildcodeschool.activitiesandintent;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


public class ItinarySearchActivity extends AppCompatActivity {

    EditText depart;
    EditText arrive;
    Button   find;
    Calendar myCalendar;
    EditText dateInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itinary_search);

        depart = (EditText) findViewById(R.id.depart);
        arrive = (EditText) findViewById(R.id.arrive);
        find   = (Button) findViewById(R.id.find);
        dateInput = (EditText) findViewById(R.id.date);
        myCalendar = Calendar.getInstance();

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


        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };
        dateInput.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(ItinarySearchActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });


    }


    final private void updateLabel() {
        String myFormat = "MM/dd/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.FRANCE);

        dateInput.setText(sdf.format(myCalendar.getTime()));
    }





    public void finish(){
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }


}
