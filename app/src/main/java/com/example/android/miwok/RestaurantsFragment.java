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
public class RestaurantsFragment extends Fragment {

    public RestaurantsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        // Create a list of words
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word(R.string.virag_etterem_descript, R.string.virag_cukraszda, R.string.virag_location, R.string.virag_url,
                R.drawable.virag));
        words.add(new Word(R.string.halaszcsarda_descript, R.string.halaszcsarda, R.string.halaszcsarda_location, R.string.halaszcsarda_url,
                R.drawable.roosevelthalaszcsarda));
        words.add(new Word(R.string.john_bull_pub_description, R.string.john_bull_pub, R.string.john_bull_location, R.string.john_bull_url,
                R.drawable.johnbull));
        words.add(new Word(R.string.taj_maha_description, R.string.taj_mahal, R.string.tajmahal_location, R.string.tajmahal_url,
                R.drawable.tajmahalimage));

        // Create an {@link WordAdapter}, whose data source is a list of {@link com.example.android.miwok.Word_2}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(getActivity(), words, R.color.category_restaurants);

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
                Intent playerIntent = new Intent(RestaurantsFragment.this.getActivity(), DetailsActivity.class);
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
