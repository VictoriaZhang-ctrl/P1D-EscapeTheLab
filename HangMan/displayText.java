import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class displayText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class displayText extends Actor
{
    private String text;
    /**
     * Act - do whatever the displayText wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public displayText(String text)
    {
        this.text = text;
    }
    public void act()
    {
        setImage(new GreenfootImage(text, 48, Color.BLACK, Color.WHITE));
    }
}
