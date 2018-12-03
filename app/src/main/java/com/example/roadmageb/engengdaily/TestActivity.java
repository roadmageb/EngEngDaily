package com.example.roadmageb.engengdaily;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class TestActivity extends AppCompatActivity {

    RadioButton choose[] = new RadioButton[4];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        choose[0] = (RadioButton)findViewById(R.id.radio1);
        choose[1] = (RadioButton)findViewById(R.id.radio2);
        choose[2] = (RadioButton)findViewById(R.id.radio3);
        choose[3] = (RadioButton)findViewById(R.id.radio4);

    }
}
