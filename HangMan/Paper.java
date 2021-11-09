import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Star here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Paper extends Actor
{
    /**
     * Act - do whatever the Star wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(this.isTouching(HangMan.class))
        {
            if(Greenfoot.isKeyDown("Space"))
            {
                World world = getWorld();
                Stage stage = (Stage)world;
                
                stage.changeSpawnStatus();
                
                stage.scrambleWord_Game();
                
                world.removeObject(this);
            }
        }
    }
}
