package com.example.miguel.guessingplayingcard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by Miguel on 9/4/2016.
 */
public class ImageAdapter extends BaseAdapter{
    private Context mContext;
    ArrayList<Card> arrayCards = new ArrayList<>();

    public ImageAdapter(Context c, ArrayList<Card> array){
        mContext = c;
        arrayCards = array;
    }

    @Override
    public int getCount() {
        return arrayCards.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayCards.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null){
            //image_model is a customized layout that contains only an ImageView named "ivCard"
            convertView = layoutInflater.inflate(R.layout.image_model, null);
        }
        ImageView imageView = (ImageView) convertView.findViewById(R.id.ivCard);
        imageView.setImageResource(arrayCards.get(position).getImage());

        return convertView;
    }
}
