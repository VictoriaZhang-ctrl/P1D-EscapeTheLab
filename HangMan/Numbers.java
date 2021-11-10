import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Numbers here.
 */
public class Numbers extends Actor
{
    Queue<Integer> num = new Queue<Integer>();
    Queue<GreenfootImage> image = new Queue<GreenfootImage>();

    boolean queueFilled = false;
    
    // These are all the images for the numbers 1 through 9
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
        // This will fill the combination and lock the lock
        if(!queueFilled)
        {
            fillQueue();
        }
        numLock();
    }
    
    // This is the method to fill the combination 
    public void fillQueue()
    {
        // The numbers will be enqueued and their correct pictures will be the combination
        for(int i = 0; i<10; i++)
        {
            num.enqueue(i);
            image.enqueue(new GreenfootImage(Integer.toString(i) + ".png"));
        }
        queueFilled = true;
    }

    public void numLock()
    {
        // This runs while the lock is being picked everytime the player clicks the box
        if(Greenfoot.mouseClicked(this))
        {
            // The lock pick sound will play
            Greenfoot.playSound("Lock Pick.mp3");
            
            // The numbers will be enqueued and the image will change to the number
            int x = num.dequeue();
            num.enqueue(x);
            currentAns = x;

            GreenfootImage i = image.dequeue();
            image.enqueue(i);

            setImage(i);
        }
    }

    // This returns the current status of the lock
    public int getCurrentAns()
    {
        return currentAns;
    }
}
