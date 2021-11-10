import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Scanner;
/**
 * Write a description of class Letters here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Letter extends Actor
{
    private char letter;
    private GreenfootImage image;
    /**
     * Act - do whatever the Letters wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

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
            Greenfoot.playSound("Paper paper.mp3");
            
            World world = getWorld();
            Stage stage = (Stage)world;

            reportLetter();

            stage.printStack();

            stage.clearString();

            world.removeObject(this);
        }
    }

    public void reportLetter()
    {
        World world = getWorld();
        Stage stage = (Stage)world;

        Stack stack = stage.getStack();
        stack.push(letter);
    }
}

