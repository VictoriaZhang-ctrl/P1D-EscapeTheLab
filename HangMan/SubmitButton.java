import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Submit here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SubmitButton extends Actor
{
    /**
     * Act - do whatever the Submit wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public SubmitButton()
    {
        
    }
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
        {
            World world = getWorld();
            Stage stage = (Stage)world;
            
            stage.submit();
        }
    }
}
