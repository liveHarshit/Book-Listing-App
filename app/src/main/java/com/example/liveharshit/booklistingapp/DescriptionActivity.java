package com.example.liveharshit.booklistingapp;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DescriptionActivity extends AppCompatActivity {
    Intent intentExtra = getIntent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String description;
        Bundle bundle = getIntent().getExtras();
        description = bundle.getString("description");
        Log.e("Description",description);

        TextView descriptionTextView = (TextView)findViewById(R.id.description_text_view);
        descriptionTextView.setText(description);

    }
}
