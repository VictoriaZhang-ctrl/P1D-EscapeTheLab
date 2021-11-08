import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Door here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Door extends Actor
{
    /**
     * Act - do whatever the Door wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    Numbers one = new Numbers();
    Numbers two = new Numbers();
    Numbers three = new Numbers();
    Numbers four = new Numbers();

    public boolean complete = false;
    public boolean game = false;

    String str = "";
    public void act()
    {
        if(this.isTouching(HangMan.class))
        {
            if(Greenfoot.isKeyDown("space"))
            {
                World world = getWorld();
                Stage stage = (Stage)world;
                stage.addObject(one, 150,100);
                stage.addObject(two, 450,100);
                stage.addObject(three, 750,100);
                stage.addObject(four, 1050,100);

                if(Stage.roomNum == 1)
                {
                    str = Stage.getNumPassword1();
                }
                else if(Stage.roomNum == 2)
                {
                    str = Stage.getNumPassword2();
                }
                else
                {
                    str = Stage.getNumPassword3();
                }

                game = true;
            }
        }

        if(!complete && game == true)
        {
            String a = Integer.toString(one.getCurrentAns());
            String b = Integer.toString(two.getCurrentAns());
            String c = Integer.toString(three.getCurrentAns());
            String d = Integer.toString(four.getCurrentAns());

            String ans = ""+a+b+c+d;

            if(ans.equals(str))
            {
                World world = getWorld();
                Stage stage = (Stage)world;
                
                world.removeObjects(world.getObjects(Numbers.class));
                
                complete = true;
                game = false;
                
                Stage.roomNumUp();

                if(Stage.roomNum == 4)
                {
                    stage.win();
                }
            }
        }
    }

}
