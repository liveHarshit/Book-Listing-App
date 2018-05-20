package com.example.liveharshit.booklistingapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.renderscript.Sampler;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class QueryUtils {

    private QueryUtils () {

    }

    public static ArrayList<BookList> fetchBookListData (String requestUrl) {
        URL url = createUrl(requestUrl);
        String jsonResponse = null;
        try {
            jsonResponse = makeHTTPRequest(url);

        } catch (IOException e) {
            e.printStackTrace();
        }

        Log.e("JSON Response",jsonResponse);
        ArrayList<BookList> bookLists = extractBookList(jsonResponse);

        return bookLists;

    }

    private static URL createUrl(String stringUrl) {
        URL url = null;
        try {
            url = new URL(stringUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }

    private static String makeHTTPRequest(URL url) throws IOException {
        String jsonResponse = null;
        if(url==null) {
            return jsonResponse;
        }
        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;

        try {

            urlConnection = (HttpURLConnection)url.openConnection();
            urlConnection.setReadTimeout(10000);
            urlConnection.setConnectTimeout(15000);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            if(urlConnection.getResponseCode()==200){
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromInputStream(inputStream);

            } else {
                Log.e("QueryUtills","Invalid Request");
            }
        } catch (IOException e){
            Log.e("","Problem retrieving the JSON results.",e);
        }
        return jsonResponse;
    }

    private static String  readFromInputStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
        BufferedReader reader = new BufferedReader(inputStreamReader);
        String line = reader.readLine();
        while (line!=null) {
            output.append(line);
            line = reader.readLine();
        }
        return output.toString();
    }

    public static ArrayList<BookList> extractBookList (String jsonResponse) {
        ArrayList<BookList> bookLists = new ArrayList<>();

        try {
            JSONObject baseJsonResponse = new JSONObject(jsonResponse);
            JSONArray items = baseJsonResponse.getJSONArray("items");

            for(int i=0;i<items.length();i++) {
                JSONObject currentBook = items.getJSONObject(i);
                JSONObject volumeInfo = currentBook.getJSONObject("volumeInfo");
                String title = volumeInfo.getString("title");
                String author_name;
                if(volumeInfo.optJSONArray("authors")!=null) {
                    JSONArray author = volumeInfo.getJSONArray("authors");
                    author_name = author.getString(0);
                } else {
                    author_name = "Not available!";
                }
                String description;
                if(volumeInfo.has("description")) {
                    description = volumeInfo.getString("description");
                } else {
                    description = "Sorry, Description is not available!";
                }
                String preview_url = volumeInfo.getString("previewLink");
                JSONObject accessInfo = currentBook.getJSONObject("accessInfo");
                JSONObject downloadInfo = accessInfo.getJSONObject("pdf");
                String downloadOrViewUrl;
                String downloadAvailable;

                if(downloadInfo.has("downloadLink")) {
                    downloadAvailable = "YES";
                    downloadOrViewUrl = downloadInfo.getString("downloadLink");
                } else {
                    downloadAvailable = "NO";
                    downloadOrViewUrl = accessInfo.getString("webReaderLink");
                }
                String imageUrl;
                if (volumeInfo.has("imageLinks")) {
                    JSONObject imageLinks = volumeInfo.getJSONObject("imageLinks");
                    imageUrl = imageLinks.getString("smallThumbnail");
                } else {
                    imageUrl = "http://www.richardsalter.com/wp-content/uploads/2011/07/Cover-not-available.jpg";
                }

                BookList bookList = new BookList(imageUrl,title,author_name,preview_url,downloadAvailable,downloadOrViewUrl,description);
                bookLists.add(bookList);

            }

        } catch (JSONException e) {
            Log.e("QueryUtils", "Problem parsing the JSON results", e);
        }

        return bookLists;
    }



}


