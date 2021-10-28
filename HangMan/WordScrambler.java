import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.concurrent.ThreadLocalRandom;
/**
 * Write a description of class WordScrambler here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordScrambler extends Actor
{
    /**
     * Act - do whatever the WordScrambler wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public WordScrambler()
    {
        setImage(new GreenfootImage(scrambler("What"), 60, Color.RED, null)); 
    }
    
    public void act()
    {
         
    }
    
    public static String scrambler(String word)
    {
        String shuffledWord = word; //original
        int wordSize = word.length();
        int shuffleCount = 1; // number of times words are shuffled
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
}
