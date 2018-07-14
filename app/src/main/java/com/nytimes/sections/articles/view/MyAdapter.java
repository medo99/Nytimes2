package com.nytimes.sections.articles.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nytimes.sections.articles.DetailActivity;
import com.nytimes.sections.articles.R;
import com.nytimes.sections.articles.model.Article;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    Context c;
    ArrayList<Article> articles;

    public MyAdapter(Context c, ArrayList<Article> articles) {
        this.c = c;
        this.articles = articles;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(c).inflate(R.layout.model,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Article article = articles.get(position);

        final String title= article.gettitle();
        final String byline= article.getbyline();
        final String published_date= article.getpublished_date();
        final String desc= article.getDesc();

        //BIND
        holder.title.setText(title);
        holder.byline.setText(byline);
        holder.published_date.setText(published_date);

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(int pos) {
                openDetailActivity(title,byline,published_date,desc);
            }
        });

    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    ////open activity
    private void openDetailActivity(String...details)
    {
        Intent i=new Intent(c,DetailActivity.class);
        i.putExtra("TITLE_KEY",details[0]);
        i.putExtra("BYLINE_KEY",details[1]);
        i.putExtra("PUBLISHED_KEY",details[2]);
        i.putExtra("DESC_KEY",details[3]);

        c.startActivity(i);

    }

}
