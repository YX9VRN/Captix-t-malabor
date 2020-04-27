package com.temalabor.temalab.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;


import java.time.LocalDateTime;
public class Comment {

    @Id
    private String _id = new ObjectId().toString();
    private String user_id;
    private String content;

    public String get_id() {
        return _id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String userId) {
        this.user_id = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
