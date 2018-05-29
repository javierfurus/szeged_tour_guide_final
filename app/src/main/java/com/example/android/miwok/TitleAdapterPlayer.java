package com.example.android.miwok;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class TitleAdapterPlayer extends ArrayAdapter<Word> {

    TitleAdapterPlayer(Activity context, ArrayList<Word> words) {
        super(context, 0, words);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listViewItem = convertView;

        if (listViewItem == null) {
            listViewItem = LayoutInflater.from(getContext()).inflate(
                    R.layout.player_list_item, parent, false
            );
        }
        Word currentWord = getItem(position);

        //get miwok word
        TextView title = (TextView) listViewItem.findViewById(R.id.title_textview);
        title.setText(currentWord.getTitle());

        //get default translation word
        TextView description = (TextView) listViewItem.findViewById(R.id.artist_text_view);
        description.setText(currentWord.getDescription());

        //get art
        ImageView art = (ImageView) listViewItem.findViewById(R.id.album_art);
        art.setImageResource(currentWord.getArt());

        //get location
        TextView location = (TextView) listViewItem.findViewById(R.id.location);
        location.setText(currentWord.getLocationId());


        return listViewItem;
    }

}
