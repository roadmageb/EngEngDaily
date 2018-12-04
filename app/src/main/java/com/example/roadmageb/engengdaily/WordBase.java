package com.example.roadmageb.engengdaily;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Random;

public class WordBase {
    private HashMap<String, String> wordDB;
    private HashMap<String, String> corrDB;
    private ArrayList<String> todayWord;
    public ArrayList<WordStat> wordStat;
    private ArrayList<String> unWord;
    private ArrayList<String> words;
    public static WordBase inst = new WordBase();


    public WordBase () {
        Random random = new Random();

        wordDB = new HashMap<>();
        corrDB = new HashMap<>();
        todayWord = new ArrayList<>();
        wordStat = new ArrayList<>();
        unWord = new ArrayList<>();

        wordDB.put("lucid","clear");
        wordDB.put("apple","red fruit");
        wordDB.put("banana","yellow long fruit. very sweet and can eat with mouth.");
        wordDB.put("kiwi","green fruit");

        corrDB.put("lucid", "clear");
        corrDB.put("apple", "red fruit");
        corrDB.put("banana", "yellow fruit");
        corrDB.put("kiwi", "green fruit");

        wordStat.add(new WordStat("lucid",20));
        wordStat.add(new WordStat("apple",15));

        unWord.addAll(wordDB.keySet());
        words.addAll(wordDB.keySet());

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
    public String getWordByIndex(int index) { return words.get(index); }
    public String getCorr(String key) { return corrDB.get(key); }
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
    public void sortWordStat() {
        Collections.sort(wordStat, new Comparator<WordStat>() {
            @Override
            public int compare(WordStat o1, WordStat o2) {
                return o2.stat.compareTo(o1.stat);
            }
        });
    }

}
