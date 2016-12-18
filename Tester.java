import java.io.*;
import java.util.*;

public class Tester
{
    public static void main(String[] args)
    {
        
       int p1 = 0;
        int p2 = 0;
        int tie = 0;
        int p1Games = 0;
        int p2Games = 0;
        for(int x = 0; x < 1000; x++)
        {

        Deck d = new Deck();
        d.createDeck();
        d.splitDeck();
        d.distributeCards();
        d.war();
        d.warGame();
        p1 += d.player1Win;
        p2 += d.player2Win;
        tie += d.warCount;
        
        if(d.player1Win > d.player2Win)
        {
            p1Games++;
        }
        else
        {
            p2Games++;
        }
    
    }
    
    try
    {
        BufferedWriter out = new BufferedWriter(new FileWriter("stats.txt"));
        out.write("Player 1 won "+p1+" battles!\n");
        out.write("Player 2 won "+p2+" battles!\n");
        out.write("Player 1 won "+p1Games+" games!\n");
        out.write("Player 2 won "+p2Games+" games!\n");
        out.write("There were "+tie+" wars!\n");
        out.close();
     
    }
    
    catch (IOException e)
    {
         System.out.println("Exception ");
    }
}
}
 