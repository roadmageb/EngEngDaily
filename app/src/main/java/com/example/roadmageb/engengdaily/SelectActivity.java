package com.example.roadmageb.engengdaily;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SelectActivity extends AppCompatActivity {
    int todayDay = 0;

    Button goReciteButton;
    Button goTestButton;
    TextView dayText;
    public static String masterDir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);
        masterDir = getFilesDir().toString();
        WordBase.inst=new WordBase();
        goReciteButton = (Button)findViewById(R.id.reciteButton);
        goTestButton = (Button)findViewById(R.id.testButton);
        dayText = (TextView)findViewById(R.id.dayTextView);

        Calendar cal = Calendar.getInstance();
        String days[] = new String[]{"일","월","화","수","목","금","토"};
        todayDay = cal.get(Calendar.DAY_OF_WEEK)-1;

        WordBase.inst.loadProgress();

        dayText.setText("오늘은 " + days[todayDay] + "요일");

        if(todayDay == 0){
            goReciteButton.setEnabled(false);
            goTestButton.setEnabled(false);
        }else if(todayDay == 6){
            goReciteButton.setEnabled(false);
            goTestButton.setEnabled(true);
            goTestButton.setText("종합시험");
        }else{
            goReciteButton.setEnabled(true);
            goTestButton.setText("테스트");
        }

        goReciteButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(),ReciteActivity.class);
                startActivity(intent);
            }
        });

        goTestButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){if(WordBase.inst.reciteEnd == 1 || todayDay == 6) {
                    Intent intent = new Intent(getApplicationContext(), TestActivity.class);
                    intent.putExtra("day", todayDay);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(),"먼저 암기를 완료하세요",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
