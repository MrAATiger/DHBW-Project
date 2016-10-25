package com.example.pingu.dhbw_project;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

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
    

    private boolean male;

    protected Intent berechnen;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


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

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

        buttonMan.setActivated(true);
    }


    private void changeToHelp() {
        Intent help = new Intent(this, help_Activity.class);
        startActivity(help);
    }

    private void changeActivity() {
        berechnen = new Intent(this, ResultActivity.class);
        berechnen.putExtra("normalgewicht", "" + this.normalgewicht);
        berechnen.putExtra("idealgewicht", "" + this.idealgewicht);
        startActivity(berechnen);
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }

    public class OnClickManListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            male = true;

            Log.i(TAG, "now is male");
            buttonMan.setActivated(true);
            buttonWomen.setActivated(false);

        }
    }

    public class OnClickWomanListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            male = false;
            Log.i(TAG, "now is female");

            buttonMan.setActivated(false);
            buttonWomen.setActivated(true);

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

            if (koerpergroesse < 145 || koerpergroesse > 230) {
                // Fehler abfangen und Toaster anzeigen
                Context context = getApplicationContext();
                CharSequence text = "Bitte gebe eine Zahl zwischen 145 und 230 ein!";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                return;
            }
            normalgewicht = (int) koerpergroesse - 100;

            Log.i(TAG, "normalgewicht: " + normalgewicht);
            if (male) {
                idealgewicht = (int) (normalgewicht * 0.9);
            } else {
                idealgewicht = (int) (normalgewicht * 0.85);
            }
            Log.i(TAG, "Idealgewicht: " + idealgewicht);


            changeActivity();

        }
    }

    public class OnHelpListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Log.i(TAG, "Help");
            changeToHelp();

        }
    }

} // end of class