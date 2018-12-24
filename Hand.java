import java.util.ArrayList;
/**
 * Write a description of class Hand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hand
{
    private ArrayList<Card> hand;
    public Hand()
    {
        hand = new ArrayList<Card>();
    }
    public void hit(Card card)
    {
        hand.add(card);
    }
    public int addUp()
    {
        int total = 0;
        for(int i = 0; i < hand.size(); i++)
        {
            total += hand.get(i).pointValue();
        }
        return total;
    }
    public boolean contains(String str)
    {
        boolean value = false;
        for(int i = 0; i < hand.size() ; i++)
        {
            if(hand.get(i).rank().equals(str))
            {
                value = true;
                break;
            }
        }
        return value;
    }
    public String toString(){
        String temp = "";
        for(int i = 0 ; i < hand.size() ; i++){
            temp += (hand.get(i)).rank() + (hand.get(i)).suit() + " ; ";
        }
        return temp;
    }
    public Card get(int a)
    {
        return hand.get(a);
    }
    public int size()
    {
        return hand.size();
    }
}
