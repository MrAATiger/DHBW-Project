package com.example.pingu.dhbw_project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends Activity {

    // LOGGER
    private static final String TAG = "MainActivity";

    protected double normalgewicht;
    protected double koerpergroesse;
    protected double idealgewicht;


    protected ImageButton buttonMan;
    protected ImageButton buttonWomen;
    protected ImageButton buttonHelp;
    protected Button buttonCalculate;

    protected EditText height;
    protected EditText weight;

    private boolean male;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // init View
        setContentView(R.layout.activity_main);

        // link View
        buttonMan = (ImageButton) findViewById(R.id.buttonMan);
        buttonWomen = (ImageButton) findViewById(R.id.buttonWomen);
        buttonHelp = (ImageButton) findViewById(R.id.buttonHelp);

        buttonCalculate = (Button) findViewById(R.id.buttonBerechnen);

        height = (EditText) findViewById(R.id.editKoerpergroesse);


        // attach listener
        buttonMan.setOnClickListener(new OnClickManListener());
        buttonWomen.setOnClickListener(new OnClickWomanListener());
        buttonCalculate.setOnClickListener(new OnCalculateListener());
        buttonHelp.setOnClickListener(new OnHelpListener());

        // init vars
        height.setText("");

        /* funktioniert nicht - prüfen
             if (koerpergroesse > 225 || koerpergroesse < 150) {
            Toast toast = Toast.makeText(this,"Text",Toast.LENGTH_SHORT);
            toast.show();
            return;}*/


    }


    private void changeActivity() {
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("normalgewicht",""+this.normalgewicht);
        intent.putExtra("idealgewicht",""+this.idealgewicht);
        startActivity(intent);
    }

    public class OnClickManListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            male = true;
            Log.i(TAG, "now is male");
            // TODO run male active animation
        }
    }

    public class OnClickWomanListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            male = false;
            Log.i(TAG, "now is female");
            // TODO run female active animation

        }
    }

    public class OnCalculateListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            Log.i(TAG, "try to calc");

            if (height.getText().toString().isEmpty() /*|| weight.getText().toString().isEmpty()*/) {
                Log.i(TAG, "there is no input");
                return;
            }

            koerpergroesse = (double) Integer.parseInt(height.getText().toString());

            normalgewicht = koerpergroesse - 100;

            Log.i(TAG, "normalgewicht: " + normalgewicht);
            if (male) {
                idealgewicht = normalgewicht * 0.9;
            } else {
                idealgewicht = normalgewicht * 0.85;
            }
            Log.i(TAG, "Idealgewicht: " + idealgewicht);


            changeActivity();

        }
    }

    public class OnHelpListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Log.i(TAG, "Help");
        }
    }

} // end of class