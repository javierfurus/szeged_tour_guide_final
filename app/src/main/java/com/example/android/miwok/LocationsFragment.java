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
public class LocationsFragment extends Fragment {

    public LocationsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        // Create and setup the {@link AudioManager} to request audio focus

        // Create a list of words
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word(R.string.votive_description, R.string.votive, R.string.votive_location, R.string.votive_url,
                R.drawable.votivechurch));
        words.add(new Word(R.string.synagogue_description, R.string.synagogue, R.string.synagogue_location, R.string.synagogue_url,
                R.drawable.szeged_synagogue));
        words.add(new Word(R.string.szegedzoo_description, R.string.szegedzoo, R.string.szegedzoo_location, R.string.szegedzoo_url,
                R.drawable.szegedzoo));
        words.add(new Word(R.string.pantheon_description, R.string.pantheon, R.string.pantheon_location, R.string.pantheon_url,
                R.drawable.pantheon));

        // Create an {@link WordAdapter}, whose data source is a list of {@link com.example.android.miwok.Word_2}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(getActivity(), words, R.color.category_locations);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

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
                Intent playerIntent = new Intent(LocationsFragment.this.getActivity(), DetailsActivity.class);
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
