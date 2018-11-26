package com.example.roadmageb.engengdaily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class WordBase {
    private HashMap<String, String> wordDB;
    private ArrayList<String> todayWord;
    private ArrayList<WordStat> wordStat;
    private ArrayList<String> unWord;

    public WordBase () {
        Random random = new Random();

        wordDB = new HashMap<>();
        todayWord = new ArrayList<>();
        wordStat = new ArrayList<>();
        unWord = new ArrayList<>();

        wordDB.put("lucid","clear");
        wordDB.put("apple","red fruit");
        wordDB.put("banana","yellow long fruit");
        wordDB.put("kiwi","green fruit");

        wordStat.add(new WordStat("lucid",20));
        wordStat.add(new WordStat("apple",15));

        unWord.addAll(wordDB.keySet());

        for(WordStat ws : wordStat)
            unWord.remove(ws.word);

        for(int i=0; i<10 && unWord.size()>0; i++){
            if(wordDB.isEmpty()) break;
            System.out.println(unWord.size());
            int tmp = random.nextInt(unWord.size());
            todayWord.add(unWord.get(tmp));
            unWord.remove(tmp);
        }
    }
    public boolean getContains(String key) { return wordDB.containsKey(key);}
    public String getMeaning (String key){
        return wordDB.get(key);
    }
    public String getTodayByIndex (int index){
        return todayWord.get(index);
    }
    public int getTodayWordNum(){
        return todayWord.size();
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
