import javax.swing.*;
public class BlackJackGUI {
    public static void main(String[] args) {
        BlackJack black = new BlackJack();
        String[] options = {"Hit", "Stay"};
        JOptionPane.showMessageDialog(null, "Welcome to this BlackJack Game!", "BlackJack Emulator", JOptionPane.INFORMATION_MESSAGE);
        int w;
        do {
            if (black.blackjack(black.getPlayerHand())) {
                JOptionPane.showMessageDialog(null, "Player has Won!", "BlackJack Game", JOptionPane.INFORMATION_MESSAGE);
            }
            if (black.blackjack(black.getDealerHand())) {
                JOptionPane.showMessageDialog(null, "Dealer has Won!", "BlackJack Game", JOptionPane.INFORMATION_MESSAGE);
            }
            int i = JOptionPane.showOptionDialog(null, "Your Hand: \n" + black.getPlayerHand().toString() +
                            " \n Hit or Stay?", "BlackJack Game", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, options, null);
            while (i == 0 && !black.bust(black.getPlayerHand())) {
                black.playerDeal();
                if(black.bust(black.getPlayerHand()))
                {
                    break;
                }
                i = JOptionPane.showOptionDialog(null, "Your Hand: \n" + black.getPlayerHand().toString() +
                                " \n Hit or Stay?", "BlackJack Game", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                        null, options, null);
            }
            while(black.getDealerHand().addUp() < 14 && !black.bust(black.getPlayerHand()))
            {
                black.dealerDeal();
            }
            if (black.win()) {
                JOptionPane.showMessageDialog(null, "Player has Won! \n Player Had: " + black.getPlayerHand() +
                        "\n Dealer Had: " + black.getDealerHand(), "BlackJack Game", JOptionPane.INFORMATION_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(null, "Dealer has Won! + \n Player Had: " + black.getPlayerHand() +
                        "\n Dealer Had: " + black.getDealerHand(), "BlackJack Game", JOptionPane.INFORMATION_MESSAGE);
            }
            w = JOptionPane.showConfirmDialog(null, "Would you like to play another round?", "BlackJack Game", JOptionPane.YES_NO_OPTION);
            if (w == JOptionPane.YES_OPTION) {
                black.reset();
            }
        } while (w == JOptionPane.YES_OPTION);
    }
}
