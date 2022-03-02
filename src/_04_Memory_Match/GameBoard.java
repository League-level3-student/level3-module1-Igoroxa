package _04_Memory_Match;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GameBoard extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    static Card firstSelectedCard = null;
    static Card secondSelectedCard = null;
    
    // 1. Initialize TOTAL_CARDS to 2;
    static int TOTAL_CARDS = 0;
    
    ArrayList<Card> cards;
    
    JPanel panel;
    JLabel timeLabel;
    JButton newGameButton;
    
    Timer updateTimer;
    Timer gameClock;
    
    int seconds;
    
    public void setup() {
        gameClock = new Timer(1000, this);
        updateTimer = new Timer(750, this);
        
        // Can't play the game if there isn't an even number of cards
        if( TOTAL_CARDS % 2 != 0) {
            System.out.println("ERROR: Odd number of total cards, " + TOTAL_CARDS);
            System.exit(1);
        }
        
        // 2. Initialize the ArrayList of Cards declared above
        
        
        // 3. Create TOTAL_CARDS number of objects each with a value of 1.
        //    Also, add action listeners to each Card object and then add each
        //    of the Card objects to the ArrayList of Cards.
        
        
        // 4. Use Collections.shuffle() method to randomize the order of
        //    the cards in the ArrayList
        
        
        // 5. Initialize the panel variable declared above
        
        
        // 6. Add all of the Card objects to the panel
        
        
        // 7. Call the setupGui() method to set up the frame
        
        
        // 8. Call the startGame() method to start the game
        
    }

    // 9. Fill in the drawCards method to draw all the cards in the ArrayList.
    //    Run your code and verify 2 cards are displayed and the game works.
    public void drawCards() {
        
    }
    
    // 10. 
    // There are 52 cards in a normal sized deck of cards (not counting
    // jokers). There are 4 card suits, each with the numbers 2 to 10 and
    // the Jack, Queen, King, and Ace for a total of 13.
    // 
    // Go back and modify the code to have a total of 52 cards and 4 copies
    // of each card, meaning x4 2s, x4 3s, x4 Jacks, ... one of each suit.
    // You can use Jacks=11, Queens=12, Kings=12, Aces=13
    // 
    // EXTRA: You can use real card faces images instead of numbers by using
    // the images in the CardImages folder and the setFaceUpIcon() method.
    // Example:
    // card.setFaceUpIcon(Card.cardImagesPath + (i+1) + ".png");
    
    
    public void setupGui(ArrayList<Card> cards) {
        setTitle("League Memory Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setPreferredSize(new Dimension(1090, 500));
        add(panel);
        
        newGameButton = new JButton("New Game");
        newGameButton.addActionListener(this);
        timeLabel = new JLabel("current time: " + (seconds / 60) + ":" + (seconds % 60));
        
        panel.add(newGameButton);
        panel.add(timeLabel);
        
        pack();
    }
    
    public void checkCards() {
        
        if( firstSelectedCard != null && secondSelectedCard != null ) {
            
            if( firstSelectedCard.isSame(secondSelectedCard) ) {
                firstSelectedCard.remove();
                secondSelectedCard.remove();
            } else {
                firstSelectedCard.setFaceUp(false);
                secondSelectedCard.setFaceUp(false);
            }
            
            firstSelectedCard = null;
            secondSelectedCard = null;
        }
    }
    
    public void startGame() {
        this.seconds = 0;
        gameClock.start();
        updateTimer.start();
    }
    
    public void endGame(boolean gameWon) {
        gameClock.stop();
        updateTimer.stop();
        
        if(gameWon) {
            // Matched all the cards
            
            int response = JOptionPane.showConfirmDialog(null, "You win !! "
                    + "\nPlaying time " + (seconds / 60) + ":" + (seconds % 60)
                    + "\nAgain ?", "You win",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                getContentPane().removeAll();
                this.setup();
                this.startGame();
            } else if (response == JOptionPane.NO_OPTION) {
                System.exit(0);
            }
        } else {
            // New game button pressed
            
            getContentPane().removeAll();
            this.setup();
            this.startGame();
        }
    }
    
    private boolean allCardsMatched() {
        if(this.cards == null) {
           return false; 
        }
        
        for(Card eachCard : cards ) {
            if( !eachCard.isMatched() ) {
                return false;
            }
        }
        
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if( e.getSource() == this.updateTimer ) {
            checkCards();
            drawCards();
            
            if( allCardsMatched() ) {
                endGame(true);
            }
            
        } else if( e.getSource() == this.gameClock ) {
            this.seconds++;
            timeLabel.setText("current time: " + (seconds / 60) + ":" + (seconds % 60));
        } else if( e.getSource() == this.newGameButton ){
            endGame(false);
        } else {
            // Card selected
            
            Card newCard = (Card)e.getSource();
            
            if( firstSelectedCard == null ) {
                // First of 2 cards selected
                
                firstSelectedCard = newCard;
                firstSelectedCard.setFaceUp(true);
                drawCards();
                updateTimer.stop();
            } else if( secondSelectedCard == null && newCard != firstSelectedCard ) {
                // Second of 2 cards selected
                
                secondSelectedCard = newCard;
                secondSelectedCard.setFaceUp(true);
                drawCards();
                updateTimer.restart();
            }
        }
        
    }
}
