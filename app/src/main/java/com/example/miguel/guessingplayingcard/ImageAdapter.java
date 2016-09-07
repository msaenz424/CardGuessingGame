package com.example.miguel.guessingplayingcard;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/**
 * Created by Miguel on 9/4/2016.
 */
public class ImageAdapter extends BaseAdapter{
    private Context mContext;
    Card arrayCards[][];

    public ImageAdapter(Context c, Card array[][], int rows){
        mContext = c;
        arrayCards= new Card[rows][3];
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < 3; j++){
                arrayCards[i][j] = array[i][j];
            }
        }
    }

    @Override
    public int getCount() {
        return (arrayCards.length * 3);   // # rows * 3
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null){
            //image_model is a customized layout that contains only an ImageView named "ivCard"
            convertView = layoutInflater.inflate(R.layout.image_model, null);
        }
        ImageView imageView = (ImageView) convertView.findViewById(R.id.ivCard);

        int indexCol = getIndexColumn(position);
        int indexRow = getIndexRow(position);
        Log.d("sadas", String.valueOf(position) + " " + String.valueOf(getCount()));
        imageView.setImageResource(arrayCards[indexRow][indexCol].getImage());

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*
                When desire column is selected the array containing all the cards must be split in 3 sub-arrays (by columns)
                Then those 3 sub-arrays need to be passed to the game object to re-arrange the main array
                 */

           }
        });

        return convertView;
    }

    public int getIndexRow(int linearPosition){
        return (linearPosition) / 3;
    }

    public int getIndexColumn(int linearPosition) {
        return linearPosition % 3;  // 3 refers to the # of columns. This value must not be changed
    }
}
