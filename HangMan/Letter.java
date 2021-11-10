import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Scanner;
/**
 * Write a description of class Letters here.
 */
public class Letter extends Actor
{
    // class variables
    private char letter;
    private GreenfootImage image;
    /**
     * Act - do whatever the Letters wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    // This will spawn a picture of the letter
    public Letter(char letter)
    {
        this.letter = letter;
        image = new GreenfootImage(Character.toString(letter).toUpperCase() + ".png");
        setImage(image);
    }

    
    public void act()
    {
        if (Greenfoot.mouseDragged(this))
        {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            setLocation(mouse.getX(), mouse.getY());
        }
        //Enter Letter via Dragging
        if (Greenfoot.mouseDragEnded(this))
        {
            if(!this.isTouching(InputBox.class))
            {
                //do nothing
            }
            else
            {
                // Every time a letter is dragged, a paper sound will play
                Greenfoot.playSound("Paper paper.mp3");
                World world = getWorld();
                Stage stage = (Stage)world;

                reportLetter();
                
                stage.printStack();

                stage.clearString();

                world.removeObject(this);
            }
        }
        //Enter Letter via KeyBoard
        if(Greenfoot.isKeyDown(Character.toString(letter)))
        {
            // Everytime a letter is pressed a paper sound will play
            Greenfoot.playSound("Paper paper.mp3");
            
            World world = getWorld();
            Stage stage = (Stage)world;
            
            reportLetter();

            stage.printStack();

            stage.clearString();

            world.removeObject(this);
        }
    }
    
    // This pushes the letter on to the stack
    public void reportLetter()
    {
        World world = getWorld();
        Stage stage = (Stage)world;

        Stack stack = stage.getStack();
        stack.push(letter);
    }
}

