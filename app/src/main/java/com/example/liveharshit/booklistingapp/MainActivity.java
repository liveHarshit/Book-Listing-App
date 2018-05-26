package com.example.liveharshit.booklistingapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private static final String GOOGLEAPI_REQUEST_URL = "https://www.googleapis.com/books/v1/volumes?q=";
    private BookListAdapter adapter;
    private ProgressBar progressBar;

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
                InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
                progressBar = (ProgressBar) findViewById(R.id.progress_bar);
                TextView textView = (TextView) findViewById(R.id.empty_view);
                textView.setText(null);
                adapter.clear();
                progressBar.setVisibility(View.VISIBLE);
                String keyword = String.valueOf(searchKeyword.getText());
                keyword = keyword.replaceAll(" ", "+");
                if (!keyword.isEmpty()) {
                    String JSON_RESPONSE_URL = GOOGLEAPI_REQUEST_URL + keyword;
                    Log.e("Final url", JSON_RESPONSE_URL);

                    ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
                    NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

                    if (networkInfo != null && networkInfo.isConnected()) {

                        BookListAsyncTask asyncTask = new BookListAsyncTask();
                        asyncTask.execute(JSON_RESPONSE_URL);
                    } else {
                        textView.setText("No internet connection");
                        progressBar.setVisibility(View.INVISIBLE);

                    }

                } else {
                    textView.setText("Please enter keyword");
                    progressBar.setVisibility(View.INVISIBLE);
                }
            }

        });
    }


    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Press back again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
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
                progressBar = (ProgressBar)findViewById(R.id.progress_bar);
                progressBar.setVisibility(View.GONE);
                adapter.addAll(bookLists);
            }
        }
    }

}
