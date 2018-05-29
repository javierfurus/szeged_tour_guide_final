package com.example.android.miwok;


import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotelsFragment extends Fragment {

    public HotelsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);
        // Create a list of words
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word(R.string.
                art_hotel_description, R.string.art_hotel, R.string.arthotel_location, R.string.arthotel_url,
                R.drawable.arthotel));
        words.add(new Word(R.string.tiszavirag_description, R.string.tiszavirag, R.string.tiszavirag_location, R.string.tiszavirag_url,
                R.drawable.tiszaviragszeged));
        words.add(new Word(R.string.science_description, R.string.science, R.string.sciencehotel_location, R.string.sciencehotel_url,
                R.drawable.science));
        words.add(new Word(R.string.auris_description, R.string.auris, R.string.auris_location, R.string.auris_url,
                R.drawable.auris));

        // Create an {@link WordAdapter}, whose data source is a list of {@link com.example.android.miwok.Word_2}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(getActivity(), words, R.color.category_hotels);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link com.example.android.miwok.Word_2} in the list.
        listView.setAdapter(adapter);

        //hide divider between the items
        listView.setDivider(null);
        listView.setDividerHeight(0);

        // Set a click listener to open DetailsActivity.class
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position,
                                    long arg3) {
                Word currentWord = getItem(position);
                Intent playerIntent = new Intent(HotelsFragment.this.getActivity(), DetailsActivity.class);
                playerIntent.putExtra("position", (Parcelable) currentWord);
                startActivity(playerIntent);

            }

            private Word getItem(int position) {
                return words.get(position);
            }
        });

        return rootView;
    }

}
