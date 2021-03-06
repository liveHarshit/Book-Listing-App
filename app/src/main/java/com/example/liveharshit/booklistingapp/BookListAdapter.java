package com.example.liveharshit.booklistingapp;

import android.app.LauncherActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.EventLogTags;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class BookListAdapter extends ArrayAdapter<BookList> {

    public BookListAdapter(Context context,List<BookList> objects) {
        super(context, 0, objects);
    }

    @NonNull
    public View getView(int position, final View convertView, ViewGroup parent) {
        View listItemView = convertView;

        if(listItemView==null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }

        final BookList currentBookList = getItem(position);

        TextView titleView = (TextView)listItemView.findViewById(R.id.title);
        titleView.setText(currentBookList.getTitle());

        TextView author = (TextView)listItemView.findViewById(R.id.author_name);
        author.setText(currentBookList.getAuthor());

        TextView pdfAvailability = (TextView)listItemView.findViewById(R.id.download_availability);
        pdfAvailability.setText(currentBookList.getDownloadAvailable());

        Button preview_button = (Button)listItemView.findViewById(R.id.preview);
        preview_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = currentBookList.getPreviewUrl();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                getContext().startActivity(i);
            }
        });

        TextView downloadTextView = (TextView)listItemView.findViewById(R.id.download_pdf);
        if(currentBookList.getDownloadAvailable().equals("YES")) {
            downloadTextView.setText("Click here to download pdf");
        } else {
            downloadTextView.setText("Click here for web reader");
        }

        downloadTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = currentBookList.getDownloadOrViewUrl();
                Intent j = new Intent(Intent.ACTION_VIEW);
                j.setData(Uri.parse(url));
                getContext().startActivity(j);
            }
        });

        ImageView imageView = (ImageView)listItemView.findViewById(R.id.cover_image);

        String imageUrl = currentBookList.getImageUrl();

        Glide.with(getContext()).load(imageUrl).into(imageView);

        Button description_button = (Button)listItemView.findViewById(R.id.description_button);
        final String description = currentBookList.getDescription();
        description_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), DescriptionActivity.class);
                i.putExtra("description",description);
                i.putExtra("title",currentBookList.getTitle());
                getContext().startActivity(i);
            }
        });

        return listItemView;

    }


}


