
public class Card
{
    
    String suit;
    int cardValue;
    
    public Card(String s, int v)
    {
        suit = s;
        cardValue = v;
        
    }

    public String getSuit()
    {
        return suit;
    }
    
    public int getValue()
    {
        return cardValue;
    }
}
