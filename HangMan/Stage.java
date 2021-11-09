import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Stage extends World

{
    public int MAX_WordScramble = 10;

    public boolean gameStart = false;
    public boolean gameOver = false;

    //spawn only once
    public static boolean spawn = true;
    //spawn only one ArrayList
    public static boolean spawnList = true;

    public boolean roomOnePrep = false;
    public boolean roomTwoPrep = false;
    public boolean roomThreePrep = false;

    public boolean allowSpawnBird = true;

    public String correctAns = "";
    public String storeWord = "";

    //RoomNum Regulator Variables
    public int roomNum = 0;
    public int roomThreeProgress = 0;

    //Passwords
    public static String passwordRoom1 = "8096";
    public static String passwordRoom2 = "7345";
    public static String passwordRoom3 = "2022";

    GreenfootImage background = new GreenfootImage("BackGround.png");

    //All Objects
    HangMan man = new HangMan();
    UndoButton undo = new UndoButton(); 
    SubmitButton submit = new SubmitButton();
    InputBox inputBox = new InputBox();
    WordScrambler wordScrambler = new WordScrambler();
    Timer timer = new Timer();
    
    String stringToDisplay = "";

    //All Data Structures
    static HashMap<String, String> map = new HashMap<String, String>();
    static Stack<Character> stackOfLetters = new Stack<Character>();

    //ListOfWords
    ArrayList<String> myList = new ArrayList<String>();

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Stage()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 600, 1); 
    }

    public void act()
    {
        //Ready Words
        if(spawnList)
        {
            fillListOfWords();
            fillHashMap();
        }
        spawnList = false;

        if(!gameStart)
        {
            gameStart();
        }
        if(roomNum == 1)
        {
            prepare_Room1();
        }
        if(roomNum == 2)
        {
            prepare_Room2();
        }
        if(roomNum == 3)
        {
            prepare_Room3();
        }
        if(roomNum == 4)
        {
            win();
        }
    }

    public void gameStart()
    {
        if(Greenfoot.isKeyDown("Enter"))
        {
            gameStart = true;
            beginningAnimation();
        }
    }
    
    public void beginningAnimation()
    {
        setBackground(new GreenfootImage("HangedMen_Background.png"));
        roomNum++;
    }

    public void prepare_Room1()
    {
        if(!roomOnePrep)
        {
            //add Objects
            removeObjects(getObjects(null));
            setBackground(background);

            roomNum = 1;
            timer.allowSpawnBird();

            addObject(new Paper(), 700, 480);
            addObject(new Door(), 1100, 410);
            addObject(timer, 0, 0);

            addObject(man, 100, 490);

            timer.addTime();

            //reset modes & data structures
            man.walkMode();
            clearStack();

            roomOnePrep = true;
        }
    }

    public void prepare_Room2()
    {
        if(!roomTwoPrep)
        {
            removeObjects(getObjects(null));
            roomNum = 2;
            timer.allowSpawnBird();
            
            addObject(new Paper(), 510, 400);
            addObject(new Door(), 1100, 410);
            addObject(timer, 0, 0);

            addObject(man, 100, 490);

            timer.addTime();

            //reset modes & data structures
            man.walkMode();
            clearStack();
            
            roomTwoPrep = true;
        }
    }

    public void prepare_Room3()
    {
        if(!roomThreePrep)
        {
            removeObjects(getObjects(null));
            roomNum = 3;
            timer.allowSpawnBird();
            
            addObject(new Paper(), 500, 410);
            addObject(new Paper(), 850, 560);
            addObject(new Door(), 1100, 410);
            addObject(timer, 0, 0);

            addObject(man, 100, 490);

            timer.addTime();

            //reset modes & data structures
            man.walkMode();
            clearStack();
            
            roomThreePrep = true;
        }
    }
    
    public void win()
    {
        removeObjects(getObjects(null));
        
        setBackground(new GreenfootImage("BackGround_WinScreen.png"));
        
        Greenfoot.stop();
    }

    public void gameOver()
    {
        removeObjects(getObjects(null));
        setBackground(new GreenfootImage("HangMan_BackGround.png"));
        showText(null, 600, 75);
        
        addObject(new HangedMan(), 600, 100);
    }

    public void increaseRoomNum()
    {
        roomNum++;
    }

    public String getPassword()
    {
        if(roomNum == 1)
        {
            return passwordRoom1;
        }
        else if(roomNum == 2)
        {
            return passwordRoom2;
        }
        else
        {
            return passwordRoom3;
        }
    }

    //Utility
    //All Word Scramble Game-Code Below
    public void scrambleWord_Game()
    {
        man.gameMode();
        if(spawn)
        {
            addObject(inputBox, 600, 150);
            addObject(undo, 1000, 200);
            addObject(submit, 1000, 150);

            String str = wordScrambler.getRandomWord(map);
            String ans = wordScrambler.getValue(str, map);
            correctAns = ans;
            storeWord = str;

            System.out.println(ans);
            spawnCharArray(str.toCharArray());
            spawn = false;
        }
    }

    //stackOfLetters functions
    public void undo()
    {
        if(!stackOfLetters.isEmpty())
        {
            char x = stackOfLetters.pop();
            spawnLetter(x, 600, 300);
            printStack();
            clearString();
        }
        else
        {
            showText(null, 600, 75);
        }

    }

    public void submit()
    {
        //list of characters in stackOfLetters
        ArrayList<Character> list = new ArrayList<Character>();

        while(!stackOfLetters.isEmpty())
        {
            list.add(stackOfLetters.pop());
        }
        Collections.reverse(list);

        //form a String with the characters in the stack.
        String str = "";
        for(char x: list)
        {
            str += x;
        }

        if(!str.equals(correctAns))
        {
            incorrect();
        }
        else
        {
            correct();
        }
    }

    public void incorrect()
    {
        //remove all Letters (A, B, C, D, etc.) and resets the Letters displayed on screen
        showText(null, 600, 75);
        removeObjects(getObjects(Letter.class));   
        spawnCharArray(storeWord.toCharArray());
    }

    public void correct()
    {
        man.walkMode();
        removeObjects(getObjects(InputBox.class));
        removeObjects(getObjects(SubmitButton.class));
        removeObjects(getObjects(UndoButton.class));
        
        if(roomNum == 1)
        {
            showText("The password is 8096", 600, 75);
        }
        else if(roomNum == 2)
        {
            showText("The password is 7345", 600, 75);
        }
        else if(roomNum == 3 && roomThreeProgress == 0)
        {
            showText("The first part of the password is 20", 600, 75);
            roomThreeProgress++;
        }
        else
        {
            showText("The second part of the password is 22", 600, 75);
        }
    }

    //Utility Functions
    public static void changeSpawnStatus()
    {
        spawn = true;
    }

    public void printStack()
    {
        if (stackOfLetters.isEmpty())
        {
            return;
        }
        char x = stackOfLetters.pop();
        // Recursively call the function PrintStack
        printStack();
        // Print the stack element starting
        // from the bottom
        stringToDisplay += x;
        showText(stringToDisplay, 600, 75);
        // Push the same element onto the stack
        // to preserve the order
        stackOfLetters.push(x);
    }

    public void clearString()
    {
        stringToDisplay = "";
    }

    public void clearStack()
    {
        while(!stackOfLetters.isEmpty())
        {
            stackOfLetters.pop();
        }
    }

    public static HashMap getHashMap()
    {
        return map;
    }

    public static Stack getStack()
    {
        return stackOfLetters;
    }

    public void fillListOfWords()
    {
        try
        {
            Reader.readInto(myList);
        }
        catch(Exception e)
        {

        }
    }

    //set up HashMap of scrambled | unscrambled words from URL
    public void fillHashMap()
    {
        for(int i = 0; i<20; i++)
        {
            //randomly chooses a word from a file and puts it into the map
            int index = (int)(Math.random() * myList.size());
            String str = myList.get(index);

            //fills map {scrambled: unscrambled}
            wordScrambler.fill(str);
        }
    }
    //spawn letterCards functions
    // "hello"
    public void spawnCharArray(char[] arr)
    {
        int size = arr.length;

        int x = 1200 / size;

        int y = 300;

        for(int i = 0; i<size; i++)
        {
            spawnLetter(arr[i], 80+x*i, y);
        }
    }
    //spawn individual letters
    public void spawnLetter(char letter, int x, int y)
    {
        addObject(new Letter(letter), x, y);
    }

}
