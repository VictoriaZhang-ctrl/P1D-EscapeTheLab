import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class JudgementBird here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class JudgementBird extends Actor
{
    /**
     * Act - do whatever the JudgementBird wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        approachPlayer();
        if(this.isTouching(HangMan.class))
        {
            World world = getWorld();
            Stage stage = (Stage)world;
            stage.gameOver();
        }
        // Add your action code here.
    }
    
    public void approachPlayer()
    {
        move(1);
    }
    
}
