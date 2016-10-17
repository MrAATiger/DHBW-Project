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

    private double normalgewicht;
    private double koerpergroesse;
    private double idealgewicht;


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


    // Berechnung des Normalgewichts
    private double normalgewicht() {
        normalgewicht = koerpergroesse - 100;
        return normalgewicht;
    }

    // Idealgewicht Mann
    private double idealgewichtMann() {
        idealgewicht = normalgewicht() * 0.9;
        return idealgewicht;
    }

    // Idealgewicht Frau
    private double idealgewichtFrau() {
        idealgewicht = normalgewicht() * 0.85;
        return idealgewicht;
    }


    private void changeActivity() {
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("normalgewicht",normalgewicht);
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


            normalgewicht();
            Log.i(TAG, "normalgewicht: " + normalgewicht);
            if (male) {
                idealgewichtMann();
            } else {
                idealgewichtFrau();
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