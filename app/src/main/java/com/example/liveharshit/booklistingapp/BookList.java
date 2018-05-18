package com.example.liveharshit.booklistingapp;

import android.graphics.Bitmap;

public class BookList {

    private Bitmap mBmp;
    private String mTitle;
    private String mAuthor;
    private String mPreviewUrl;
    private String mDownloadAvailable;
    private String mDownloadOrViewUrl;

    public BookList (Bitmap bmp,String title, String author, String previewUrl, String downloadAvailable, String downloadOrViewUrl) {
        mBmp = bmp;
        mTitle = title;
        mAuthor = author;
        mPreviewUrl = previewUrl;
        mDownloadAvailable = downloadAvailable;
        mDownloadOrViewUrl = downloadOrViewUrl;
    }

    public Bitmap getBmp () {return mBmp;}
    public String getTitle () {return mTitle;}
    public String getAuthor () {return mAuthor;}
    public String getPreviewUrl () {return mPreviewUrl;}
    public String getDownloadAvailable () {return mDownloadAvailable;}
    public String getDownloadOrViewUrl () {return mDownloadOrViewUrl;}

}
