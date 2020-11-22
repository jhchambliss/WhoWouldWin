package com.mobile.whowouldwin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class Second extends AppCompatActivity {

    private TextView c1Label, c2Label, c1v1Label, c1v2Label, c1v3Label, c2v1Label, c2v2Label, c2v3Label;
    private Button determineWinner;
    private SeekBar seekBar1, seekBar2, seekBar3, seekBar4, seekBar5, seekBar6;
    private String winner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.variable_input);

        // define variables for widgets
        c1Label = (TextView) findViewById(R.id.contestantOneInputLabel);
        c2Label = (TextView) findViewById(R.id.contestantTwoInputLabel);
        c1v1Label = (TextView) findViewById(R.id.c1v1Label);
        c1v2Label = (TextView) findViewById(R.id.c1v2Label);
        c1v3Label = (TextView) findViewById(R.id.c1v3Label);
        c2v1Label = (TextView) findViewById(R.id.c2v1Label);
        c2v2Label = (TextView) findViewById(R.id.c2v2Label);
        c2v3Label = (TextView) findViewById(R.id.c2v3Label);
        determineWinner = (Button) findViewById(R.id.determineWinner);
        seekBar1 = (SeekBar) findViewById(R.id.seekBar1);
        seekBar2 = (SeekBar) findViewById(R.id.seekBar2);
        seekBar3 = (SeekBar) findViewById(R.id.seekBar3);
        seekBar4 = (SeekBar) findViewById(R.id.seekBar4);
        seekBar5 = (SeekBar) findViewById(R.id.seekBar5);
        seekBar6 = (SeekBar) findViewById(R.id.seekBar6);

        // get data from intent
        Bundle bundle = getIntent().getExtras();

        final String name1 = bundle.getString("c1Name");
        final String name2 = bundle.getString("c2Name");
        String variable1 = bundle.getString("v1Name");
        String variable2 = bundle.getString("v2Name");
        String variable3 = bundle.getString("v3Name");

        // Set contestant names
        c1Label.setText(name1);
        c2Label.setText(name2);

        // set variable names
        c1v1Label.setText(variable1);
        c2v1Label.setText(variable1);
        c1v2Label.setText(variable2);
        c2v2Label.setText(variable2);
        c1v3Label.setText(variable3);
        c2v3Label.setText(variable3);

        determineWinner.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                // get data for contestant 1
                int c1v1 = seekBar1.getProgress();
                int c1v2 = seekBar2.getProgress();
                int c1v3 = seekBar3.getProgress();

                // get data for contestant 2
                int c2v1 = seekBar4.getProgress();
                int c2v2 = seekBar5.getProgress();
                int c2v3 = seekBar6.getProgress();

                int c1Total = c1v1 + c1v2 + c1v3;
                int c2Total = c2v1 + c2v2 + c2v3;

                if (c1Total > c2Total) {
                    winner = name1;
                } else if (c2Total > c1Total) {
                    winner = name2;
                } else {
                    winner = "It's a tie.";
                }

                Intent intent = new Intent(Second.this, Winner.class);
                intent.putExtra("winner", winner);
                startActivity(intent);
            }
        });
    }
}