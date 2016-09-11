package com.example.miguel.guessingplayingcard;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends Activity {
    private Button btnInstructions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        btnInstructions = (Button)findViewById(R.id.btnInstructions);
        btnInstructions.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String instructions = "Look for the card that you most like and click on the column that your card is located (you can click anywhere on the column). " +
                        "Then, the deck will shuffle and you will have to locate your card again, once you locate it click again on its column. " +
                        "Repeat this procedure 4 times";
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setMessage(instructions)
                        .setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //nothing to do
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
        // attaches fragment_cards layout to fragment_container fragment view
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentCards fragmentCards = new FragmentCards();
        fragmentTransaction.add(R.id.fragment_container, fragmentCards);
        fragmentTransaction.commit();

    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }
}
