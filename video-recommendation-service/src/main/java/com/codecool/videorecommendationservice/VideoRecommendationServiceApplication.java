package com.codecool.videorecommendationservice;

import com.codecool.videorecommendationservice.modell.Recommendation;
import com.codecool.videorecommendationservice.repository.RecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class VideoRecommendationServiceApplication {

    @Autowired
    RecommendationRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(VideoRecommendationServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner init() {
        return args -> {
            Recommendation first = Recommendation.builder()
                    .rating(3)
                    .comment("Good")
                    .videoId(1)
                    .build();
            repository.save(first);

            Recommendation second = Recommendation.builder()
                    .rating(2)
                    .comment("Bad")
                    .videoId(2)
                    .build();
            repository.save(second);

            Recommendation secondvote = Recommendation.builder()
                    .rating(1)
                    .comment("Very Bad")
                    .videoId(2)
                    .build();
            repository.save(secondvote);

            Recommendation third = Recommendation.builder()
                    .rating(4)
                    .comment("Very Good")
                    .videoId(3)
                    .build();
            repository.saveAndFlush(third);


        };
    }


}
