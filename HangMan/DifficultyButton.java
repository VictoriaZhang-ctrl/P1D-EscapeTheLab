import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DifficultyButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DifficultyButton extends Actor
{
    private int setDifficulty;
    /**
     * Act - do whatever the DifficultyButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public DifficultyButton(int difficulty)
    {
        this.setDifficulty = difficulty;
        if(setDifficulty == 1)
        {
            setImage(new GreenfootImage("Easy.png"));
        }
        else if(setDifficulty == 2)
        {
            setImage(new GreenfootImage("Normal.png"));
        }
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
            
            Greenfoot.playSound("mixkit-retro-arcade-casino-notification-211.wav");
            
            stage.setDifficulty(setDifficulty);
            
            stage.difficultySelected();
        }
    }
}
