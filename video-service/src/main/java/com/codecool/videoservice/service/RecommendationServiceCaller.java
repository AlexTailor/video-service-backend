package com.codecool.videoservice.service;

import com.codecool.videoservice.model.Recommendation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


@Service
@Slf4j
public class RecommendationServiceCaller {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${recommendation.url}")
    private String baseUrl;

    public Recommendation[] getVideoRecommendations(long videoId){
        ResponseEntity<Recommendation[]> recommendationResponseEntity =
                restTemplate.getForEntity("http://recommendation/recommendations/" + videoId, Recommendation[].class);
        return recommendationResponseEntity.getBody();
    }



}
