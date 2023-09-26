package com.example.inclass3_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    final String TAG = "Concert Demo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editTextNumTic = findViewById(R.id.editTextNumTic);
        Button btnBookConcert = findViewById(R.id.btnBookConcert);
        Spinner spinnerConcertType = findViewById(R.id.spinnerConcertType);

        /*
        spinnerConcertType.setOnItemSelectedListener(){
            @override
                    public void() {
                if (i == 0) {
                    toast.makeText();
                } else if (i == 1) {

                } else {

                }
            }


        }
        */




        btnBookConcert.setOnClickListener((View view) -> {
            if (editTextNumTic.getText().toString().isEmpty()){
                Toast.makeText(this,"Number of thickets must be entered.",Toast.LENGTH_LONG).show();
            }else{
                try{
                    int numTix = Integer.parseInt(editTextNumTic.getText().toString());
                    int index = spinnerConcertType.getSelectedItemPosition();
                    double cost = 0;
                    switch(index){
                        case 0:
                            cost = numTix * 79;
                            break;
                        case 1:
                            cost = numTix * 69;
                            break;
                        case 2:
                            cost = numTix * 59;
                            break;
                    }

                    DecimalFormat df = new DecimalFormat("$#.##");
                    String outputCostTxt = df.format(cost);

                    Toast.makeText(this,outputCostTxt, Toast.LENGTH_SHORT).show();

                    //create a bundle of data
                    //create intent and put it in the intent object
                    //use the intent to start next activity

                    Bundle bundle = new Bundle();
                    bundle.putInt("NUMTIX",numTix);
                    bundle.putString("TYPE",spinnerConcertType.getSelectedItem().toString());
                    bundle.putDouble("COST",cost);

                    Intent myResult = new Intent(MainActivity.this, LayoutActivity.class);

                    myResult.putExtras(bundle);
                    startActivity(myResult);


                }catch(Exception ex){
                    ex.printStackTrace();
                    Log.d(TAG, "Error in parse/number of tickets");
                    Toast.makeText(this, "Number of tickets must be whole number > 0",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}