package com.example.miguel.guessingplayingcard;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Window;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        // attaches fragment_cards layout to fragment_container fragment view
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentCards fragmentCards = new FragmentCards();
        fragmentTransaction.add(R.id.fragment_container, fragmentCards);
        fragmentTransaction.commit();

    }
}
