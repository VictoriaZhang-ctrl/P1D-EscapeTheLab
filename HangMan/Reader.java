import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class Reader {
    //When the reader reads the words from the url, the words from the reader will throw into the arraylist<String> "list"
    public static void readInto(ArrayList<String> list) throws Exception
    {
        String url = "https://raw.githubusercontent.com/first20hours/google-10000-english/master/google-10000-english-no-swears.txt";
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
