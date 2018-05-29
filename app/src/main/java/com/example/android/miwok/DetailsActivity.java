package com.example.android.miwok;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity {
    Button takemethere;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_activity);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent intent = getIntent();
        final Word song = intent.getParcelableExtra("position");

        ArrayList<Word> selectedsong = new ArrayList<>();
        selectedsong.add(song);
        TitleAdapterPlayer adapter =
                new TitleAdapterPlayer(DetailsActivity.this, selectedsong);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);
        listView.setEnabled(false);

        //changes the Title of the activity to the name of the item selected
        setTitle(song.getTitle());

        takemethere = (Button) findViewById(R.id.takemetherebutton);
        takemethere.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = context.getResources().getString(song.getLocationURL());

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

    }
}