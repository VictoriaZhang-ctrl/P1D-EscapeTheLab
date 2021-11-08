import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class TestWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestWorld extends World
{

    /**
     * Constructor for objects of class TestWorld.
     * 
     */
    public TestWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);

        ArrayList<String> myList = new ArrayList<String>();
        try{
            Reader.readInto(myList);
        } catch(Exception e) {
        }
        
        Queue<String> q = new Queue<String>();
        for(int i = 0; i < 10; i++)
        {
            int n = (int)( Math.random() * 100);
            q.enqueue(myList.get(n));
        }
        
        for(String str: q){
            System.out.println(str);    
        }
        
    }
}
