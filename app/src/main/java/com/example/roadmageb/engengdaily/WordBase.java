package com.example.roadmageb.engengdaily;

import java.util.ArrayList;
import java.util.HashMap;

public class WordBase {
    private HashMap<String, String> wordDB;
    private ArrayList<String> todayWord;
    private ArrayList<WordStat> wordStat;

    public WordBase () {
        wordDB = new HashMap<>();
        todayWord = new ArrayList<>();
        wordStat = new ArrayList<>();
        wordDB.put("lucid","clear");
    }
    public String getMeaning (String key){
        return wordDB.get(key);
    }
    class WordStat
    {
        String word;
        int stat;
        WordStat(String word, int stat){
            this.word = word;
            this.stat = stat;
        }
        WordStat(){
            this.word = "";
            this.stat = 0;
        }
        int getStat(){
            return stat;
        }
        void setRel(int rel){
            stat += rel;
        }
    }
}
