package com.example.inclass3_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.TextViewOnReceiveContentListener;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.TextView;

public class LayoutActivity extends AppCompatActivity {
    final String TAG = "Concert show";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);

        try {

            int numTix = 0;
            Bundle bundle = getIntent().getExtras();
            double costR = bundle.getDouble("COST", 0);
            numTix = getIntent().getExtras().getInt("NUMTIX", 0);
            String concertType = bundle.getString("TYPE", "NOTHING");

            String outputStr = "Concert type:" + concertType +
                    "Number of ticket:" + numTix +
                    "total cost:" + costR;

            TextView txtViewResult = findViewById(R.id.txtViewResult);
            txtViewResult.setText(outputStr);
            txtViewResult.setGravity(Gravity.CENTER);
            txtViewResult.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL);


        } catch (Exception ex) {
            ex.printStackTrace();
            Log.d(TAG, ex.getMessage());
        }
    }
}
