import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HangMan here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HangMan extends Actor
{
    GreenfootImage original = new GreenfootImage("StickMan_Scared.png");
    GreenfootImage inverted = new GreenfootImage("StickMan_flipped.png");
    
    GreenfootImage right1 = new GreenfootImage("Walk_1.png");
    GreenfootImage right2 = new GreenfootImage("Walk_2.png");
    
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
    
    private int right = 0;
    private int rightImage = 0;
    
    private int left = 0;
    private int leftImage = 0;
    
    private int speed = 5;
    public void walk()
    {
        if(Greenfoot.isKeyDown("right") == true)
        {
            right++;
        }
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
        
        if(Greenfoot.isKeyDown("left") == true)
        {
            left++;
        }
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
