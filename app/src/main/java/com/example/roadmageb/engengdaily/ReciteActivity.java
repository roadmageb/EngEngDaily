package com.example.roadmageb.engengdaily;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ReciteActivity extends AppCompatActivity {
    int index = 0;
    TextView wordView;
    Button nextBtn;
    Button prevBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recite);
        wordView = (TextView)findViewById(R.id.wordText);
        nextBtn = (Button)findViewById(R.id.nextButton);
        prevBtn = (Button)findViewById(R.id.prevButton);
        index = 0;

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
    }
}
