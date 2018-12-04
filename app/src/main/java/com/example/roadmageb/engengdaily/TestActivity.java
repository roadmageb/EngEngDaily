package com.example.roadmageb.engengdaily;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class TestActivity extends AppCompatActivity {
    Random rnd = new Random();
    RadioButton choose[] = new RadioButton[4];
    ArrayList<String> testList = new ArrayList<>();
    Button acButton;
    TextView oxText;
    int corrNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        
        acButton = (Button)findViewById(R.id.acceptButton);
        oxText = (TextView)findViewById(R.id.resultText);
        
        Intent thisIntent = getIntent();
        int todayDay = thisIntent.getIntExtra("day",0);
        choose[0] = (RadioButton)findViewById(R.id.radio1);
        choose[1] = (RadioButton)findViewById(R.id.radio2);
        choose[2] = (RadioButton)findViewById(R.id.radio3);
        choose[3] = (RadioButton)findViewById(R.id.radio4);

        if(todayDay != 6){
            for(int i=0; i<WordBase.inst.getTodayWordNum();i++){
                testList.add(WordBase.inst.getTodayByIndex(i));
            }
            Collections.sort(testList, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return rnd.nextInt(2);
                }
            });
        }else{
            WordBase.inst.sortWordStat();
            for(int i=0;i<Math.max(20,WordBase.inst.wordStat.size());i++)
                testList.add(WordBase.inst.wordStat.get(i).word);
            Collections.sort(testList, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return rnd.nextInt(2);
                }
            });
        }
    }
    void setQuestion(int index){
        corrNum = rnd.nextInt(4);
        for(int i=0;i<4;i++)
            choose[i].setText("");
        ////////////////////////////////////choose[corrNum].setText(WordBase.inst.getCorr(WordBase.inst));
    }
    
}
