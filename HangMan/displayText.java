import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class displayText extends Actor
{
    private String text;
    /**
     * Act - do whatever the displayText wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public displayText(String text)
    {
        //display text in the world
        this.text = text;
    }
    public void act()
    {
        //Make txt size and color  
        setImage(new GreenfootImage(text, 48, Color.BLACK, Color.WHITE));
    }
}
