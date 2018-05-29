package com.example.android.miwok;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by javier on 2018.03.23..
 */

public class Word_2 extends ArrayList<Parcelable> implements Parcelable {
    public static final Creator<Word_2> CREATOR = new Creator<Word_2>() {
        @Override
        public Word_2 createFromParcel(Parcel in) {
            return new Word_2(in);
        }

        @Override
        public Word_2[] newArray(int size) {
            return new Word_2[size];
        }
    };
    private String mTitle;
    private String mArtist;
    private int mAlbumArt;
    private String mSongLength;

    public Word_2(String artist, String title, int albumArt, String songLength) {
        mTitle = title;
        mArtist = artist;
        mAlbumArt = albumArt;
        mSongLength = songLength;
    }

    protected Word_2(Parcel in) {
        mTitle = in.readString();
        mArtist = in.readString();
        mAlbumArt = in.readInt();
        mSongLength = in.readString();
    }

    public String getDefinition() {
        return mTitle;
    }

    public String getTitle() {
        return mArtist;
    }

    public int getArt() {
        return mAlbumArt;
    }

    public String getSongLength() {
        return mSongLength;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mTitle);
        parcel.writeString(mArtist);
        parcel.writeInt(mAlbumArt);
        parcel.writeString(mSongLength);
    }
}
