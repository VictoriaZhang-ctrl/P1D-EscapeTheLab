import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Timer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Timer extends Actor
{
    static int time;
    static int count;
    static boolean allowSpawnBird = true;
    JudgementBird bird = new JudgementBird();
    /**
     * Act - do whatever the Timer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(time > 0)
        {
            time--;
        }
        else if(allowSpawnBird)
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
    
    public static void allowSpawnBird()
    {
        allowSpawnBird = true;
    }
}
