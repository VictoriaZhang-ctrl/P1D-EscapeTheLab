import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Is used in an animation in when the players gets a Game Over.
 * Does not serve any other function.
 */
public class HangedMan extends Actor
{
    /**
     * Act - do whatever the HangedMan wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    // This will run if the player loses
    public void act()
    {
        World world = getWorld();
        Stage stage = (Stage)world;
        
        // The ending animation will play
        endAnimation();
        
        Greenfoot.delay(50);
        
        // All the objects are removed
        world.removeObjects(world.getObjects(null));
        
        // This sets the background to the game over screen
        stage.setBackground(new GreenfootImage("GameOverScreen.png"));
        
        Greenfoot.stop();
    }
    
    // This sets the ending animation
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
