package com.example.miguel.guessingplayingcard;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // shows gridview filled with cards
        GridView gridview = (GridView) findViewById(R.id.gvCards);
        gridview.setAdapter(new ImageAdapter(this));

        // attaches "gvCards" gridview to the fragment
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentCards fragmentCards = new FragmentCards();
        fragmentTransaction.add(R.id.fragment_container,fragmentCards);
        fragmentTransaction.commit();
    }
}
