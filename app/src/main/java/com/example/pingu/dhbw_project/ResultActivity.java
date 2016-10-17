package com.example.pingu.dhbw_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView normalgewicht;
    private TextView idealgewicht;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        normalgewicht = (TextView) findViewById(R.id.resultWeight);

        idealgewicht = (TextView) findViewById(R.id.resultIdealWeight) ;


        Intent intent = getIntent();
        String ergebnis = intent.getStringExtra("normalgewicht");
        String idealErgebnis = intent.getStringExtra("idealgewicht");
        normalgewicht.setText(ergebnis);
        idealgewicht.setText(idealErgebnis);



    }
}
