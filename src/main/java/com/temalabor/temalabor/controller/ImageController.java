package com.temalabor.temalabor.controller;

import com.temalabor.temalabor.model.Image;
import com.temalabor.temalabor.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ImageController {
    @Autowired
    private ImageRepository repository;

    @GetMapping(value="/images")
    public List<Image> getImages(){
        return repository.findAll();
    }
    @PostMapping(value = "/images")
    public Image newImage(@RequestBody Image image){
        return repository.save(image);
    }
}
