import java.util.ArrayList;

public class BlackJack {
    private Hand dealerHand;
    private Hand playerHand;
    private Deck deck;
    private String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
    private char[] suits = {'♥' , '♣' , '♠' , '♦'};
    private int[] pts = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};

    public BlackJack() {
        deck = new Deck(ranks, suits, pts);
        dealerHand = new Hand();
        playerHand = new Hand();
        dealMyCards();
    }

    public void dealerDeal() {
        dealerHand.hit(deck.deal());
    }
    
    public void playerDeal() {
        playerHand.hit(deck.deal());
    }

    public int deckSize() {
        return deck.size();
    }

    /**
     * Deal cards to this board to start the game.
     */
    public void reset() {
        dealerHand = new Hand();
        playerHand = new Hand();
        deck  = new Deck(ranks, suits, pts);
        dealMyCards();
    }

    private void dealMyCards() {
        for(int i = 0; i < 2; i++)
        {
            playerDeal();
            dealerDeal();
        }
    }
    
    public boolean bust(Hand hand)
    {
        return playerHand.addUp() > 21;
    }
    
    public Hand getPlayerHand()
    {
        return playerHand;
    }
    
    public Hand getDealerHand()
    {
        return dealerHand;
    }
    
    public boolean blackjack(Hand hand)
    {
        if(hand.size() == 2)
        {
            return hand.get(0).pointValue() == 1 && hand.get(1).pointValue() == 10 || hand.get(1).pointValue() == 1 && hand.get(0).pointValue() == 10;
        }
        return false;
    }
    
    public boolean win()
    {
        int player = playerHand.addUp();
        int dealer = dealerHand.addUp();
        if(playerHand.contains("Ace") && player + 10 <= 21)
        {
            player += 10;
        }
        if(dealerHand.contains("Ace") && dealer + 10 <= 21)
        {
            dealer += 10;
        }
        if(bust(playerHand))
        {
            return false;
        }
        if(bust(dealerHand))
        {
            return true;
        }
        return player > dealer;
    }
}
