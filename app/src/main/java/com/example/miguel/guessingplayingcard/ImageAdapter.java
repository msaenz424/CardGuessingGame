package com.example.miguel.guessingplayingcard;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * ImageAdapter Model Object
 *
 * @author Miguel Saenz
 */
public class ImageAdapter extends BaseAdapter{
    private Context mContext;
    Game objGame;
    Card arrayCards[][];

    /**
     * Class constructor specifying context, array and game object
     *
     * @param c represents the View' context
     * @param array represents the array of cards
     * @param game represents the current Game object
     */
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

    /** @return the total number of cards being in the current Game object */
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
        final LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null){
            //image_model is a customized layout that contains only an ImageView named "ivCard"
            convertView = layoutInflater.inflate(R.layout.image_model, null);
        }
        final ImageView imageView = (ImageView) convertView.findViewById(R.id.ivCard);

        int indexRow = getIndexRow(position);
        int indexCol = getIndexColumn(position);

        loadBitmap(arrayCards[indexRow][indexCol].getImage(), imageView, null);

        imageView.setAdjustViewBounds(true); // trims any blank space between rows in gridview
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shuffleCards(position);

                // 4 is the number of times the cards need to be shuffled in order to "guess" the card
                if (objGame.mCounter < 4){
                    notifyDataSetChanged();
                }else{
                    v.setClickable(false);   // avoids interacting with GridView while guessed card is being displayed
                    showGuessedCard(parent); // this shows the guessed card
                    objGame.mCounter = 0;    // resets the counter that keeps track of the number of times the cards have been shuffled
                }
            }
        });
        return convertView;
    }

    /**
     * Figures out which row was clicked
     *
     * @param linearPosition represents the position of the card selected in the GridView
     * @return the index of row selected
     */
    public int getIndexRow(int linearPosition){
        return (linearPosition) / 3;
    }

    /**
     * Figures out which column was clicked.
     *
     * @param linearPosition represents the position of the card selected in the GridView
     * @return the index of column selected
     */
    public int getIndexColumn(int linearPosition) {
        return linearPosition % 3;
    }

    /**
     * Passes a image from BitmapWorkerTask object to be processed in the background
     *
     * @param resId                 represents a image
     * @param imageView             represents a view
     * @param mPlaceHolderBitmap    represents a place holder to be shown while image is loading
     */
    public void loadBitmap(int resId, ImageView imageView, Bitmap mPlaceHolderBitmap) {
        if (BitmapWorkerTask.cancelPotentialWork(resId, imageView)) {
            final BitmapWorkerTask task = new BitmapWorkerTask(imageView, mContext);
            final BitmapWorkerTask.AsyncDrawable asyncDrawable =
                    new BitmapWorkerTask.AsyncDrawable(mContext.getResources(), mPlaceHolderBitmap, task);
            imageView.setImageDrawable(asyncDrawable);
            task.execute(resId);
        }
    }

    /**
     * Shows the card that the user has originally picked and followed the instructions accordingly
     *
     * @param parent represents the parent view of the custom image that will be displayed
     */
    private void showGuessedCard(final ViewGroup parent){
        LayoutInflater toastInflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = toastInflater.inflate(R.layout.custom_toast, (ViewGroup)parent.findViewById(R.id.custom_toast_container));
        ImageView imageView = (ImageView)layout.findViewById(R.id.ivResult);
        imageView.setImageResource(arrayCards[objGame.getNumberofRows()/2][1].getImage());
        Toast toast = new Toast(mContext);
        toast.setGravity(Gravity.FILL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }

    /**
     * Redistributes array of cards in a local array in an arbitrary manner.
     * Then the local array is passed to a function in Game object to rearrange the cards
     * @param position
     */
    private void shuffleCards(int position){
        int newColumns[] = new int[getCount()];
        int rows = objGame.getNumberofRows();
        for (int i = 0; i < rows; i++){
            newColumns[i] = arrayCards[i][getIndexColumn(position+1)].getImage();
            newColumns[i + rows] = arrayCards[i][getIndexColumn(position)].getImage();
            newColumns[i + rows*2] = arrayCards[i][getIndexColumn(position+2)].getImage();
        }
        objGame.arrangeCardsArray(newColumns);
        // after cards are rearranged, now they need to be shown in a left-to-right manner starting from row 0
        for (int i = 0; i < getCount()/3; i++){
            for (int j = 0; j < 3; j++) {
                arrayCards[i][j].setImage(objGame.getCardsArray()[i][j]);
            }
        }
    }

}
