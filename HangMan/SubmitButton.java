import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class SubmitButton extends Actor
{
    /**
     * Act - do whatever the Submit wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {   
        //it will play the wsubmit sound and renew to a new stage by use mouse or enter key to control
        if(Greenfoot.mouseClicked(this) || Greenfoot.isKeyDown("Enter"))
        {
            Greenfoot.playSound("mixkit-retro-arcade-casino-notification-211.wav");
            World world = getWorld();
            Stage stage = (Stage)world;
            
            stage.submit();
        }
    }
}
