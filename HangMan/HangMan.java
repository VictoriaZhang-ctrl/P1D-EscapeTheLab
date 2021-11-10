import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HangMan here.
 */
public class HangMan extends Actor
{
    // This includes both pictures for the Stickman, original and inverted
    GreenfootImage original = new GreenfootImage("StickMan_Scared.png");
    GreenfootImage inverted = new GreenfootImage("StickMan_flipped.png");
    
    // This includes the walking right animation for the Stickman
    GreenfootImage right1 = new GreenfootImage("Walk_1.png");
    GreenfootImage right2 = new GreenfootImage("Walk_2.png");
    
    // This includes the walking left animation for the Stickman
    GreenfootImage left1 = new GreenfootImage("Walk_3.png");
    GreenfootImage left2 = new GreenfootImage("Walk_4.png");
    
    public static boolean inGame = false;
    /**
     * Act - do whatever the HangMan wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(!inGame)
        {
            walk();
        }
    }
    
    // class variables
    private int right = 0;
    private int rightImage = 0;
    
    private int left = 0;
    private int leftImage = 0;
    
    private int speed = 5;
    
    // This method is what enables the Stickman to walk
    public void walk()
    {
        // If the right key is down, the Stickman will walk right
        if(Greenfoot.isKeyDown("right") == true)
        {
            right++;
        }
        // These are used for the walking right animation
        if(right == 5)
        {
            rightImage = 1;
        }
        if(right == 10)
        {
            rightImage = 2;
        }
        if(right == 15)
        {
            rightImage = 3;
            right = 0;
        }
        
        if(rightImage == 1)
        {
            setImage(right1);
            move(speed);
        }
        if(rightImage == 2)
        {
            setImage(original);
            move(speed);
        }
        if (rightImage == 3)
        {
            setImage(right2);
            move(speed);
        }
        
        if (Greenfoot.isKeyDown("right") == false)
        {
            right = 0;
            rightImage = 0;
        }
        
        // If the left key is down, the Stickman will walk left
        if(Greenfoot.isKeyDown("left") == true)
        {
            left++;
        }
        
        // These are used for the walking left animation
        if(left == 5)
        {
            leftImage = 1;
        }
        if(left == 10)
        {
            leftImage = 2;
        }
        if(left == 15)
        {
            leftImage = 3;
            left = 0;
        }
        
        if(leftImage == 1)
        {
            setImage(left1);
            move(-(speed));
        }
        if(leftImage == 2)
        {
            setImage(inverted);
            move(-(speed));
        }
        if (leftImage == 3)
        {
            setImage(left2);
            move(-(speed));
        }
        
        if (Greenfoot.isKeyDown("left") == false)
        {
            left = 0;
            leftImage = 0;
        }
        
        if(leftImage == 0 && rightImage == 0)
        {
            setImage(original);
        }
    }
    
    public static void walkMode()
    {
        inGame = false;
    }
    public static void gameMode()
    {
        inGame = true;
    }
    
}
