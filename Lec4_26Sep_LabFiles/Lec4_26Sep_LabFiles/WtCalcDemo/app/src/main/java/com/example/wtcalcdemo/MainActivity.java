package com.example.wtcalcdemo;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView txtViewResults;
    EditText editText;
    Button btnConvert;
    RadioGroup radioGroupConvert;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setLogo(R.mipmap.ic_launcher_wt_round);
        actionBar.setTitle(R.string.txtTitle);

        txtViewResults =  findViewById(R.id.txtViewResults);
        editText = findViewById(R.id.editTextInputWt);
        radioGroupConvert =  findViewById(R.id.radioGroupConvert);
        btnConvert = findViewById(R.id.btnConvert);

        btnConvert.setOnClickListener((View view) -> {
            if(radioGroupConvert.getCheckedRadioButtonId() == -1){
                Toast.makeText(this,"pls choose convertion type",Toast.LENGTH_SHORT);

            }else{
                double inputWt = 0, outputWt = 0;
                try {
                    inputWt = Double.parseDouble(editText.getText().toString());

                    if (inputWt <= 0) {
                        Toast.makeText(this, "input the wt more than 0", Toast.LENGTH_SHORT);

                    } else {
                        outputWt = inputWt * 2.2;
                        txtViewResults.setText(String.format("convert to %.2f", outputWt));

                    }


                }catch(Exception ex){

                    ex.printStackTrace();
                    Log.d("WT demo",ex.getMessage());
                }
            }
        });




    }
}