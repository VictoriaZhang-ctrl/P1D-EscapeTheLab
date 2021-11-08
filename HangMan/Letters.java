import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Scanner;
/**
 * Write a description of class Letters here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Letters extends Actor
{
    /**
     * Act - do whatever the Letters wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public Letters()
    {
        
    }

    public void act()
    {
        if (Greenfoot.mouseDragged(this))
        {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            setLocation(mouse.getX(), mouse.getY());
        }
        if (Greenfoot.mouseDragEnded(this))
        {
            if(!this.isTouching(InputBox.class))
            {
                //do nothing
            }
            else
            {
                reportInput();
                World world = getWorld();
                Stage stage = (Stage)world;
                
                stage.printStack();
                stage.clearString();
                world.removeObject(this);
            }
        }
    }
    
    public abstract void reportInput();
}
