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
                // Every time a letter is dragged and dropped into InputBox
                // The string displayed to the player updates so that
                // it matches the current status of the word.
                Greenfoot.playSound("Paper paper.mp3");
                World world = getWorld();
                Stage stage = (Stage)world;

                reportInput();
                
                stage.printStack();

                stage.clearString();

                world.removeObject(this);
            }
        }
    }
    
    // This pushes the letter on to the stackOfStrings found in Stage
    // The stackOfStrings records the user's inputs
    public void reportInput()
    {
        World world = getWorld();
        Stage stage = (Stage)world;

        Stack stack = stage.getStack();
        stack.push(letter);
    }
}

