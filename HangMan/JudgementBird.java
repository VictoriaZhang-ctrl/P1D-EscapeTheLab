import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class JudgementBird here.
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
        // The judgement bird will walk towards the player
        approachPlayer();
        // If the judgement bird is touching the player, they will be caught
        if(this.isTouching(HangMan.class))
        {
            catchPlayer();
        }
        // Add your action code here.
    }

    public void approachPlayer()
    {
        count++;
        // These are the animations and sounds that will play when the judgement bird is walking
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
    
    // This willl run if the judgement bird catches the player
    public void catchPlayer()
    {
        World world = getWorld();
        Stage stage = (Stage)world;
        
        // The games are removed
        world.removeObjects(world.getObjects(Letter.class));
        world.removeObjects(world.getObjects(InputBox.class));
        world.removeObjects(world.getObjects(SubmitButton.class));
        world.removeObjects(world.getObjects(UndoButton.class));
        
        // The animation for the judgement bird catching the player will play
        Greenfoot.delay(15);
        setImage(new GreenfootImage("Reach1.png"));
        Greenfoot.delay(15);
        setImage(new GreenfootImage("Reach2.png"));
        Greenfoot.delay(15);
        setImage(new GreenfootImage("Reach3.png"));
        Greenfoot.delay(15);
        
        // The sound effect will play
        Greenfoot.playSound("mixkit-gore-video-game-blood-splash-263.wav");
        
        // The stage will be changed to the game over stage
        stage.gameOver();
    }
}
