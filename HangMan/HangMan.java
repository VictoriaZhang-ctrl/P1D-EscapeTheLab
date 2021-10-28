import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HangMan here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HangMan extends Actor
{
    /**
     * Act - do whatever the HangMan wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        walk();
    }
    
    public void walk()
    {
        if(Greenfoot.isKeyDown("right") == true)
        {
            move(1);
        }
        if(Greenfoot.isKeyDown("left") == true)
        {
            move(-1);
        }
    }
}
