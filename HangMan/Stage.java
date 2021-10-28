import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Stage extends World

{
    public int MAX_WordScramble = 5;
    
    public boolean gameStart = false;
    public boolean gameOver = false;
    
    GreenfootImage background = new GreenfootImage("BackGround.png");
    
    //Map the unscrambled vs scrambled word (key: unscrambled, value: scrambled)
    HashMap<String, ArrayList> dictionary = new HashMap<String, ArrayList>();
    
    HangMan man = new HangMan();
    
    Timer timer = new Timer();
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Stage()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 600, 1); 
    }
    
    public void act()
    {
        setBackground(background);
        addObject(man, 75, 465);
        addObject(timer, 600, 75);
    }
    
    public void fillDictionary()
    {
        
    }
    
    public void hangMan_Game(String word)
    {
        
    }
    
    public void scrambleWord_Game(String word)
    {
        
    }
}
