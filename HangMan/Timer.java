import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Timer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Timer extends Actor
{
    private int time = 6000;
    /**
     * Act - do whatever the Timer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        setImage(new GreenfootImage(""+(time/100), 60, Color.RED, null));
        
        countDown();
    }
    public void countDown()
    {
        if(time!=0)
        {
            time -= 2;
        }
        else
        {
            World world = getWorld();
            world.removeObject(this);
            Stage stage = (Stage)world;
            stage.gameOver = true;
        }
    }
    
    
}
