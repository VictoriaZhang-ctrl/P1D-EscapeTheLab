import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Numbers here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Numbers extends Actor
{
    Queue<Integer> queue = new Queue<Integer>();
    Queue<GreenfootImage> pictureQueue = new Queue<GreenfootImage>();
    boolean queueFilled = false;
    /**
     * Act - do whatever the Numbers wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
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
    
    public Numbers()
    {
        currentAns = this.currentAns;
    }
    public void act()
    {
        if(!queueFilled)
        {
            fillQueue();
            fillPictureQueue();
        }
        
        if(Greenfoot.mouseClicked(this))
        {
            int x = queue.dequeue();
            GreenfootImage image = pictureQueue.dequeue();
            
            queue.enqueue(x);
            pictureQueue.enqueue(image);
            
            setImage(image);
            currentAns = x;
        }
    }
    
    public void fillQueue()
    {
        for(int i = 0; i<10; i++)
        {
            queue.enqueue(i);
        }
        queueFilled = true;
    }
    
    public void fillPictureQueue()
    {
        pictureQueue.enqueue(zero);
        pictureQueue.enqueue(one);
        pictureQueue.enqueue(two);
        pictureQueue.enqueue(three);
        pictureQueue.enqueue(four);
        pictureQueue.enqueue(five);
        pictureQueue.enqueue(six);
        pictureQueue.enqueue(seven);
        pictureQueue.enqueue(eight);
        pictureQueue.enqueue(nine);
    }
    
    public int getCurrentAns()
    {
        return currentAns;
    }
}
