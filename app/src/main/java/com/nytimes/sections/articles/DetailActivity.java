package com.nytimes.sections.articles;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    TextView title,byline, published_date,desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        title = (TextView) findViewById(R.id.title);
        byline= (TextView) findViewById(R.id.byline);
        published_date = (TextView) findViewById(R.id.published_date);
        desc = (TextView) findViewById(R.id.desc);

        //GET INTENT
        Intent i=this.getIntent();

        //RECEIVE DATA
        String title1=i.getExtras().getString("TITLE_KEY");
        getSupportActionBar().setTitle(title1);

        String byline1=i.getExtras().getString("BYLINE_KEY");
        String published_date1=i.getExtras().getString("PUBLISHED_KEY");
        String desc1=i.getExtras().getString("DESC_KEY");

        //BIND DATA
        title.setText(title1);
        byline.setText(byline1);
        published_date.setText(published_date1);
        desc.setText(desc1);

        // Show the Up button in the action bar.
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            // This ID represents the Home or Up button. In the case of this
            // activity, the Up button is shown. For
            // more details, see the Navigation pattern on Android Design:
            //
            // http://developer.android.com/design/patterns/navigation.html#up-vs-back
            //
            navigateUpTo(new Intent(this, MainActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
