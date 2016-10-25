package com.example.pingu.dhbw_project;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class ResultActivity extends AppCompatActivity {

    private TextView normalgewicht;
    private TextView idealgewicht;
    private TextView height;
    private Button zurueck;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        normalgewicht = (TextView) findViewById(R.id.resultWeight);
        height = (TextView) findViewById(R.id.koerpergroesseEingabe);
        idealgewicht = (TextView) findViewById(R.id.resultIdealWeight);
        zurueck = (Button) findViewById(R.id.zurueck);


        zurueck.setOnClickListener(new MainActivity());

        Intent intent = getIntent();
        String ergebnis = intent.getStringExtra("normalgewicht");
        String idealErgebnis = intent.getStringExtra("idealgewicht");
        String heightEingabe = intent.getStringExtra("koerpergroesseEingabe");

        normalgewicht.setText(ergebnis);
        idealgewicht.setText(idealErgebnis);
        height.setText(heightEingabe);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void changeActivity() {
        finish();
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Result Page") // TODO: Define a title for the content shown.
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

    public class MainActivity extends Activity implements View.OnClickListener

    {

        @Override
        public void onClick(View v) {
        changeActivity();
        }
    }
}
