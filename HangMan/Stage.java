import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class MyWorld here.
 */

public class Stage extends World

{
    //class varaibles
    public boolean gameStart = false;
    public boolean gameOver = false;

    public int difficulty = 0;

    //Spawn Regulator Variables
    public static boolean spawn = true;
    public static boolean spawnList = true;
    public boolean allowSpawnBird = true;

    public String correctAns = "";
    public String storeScrambledWord = "";

    String text = "";
    String stringToDisplay = "";

    //RoomNum Regulator Variables
    public int roomNum = 0;
    public int roomThreeProgress = 0;
    public boolean roomOnePrep = false;
    public boolean roomTwoPrep = false;
    public boolean roomThreePrep = false;

    //Passwords
    public static String passwordRoom1;
    public static String passwordRoom2;
    public static String passwordRoom3;

    GreenfootImage background = new GreenfootImage("BackGround.png");
    GreenfootSound bgm = new GreenfootSound("dark-relaxing-ambient-10275.mp3");

    //All Objects
    HangMan man = new HangMan();
    UndoButton undo = new UndoButton(); 
    SubmitButton submit = new SubmitButton();
    InputBox inputBox = new InputBox();
    WordScrambler wordScrambler = new WordScrambler();
    Timer timer = new Timer();
    Rules ruleButton = new Rules();

    //Data Structures
    static HashMap<String, String> map = new HashMap<String, String>();
    static Stack<Character> stackOfLetters = new Stack<Character>();

    //List of words read from a file
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
        // If the game has not started yet, the rule button will be on the screen
        if(!gameStart)
        {
            addObject(ruleButton, 1100, 550);
            showTitleScreen();
        }

        // If the player is on room 1, the things in room 1 will spawn
        if(roomNum == 1)
        {
            prepare_Room1();
        }

        // If the player is on room 2, the things in room 2 will spawn
        if(roomNum == 2)
        {
            prepare_Room2();
        }

        // If the player is on room 3, the things in room 3 will spawn
        if(roomNum == 3)
        {
            prepare_Room3();
        }

