package game;

import model.Card;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class GameLogic {
    private final ArrayList<Card> cards = new ArrayList<>();
    private final ArrayList<JButton> cardButtons = new ArrayList<>();
    private final ImageIcon cardBackImage;
    private JButton firstSelected;
    private JButton secondSelected;
    private int errors = 0;
    private boolean isGameReady = false;
    
    public static final int ROWS = 4;
    public static final int COLS = 5;
    public static final int CARD_WIDTH = 90;
    public static final int CARD_HEIGHT = 128;
    
    public GameLogic() {
        loadCards();
        cardBackImage = loadCardBack();
        shuffleCards();
    }
    
    private void loadCards() {
        String[] cardTypes = {
            "darkness", "double", "fairy", "fighting", "fire",
            "grass", "lightning", "metal", "psychic", "water"
        };
        
        for (String type : cardTypes) {
            Image img = new ImageIcon(getClass().getResource("/img/" + type + ".jpg")).getImage();
            ImageIcon icon = new ImageIcon(img.getScaledInstance(CARD_WIDTH, CARD_HEIGHT, Image.SCALE_SMOOTH));
            cards.add(new Card(type, icon));
        }
        cards.addAll(new ArrayList<>(cards));
    }
    
    private ImageIcon loadCardBack() {
        Image img = new ImageIcon(getClass().getResource("/img/back.jpg")).getImage();
        return new ImageIcon(img.getScaledInstance(CARD_WIDTH, CARD_HEIGHT, Image.SCALE_SMOOTH));
    }
    
    public void shuffleCards() {
        Collections.shuffle(cards);
    }
    
    public boolean handleCardClick(JButton clickedButton) {
        if (!isGameReady || clickedButton.getIcon() != cardBackImage) return false;
        
        if (firstSelected == null) {
            firstSelected = clickedButton;
            showCard(firstSelected);
            return false;
        } else if (secondSelected == null) {
            secondSelected = clickedButton;
            showCard(secondSelected);
            
            if (!cardsMatch()) {
                errors++;
                return true; // Karten müssen verdeckt werden
            }
            resetSelection();
            return false;
        }
        return false;
    }
    
    private void showCard(JButton button) {
        int index = cardButtons.indexOf(button);
        button.setIcon(cards.get(index).getImage());
    }
    
    private boolean cardsMatch() {
        return firstSelected.getIcon() == secondSelected.getIcon();
    }
    
    public void hideSelectedCards() {
        if (firstSelected != null && secondSelected != null) {
            firstSelected.setIcon(cardBackImage);
            secondSelected.setIcon(cardBackImage);
            resetSelection();
        }
    }
    
    private void resetSelection() {
        firstSelected = null;
        secondSelected = null;
    }
    
    // Getter/Setter und weitere benötigte Methoden
    public void addCardButton(JButton button) { cardButtons.add(button); }
    public ArrayList<Card> getCards() { return cards; }
    public ImageIcon getCardBack() { return cardBackImage; }
    public int getErrors() { return errors; }
    public void setGameReady(boolean ready) { isGameReady = ready; }
    public boolean isGameReady() { return isGameReady; }
    public ArrayList<JButton> getCardButtons() { return cardButtons; }
    public void resetGame() {
        errors = 0;
        resetSelection();
        shuffleCards();
    }
}
