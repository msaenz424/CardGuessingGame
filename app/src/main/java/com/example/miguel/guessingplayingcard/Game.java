package com.example.miguel.guessingplayingcard;

import java.util.ArrayList;

/**
 * Created by Miguel on 8/22/2016.
 */
public class Game {
    private int mCounter = 0;
    private static final int CARDS_IN_GAME = 21; //for this to work it has to be an odd number and multiple of 3
    public static final int CARDS_IN_EACH_COLUMN = CARDS_IN_GAME / 3; // or in other words, number of rows
    private int cardsArray[][] = new int[CARDS_IN_EACH_COLUMN][3];

    public Game(){
        int[] tempArray = {
                R.drawable.c101,
                R.drawable.c102,
                R.drawable.c103,
                R.drawable.c104,
                R.drawable.c105,
                R.drawable.c106,
                R.drawable.c107,
                R.drawable.c108,
                R.drawable.c109,
                R.drawable.c110,
                R.drawable.c111,
                R.drawable.c112,
                R.drawable.c113,
                R.drawable.c114,
                R.drawable.c115,
                R.drawable.c116,
                R.drawable.c117,
                R.drawable.c118,
                R.drawable.c119,
                R.drawable.c120,
                R.drawable.c121
        };
        int c = 0;
        for (int i = 0; i < CARDS_IN_EACH_COLUMN; i++){
            for (int j = 0; j < 3; j++){
                cardsArray[i][j] = tempArray[c++];
            }
        }


    }

    /*
    Each array argument represents a column of playing cards
    Method re-arranges playing cards and returns a new array of them.
    c counts the total of amount of playing cards
    i counts cards in each column
     */
    public void arrangeCardsArray(Card array[][]){
        /*
        int c = 0;
        for (int i = 0; i < CARDS_IN_EACH_COLUMN; i++){
            cardsArray[c] = firstColumn[i];
            c++;
        }
        for (int i = 0; i < CARDS_IN_EACH_COLUMN; i++){
            cardsArray[c] = chosenColumn[i];
            c++;
        }
        for (int i = 0; i < CARDS_IN_EACH_COLUMN; i++){
            cardsArray[c] = lastColumn[i];
            c++;
        }
        */
    }

    public int[][] getCardsArray(){
        return cardsArray;
    }
    public int getNumberofRows(){
        return CARDS_IN_EACH_COLUMN;
    }
}
