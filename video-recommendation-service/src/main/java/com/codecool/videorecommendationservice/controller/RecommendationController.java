package com.codecool.videorecommendationservice.controller;

import com.codecool.videorecommendationservice.modell.Recommendation;
import com.codecool.videorecommendationservice.repository.RecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecommendationController {

    @Autowired
    RecommendationRepository repository;

    @GetMapping("/recommendations/{videoId}")
    public List<Recommendation> getRecommendationsByVideoId(@PathVariable("videoId") long videoId) {
        return repository.getAllByVideoId(videoId);
    }

    @PostMapping("/save")
    public void saveRecommendation(@RequestBody Recommendation recommendation) {
        repository.saveAndFlush(recommendation);
    }
}
