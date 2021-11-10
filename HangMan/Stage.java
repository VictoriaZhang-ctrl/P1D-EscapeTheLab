import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class MyWorld here.
 */

public class Stage extends World

{
    public boolean gameStart = false;
    public boolean gameOver = false;

    public int difficulty = 0;      //1 = easy, 2 = normal; 3 = hard

    //Spawn Regulator Variables
    public static boolean spawn = true;
    public static boolean spawnList = true;
    public boolean allowSpawnBird = true;

    //used in WordScramble game
    public String correctAns = "";
    public String storeScrambledWord = "";

    //used at the end, when the player wins, their total time used is displayed.
    String text = "";
    String stringToDisplay = "";

    //RoomNum Regulator Variables
    public int roomNum = 0;                     //Determines the player's progress
                                                //The player must complete 3 rooms
    public int roomThreeProgress = 0;
    public boolean roomOnePrep = false;         //Ensures the objects in a room
    public boolean roomTwoPrep = false;         //Is spawned only once
    public boolean roomThreePrep = false;

    //Passwords
    public static String passwordRoom1;         //Passwords for each room
    public static String passwordRoom2;         //Each is different &
    public static String passwordRoom3;         //Randomly generated

    GreenfootImage background = new GreenfootImage("BackGround.png");
    GreenfootSound bgm = new GreenfootSound("dark-relaxing-ambient-10275.mp3");

    //Objects
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

    //Once the player has selected a difficulty, the game can begin
    //words are chosen based on their lengths
    //passwords are generated for each room
    //roomNum++ tells the program to move on to room 1 and begin the game.
    public void setDifficulty(int setDifficulty)
    {
        difficulty = setDifficulty;
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
            //Clear the screen and set the background.
            removeObjects(getObjects(null));
            setBackground(background);

            // The objects will be added
            addObject(new Paper(), 700, 480);
            addObject(new Door(), 1100, 410);
            addObject(timer, 0, 0);

            addObject(man, 100, 490);
            
            //Start counting down to when the bird will spawn.
            timer.allowSpawnBird();
            timer.addTime();

            //allows the player to walk around.
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

            // The objects will be added
            addObject(new Paper(), 510, 400);
            addObject(new Door(), 1100, 410);
            addObject(timer, 0, 0);
            addObject(man, 100, 490);

            timer.allowSpawnBird();
            timer.addTime();

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

    // This method returns the randomized passwords for each room.
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

            displayScrambledLetters(scrambledWord.toCharArray());
            spawn = false;
        }
    }

    //Removes the last letter inputted from the stack
    //and gives the letter back to the player.
    public void undo()
    {
        if(!stackOfLetters.isEmpty())
        {
            char x = stackOfLetters.pop();
            addObject(new Letter(x), 600, 300);
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
        //Reverse the ArrayList because of the way a Stack is structured
        //Last-In, First-Out, so if the ArrayList is not reverse, the word
        //would come out backwards.
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

    // This method will be called if the player's input does not match the answer.
    public void incorrect()
    {
        Greenfoot.playSound("mixkit-wrong-electricity-buzz-955.wav");
        showText(null, 600, 75);
        
        //clear the screen of unused Letters
        removeObjects(getObjects(Letter.class)); 
        
        //all  Letters needed to complete the puzzle is given back to the
        //player for them to try again.
        //Basically restarts the WordScramble game.
        displayScrambledLetters(storeScrambledWord.toCharArray());
    }

    // This method will be called if the answer is correct
    public void correct()
    {
        // This sound will play
        Greenfoot.playSound("correct.mp3");
        man.walkMode();
        
        // The WordScramble game is over, remove unuseful objects.
        removeObjects(getObjects(InputBox.class));
        removeObjects(getObjects(SubmitButton.class));
        removeObjects(getObjects(UndoButton.class));

        // The corresponding password will be given to players.
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

    // This function displays all letters present in stackOfLetters during
    // a WordScramble game.
    // This method allows players to see what sequence of letters they've
    // already spelled.
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

    //gets a random word of an appropriate length from the file.
    //the appropriate length is based on the difficulty.
    //Easy = 3-4 letters; Normal = 4-5 letters; Hard = 6+ letters
    public String getRandomWordFromFile(int difficulty)
    {
        int appropriateSize = difficulty + 2;

        int index = (int)(Math.random() * myList.size());
        String str = myList.get(index);

        //While the string selected is not an appropriate length
        //reselect the string.
        if(difficulty!=3)   //Easy and Normal uses this code
        {
            while(str.length() < appropriateSize || str.length() > appropriateSize + 1)
            {
                index = (int)(Math.random() * myList.size());
                str = myList.get(index);
            }
        }
        else    //Hard uses this code
        {
            while(str.length() < appropriateSize + 1)
            {
                index = (int)(Math.random() * myList.size());
                str = myList.get(index);
            }
        }

        return str;
    }

    // Spawns the individual letters in a ScrambledWord string
    // This allows the player to see and interact with the objects
    // needed to complete the WordScramble game.
    public void displayScrambledLetters(char[] arr)
    {
        int size = arr.length;

        int x = 1200 / size;

        int y = 300;

        for(int i = 0; i<size; i++)
        {
            addObject(new Letter(arr[i]), 80+x*i, y);
        }
    }
    
    // Utility Functions
    // This method is called to allow objects needed in a WordScramble game
    // to be created & displayed on-screen. Without this method, the objects
    // would be spawned multiple times.
    public static void changeSpawnStatus()
    {
        spawn = true;
    }
    
    // This clears the String that is displayed when player inputs a letter
    // during a WordScramble game.
    public void clearString()
    {
        stringToDisplay = "";
    }

    // This removes all elements in the stackOfLetters.
    // This method is called so that the next time a WordScramble game is played
    // no elements is in the stack to interfere with the player's inputs.
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
