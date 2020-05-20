package com.temalabor.temalab.model;

import org.springframework.data.annotation.Id;

public class Comment {

    @Id
    private String _id ;
    private String username;
    private String content;
    private String postId;

    public String get_id() {
        return _id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public void set_id(String _id) {
        this._id = _id;
    }
}
