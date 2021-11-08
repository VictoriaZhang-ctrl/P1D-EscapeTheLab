import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Door here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Door extends Actor
{
    /**
     * Act - do whatever the Door wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    Numbers one = new Numbers();
    Numbers two = new Numbers();
    Numbers three = new Numbers();
    Numbers four = new Numbers();
    
    boolean spawned = false;
    public void act()
    {
        if(this.isTouching(HangMan.class))
        {
            if(Greenfoot.isKeyDown("Space") && spawned == false)
            {
                getWorld().addObject(one, 150, 75);
                getWorld().addObject(two, 450, 75);
                getWorld().addObject(three, 750, 75);
                getWorld().addObject(four, 1050, 75);
                spawned = true;
            }
        }
    }
}
