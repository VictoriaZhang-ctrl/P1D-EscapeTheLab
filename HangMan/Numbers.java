import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Numbers here.
 */
public class Numbers extends Actor
{
    Queue<Integer> num = new Queue<Integer>();
    Queue<GreenfootImage> image = new Queue<GreenfootImage>();

    boolean queueFilled = false;    //makes sure the queue is filled only once.
    
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
        // The numbers will be stored in num.
        // Their corresponding pictures will be stored in image
        for(int i = 0; i<10; i++)
        {
            num.enqueue(i);
            image.enqueue(new GreenfootImage(Integer.toString(i) + ".png"));
        }
        queueFilled = true;
    }
    
    // Player is asked to enter the code.
    public void numLock()
    {
        //Clicking the object makes it loop through num and images.
        if(Greenfoot.mouseClicked(this))
        {
            // The lock pick sound will play
            Greenfoot.playSound("Lock Pick.mp3");
            
            // Loop through num and image
            // set the currentAns to whatever integer is displayed onscreen.
            int x = num.dequeue();
            num.enqueue(x);
            currentAns = x;
            
            //the image displayed onscreen corresponds to the correct integer.
            GreenfootImage i = image.dequeue();
            image.enqueue(i);
            setImage(i);
        }
    }

    // This returns the object's current value
    public int getCurrentAns()
    {
        return currentAns;
    }
}
