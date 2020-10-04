package com.codecool.videoservice.controller;

import com.codecool.videoservice.model.Recommendation;
import com.codecool.videoservice.model.VidAndRec;
import com.codecool.videoservice.model.Video;
import com.codecool.videoservice.repository.VideoRepository;
import com.codecool.videoservice.service.RecommendationServiceCaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VideoController {
    @Autowired
    VideoRepository repository;

    @Autowired
    RecommendationServiceCaller caller;

    @GetMapping("/videos")
    public List<Video> getAllVideo(){
        return repository.findAll();
    }

    @GetMapping("/videos/{id}")
    public VidAndRec getVideoAndRec(@PathVariable("id") long videoId){
        VidAndRec vidAndRec = new VidAndRec(repository.findById(videoId), caller.getVideoRecommendations(videoId));
        return vidAndRec;
    }

    @PostMapping("/save")
    public void saveVideo(@RequestBody Video video) {
        repository.saveAndFlush(video);
    }
}
