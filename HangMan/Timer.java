import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Timer extends Actor
{
    static int time;        //the amount of time until JudgementBird is spawned.
    static int count;       //to display at the end, once the player wins.
    static boolean allowSpawnBird = true;
    JudgementBird bird = new JudgementBird();
    /**
     * Act - do whatever the Timer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(time > 0) //timer will count down
        {
            time--;
        }
        else if(allowSpawnBird) //it will reset the judgementBird begin and after timer comes off, it will release JudgementBird
        {
            Greenfoot.playSound("mixkit-horror-impact-773.wav");
            World world = getWorld();
            Stage stage = (Stage)world;
            
            getWorld().addObject(bird, 0, 400);
            allowSpawnBird = false;
        }
        count++; 
    }
    
    //Spawn the JudgementBird 10 seconds after this function is called.
    public static void addTime()
    {
        time += 1000;
    }
    
    //Allow for the spawn of the bird.
    //Called everytime the player enters a new room.
    public static void allowSpawnBird()
    {
        allowSpawnBird = true;
    }
}
