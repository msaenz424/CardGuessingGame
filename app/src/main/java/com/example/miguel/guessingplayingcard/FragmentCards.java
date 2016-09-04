package com.example.miguel.guessingplayingcard;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Miguel on 8/22/2016.
 */
public class FragmentCards extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.fragment_cards,container,false);
        return view;
    }
}
