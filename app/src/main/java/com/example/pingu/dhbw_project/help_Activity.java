package com.example.pingu.dhbw_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class help_Activity extends AppCompatActivity  {

   protected Button zurueck;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        zurueck = (Button) findViewById(R.id.zurueckHelp);
        zurueck.setOnClickListener(new BackButton());

    }
    public void changeActivity() {
        finish();
    }

    public class BackButton implements View.OnClickListener {

        @Override
        public void onClick(View v) {
           changeActivity();
        }
    }

} // end of class
