package com.mobile.whowouldwin;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    private EditText c1Name;
    private EditText c2Name;
    private EditText v1Name;
    private EditText v2Name;
    private EditText v3Name;
    private Spinner leastImportantSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // textboxes to enter contestant names
        c1Name = findViewById(R.id.contestantOneTextBox);
        c2Name = findViewById(R.id.contestantTwoTextBox);

        // textboxes to enter variable names
        v1Name = findViewById(R.id.variableOneTextBox);
        v2Name = findViewById(R.id.variableTwoTextBox);
        v3Name = findViewById(R.id.variableThreeTextBox);

        // widgets for ranking
        CheckBox yesCheckBox = findViewById(R.id.yesCheckBox);
        Spinner mostImportantSpinner = findViewById(R.id.mostImportantSpinner);
        Spinner leastImportantSpinner = findViewById(R.id.leastImportantSpinner);

        // the button
        Button submitNames = findViewById(R.id.submitNames);

        // set values for spinners
        // mostImportantSpinner



        yesCheckBox.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // make spinners visible??
            }
        });

        // onCLick to get the values
        submitNames.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                String name1 = c1Name.getText().toString();
                String name2 = c2Name.getText().toString();
                String variable1 = v1Name.getText().toString();
                String variable2 =  v2Name.getText().toString();
                String variable3 = v3Name.getText().toString();

                Intent intent = new Intent(HomeActivity.this, Second.class);
                intent.putExtra("c1Name", name1);
                intent.putExtra("c2Name", name2);
                intent.putExtra("v1Name", variable1);
                intent.putExtra("v2Name", variable2);
                intent.putExtra("v3Name", variable3);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_about:
                startActivity(new Intent(getApplicationContext(), AboutActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}