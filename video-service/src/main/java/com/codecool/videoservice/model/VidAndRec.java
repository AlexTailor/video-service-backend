package com.codecool.videoservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
public class VidAndRec {

    private Optional<Video> video;
    private Recommendation[] recommendations;

}
