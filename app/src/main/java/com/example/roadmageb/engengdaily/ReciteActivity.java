package com.example.roadmageb.engengdaily;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ReciteActivity extends AppCompatActivity {
    int index = 0;
    TextView wordView;
    Button nextBtn;
    Button prevBtn;
    LinearLayout meaningLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recite);
        wordView = (TextView)findViewById(R.id.wordText);
        nextBtn = (Button)findViewById(R.id.nextButton);
        prevBtn = (Button)findViewById(R.id.prevButton);
        meaningLayout = (LinearLayout)findViewById(R.id.parentLayout);
        index = 0;

        setContents();

        prevBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index = Math.max(index - 1, 0);
                setContents();
            }
        });
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(index == SelectActivity.WB.getTodayWordNum() - 1)
                    finish();
                else {
                    index = Math.min(index + 1, SelectActivity.WB.getTodayWordNum() - 1);
                    setContents();
                }
            }
        });
    }

    void setContents(){
        if(index == 0)
            prevBtn.setEnabled(false);
        if(index == SelectActivity.WB.getTodayWordNum() - 1)
            nextBtn.setText("완료");

        wordView.setText(SelectActivity.WB.getTodayByIndex(index));

        String meaning = SelectActivity.WB.getMeaning(SelectActivity.WB.getTodayByIndex(index));
        String meaningSplit[] = meaning.split(" ");

        LinearLayout newLine = new LinearLayout(this);
        meaningLayout.addView(newLine);

        for(String sptWord : meaningSplit){
            TextView wordTmp = new TextView(this);
            wordTmp.setText(sptWord);
            if(SelectActivity.WB.getContains(sptWord.toLowerCase()))
                wordTmp.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){

                    }
                });
            newLine.addView(wordTmp);
            
        }
    }
}
