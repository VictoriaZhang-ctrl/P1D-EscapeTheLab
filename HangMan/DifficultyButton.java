import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DifficultyButton here.
 */
public class DifficultyButton extends Actor
{
    //class variable
    private int setDifficulty;
    /**
     * Act - do whatever the DifficultyButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    // This sets the images for the different difficulty buttons
    public DifficultyButton(int difficulty)
    {
        this.setDifficulty = difficulty;
        // The first difficulty is easy
        if(setDifficulty == 1)
        {
            setImage(new GreenfootImage("Easy.png"));
        }
        // The second difficulty is normal
        else if(setDifficulty == 2)
        {
            setImage(new GreenfootImage("Normal.png"));
        }
        // The third difficulty is hard
        else
        {
            setImage(new GreenfootImage("Hard.png"));
        }
    }
    public void act()
    {
        if(Greenfoot.mouseClicked(this))
        {
            World world = getWorld();
            Stage stage = (Stage)world;
            // This sound will play when the player clicks on the difficulty
            Greenfoot.playSound("mixkit-retro-arcade-casino-notification-211.wav");
            // this sets the stage to the difficulty chosen by the player
            stage.setDifficulty(setDifficulty);
            stage.difficultySelected();
        }
    }
}
