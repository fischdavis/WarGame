import java.util.ArrayList;

public class Deck {
    ArrayList<Card> deck = new ArrayList<Card>();
    ArrayList<Card> player1 = new ArrayList<Card>();
    ArrayList<Card> player2 = new ArrayList<Card>();
    ArrayList<Card> pile = new ArrayList<Card>();
    boolean winner;
    public int player1Win;
    public int player2Win;
    public int warCount;
    public Deck()
    {

    }

    public void createDeck(){
        for(int i =0; i<4; i++)
        {        
            for(int j =1; j<15;j++)
            {            
                if(i==0) deck.add(new Card("Spades", j));                   
                if(i==1) deck.add(new Card("Hearts", j));
                if(i==2) deck.add(new Card("Clubs", j));
                if(i==3) deck.add(new Card("Diamonds",j));

            }
        }
    }

    public void splitDeck()
    {
        for(int i = 0; i< 52;i++)
        {
            int r = (int) (Math.random()*(51-i));
            if(i%2==0)
            {
                player1.add(deck.get(r));
            }
            else
            {
                player2.add(deck.get(r));
            }
            deck.remove(r);
        }

    }

    public int [] war(){

        int[]score = new int[2];
        ArrayList<Card> tempPlay1 = new ArrayList<Card>(player1);
        ArrayList<Card> tempPlay2 = new ArrayList<Card>(player2);
        for(Card c : tempPlay1)
        {
            int x = tempPlay1.indexOf(c);
            if(c.getValue() > tempPlay2.get(x).getValue())
            {
                winner = true;
                score[0]++;
                pile.add(tempPlay1.get(x));
                pile.add(tempPlay2.get(x));
                distributeCards();
            }
            else if(c.getValue() <tempPlay2.get(x).getValue()) score[1]++;
            distributeCards();
        }

        player1 = new ArrayList<Card>(tempPlay1);
        player2 = new ArrayList<Card>(tempPlay2);
        return score;
    }   

    public void distributeCards(){

        if(winner==true)
        {

            for(int i = 0; i<pile.size(); i++)
            {
                player1.add(pile.get(i));
            }
        }
        else
        {
            for(int i = 0; i<pile.size(); i++)
            {
                player2.add(pile.get(i));
            }
        }

    }

    public String warGame(){
        String print= "";
        for(Card c : player1)
        {
            int x = player1.indexOf(c);
            if(c.getValue() > player2.get(x).getValue())
            {
                player1Win++;
                print+= "\n"+"Player1 won";
            }
            else if(c.getValue() <player2.get(x).getValue())
            {
                player2Win++;
                print+="\n"+"Player2 won";
            }

            else if(c.getValue() ==player2.get(x).getValue())
            {
                warCount++;
                print+= "\n"+"Its a tie";
            }
        }

        return print;
    }
}