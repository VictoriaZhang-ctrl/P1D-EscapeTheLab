import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Rules extends Actor
{
    /**
     * Act - do whatever the Rules wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int showImage = 0;
    public void act()
    {
        //When the Mouse arrow clicked the image and the stage will change to another image, also the clicking will play once the mouse clicked it.
        //and return to beginning stage
        if(Greenfoot.mouseClicked(this))
        {
            Greenfoot.playSound("mixkit-retro-arcade-casino-notification-211.wav");
            World world = getWorld();
            Stage stage = (Stage)world;

            if(Greenfoot.mouseClicked(null))
            {
                showImage++;
            }
            if(showImage == 1)
            {
                stage.setBackground("Rules_Basics.png");
            }
            else if(showImage == 2)
            {
                stage.setBackground("Rules_WordScramble.png");
            }
            else if(showImage == 3)
            {
                stage.setBackground("Rules_NumberLock.png");
            }
            else
            {
                stage.setBackground("BackGround_StarterPage.png");
                showImage = 0;
            }
        }
    }
}
