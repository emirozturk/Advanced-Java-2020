package com.emirozturk.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Song {
    @NonNull
    private int id;
    @NonNull
    private String name;
    @NonNull
    private int releaseyear;
    private List<Artist> artists;
    private List<Lyric> lyrics;

    public void addArtist(Artist artist) {
        if(artists == null)
            artists = new ArrayList<>();
        artists.add(artist);
    }

    public void addLyric(Lyric lyric) {
        if(lyrics == null)
            lyrics = new ArrayList<>();
        lyrics.add(lyric);
    }
}
