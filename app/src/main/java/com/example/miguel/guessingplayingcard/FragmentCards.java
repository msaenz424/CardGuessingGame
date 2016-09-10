package com.example.miguel.guessingplayingcard;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

public class FragmentCards extends Fragment {
    Game newGame = new Game(); // A new game should be created every round, that is when user selects his column
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.fragment_cards,container,false);
        /*
         Need to create an array of "Card" objects to eventually pass it to the adapter.
         Each new card-object will be passed to this array
        */
        Card arrayCards[][] = new Card[newGame.getNumberofRows()][3];
        for (int i = 0; i < newGame.getNumberofRows(); i++){
            for (int j = 0; j < 3; j++){
                Card objCard = new Card(newGame.getCardsArray()[i][j]);
                arrayCards[i][j] = objCard;
            }
        }

        // shows gridview filled with cards
        GridView gridview = (GridView) view.findViewById(R.id.gvCards);
        ImageAdapter imageAdapter = new ImageAdapter(view.getContext(), arrayCards, newGame);
        gridview.setAdapter(imageAdapter);
        return view; //returns the fragment(containing the gridview) inflated
    }

}
