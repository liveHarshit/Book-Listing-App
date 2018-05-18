package com.example.liveharshit.booklistingapp;

import android.app.LauncherActivity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class BookListAdapter extends ArrayAdapter<BookList> {

    public BookListAdapter(Context context,List<BookList> objects) {
        super(context, 0, objects);
    }

    @NonNull
    public View getView(int position,View convertView,ViewGroup parent) {
        View listItemView = convertView;

        if(listItemView==null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }

        BookList currentBookList = getItem(position);

        TextView titleView = (TextView)listItemView.findViewById(R.id.title);
        titleView.setText(currentBookList.getTitle());

        TextView author = (TextView)listItemView.findViewById(R.id.author_name);
        author.setText(currentBookList.getAuthor());

        TextView pdfAvailability = (TextView)listItemView.findViewById(R.id.download_availability);
        pdfAvailability.setText(currentBookList.getDownloadAvailable());



        return listItemView;
    }
}
