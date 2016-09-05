package com.example.miguel.guessingplayingcard;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.util.ArrayList;

/**
 * Created by Miguel on 8/22/2016.
 */
public class FragmentCards extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.fragment_cards,container,false);

        Game newGame = new Game(); // A new game should be created every round, that is when user presses any "column" button

        /*
         Need to create an array of "Card" objects to eventually pass it to the adapter.
         An array of int containing the path to the drawable folder will need to be passed each time
         a new objCard is created.
        */
        ArrayList<Card> arrayCards = new ArrayList<>(); //array of objects

        for (int i = 0; i < newGame.getCardsArray().length; i++){
            Card objCard = new Card(newGame.getCardsArray()[i]);
            arrayCards.add(objCard);
        }

        // shows gridview filled with cards
        GridView gridview = (GridView) view.findViewById(R.id.gvCards);
        gridview.setAdapter(new ImageAdapter(view.getContext(), arrayCards));
        return view; //return the fragment(containing the gridview) inflated
    }
}
