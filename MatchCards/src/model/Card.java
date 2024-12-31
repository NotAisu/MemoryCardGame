package model;

import javax.swing.ImageIcon;

public class Card {
    private final String name;
    private final ImageIcon frontImage;
    
    public Card(String name, ImageIcon frontImage) {
        this.name = name;
        this.frontImage = frontImage;
    }
    
    public String getName() { return name; }
    public ImageIcon getImage() { return frontImage; }
    
    @Override
    public String toString() { return name; }
}
