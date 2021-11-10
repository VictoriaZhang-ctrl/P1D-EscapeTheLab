import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.concurrent.ThreadLocalRandom;
import java.util.*;

public class WordScrambler extends Actor
{
    public static String scrambled(String word)
    {
        String shuffledWord = word; //original
        int wordSize = word.length(); //make letter of the word equal to the length
        int shuffleCount = 5; // number of times words are shuffled
        for(int i=0;i<shuffleCount;i++)
        {
            //swap letters in two indexes
            int position1 = ThreadLocalRandom.current().nextInt(0, wordSize);
            int position2 = ThreadLocalRandom.current().nextInt(0, wordSize);
            shuffledWord = swapCharacters(shuffledWord,position1,position2);
        }
        return shuffledWord;//return method
    }
    
    private static String swapCharacters(String shuffledWord, int position1, int position2)
    {
        char[] charArray = shuffledWord.toCharArray();//Create an array for storing letters
        
        char temp = charArray[position1];
        charArray[position1] = charArray[position2];
        charArray[position2] = temp;//switching the letter of the word
        
        return new String(charArray);//return method
    }
    
    //fills HashMap with {key: scrambled word | value: unscrambled word}
    public static void fill(String word)
    {
        String scrambled = scrambled(word); // named type of the object 
        
        Stage.getHashMap().put(scrambled, word); //get the item and store into the stage
    }
    
    //returns a random scrambled word from within the HashMap
    public static String getRandomWord(HashMap map)
    {
        ArrayList<String> keys = new ArrayList<String>(map.keySet()); //create arraylist of an object called keys
        Random r = new Random(); //randomize the valuable r 
        
        String key = keys.get(r.nextInt(keys.size())); //the object will get the word base of the word size
        return key; //return method
    }
    
    //Returns unscrambled word
    public static String getValue(String key, HashMap<String, String> map)
    {
        return map.get(key); //return method
    }
}
