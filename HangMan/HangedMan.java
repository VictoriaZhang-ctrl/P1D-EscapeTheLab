import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HangedMan here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HangedMan extends Actor
{
    boolean move = true;
    /**
     * Act - do whatever the HangedMan wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(move)
        {
            for(int i = 0; i<10; i++)
            {
                Greenfoot.delay(5);
                setLocation(getX(), getY()+20);
                Greenfoot.delay(20);
            }
            move = false;
            Greenfoot.stop();
        }
    }
}
