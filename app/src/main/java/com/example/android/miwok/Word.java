/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * {@link Word} represents a vocabulary word that the user wants to learn.
 * It contains resource IDs for the default translation, Miwok translation, audio file, and
 * optional image file for that word.
 */
public class Word extends ArrayList<Parcelable> implements Parcelable {

    public static final Creator<Word> CREATOR = new Creator<Word>() {
        @Override
        public Word createFromParcel(Parcel in) {
            return new Word(in);
        }

        @Override
        public Word[] newArray(int size) {
            return new Word[size];
        }
    };
    /** String resource ID for the default translation of the word */
    private int mDescriptionId;
    /** String resource ID for the Miwok translation of the word */
    private int mTitleId;
    /** Image resource ID for the word */
    private int mImageResourceId;
    private int mLocationURLId;
    /** Constant value that represents no image was provided for this word */
    private static final int NO_IMAGE_PROVIDED = -1;
    private int mLocationId;

    /**
     * Create a new com.example.android.miwok.Word_2 object.
     *
     * @param defaultTranslationId is the string resource ID for the word in a language that the
     *                             user is already familiar with (such as English)
     * @param miwokTranslationId is the string resource Id for the word in the Miwok language
     */
    public Word(int defaultTranslationId, int miwokTranslationId, int locationId, int locationURLId) {
        mDescriptionId = defaultTranslationId;
        mTitleId = miwokTranslationId;
        mLocationId = locationId;
        mLocationURLId = locationURLId;
    }

    /**
     * Create a new com.example.android.miwok.Word_2 object.
     *  @param descriptionId is the string resource ID for the word in a language that the
     *                             user is already familiar with (such as English)
     * @param titleId is the string resource Id for the word in the Miwok language
     * @param imageResourceId is the drawable resource ID for the image associated with the word
     */
    public Word(int descriptionId, int titleId, int locationId, int locationURLId, int imageResourceId) {
        mDescriptionId = descriptionId;
        mTitleId = titleId;
        mLocationId = locationId;
        mLocationURLId = locationURLId;
        mImageResourceId = imageResourceId;
    }

    protected Word(Parcel in) {
        mDescriptionId = in.readInt();
        mTitleId = in.readInt();
        mLocationId = in.readInt();
        mLocationURLId = in.readInt();
        mImageResourceId = in.readInt();
    }

    /**
     * Get the string resource ID for the default translation of the word.
     */
    public int getDescription() {
        return mDescriptionId;
    }

    /**
     * Get the string resource ID for the Miwok translation of the word.
     */
    public int getTitle() {
        return mTitleId;
    }

    /**
     * Return the image resource ID of the word.
     */
    public int getArt() {
        return mImageResourceId;
    }

    public int getLocationId() {
        return mLocationId;
    }

    public int getLocationURL() {
        return mLocationURLId;
    }
    /**
     * Returns whether or not there is an image for this word.
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mDescriptionId);
        parcel.writeInt(mTitleId);
        parcel.writeInt(mLocationId);
        parcel.writeInt(mLocationURLId);
        parcel.writeInt(mImageResourceId);
    }
}