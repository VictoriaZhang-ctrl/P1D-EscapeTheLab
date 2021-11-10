import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

// A class for the player to see and choose a difficulty.

public class Rules extends Actor
{
    int showImage = 0;  //determines which instructions are shown on-screen
    public void act()
    {
        //Everytime the player clicks "Rules", it shows instructions on
        //how to play the game.
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
