package com.codecool.videorecommendationservice.modell;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Recommendation {
    @Id
    @GeneratedValue
    private long id;

    private int rating;

    private String comment;

    @Column(nullable = false)
    private long videoId;
}

//properties: id, rating (integer, 1-5), comment, videoId