package com.temalabor.temalab.model;

import java.io.Serializable;

public class FileUploadResponse implements Serializable {
    private final String imageUrl;


    public FileUploadResponse(String imageUrl){
        this.imageUrl = imageUrl;
    }
    public String getImageUrl() {
        return imageUrl;
    }
}
