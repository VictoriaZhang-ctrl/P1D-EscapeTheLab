import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * When interacted with, it requires the player to enter a 4-digit passcode
 * to enter the next room/complete the game.
 */
public class Door extends Actor
{
    /**
     * Act - do whatever the Door wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    // This makes a new lock combination every time with 4 numbers
    Numbers one = new Numbers();
    Numbers two = new Numbers();
    Numbers three = new Numbers();
    Numbers four = new Numbers();
    
    boolean spawned = false;
    boolean game = false;
    public void act()
    {
        // If the player interacts with the Door by pressing "space"
        // they will be required to enter a 4-digit number code
        if(this.isTouching(HangMan.class))
        {
            if(Greenfoot.isKeyDown("Space") && spawned == false)
            {
                // The lock will appear with 4 seperate boxes for the combination to be entered
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
        
        //gets the password for this particular room
        String password = stage.getPassword();
        
        String a = Integer.toString(one.getCurrentAns());
        String b = Integer.toString(two.getCurrentAns());
        String c = Integer.toString(three.getCurrentAns());
        String d = Integer.toString(four.getCurrentAns());
        
        String ans = ""+a+b+c+d;
        
        // If the inputted password is equal to the right combination
        // they are allowed to move onto the next room.
        if(ans.equals(password))
        {
            //The unlock sound will play
            Greenfoot.playSound("mixkit-gaming-lock-2848.wav");
            //The room will then change after a slight delay
            Greenfoot.delay(50);
            stage.increaseRoomNum();
            
            //the player's avatar is allowed to move again.
            HangMan.walkMode();
        }
    }
}
