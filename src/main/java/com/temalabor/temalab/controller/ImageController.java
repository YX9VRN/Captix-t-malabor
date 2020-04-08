package com.temalabor.temalab.controller;

import com.temalabor.temalab.model.Image;
import com.temalabor.temalab.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
public class ImageController {
    @Autowired
    private ImageRepository repository;

    @GetMapping(value="/images")
    public List<Image> getImages(){
        return repository.findAll();
    }

}
