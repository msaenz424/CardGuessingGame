package com.example.miguel.guessingplayingcard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Game Model Object
 *
 * @author Miguel Saenz
 */
public class Game {
    int mCounter=0;
    private static final int CARDS_IN_GAME = 51; //for this to work it has to be an odd number and multiple of 3
    public static final int CARDS_IN_EACH_COLUMN = CARDS_IN_GAME / 3; // or in other words, number of rows
    private int cardsArray[][] = new int[CARDS_IN_EACH_COLUMN][3];

    /** Class constructor */
    public Game(){
        ArrayList<Integer> arrayDeck = new ArrayList<>();
        arrayDeck.add(R.drawable.c101);
        arrayDeck.add(R.drawable.c102);
        arrayDeck.add(R.drawable.c103);
        arrayDeck.add(R.drawable.c104);
        arrayDeck.add(R.drawable.c105);
        arrayDeck.add(R.drawable.c106);
        arrayDeck.add(R.drawable.c107);
        arrayDeck.add(R.drawable.c108);
        arrayDeck.add(R.drawable.c109);
        arrayDeck.add(R.drawable.c110);
        arrayDeck.add(R.drawable.c111);
        arrayDeck.add(R.drawable.c112);
        arrayDeck.add(R.drawable.c113);
        arrayDeck.add(R.drawable.c114);
        arrayDeck.add(R.drawable.c115);
        arrayDeck.add(R.drawable.c116);
        arrayDeck.add(R.drawable.c117);
        arrayDeck.add(R.drawable.c118);
        arrayDeck.add(R.drawable.c119);
        arrayDeck.add(R.drawable.c120);
        arrayDeck.add(R.drawable.c121);
        arrayDeck.add(R.drawable.c122);
        arrayDeck.add(R.drawable.c123);
        arrayDeck.add(R.drawable.c124);
        arrayDeck.add(R.drawable.c125);
        arrayDeck.add(R.drawable.c126);
        arrayDeck.add(R.drawable.c127);
        arrayDeck.add(R.drawable.c128);
        arrayDeck.add(R.drawable.c129);
        arrayDeck.add(R.drawable.c130);
        arrayDeck.add(R.drawable.c131);
        arrayDeck.add(R.drawable.c132);
        arrayDeck.add(R.drawable.c133);
        arrayDeck.add(R.drawable.c134);
        arrayDeck.add(R.drawable.c135);
        arrayDeck.add(R.drawable.c136);
        arrayDeck.add(R.drawable.c137);
        arrayDeck.add(R.drawable.c138);
        arrayDeck.add(R.drawable.c139);
        arrayDeck.add(R.drawable.c140);
        arrayDeck.add(R.drawable.c141);
        arrayDeck.add(R.drawable.c142);
        arrayDeck.add(R.drawable.c143);
        arrayDeck.add(R.drawable.c144);
        arrayDeck.add(R.drawable.c145);
        arrayDeck.add(R.drawable.c146);
        arrayDeck.add(R.drawable.c147);
        arrayDeck.add(R.drawable.c148);
        arrayDeck.add(R.drawable.c149);
        arrayDeck.add(R.drawable.c150);
        arrayDeck.add(R.drawable.c151);
        arrayDeck.add(R.drawable.c152);
        arrayDeck.add(R.drawable.c153);
        arrayDeck.add(R.drawable.c154);
        arrayDeck.add(R.drawable.c155);
        arrayDeck.add(R.drawable.c157);
        arrayDeck.add(R.drawable.c158);
        arrayDeck.add(R.drawable.c159);
        arrayDeck.add(R.drawable.c160);
        arrayDeck.add(R.drawable.c161);
        arrayDeck.add(R.drawable.c162);
        arrayDeck.add(R.drawable.c163);
        arrayDeck.add(R.drawable.c164);
        arrayDeck.add(R.drawable.c165);

        // shuffles the cards and then populate them into an multidimensional array
        // which size is determined by the number of cards being used divided by 3
        Collections.shuffle(arrayDeck);
        int c = 0;
        for (int i = 0; i < CARDS_IN_EACH_COLUMN; i++){
            for (int j = 0; j < 3; j++){
                cardsArray[i][j] = arrayDeck.get(c);
                c++;
            }
        }
    }
    /**
     * Rearranges the main array of cards.
     * Updates a counter which is used to check how many
     * times the main array has been rearranged. The game should
     * stop when the counters reaches 4.
     *
     * @param array this array represents a column in GridView
     */
    public void arrangeCardsArray(int array[]){
        int c = 0;
        for (int i = 0; i < CARDS_IN_EACH_COLUMN; i++){
            for (int j = 0; j < 3; j++){
                cardsArray[i][j]= array[c];
                c++;
            }
        }
        mCounter++;
    }

    /**
     * Returns the a multidimensional array that can be used to populate
     * the GridView.
     * @return the main array of cards
     */
    public int[][] getCardsArray(){
        return cardsArray;
    }

    /**
     * Returns the number of cards that exists in each column.
     * This value is important for the algorithm to work.
     * @return
     */
    public int getNumberofRows(){
        return CARDS_IN_EACH_COLUMN;
    }
}
