package com.example.roadmageb.engengdaily;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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
    
    Button acButton;
    TextView oxText;
    TextView wordText;
    int corrNum, pickNum;
    int qIndex=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        
        acButton = (Button)findViewById(R.id.acceptButton);
        oxText = (TextView)findViewById(R.id.resultText);
        wordText = (TextView)findViewById(R.id.questionText);
        
        Intent thisIntent = getIntent();
        int todayDay = thisIntent.getIntExtra("day",0);
        qIndex = WordBase.inst.testProgress;
        choose[0] = (RadioButton)findViewById(R.id.radio1);
        choose[1] = (RadioButton)findViewById(R.id.radio2);
        choose[2] = (RadioButton)findViewById(R.id.radio3);
        choose[3] = (RadioButton)findViewById(R.id.radio4);

        if(todayDay != 6){
            for(int i=0; i<WordBase.inst.getTodayWordNum();i++){
                WordBase.inst.testList.add(WordBase.inst.getTodayByIndex(i));
            }
            Collections.sort(WordBase.inst.testList, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return rnd.nextInt(2);
                }
            });
        }else{
            WordBase.inst.sortWordStat();
            for(int i=0;i<Math.max(20,WordBase.inst.wordStat.size());i++)
                WordBase.inst.testList.add(WordBase.inst.wordStat.get(i).word);
            Collections.sort(WordBase.inst.testList, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return rnd.nextInt(2);
                }
            });
        }
        setQuestion(qIndex);
        acButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(acButton.getText().equals("확인")){

                    pickNum=-1;
                    for(int i=0;i<4;i++) if(choose[i].isChecked()) pickNum = i;
                    if(pickNum == corrNum){
                        oxText.setText("정답");
                        //oxText
                        oxText.setVisibility(View.VISIBLE);
                        WordBase.inst.updateWordStat(WordBase.inst.testList.get(qIndex),true);
                    }else{
                        oxText.setText("오답");
                        oxText.setVisibility(View.VISIBLE);
                        choose[corrNum].setSelected(true);
                        WordBase.inst.updateWordStat(WordBase.inst.testList.get(qIndex),false);
                    }
                    WordBase.inst.saveStat();
                    if(qIndex == WordBase.inst.testList.size()-1)
                        acButton.setText("완료");
                    else
                        acButton.setText("다음");
                }else if(acButton.getText().equals("다음")){
                    acButton.setText("확인");
                    oxText.setVisibility(View.INVISIBLE);
                    setQuestion(++qIndex);
                }else{
                    finish();
                }
            }
        });

    }
    void setQuestion(int index){
        WordBase.inst.testProgress = qIndex+1;
        WordBase.inst.saveProgress();
        corrNum = rnd.nextInt(4);
        wordText.setText(WordBase.inst.testList.get(index));
        for(int i=0;i<4;i++)
            choose[i].setText("");
        choose[corrNum].setText(WordBase.inst.getMeaning(WordBase.inst.testList.get(index)));
        for(int i=0;i<4;i++) {
            choose[i].setChecked(false);
            if(i!=corrNum) {
                choose[i].setText(WordBase.inst.getMeaning(WordBase.inst.getWordByIndex(rnd.nextInt(WordBase.inst.getWordNum()))));
                boolean ret = false;
                for (int j = 0; j < 4; j++)
                    if (i != j && choose[i].getText().equals(choose[j].getText()))
                        ret = true;
                if(ret)i--;
            }
        }
    }
    
}
