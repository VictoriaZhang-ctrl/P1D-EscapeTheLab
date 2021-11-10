import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

// A class for the player to interact with when they want to finalize their answer.
public class SubmitButton extends Actor
{
    /**
     * Act - do whatever the Submit wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {  
        if(Greenfoot.mouseClicked(this) || Greenfoot.isKeyDown("Enter"))
        {
            Greenfoot.playSound("mixkit-retro-arcade-casino-notification-211.wav");
            World world = getWorld();
            Stage stage = (Stage)world;
            
            stage.submit();
        }
    }
}
