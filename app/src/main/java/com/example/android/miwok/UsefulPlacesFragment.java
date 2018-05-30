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
public class UsefulPlacesFragment extends Fragment {

    public UsefulPlacesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);
        // Create a list of words
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word(R.string.
                arkad_description, R.string.arkad, R.string.arkad_location, R.string.arkad_url,
                R.drawable.arkadszeged));
        words.add(new Word(R.string.nagyaruhaz_description, R.string.nagyaruhaz, R.string.nagyaruhaz_location,
                R.string.nagyaruhaz_url, R.drawable.nagyaruhaz));
        words.add(new Word(R.string.napfenypark_description, R.string.napfenypark, R.string.napfenypark_location,
                R.string.napfenypark_url, R.drawable.napfenypark));
        words.add(new Word(R.string.plaza_description, R.string.plaza, R.string.plaza_location, R.string.plaza_url,
                R.drawable.szegedplaza));

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
                Intent playerIntent = new Intent(UsefulPlacesFragment.this.getActivity(), DetailsActivity.class);
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
