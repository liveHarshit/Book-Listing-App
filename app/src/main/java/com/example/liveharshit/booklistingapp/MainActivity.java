package com.example.liveharshit.booklistingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<BookList> bookLists = QueryUtils.extractBookList();
        ListView listView = (ListView)findViewById(R.id.list);
        BookListAdapter adapter = new BookListAdapter(this,bookLists);
        listView.setAdapter(adapter);
    }
}
