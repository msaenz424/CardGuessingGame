package com.example.miguel.guessingplayingcard;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter{
    private Context mContext;
    Game objGame;
    Card arrayCards[][];

    public ImageAdapter(Context c, Card array[][], Game game){
        mContext = c;
        objGame = game;
        arrayCards= new Card[game.getNumberofRows()][3];
        for (int i = 0; i < game.getNumberofRows(); i++){
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
    public View getView(final int position, View convertView, final ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null){
            //image_model is a customized layout that contains only an ImageView named "ivCard"
            convertView = layoutInflater.inflate(R.layout.image_model, null);
        }
        final ImageView imageView = (ImageView) convertView.findViewById(R.id.ivCard);

        int indexCol = getIndexColumn(position);
        int indexRow = getIndexRow(position);

        imageView.setImageResource(arrayCards[indexRow][indexCol].getImage());

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int newColumns[] = new int[getCount()];
                /*
                When the desire column is selected the array containing all the cards must be split in 3 sub-arrays (by columns)
                Then those 3 sub-arrays need to be passed to the game object to re-arrange the main array.
                 */
                int rows = objGame.getNumberofRows();
                for (int i = 0; i < rows; i++){
                    newColumns[i] = arrayCards[i][getIndexColumn(position+1)].getImage();
                    newColumns[i + rows] = arrayCards[i][getIndexColumn(position)].getImage();
                    newColumns[i + rows*2] = arrayCards[i][getIndexColumn(position+2)].getImage();
                }
                objGame.arrangeCardsArray(newColumns);
                // after rearranging the cards, now these need to be shown left-to-right manner starting from row 0
                for (int i = 0; i < getCount()/3; i++){
                    for (int j = 0; j < 3; j++) {
                        arrayCards[i][j].setImage(objGame.getCardsArray()[i][j]);
                    }
                }
                notifyDataSetChanged();
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
