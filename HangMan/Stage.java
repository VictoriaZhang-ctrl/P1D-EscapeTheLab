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
<<<<<<< Updated upstream
    public int MAX_WordScramble = 5;
    
    public boolean gameStart = false;
    public boolean gameOver = false;
    
=======
    public int MAX_WordScramble = 10;

    //start & stop booleans
    public boolean gameStart = false;
    public boolean gameOver = false;
    public boolean roomOnePrep = false;
    public boolean roomTwoPrep = false;
    public boolean roomThreePrep = false;

    //spawn only once
    public static boolean spawn = true;
    //spawn only one ArrayList
    public static boolean spawnList = true;

    public String correctAns = "";
    public String storeWord = "";

    public static int roomNum = 0;
    public int roomThreeProgress = 0;
    public static String numPassword1 = "8096";
    public static String numPassword2 = "7453";
    public static String numPassword3 = "1285";

>>>>>>> Stashed changes
    GreenfootImage background = new GreenfootImage("BackGround.png");
    
    //Map the unscrambled vs scrambled word (key: unscrambled, value: scrambled)
    HashMap<String, ArrayList> dictionary = new HashMap<String, ArrayList>();
    
    HangMan man = new HangMan();
<<<<<<< Updated upstream
    
    Timer timer = new Timer();
=======
    HangedMan hanged = new HangedMan();

    UndoButton undo = new UndoButton(); 

    SubmitButton submit = new SubmitButton();

    InputBox inputBox = new InputBox();

    WordScrambler wordScrambler = new WordScrambler();

    JudgementBird bird = new JudgementBird();

    Scanner sc = new Scanner(System.in);

    Timer timer = new Timer();

    String stringToDisplay = "";
    //All Data Structures
    static HashMap<String, String> map = new HashMap<String, String>();
    static Stack<Character> stackOfLetters = new Stack<Character>();
    static Queue<String> queueOfWords = new Queue<String>();

    //ListOfWords
    ArrayList<String> myList = new ArrayList<String>();

    public static boolean spawnBird = false;
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
        setBackground(background);
        addObject(man, 75, 465);
        addObject(timer, 600, 75);
    }
    
    public void fillDictionary()
    {
        
    }
    
    public void hangMan_Game(String word)
    {
        
=======
        //ready all the words that will be used in the game
        if(spawnList)
        {
            fillListOfWords();
            fillHashMap();
            //fillQueue();
        }
        spawnList = false;

        if(!gameStart)
        {
            gameStart();
        }

        //set the stage
        if(gameStart)
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
    }

    public void gameStart()
    {
        setBackground(new GreenfootImage("BackGround_StarterPage.png"));
        if(Greenfoot.isKeyDown("Enter"))
        {
            gameStart = true;
        }
    }

    public void gameOver()
    {
        removeObjects(getObjects(null));
        showText(null, 600, 75);
        setBackground("HangMan_BackGround.png");
        addObject(hanged, 600, 50);
    }

    public void win()
    {
        removeObjects(getObjects(null));
        setBackground("BackGround_WinScreen.png");
    }

    public static void roomNumUp()
    {
        roomNum++;
    }

    public void prepare_Room1()
    {
        if(!roomOnePrep)
        {
            setBackground(background);

            roomNum = 1;
            timer.addTime();
            timer.allowSpawnBird();

            //add Objects
            addObject(new Door(), 1100, 420);
            addObject(man, 100, 490);
            addObject(timer, 0, 0);
            addObject(new Paper(), 700, 480);

            //reset modes & data structures
            man.walkMode();
            clearStack();

            //ensures prepare_Room1 is not ran multiple times
            roomOnePrep = true;
        }
    }

    public void prepare_Room2()
    {
        if(!roomTwoPrep)
        {
            removeObjects(getObjects(null));

            showText(null, 600, 75);
            timer.addTime();
            timer.allowSpawnBird();

            addObject(new Door(), 1100, 420);
            addObject(man, 100, 490);
            addObject(timer, 0, 0);
            addObject(new Paper(), 320, 410);

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

            showText(null, 600, 75);
            timer.addTime();
            timer.allowSpawnBird();

            addObject(new Door(), 1100, 420);
            addObject(man, 100, 490);
            addObject(timer, 0, 0);
            addObject(new Paper(), 320, 410);
            addObject(new Paper(), 970, 400);

            man.walkMode();
            clearStack();

            roomThreePrep = true;
        }
    }

    public void begginningAnimation()
    {
        setBackground("HangedMen_Background.png");
    }

    public static String getNumPassword1()
    {
        return numPassword1;
    }

    public static String getNumPassword2()
    {
        return numPassword2;
    }

    public static String getNumPassword3()
    {
        return numPassword3;
    }

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
        removeObjects(getObjects(Letters.class));   
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
            showText("The passcode is 8096", 600, 75);
        }
        else if(roomNum == 2)
        {
            showText("The passcode is 7453", 600, 75);
        }
        else if(roomNum == 3 && roomThreeProgress == 0)
        {
            showText("The first part of the code is 12", 600, 75);
            roomThreeProgress++;
        }
        else
        {
            showText("The second part of the code is 85", 600, 75);
        }
    }

    //Utility Functions
    public void fillQueue()
    {
        for(int i = 0; i<10; i++)
        {
            //randomly chooses a word from a file and puts it into the queue
            int index = (int)(Math.random() * myList.size());
            String str = myList.get(index);

            queueOfWords.enqueue(str);
        }
    }

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
    public void spawnCharArray(char[] arr)
    {
        int size = arr.length;

        int x = 1200 / size;

        int y = 300;

        for(int i = 0; i<size; i++)
        {
            spawnLetter(arr[i], 80+x*i, y);
        }
>>>>>>> Stashed changes
    }
    
    public void scrambleWord_Game(String word)
    {
        
    }
}
