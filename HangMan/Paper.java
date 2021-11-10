import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Star here.
 */
public class Paper extends Actor
{
    /**
     * Act - do whatever the Star wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        //If the player interacts with the Paper by pressing "Space"
        //They will be required to complete the WordScramble game.
        if(this.isTouching(HangMan.class))
        {
            if(Greenfoot.isKeyDown("Space"))
            {
                World world = getWorld();
                Stage stage = (Stage)world;
                
                //allows for words to be spawned ONCE
                stage.changeSpawnStatus();
                stage.beginWordScrambleGame();
                
                world.removeObject(this);
            }
        }
    }
}
