package com.codecool.videoservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Video {
    @Id
    @GeneratedValue
    private long id;

    private String name;

    private String url;
}

// properties: id, name, url (yes, these videos are coming from YouTube or Vimeo)