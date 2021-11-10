import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Door here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Door extends Actor
{
    /**
     * Act - do whatever the Door wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    Numbers one = new Numbers();
    Numbers two = new Numbers();
    Numbers three = new Numbers();
    Numbers four = new Numbers();
    
    boolean spawned = false;
    boolean game = false;
    public void act()
    {
        if(this.isTouching(HangMan.class))
        {
            if(Greenfoot.isKeyDown("Space") && spawned == false)
            {
                getWorld().showText(null, 600, 75);
                getWorld().addObject(one, 150, 75);
                getWorld().addObject(two, 450, 75);
                getWorld().addObject(three, 750, 75);
                getWorld().addObject(four, 1050, 75);
                HangMan.gameMode();
                spawned = true;
            }
        }
        Stage stage = (Stage)(getWorld());
        String password = stage.getPassword();
        
        String a = Integer.toString(one.getCurrentAns());
        String b = Integer.toString(two.getCurrentAns());
        String c = Integer.toString(three.getCurrentAns());
        String d = Integer.toString(four.getCurrentAns());
        
        String ans = ""+a+b+c+d;
        
        if(ans.equals(password))
        {
            Greenfoot.playSound("mixkit-gaming-lock-2848.wav");
            Greenfoot.delay(50);
            stage.increaseRoomNum();
            HangMan.walkMode();
        }
    }
}
