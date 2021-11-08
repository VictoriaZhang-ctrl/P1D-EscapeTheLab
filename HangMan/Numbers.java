import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Numbers here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Numbers extends Actor
{
    Queue<Integer> num = new Queue<Integer>();
    Queue<GreenfootImage> image = new Queue<GreenfootImage>();

    boolean queueFilled = false;

    GreenfootImage zero = new GreenfootImage("0.png");
    GreenfootImage one = new GreenfootImage("1.png");
    GreenfootImage two = new GreenfootImage("2.png");
    GreenfootImage three = new GreenfootImage("3.png");
    GreenfootImage four = new GreenfootImage("4.png");
    GreenfootImage five = new GreenfootImage("5.png");
    GreenfootImage six = new GreenfootImage("6.png");
    GreenfootImage seven = new GreenfootImage("7.png");
    GreenfootImage eight = new GreenfootImage("8.png");
    GreenfootImage nine = new GreenfootImage("9.png");
    
    public int currentAns;

    /**
     * Act - do whatever the Numbers wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        fillQueue();
        
        numLock();
    }

    public void fillQueue()
    {
        if(!queueFilled)
        {
            for(int i = 0; i<10; i++)
            {
                num.enqueue(i);
            }
            image.enqueue(zero);
            image.enqueue(one);
            image.enqueue(two);
            image.enqueue(three);
            image.enqueue(four);
            image.enqueue(five);
            image.enqueue(six);
            image.enqueue(seven);
            image.enqueue(eight);
            image.enqueue(nine);
            
            queueFilled = true;
        }
    }

    public void numLock()
    {
        if(Greenfoot.mouseClicked(this))
        {
            int x = num.dequeue();
            num.enqueue(x);
            
            GreenfootImage i = image.dequeue();
            image.enqueue(i);
            
            setImage(i);
        }
    }
    
    public int getCurrentAns()
    {
        return currentAns;
    }
}
