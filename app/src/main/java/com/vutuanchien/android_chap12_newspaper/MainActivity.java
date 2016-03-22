package com.vutuanchien.android_chap12_newspaper;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    AdapterListview adapterListview;
    MyAsyntaskReadNews myAsyntaskReadNews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        myAsyntaskReadNews = new MyAsyntaskReadNews();
        try {
//            get and execute this link to show
            myAsyntaskReadNews.execute(new URL("http://vnexpress.net/rss/tin-moi-nhat.rss"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

    }

    // thread run in background of app
    public class MyAsyntaskReadNews extends AsyncTask<URL, Void, List<News>> {
        AdapterListview adapterListview;

        @Override
        protected List<News> doInBackground(URL... params) {
            for (URL url : params) {
                try {
                    URLConnection connection = url.openConnection();
                    if (url.getPath().contains("HTTPS")) {
                        HttpURLConnection httpURLConnection = (HttpURLConnection) connection;
                        if (httpURLConnection.getResponseCode() == httpURLConnection.HTTP_OK) {
                            return RSSUtils.read24hcom(httpURLConnection.getInputStream());
                        } else {

                        }
                    } else {
                        HttpURLConnection httpURLConnection = (HttpURLConnection) connection;
                        if (httpURLConnection.getResponseCode() == httpURLConnection.HTTP_OK) {
                            return RSSUtils.read24hcom(httpURLConnection.getInputStream());
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(List<News> newses) {
            super.onPostExecute(newses);
            adapterListview = new AdapterListview(MainActivity.this, R.layout.customlistview, newses);
            listView.setAdapter(adapterListview);
        }
    }
}
