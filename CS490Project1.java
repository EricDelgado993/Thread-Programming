import java.util.Scanner; 

public class CS490Project1 
{ 
    public static void main(String[] args) 
    { 
        var consoleReader = new Scanner(System.in); 
        System.out.print("How many message threads should be started?  (Enter a 	 number): "); 
        var nThreads = consoleReader.nextInt(); 
        System.out.println("Will run " + nThreads + " threads."); 
        
        for (int i = 1; i <= nThreads; i++)
        { 
           var msgWriter = new MessageWriter("" + i); 
           var thread = new Thread(msgWriter); 
           thread.start(); 
        } 
        System.out.println("Main Program Ended"); 
    } 
} 

public class CS490Project1 
{ 
    public static void main(String[] args) 
    { 

        for (int i = 1; i <= nThreads; i++)
        { 
           var msgWriter = new MessageWriter("" + i, i); 
           var thread = new Thread(msgWriter); 
           thread.start();
        }  

public class MessageWriter implements Runnable 
{ 
    private int myCounter; 
    private String myName; 
    private int myDelay; 
    
    public MessageWriter(String name, int delay) 
    { 
        myCounter = 0; 
        myName = name; 
        myDelay = delay;
    } 

    public void run() 
    { 
        for (int i = 0; i < 10; i++) 
        { 
            try 
            { 
                Thread.sleep(1000 * myDelay); 
            } 

            catch (InterruptedException exc) 
            { 
                System.out.println(exc); 
            } 
            
            ++myCounter; 
            System.out.println("Message #" + myCounter + " - " + myName); 

        } 
    } 
} 

public class MessageWriter implements Runnable 
{ 
    private static int myCounter = 0; 
    private String myName; 
    private int myDelay; 
    
    public MessageWriter(String name, int delay) 
    { 
        myCounter = 0; 
        myName = name; 
        myDelay = delay; 
    } 
    
    public void run() 
    { 
        for (int i = 0; i < 10; i++) 
        { 
            try 
            { 
                Thread.sleep(1000 * myDelay); // 1000 ms 
            } 

            catch (InterruptedException exc) 
            { 
                System.out.println(exc); 
            } 
            
            synchronized(MessageWriter.class) 
            { 
                ++myCounter; 
                System.out.println("Message #" + myCounter + " - " + myName); 

            } 
        } 
    } 
} 
