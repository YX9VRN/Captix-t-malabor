package com.temalabor.temalab.model;

import com.mongodb.lang.Nullable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Document("users")
public class User {

    @Id
    private String _id;
    @NotNull
    private String username;
    private String email;
    private String password;
    private int rating;
    private boolean isAdmin;
    private String profilePictureUrl;
    public  User(){}

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
