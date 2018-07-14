package com.nytimes.sections.articles.serveice;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.nytimes.sections.articles.model.Article;
import com.nytimes.sections.articles.view.MyAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JSONParser extends AsyncTask<Void,Void,Boolean>{

    Context c;
    String jsonData;
    RecyclerView rv;

    ProgressDialog pd;
    ArrayList<Article> articles =new ArrayList<>();

    public JSONParser(Context c, String jsonData, RecyclerView rv) {
        this.c = c;
        this.jsonData = jsonData;
        this.rv = rv;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        pd=new ProgressDialog(c);
        pd.setTitle("Parse");
        pd.setMessage("Parsing...Please wait");
        pd.show();
    }

    @Override
    protected Boolean doInBackground(Void... voids) {
        return parse();
    }

    @Override
    protected void onPostExecute(Boolean isParsed) {
        super.onPostExecute(isParsed);

        pd.dismiss();

        if(isParsed)
        {
            //BIND
            rv.setAdapter(new MyAdapter(c, articles));

        }else
        {
            Toast.makeText(c, "Unable To Parse,Check Your Log output", Toast.LENGTH_SHORT).show();
        }


    }

    private Boolean parse()
    {
        try
        {
            JSONObject response = new JSONObject(jsonData);
          //  JSONArray posts =

            JSONArray ja=response.optJSONArray("results");
            JSONObject jo;

            articles.clear();
            Article article;

            for (int i=0;i<ja.length();i++)
            {
                jo=ja.getJSONObject(i);

                String title=jo.getString("title");
                String byline=jo.getString("byline");
                String published_date=jo.getString("published_date");
                String desc=jo.getString("abstract");

                article =new Article();

                article.settitle(title);
                article.setbyline(byline);
                article.setpublished_date(published_date);
                article.setDesc(desc);
                articles.add(article);
            }

            return true;

        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }



}



















