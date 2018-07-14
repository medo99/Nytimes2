package com.nytimes.sections.articles;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.nytimes.sections.articles.serveice.JSONDownloader;

public class MainActivity extends AppCompatActivity {

    String jsonURL="https://api.nytimes.com/svc/mostpopular/v2/mostviewed/all-sections/7.json?api-key=f4fa5bfebfe740838d5b92c037f4d4f6";

    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        rv = (RecyclerView) findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new JSONDownloader(MainActivity.this, jsonURL, rv).execute();

            }
        });*/
        new JSONDownloader(MainActivity.this, jsonURL, rv).execute();

    }




}
