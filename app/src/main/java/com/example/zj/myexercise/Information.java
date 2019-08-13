package com.example.zj.myexercise;

public class Information {
    private String title;
    private String theme;
    private String url;

    public Information(String title,String theme,String url){
        this.title=title;
        this.theme=theme;
        this.url=url;
    }

    public String getTitle() {
        return title;
    }

    public String getTheme() {
        return theme;
    }

    public String getUrl() {
        return url;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
