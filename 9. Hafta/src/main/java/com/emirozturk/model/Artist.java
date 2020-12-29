package com.emirozturk.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Artist {
    @NonNull
    private int id;
    @NonNull
    private String name;
    private List<Song> songs;

    public void addSong(Song song) {
        if(songs == null)
            songs = new ArrayList<>();
        songs.add(song);
    }
}
