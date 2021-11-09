import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HangedMan here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HangedMan extends Actor
{
    /**
     * Act - do whatever the HangedMan wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        World world = getWorld();
        Stage stage = (Stage)world;

        endAnimation();
        
        Greenfoot.delay(50);
        
        world.removeObjects(world.getObjects(null));
        
        stage.setBackground(new GreenfootImage("GameOverScreen.png"));
        
        Greenfoot.stop();
    }
    
    public void endAnimation()
    {
        for(int i = 0; i<5; i++)
        {
            Greenfoot.delay(10);
            setLocation(getX(), getY()+20);
            Greenfoot.delay(10);
        }
    }
}
