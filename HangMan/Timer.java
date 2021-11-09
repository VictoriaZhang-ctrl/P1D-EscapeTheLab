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
            World world = getWorld();
            Stage stage = (Stage)world;
            
            getWorld().addObject(bird, 0, 400);
            allowSpawnBird = false;
        }
        count++;
    }
    
    public static void addTime()
    {
        time += 200;
    }
    
    public static void allowSpawnBird()
    {
        allowSpawnBird = true;
    }
}
