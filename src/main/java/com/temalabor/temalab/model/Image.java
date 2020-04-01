package com.temalabor.temalab.model;

import org.springframework.data.annotation.Id;

public class Image {
    @Id
    private String _id;
    private String title;
    private String url;

    public Image(){}

    public Image( String title, String url) {
        this.title = title;
        this.url = url;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
