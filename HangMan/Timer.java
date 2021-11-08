import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Timer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Timer extends Actor
{
<<<<<<< Updated upstream
    private int time = 6000;
=======
>>>>>>> Stashed changes
    /**
     * Act - do whatever the Timer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
<<<<<<< Updated upstream
    public void act()
    {
        setImage(new GreenfootImage(""+(time/100), 60, Color.RED, null));
        
        countDown();
    }
    public void countDown()
    {
        if(time!=0)
        {
            time -= 2;
        }
        else
        {
            World world = getWorld();
            world.removeObject(this);
            Stage stage = (Stage)world;
            stage.gameOver = true;
        }
    }
    
    
=======
    int time = 500;
    boolean spawn = true;
    public void act()
    {
        countdown();
        // Add your action code here.
    }

    public void countdown()
    {
        if(time > 0)
        {
            time-=2;
        }
        else
        {
            //gets the Stage to turn boolean gameOver to true, ending the game
            World world = getWorld();
            world.removeObject(this);
            Stage stage = (Stage)world;
            if(spawn)
            {
                stage.addObject(new JudgementBird(), 0, 400);
                spawn = false;
            }
        }
    }
    
    public void addTime()
    {
        time += 1000;
    }
    
    public void allowSpawnBird()
    {
        spawn = true;
    }
>>>>>>> Stashed changes
}
