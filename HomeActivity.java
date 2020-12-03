package com.mobile.whowouldwin;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity implements OnItemSelectedListener {

    private EditText c1Name;
    private EditText c2Name;
    private EditText v1Name;
    private EditText v2Name;
    private EditText v3Name;
    private TextView mostImportantTextView, leastImportantTextView;
    private int most, least;
    private Spinner mostImportantSpinner, leastImportantSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mostImportantTextView = findViewById(R.id.mostImportantTextView);
        leastImportantTextView = findViewById(R.id.leastImportantTextView);

        // textboxes to enter contestant names
        c1Name = findViewById(R.id.contestantOneTextBox);
        c2Name = findViewById(R.id.contestantTwoTextBox);

        // textboxes to enter variable names
        v1Name = findViewById(R.id.variableOneTextBox);
        v2Name = findViewById(R.id.variableTwoTextBox);
        v3Name = findViewById(R.id.variableThreeTextBox);

        // widgets for ranking
        final CheckBox yesCheckBox = findViewById(R.id.yesCheckBox);
        mostImportantSpinner = findViewById(R.id.mostImportantSpinner);
        leastImportantSpinner = findViewById(R.id.leastImportantSpinner);

        // the button
        Button submitNames = findViewById(R.id.submitNames);

        // set array adapter for spinner
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(
                this, R.array.mostImportantArray, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        mostImportantSpinner.setAdapter(adapter1);
        mostImportantSpinner.setOnItemSelectedListener(this);


        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(
                this, R.array.leastImportantArray, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        leastImportantSpinner.setAdapter(adapter2);
        leastImportantSpinner.setOnItemSelectedListener(this);



        // set visibility for ranking spinners based on whether or not the user wants to add weight to their variables
        yesCheckBox.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // make spinners visible??
                if (yesCheckBox.isChecked()) {
                    mostImportantSpinner.setVisibility(View.VISIBLE);
                    leastImportantSpinner.setVisibility(View.VISIBLE);
                    mostImportantTextView.setVisibility(View.VISIBLE);
                    leastImportantTextView.setVisibility(View.VISIBLE);
                } else {
                    mostImportantSpinner.setVisibility(View.GONE);
                    leastImportantSpinner.setVisibility(View.GONE);
                    mostImportantTextView.setVisibility(View.GONE);
                    leastImportantTextView.setVisibility(View.GONE);
                }
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
                intent.putExtra("most", most);
                intent.putExtra("least", least);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_about:
                startActivity(new Intent(getApplicationContext(), AboutActivity.class));
                return true;
            case R.id.menu_how_to_play:
                startActivity(new Intent(getApplicationContext(), PlayActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        // get ranking values
        most = mostImportantSpinner.getSelectedItemPosition();
        least = leastImportantSpinner.getSelectedItemPosition();
        // var 1 [0], var 2 [1], var 3 [2]
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        most = 3;
        least = 3;
    }
}