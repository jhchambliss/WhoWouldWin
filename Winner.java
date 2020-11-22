package com.mobile.whowouldwin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Winner extends AppCompatActivity {

    TextView winnerAnnouncement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);

        winnerAnnouncement = (TextView) findViewById(R.id.winnerTextView);

        Intent intent = getIntent();

        String winner = intent.getStringExtra("winner");

        winnerAnnouncement.setText(winner);

    }
}