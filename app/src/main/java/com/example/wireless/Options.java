package com.example.wireless;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Options extends AppCompatActivity {
    double total = 50;
    double lines = 0;
    DecimalFormat money = new DecimalFormat("#.##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);


        final EditText numLines = findViewById(R.id.txtNumLines);
        final Button btnNext = findViewById(R.id.btnNext);
        final CheckBox data = findViewById(R.id.checkData);
        final CheckBox mins = findViewById(R.id.checkMins);
        final CheckBox house = findViewById(R.id.checkHouse);
        final TextView results = findViewById(R.id.total);
        final Button btnTol = findViewById(R.id.btnTotal);



        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Options.this, Account.class));
            }
        });

        btnTol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (data.isChecked()) {
                    lines=Double.parseDouble(numLines.getText().toString());
                    total = total + (lines*15);
                    total= total +60;
                    results.setText("$"+money.format(total));
                }
                if (mins.isChecked()) {
                    lines=Double.parseDouble(numLines.getText().toString());
                    total = total + (lines*15);
                    total = total +30;
                    results.setText("$"+money.format(total));
                }
                if (house.isChecked()) {
                    lines=Double.parseDouble(numLines.getText().toString());
                    total = total + (lines*15);
                    total = total + 50;
                    results.setText("$"+money.format(total));
                }

                if(data.isChecked() && (mins.isChecked() || house.isChecked()))
                {
                    lines=Double.parseDouble(numLines.getText().toString());

                    total = total-(total*.15);
                    results.setText("$"+money.format(total));
                }
                if(mins.isChecked() &&(data.isChecked() || house.isChecked()))
                {
                    lines=Double.parseDouble(numLines.getText().toString());

                    total = total-(total*.15);
                    results.setText("$"+money.format(total));
                }
                if(house.isChecked() &&(data.isChecked() || mins.isChecked()))
                {
                    lines=Double.parseDouble(numLines.getText().toString());

                    total = total-(total*.15);
                    results.setText("$"+money.format(total));
                }

                total=50;
            }
        });

    }
}
