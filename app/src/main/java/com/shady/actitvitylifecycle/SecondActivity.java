package com.shady.actitvitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private TextView showMsg;
    private Button goBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Bundle extra = getIntent().getExtras();
        showMsg = findViewById(R.id.showMsg);
        goBack = findViewById(R.id.backButton);

        if (extra != null) {
            String name = extra.getString("name");
            int number = extra.getInt("number");

            showMsg.setText("Your name is "+name + " and your no is "+String.valueOf(number));
        }

        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntenet = getIntent();
                returnIntenet.putExtra("msgBack", "Hello from second Activity");
                setResult(RESULT_OK, returnIntenet);
                finish();
            }
        });

    }
}
