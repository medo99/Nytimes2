package com.nytimes.sections.articles.model;


public class Article {
/* this module article that get and set for all item come from the webservice and send it to the front end */
    String title,byline,published_date,desc;
/* get title method */
    public String gettitle() {
        return title;
    }
/* set title method*/
    public void settitle(String title) {
        this.title = title;
    }
/* get by method for get author */
    public String getbyline() {
        return byline;
    }
/* set by method for set author*/
    public void setbyline(String byline) {
        this.byline = byline;
    }
/* get published date method for get date*/
    public String getpublished_date() {
        return published_date;
    }
/*set published date method for set date */
    public void setpublished_date(String published_date) {
        this.published_date = published_date;
    }
/*get abstract method for get news description  */
    public void setDesc(String desc) {
        this.desc = desc;
    }
/* set abstract method for set news description */
    public String getDesc() {
        return desc;
    }
}
