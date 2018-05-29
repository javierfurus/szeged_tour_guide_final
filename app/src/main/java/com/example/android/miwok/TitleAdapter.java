package com.example.android.miwok;

import android.app.Activity;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class TitleAdapter extends ArrayAdapter<Word_2> {

    TitleAdapter(Activity context, ArrayList<Word_2> words) {
        super(context, 0, words);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listViewItem = convertView;
        if (listViewItem == null) {
            listViewItem = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false
            );
        }
        Word_2 currentWord = getItem(position);

        //get music title
        TextView title = (TextView) listViewItem.findViewById(R.id.title_textview);
        title.setText(currentWord.getTitle());
        title.setTypeface(null, Typeface.BOLD);

        //get the description of the song
        TextView description = (TextView) listViewItem.findViewById(R.id.artist_text_view);
        description.setText(currentWord.getDefinition());

        //get art
        ImageView art = (ImageView) listViewItem.findViewById(R.id.album_art);
        art.setImageResource(currentWord.getArt());

        return listViewItem;
    }

}
