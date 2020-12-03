package com.mobile.whowouldwin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class  Second extends AppCompatActivity {

    private SeekBar seekBar1, seekBar2, seekBar3, seekBar4, seekBar5, seekBar6;
    private String winner;
    private int most, least;
    private int c1v1, c1v2, c1v3, c2v1, c2v2, c2v3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.variable_input);

        // define variables for widgets
        TextView c1Label = findViewById(R.id.contestantOneInputLabel);
        TextView c2Label = findViewById(R.id.contestantTwoInputLabel);
        TextView c1v1Label = findViewById(R.id.c1v1Label);
        TextView c1v2Label = findViewById(R.id.c1v2Label);
        TextView c1v3Label = findViewById(R.id.c1v3Label);
        TextView c2v1Label = findViewById(R.id.c2v1Label);
        TextView c2v2Label = findViewById(R.id.c2v2Label);
        TextView c2v3Label = findViewById(R.id.c2v3Label);
        Button determineWinner = findViewById(R.id.determineWinner);
        seekBar1 = findViewById(R.id.seekBar1);
        seekBar2 = findViewById(R.id.seekBar2);
        seekBar3 = findViewById(R.id.seekBar3);
        seekBar4 = findViewById(R.id.seekBar4);
        seekBar5 = findViewById(R.id.seekBar5);
        seekBar6 = findViewById(R.id.seekBar6);

        // get data from intent
        Bundle bundle = getIntent().getExtras();

        final String name1 = bundle.getString("c1Name");
        final String name2 = bundle.getString("c2Name");
        String variable1 = bundle.getString("v1Name");
        String variable2 = bundle.getString("v2Name");
        String variable3 = bundle.getString("v3Name");
        most = bundle.getInt("most");
        least = bundle.getInt("least");

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
                c1v1 = seekBar1.getProgress();
                c1v2 = seekBar2.getProgress();
                c1v3 = seekBar3.getProgress();

                // get data for contestant 2
                c2v1 = seekBar4.getProgress();
                c2v2 = seekBar5.getProgress();
                c2v3 = seekBar6.getProgress();

                double c1Total = weighted(c1v1, c1v2, c1v3);
                double c2Total = weighted(c2v1, c2v2, c2v3);

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

    public double weighted(int a, int b, int c) {

        double x = a;
        double y = b;
        double z = c;

        // switch statement to apply weight for most important variable
        switch (most) {
            case 0:
                x = a * 1.25;
                break;
            case 1:
                y = b * 1.25;
                break;
            case 2:
                z = c * 1.25;
                break;
            case 3:
                break;
        }

        // switch statement to reduce weight for least important variable
        switch (least) {
            case 0:
                x = a * .8;
                break;
            case 1:
                y = b * .8;
                break;
            case 2:
                z = c * .8;
                break;
            case 3:
                break;
        }

        // return the total score
        return (x + y + z);

    }
}