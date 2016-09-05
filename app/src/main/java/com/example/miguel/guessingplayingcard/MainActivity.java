package com.example.miguel.guessingplayingcard;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // attaches fragment_cards layout to fragment_container fragment view
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentCards fragmentCards = new FragmentCards();
        fragmentTransaction.add(R.id.fragment_container, fragmentCards);
        fragmentTransaction.commit();

    }
}
