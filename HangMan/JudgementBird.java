import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class JudgementBird here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class JudgementBird extends Actor
{
    int count = 0;
    int endCounter = 300;
    /**
     * Act - do whatever the JudgementBird wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        approachPlayer();
        if(this.isTouching(HangMan.class))
        {
            endAnimation();
        }
    }

    public void approachPlayer()
    {
        count++;
        if(count == 0)
        {
            setImage("Walk1.png");
            move(20);
        }
        if(count == 60)
        {
            setImage("Walk2.png");
            move(20);
        }
        if(count == 120)
        {
            setImage("Walk3.png");
            move(20);
        }
        if(count == 180)
        {
            setImage("Walk4.png");
            move(20);
            count = 0;
        }
    }

    public void endAnimation()
    {
        World world = getWorld();
        Stage stage = (Stage)world;
        
        world.removeObjects(world.getObjects(Letters.class));
        world.removeObjects(world.getObjects(Paper.class));
        world.removeObjects(world.getObjects(InputBox.class));
        world.removeObjects(world.getObjects(Numbers.class));
        world.removeObjects(world.getObjects(SubmitButton.class));
        world.removeObjects(world.getObjects(UndoButton.class));
        
        Greenfoot.delay(10);
        setImage(new GreenfootImage("Reach1.png"));
        Greenfoot.delay(10);
        setImage(new GreenfootImage("Reach2.png"));
        Greenfoot.delay(10);
        setImage(new GreenfootImage("Reach3.png"));
        Greenfoot.delay(10);
        stage.gameOver();
    }
}
