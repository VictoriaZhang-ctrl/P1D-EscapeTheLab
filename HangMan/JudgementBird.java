import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class JudgementBird here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class JudgementBird extends Actor
{
    /**
     * Act - do whatever the JudgementBird wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int count = 0;
    public void act()
    {
        approachPlayer();
        if(this.isTouching(HangMan.class))
        {
            catchPlayer();
        }
        // Add your action code here.
    }

    public void approachPlayer()
    {
        count++;
        if(count == 100)
        {
            Greenfoot.playSound("mixkit-hard-horror-hit-drum-565.wav");
            setImage(new GreenfootImage("Walk1.png"));
            move(10);
        }
        if(count == 150)
        {
            setImage(new GreenfootImage("Walk2.png"));
            move(10);
        }
        if(count == 200)
        {
            Greenfoot.playSound("mixkit-hard-horror-hit-drum-565.wav");
            setImage(new GreenfootImage("Walk3.png"));
            move(10);
        }
        if(count == 250)
        {
            setImage(new GreenfootImage("Walk4.png"));
            move(10);
            count = 0;
        }
    }

    public void catchPlayer()
    {
        World world = getWorld();
        Stage stage = (Stage)world;
        
        world.removeObjects(world.getObjects(Letter.class));
        world.removeObjects(world.getObjects(InputBox.class));
        world.removeObjects(world.getObjects(SubmitButton.class));
        world.removeObjects(world.getObjects(UndoButton.class));
        
        Greenfoot.delay(15);
        setImage(new GreenfootImage("Reach1.png"));
        Greenfoot.delay(15);
        setImage(new GreenfootImage("Reach2.png"));
        Greenfoot.delay(15);
        setImage(new GreenfootImage("Reach3.png"));
        Greenfoot.delay(15);
        
        Greenfoot.playSound("mixkit-gore-video-game-blood-splash-263.wav");
        
        stage.gameOver();
    }
}
