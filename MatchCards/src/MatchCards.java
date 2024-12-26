import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class MatchCards {
    class Card {
        String cardName;
        ImageIcon cardImageIcon;

        Card(String cardName, ImageIcon cardImageIcon) {
            this.cardName = cardName;
            this.cardImageIcon = cardImageIcon;
        }

        public String toString() {
            return cardName;
        }
    }

    

    MatchCards(){
        
    }
}

