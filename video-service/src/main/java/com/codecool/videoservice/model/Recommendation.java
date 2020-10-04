package com.codecool.videoservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Recommendation {

    private int rating;
    private String comment;
    private long videoId;
}
