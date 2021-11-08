import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class C here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class C extends Letters
{
    /**
     * Act - do whatever the C wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public C()
    {
        
    }
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
        
        stack.push('c');
    }
}
