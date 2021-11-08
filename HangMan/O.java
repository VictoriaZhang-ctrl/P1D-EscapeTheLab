import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class O here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class O extends Letters
{
    /**
     * Act - do whatever the O wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        super.act();
    }
    
    @Override
    public void reportInput()
    {
        World world = getWorld();
        Stage stage = (Stage)world;
        Stack stack = stage.getStack();
        
        stack.push('o');
    }
}
