package com.temalabor.temalab.controller;

import com.temalabor.temalab.model.FileUploadResponse;
import com.temalabor.temalab.model.Post;
import com.temalabor.temalab.repository.PostRepository;
import com.temalabor.temalab.services.AmazonS3BucketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class S3BucketController {

    @Autowired
    private AmazonS3BucketService amazonS3BucketService;
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/uploadFile")
    public ResponseEntity<?> uploadFile(@RequestPart(value = "file") MultipartFile file) {
        return ResponseEntity.ok( new FileUploadResponse(this.amazonS3BucketService.uploadFile(file)));
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/deleteFile")
    public String deleteFile(@RequestBody String fileURL) {
        return this.amazonS3BucketService.deleteFileFromBucket(fileURL);
    }
}
