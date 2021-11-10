import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.concurrent.ThreadLocalRandom;
import java.util.*;
/**
 * Write a description of class WordScrambler here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordScrambler extends Actor
{
    public void act()
    {
          
    }
    
    public static String scrambled(String word)
    {
        String shuffledWord = word; //original
        int wordSize = word.length();
        int shuffleCount = 5; // number of times words are shuffled
        for(int i=0;i<shuffleCount;i++)
        {
            //swap letters in two indexes
            int position1 = ThreadLocalRandom.current().nextInt(0, wordSize);
            int position2 = ThreadLocalRandom.current().nextInt(0, wordSize);
            shuffledWord = swapCharacters(shuffledWord,position1,position2);
        }
        return shuffledWord;
    }
    
    private static String swapCharacters(String shuffledWord, int position1, int position2)
    {
        char[] charArray = shuffledWord.toCharArray();
        
        char temp = charArray[position1];
        charArray[position1] = charArray[position2];
        charArray[position2] = temp;
        return new String(charArray);
    }
    
    //fills HashMap with {key: scrambled word | value: unscrambled word}
    public static void fill(String word)
    {
        String scrambled = scrambled(word);
        
        Stage.getHashMap().put(scrambled, word);
    }
    
    //returns a random scrambled word from within the HashMap
    public static String getRandomWord(HashMap map)
    {
        ArrayList<String> keys = new ArrayList<String>(map.keySet());
        Random r = new Random();
        
        String key = keys.get(r.nextInt(keys.size()));
        return key;
    }
    
    //Returns unscrambled word
    public static String getValue(String key, HashMap<String, String> map)
    {
        return map.get(key);
    }
}
