package com.nytimes.sections.articles.model;


public class Article {

    String title,byline,published_date,desc;

    public String gettitle() {
        return title;
    }

    public void settitle(String title) {
        this.title = title;
    }

    public String getbyline() {
        return byline;
    }

    public void setbyline(String byline) {
        this.byline = byline;
    }

    public String getpublished_date() {
        return published_date;
    }

    public void setpublished_date(String published_date) {
        this.published_date = published_date;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
