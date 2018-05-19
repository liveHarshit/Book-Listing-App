package com.example.liveharshit.booklistingapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private BookListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView)findViewById(R.id.list);
        adapter = new BookListAdapter(this,new ArrayList<BookList>());
        listView.setAdapter(adapter);

//        ArrayList<BookList> bookLists = QueryUtils.extractBookList();

//        BookListAdapter adapter = new BookListAdapter(this,bookLists);


        BookListAsyncTask asyncTask = new BookListAsyncTask();
        asyncTask.execute();


    }

    private class BookListAsyncTask extends AsyncTask<Void,Void,ArrayList<BookList>> {


        @Override
        protected ArrayList<BookList> doInBackground(Void... voids) {
            ArrayList<BookList> bookLists = QueryUtils.extractBookList();
            return bookLists;
        }

        @Override
        protected void onPostExecute(ArrayList<BookList> bookLists) {
            adapter.addAll(bookLists);

        }
    }

}
