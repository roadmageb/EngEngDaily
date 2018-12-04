package com.example.roadmageb.engengdaily;
public class WordStat
{
    String word;
    Integer stat;
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
