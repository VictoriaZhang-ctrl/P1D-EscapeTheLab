import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class Reader {
    public static void readInto(ArrayList<String> list) throws Exception
    {
        String url = "https://raw.githubusercontent.com/first20hours/google-10000-english/master/google-10000-english-no-swears.txt&quot";
        URL wordsURL = new URL(url);
        BufferedReader in = new BufferedReader(new InputStreamReader(wordsURL.openStream()));
        String word;
        while ((word = in.readLine()) != null)
        {
            list.add(word);
        }
        in.close();
    }
}
