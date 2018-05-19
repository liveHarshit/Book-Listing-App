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
import android.widget.EditText;
import android.widget.ListView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private static final String GOOGLEAPI_REQUEST_URL = "https://www.googleapis.com/books/v1/volumes?q=";
    private BookListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button searchButton = (Button) findViewById(R.id.search_button);
        final EditText searchKeyword = (EditText)findViewById(R.id.keyword_text);
        ListView listView = (ListView)findViewById(R.id.list);
        adapter = new BookListAdapter(this,new ArrayList<BookList>());
        listView.setAdapter(adapter);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String keyword = String.valueOf(searchKeyword.getText());
                keyword = keyword.replaceAll(" ","+");
                String JSON_RESPONSE_URL = GOOGLEAPI_REQUEST_URL+keyword;
                Log.e("Final url",JSON_RESPONSE_URL);
                BookListAsyncTask asyncTask = new BookListAsyncTask();
                asyncTask.execute(JSON_RESPONSE_URL);

            }
        });

    }

    private class BookListAsyncTask extends AsyncTask <String,Void,ArrayList<BookList>> {

        @Override
        protected ArrayList<BookList> doInBackground(String... strings) {
            ArrayList<BookList> bookLists = QueryUtils.fetchBookListData(strings[0]);
            return bookLists;
        }

        @Override
        protected void onPostExecute(ArrayList<BookList> bookLists) {
            adapter.clear();
            if(bookLists!=null&&!bookLists.isEmpty()) {
                adapter.addAll(bookLists);
            }
        }
    }

}
