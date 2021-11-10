import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class UndoButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UndoButton extends Actor
{
    /**
     * Act - do whatever the UndoButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (Greenfoot.mouseClicked(this) || Greenfoot.isKeyDown("Backspace"))
        {
            Greenfoot.playSound("mixkit-retro-arcade-casino-notification-211.wav");
            World world = getWorld();
            Stage stage = (Stage)world;
            
            stage.undo();
        }
    }
}
