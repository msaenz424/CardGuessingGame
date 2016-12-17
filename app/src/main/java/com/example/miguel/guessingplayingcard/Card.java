package com.example.miguel.guessingplayingcard;

/**
 * Card Model Object
 *
 * @author Miguel Saenz
 */
public class Card {
    private int image;

    /** Class constructor specifying a drawable resource. */
    public Card(int image){
        this.image = image;
    }

    /**
     *
     * @return a drawable resource
     */
    public int getImage(){
        return image;
    }

    /**
     * Sets the drawable resource value. This is used
     * to change the drawable resource value previously assigned.
     *
     * @param image a drawable resource
     */
    public void setImage(int image){
        this.image = image;
    }

}
