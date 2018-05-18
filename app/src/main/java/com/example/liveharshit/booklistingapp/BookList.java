package com.example.liveharshit.booklistingapp;

import android.graphics.Bitmap;

public class BookList {

    private String mImageurl;
    private String mTitle;
    private String mAuthor;
    private String mPreviewUrl;
    private String mDownloadAvailable;
    private String mDownloadOrViewUrl;

    public BookList (String imageUrl,String title, String author, String previewUrl, String downloadAvailable, String downloadOrViewUrl) {
        mImageurl = imageUrl;
        mTitle = title;
        mAuthor = author;
        mPreviewUrl = previewUrl;
        mDownloadAvailable = downloadAvailable;
        mDownloadOrViewUrl = downloadOrViewUrl;
    }

    public String getImageUrl () {return mImageurl;}
    public String getTitle () {return mTitle;}
    public String getAuthor () {return mAuthor;}
    public String getPreviewUrl () {return mPreviewUrl;}
    public String getDownloadAvailable () {return mDownloadAvailable;}
    public String getDownloadOrViewUrl () {return mDownloadOrViewUrl;}

}
