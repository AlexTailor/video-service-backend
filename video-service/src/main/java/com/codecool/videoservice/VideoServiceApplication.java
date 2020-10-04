package com.codecool.videoservice;

import com.codecool.videoservice.model.Video;
import com.codecool.videoservice.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class VideoServiceApplication {

    @Autowired
    VideoRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(VideoServiceApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public CommandLineRunner init(){
        return args -> {
            Video silicon_valley = Video.builder()
                    .name("Silicon Valley")
                    .url("https://www.youtube.com/watch?v=Vm4tx1O9GAc")
                    .build();
            repository.save(silicon_valley);

            Video how_i_met_your_mother = Video.builder()
                    .name("How I Met Your Mother")
                    .url("https://www.youtube.com/watch?v=aJtVL2_fA5w")
                    .build();
            repository.save(how_i_met_your_mother);

            Video the_umbrella_academy = Video.builder()
                    .name("The Umbrella Academy")
                    .url("https://www.youtube.com/watch?v=0DAmWHxeoKw")
                    .build();
            repository.saveAndFlush(the_umbrella_academy);



        };
    }
}
