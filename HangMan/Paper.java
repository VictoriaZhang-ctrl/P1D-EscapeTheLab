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
        // This will run if the player pressed the space bar while the hangman is touching the paper
        if(this.isTouching(HangMan.class))
        {
            if(Greenfoot.isKeyDown("Space"))
            {
                World world = getWorld();
                Stage stage = (Stage)world;
                
                // The stage will change to the word scramble game after the paper was pressed
                stage.changeSpawnStatus();
                
                stage.scrambleWord_Game();
                
                world.removeObject(this);
            }
        }
    }
}
