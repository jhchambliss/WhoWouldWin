package com.mobile.whowouldwin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText c1Name;
    private EditText c2Name;
    private EditText v1Name;
    private EditText v2Name;
    private EditText v3Name;
    private Button submitNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // textboxes to enter contestant names
        c1Name = (EditText) findViewById(R.id.contestantOneTextBox);
        c2Name = (EditText) findViewById(R.id.contestantTwoTextBox);

        // textboxes to enter variable names
        v1Name = (EditText) findViewById(R.id.variableOneTextBox);
        v2Name = (EditText) findViewById(R.id.variableTwoTextBox);
        v3Name = (EditText) findViewById(R.id.variableThreeTextBox);

        // the button
        submitNames = (Button) findViewById(R.id.submitNames);

        // onCLick to get the values
        submitNames.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                String name1 = c1Name.getText().toString();
                String name2 = c2Name.getText().toString();
                String variable1 = v1Name.getText().toString();
                String variable2 =  v2Name.getText().toString();
                String variable3 = v3Name.getText().toString();

                Intent intent = new Intent(MainActivity.this, Second.class);
                intent.putExtra("c1Name", name1);
                intent.putExtra("c2Name", name2);
                intent.putExtra("v1Name", variable1);
                intent.putExtra("v2Name", variable2);
                intent.putExtra("v3Name", variable3);
                startActivity(intent);
            }
        });

    }

}