        // If the player is on room 4, it is the winning screen, and the things in room 4 will spawn
        if(roomNum == 4)
        {
            win();
        }
    }

    // This is what will run when the game is started
    public void showTitleScreen()
    {
        // If the enter key is pressed the game will start
        if(Greenfoot.isKeyDown("Enter"))
        {
            // The background sound will play
            Greenfoot.playSound("mixkit-retro-arcade-casino-notification-211.wav");

            // The rule button will be removed and the difficulty buttons will spawn
            removeObject(ruleButton);
            setBackground(new GreenfootImage("GreyBackDrop.png"));
            addObject(new DifficultyButton(1), 300, 200);
            addObject(new DifficultyButton(2), 600, 200);
            addObject(new DifficultyButton(3), 900, 200);

            gameStart = true;
        }
    }

    public void setDifficulty(int setDifficulty)
    {
        difficulty = setDifficulty;
    }

    // Once the difficulty is selected the list of words for that difficulty will spawn
    public void difficultySelected()
    {
        fillListOfWords();

        passwordRoom1 = setRandomizedPassword();
        passwordRoom2 = setRandomizedPassword();
        passwordRoom3 = setRandomizedPassword();

        //Play BGM & Begin Game
        bgm.playLoop();
        roomNum++;
    }

    // This will run when the player is in room 1
    public void prepare_Room1()
    {
        if(!roomOnePrep)
        {
            //add Objects
            removeObjects(getObjects(null));
            setBackground(background);

            // The timer rill run to see when the judgement bird should spawn
            timer.allowSpawnBird();

            // The objects will be added
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

    // This will run when the player is in room 2
    public void prepare_Room2()
    {
        if(!roomTwoPrep)
        {
            removeObjects(getObjects(null));

            // The timer will run to see when the judgement bird will spawn
            timer.allowSpawnBird();

            // The objects will be added
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

    // This will run when the player is in room 3
    public void prepare_Room3()
    {
        if(!roomThreePrep)
        {
            removeObjects(getObjects(null));

            // The timer will run to see when the judgement bird will spawn
            timer.allowSpawnBird();

            // The objects will be added
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

    // This will run when the player has passed a total of 3 rooms
    // This signifies that the player has completed the game
    // The total amount of time the player used is tallied and displayed.
    // The game ends after this function is called.
    public void win()
    {
        // The background music will stop playing
        bgm.stop();
        // The winning music will play
        Greenfoot.playSound("138 Spotted! Twins.mp3");

        // This will return the total amount of time it took the player to escape
        String totalTime = Integer.toString(Timer.count/100); 
        removeObjects(getObjects(null));

        // The background will change to the winning screen
        setBackground(new GreenfootImage("BackGround_WinScreen.png"));

        // This will tell the player how long it took them to escape
        text = "It took you " + totalTime + " seconds to escape!";
        addObject(new displayText(text), 600, 550);

        // The stickman will change to a happy stickman
        getBackground().drawImage(new GreenfootImage("StickMan_Happy.png"), 550, 270);
        // The game will stop running
        Greenfoot.stop();
    }

    // This method displays a series of animations
    // This method is called when JudgementBird catches the player avatar
    // Signifies that the player has lost.
    public void gameOver()
    {
        // The background music will stop
        bgm.stop();
        // All the objects will be removed
        removeObjects(getObjects(null));
        // The background will change to the game over background
        setBackground(new GreenfootImage("HangMan_BackGround.png"));
        showText(null, 600, 75);

        addObject(new HangedMan(), 600, 100);
    }

    // Everytime the player goes to the next room a sound will play
    public void increaseRoomNum()
    {
        Greenfoot.playSound("mixkit-gear-metallic-lock-sound-2858.wav");
        roomNum++;
    }

    // This makes a different combination for the lock every time
    public String setRandomizedPassword()
    {
        String password = "";
        for(int i = 0; i<4; i++)
        {
            // The password will always have 4 numbers ranging from 0 to 9
            String str = Integer.toString((int)(Math.random() * 9));
            password += str;
        }
        return password;
    }

    // This sets the passwords for each room
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
    public void beginWordScrambleGame()
    {
        //disables the player's ability to walk around.
        man.gameMode();

        // if(spawn) ensures that the code within the if-loop is run only once
        // Only one set of letters should be displayed on-screen
        if(spawn)
        {
            addObject(inputBox, 600, 150);
            addObject(undo, 1000, 200);
            addObject(submit, 1000, 150);

            String unscrambledWord = getRandomWordFromFile(difficulty);
            String scrambledWord = wordScrambler.scrambleWord(unscrambledWord);
            correctAns = unscrambledWord;
            storeScrambledWord = scrambledWord;

            spawnCharArray(scrambledWord.toCharArray());
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

        // This checks to see if the answer is correct or incorrect
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
        Greenfoot.playSound("mixkit-wrong-electricity-buzz-955.wav");
        showText(null, 600, 75);
        removeObjects(getObjects(Letter.class));   
        spawnCharArray(storeScrambledWord.toCharArray());
    }

    // This will run if the answer is correct
    public void correct()
    {
        // This sound will play
        Greenfoot.playSound("correct.mp3");
        man.walkMode();
        // The objects will be removed
        removeObjects(getObjects(InputBox.class));
        removeObjects(getObjects(SubmitButton.class));
        removeObjects(getObjects(UndoButton.class));

        // For each room, the lock combination will be printed to the screen
        if(roomNum == 1)
        {
            showText("The password is " + passwordRoom1, 600, 75);
        }
        else if(roomNum == 2)
        {
            showText("The password is " + passwordRoom2, 600, 75);
        }
        else if(roomNum == 3 && roomThreeProgress == 0)
        {
            showText("The first part of the password is " + passwordRoom3.substring(0,2), 600, 75);
            roomThreeProgress++;
        }
        else
        {
            showText("The second part of the password is " + passwordRoom3.substring(2,4), 600, 75);
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

    // This clears the string
    public void clearString()
    {
        stringToDisplay = "";
    }

    // This clears what the player currently has by popping off all the letters
    public void clearStack()
    {
        while(!stackOfLetters.isEmpty())
        {
            stackOfLetters.pop();
        }
    }

    public static Stack getStack()
    {
        return stackOfLetters;
    }

    public String getRandomWordFromFile(int difficulty)
    {
        int appropriateSize = difficulty + 2;

        int index = (int)(Math.random() * myList.size());
        String str = myList.get(index);

        while(str.length() < appropriateSize || str.length() > appropriateSize + 1)
        {
            index = (int)(Math.random() * myList.size());
            str = myList.get(index);
        }

        return str;
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
    }

    //spawn individual letters
    public void spawnLetter(char letter, int x, int y)
    {
        addObject(new Letter(letter), x, y);
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
}
