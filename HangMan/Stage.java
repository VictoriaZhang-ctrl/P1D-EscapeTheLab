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

    public boolean gameStart = true;
    public boolean gameOver = false;
    
    //spawn only once
    public static boolean spawn = true;
    //spawn only one ArrayList
    public static boolean spawnList = true;

    public String correctAns = "";
    public String storeWord = "";

    GreenfootImage background = new GreenfootImage("BackGround.png");

    //All Objects
    HangMan man = new HangMan();
    UndoButton undo = new UndoButton(); 
    SubmitButton submit = new SubmitButton();
    InputBox inputBox = new InputBox();
    WordScrambler wordScrambler = new WordScrambler();
    
    JudgementBird bird = new JudgementBird();

    String stringToDisplay = "";

    //All Data Structures
    static HashMap<String, String> map = new HashMap<String, String>();
    static Stack<Character> stackOfLetters = new Stack<Character>();
    static Queue<String> queueOfWords = new Queue<String>();

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
        setBackground(background);

        //Ready Words
        if(spawnList)
        {
            fillListOfWords();
            fillHashMap();
            fillQueue();
        }
        spawnList = false;

        prepare_Room1();
    }

    public void prepare_Room1()
    {
        if(gameStart)
        {
            //add Objects
            addObject(man, 100, 490);
            //addObject(bird, 0, 420);
            addObject(new Paper(), 800, 490);
            addObject(new Paper(), 1100, 490);

            //reset modes & data structures
            man.walkMode();
            clearStack();

            //set gameStart to FALSE
            gameStart = false;
        }
    }

    public void beginningAnimation()
    {

    }

    public void gameOver()
    {
        removeObjects(getObjects(null));
    }
    
    //All HangMan Game-Code Below
    public void hangMan_Game()
    {
        String answer = queueOfWords.dequeue();
        queueOfWords.enqueue(answer);
        
        String maskedWord = "";
        for(int i = 0; i<answer.length(); i++)
        {
            maskedWord += "-";
        }
        
        boolean complete = false;
        
        ArrayList<Character> guessedCorrect = new ArrayList<Character>();
        ArrayList<Character> guessedIncorrect = new ArrayList<Character>();
    }
    
    //Utility
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
        showText(null, 600, 75);
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
