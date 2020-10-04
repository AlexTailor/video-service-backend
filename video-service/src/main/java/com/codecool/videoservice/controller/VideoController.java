package com.codecool.videoservice.controller;

import com.codecool.videoservice.model.Video;
import com.codecool.videoservice.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VideoController {
    @Autowired
    VideoRepository repository;

    @GetMapping("/videos")
    public List<Video> getAllVideo(){
        return repository.findAll();
    }

}
