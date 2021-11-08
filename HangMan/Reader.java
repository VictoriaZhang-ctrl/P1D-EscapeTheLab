import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Reader extends Queue{
    public static ArrayList<String> readNouns() throws Exception {
        return readWords("https://gist.githubusercontent.com/sirkets/7d89492826a0d245a086e8c5c56829a8/raw/307ef87315bf0360f682bf25821fdcf4fe71db8c/nouns.txt");
    }
    
    public static ArrayList<String> readVerbs() throws Exception {
        return readWords("https://gist.githubusercontent.com/sirkets/2b7c3122db8c0bc08aa9e82a35175b3e/raw/16f6c7296d21910ee28cfcd637a9176f093e0da6/verbs.txt");
    }
    
    public static ArrayList<String> readAdjectives() throws Exception {
        return readWords("https://gist.githubusercontent.com/sirkets/ab19d0cd12e24d7a906af9e8b44e526c/raw/3244d71ac98f9d07646b99e17d0a21b1e4cef23b/adjectives.txt");
    }
    
    private static ArrayList<String> readWords(String url) throws Exception {
        URL wordsURL = new URL(url);//URL Original
        BufferedReader in = new BufferedReader(new InputStreamReader(wordsURL.openStream()));
        ArraList<String> list = new ArrayList<String>();
        String word;
        while (list.size() < 30 && (word = in.readLine()) != null) {
            list.add(word);
        }
        in.close();
        return list;
    }
    private static String RandomThreeList()
    {
        //name call myRandom
        Random myRandom = new Random();
        String readWords = 1; 
        String readVerbs = 2;
        String readAdjectives = 3;
        int [] threeList = {1,2,3} ;
        int random = myRandom.nextInt(threeList.length);
        //random is three list
        if (random == 1) {
            random.ArrayList;
        }else if (random == 2) 
        {
            random.ArrayList;
        }else if (random == 3) 
        {
            random(ArrayList<String>);
        }else 
        {
            //do nothing123
        }
    }
}

