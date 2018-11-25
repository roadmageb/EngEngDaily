package com.example.roadmageb.engengdaily;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;

public class SelectActivity extends AppCompatActivity {
    public static WordBase WB = new WordBase();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        Button goReciteButton = (Button)findViewById(R.id.reciteButton);
        Button goTestButton = (Button)findViewById(R.id.testButton);
        TextView dayText = (TextView)findViewById(R.id.dayTextView);

        Calendar cal = Calendar.getInstance();
        String days[] = new String[]{"일","월","화","수","목","금","토"};
        int todayDay = cal.get(Calendar.DAY_OF_WEEK)-1;

        dayText.setText("오늘은 " + days[todayDay] + "요일");

        /*if(todayDay == 0){
            goReciteButton.setEnabled(false);
            goTestButton.setEnabled(false);
        }*/

        goReciteButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(),ReciteActivity.class);
                startActivity(intent);
            }
        });

        goTestButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(),TestActivity.class);
                startActivity(intent);
            }
        });
    }
}
