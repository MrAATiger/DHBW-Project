package com.example.pingu.dhbw_project;

import android.content.DialogInterface;
import android.media.Image;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {



    private     double normalgewicht;
    private     double koerpergroesse;
    private     double idealgewicht;

    protected   ImageButton buttonMan;
    protected   ImageButton buttonWomen;
    protected   ImageButton buttonHelp;
    protected   Button buttonCalculate;


    protected EditText height;
    protected EditText weight;

    public MainActivity () {


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        buttonMan = (ImageButton) findViewById(R.id.buttonMan);

        setContentView(R.layout.activity_main);
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


    @Override
    public void onClick(View v) {

    }
} // end of class