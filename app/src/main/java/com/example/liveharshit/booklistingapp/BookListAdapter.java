package com.example.liveharshit.booklistingapp;

import android.app.LauncherActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

public class BookListAdapter extends ArrayAdapter<BookList> {

    Bitmap imageBitmap = null;

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

        URL url = createUrl(imageUrl);

        ImageAsyncTask task = new ImageAsyncTask();
        task.execute(url);

        imageView.setImageBitmap(imageBitmap);


        return listItemView;

    }


    private static URL createUrl(String stringUrl){
        URL url = null;
        try {
            url = new URL(stringUrl);
        } catch (MalformedURLException e) {
            Log.e("","Invalid Url");
        }
        return url;
    }

    private static Bitmap makeHTTPrequest(URL url) throws IOException {
        Bitmap bmp = null;
        if (url == null) {
            return bmp;
        }
        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;

        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(10000);
            urlConnection.setConnectTimeout(15000);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            if (urlConnection.getResponseCode() == 200) {
                inputStream = urlConnection.getInputStream();
                bmp = BitmapFactory.decodeStream(inputStream);
            } else {
                Log.e("", "Invalid Request");
            }

        } catch (IOException e) {
            Log.e("", "Problem reverting image bitmap", e);
        }

        return bmp;
    }

    private class ImageAsyncTask extends AsyncTask<URL,Void,Bitmap> {

        @Override
        protected Bitmap doInBackground(URL... urls) {
            Bitmap imageBitmap = null;
            try {
                imageBitmap = makeHTTPrequest(urls[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return imageBitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            imageBitmap = bitmap;
        }
    }

}


