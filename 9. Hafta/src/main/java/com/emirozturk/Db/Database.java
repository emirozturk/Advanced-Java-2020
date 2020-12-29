package com.emirozturk.Db;

import com.emirozturk.model.Artist;
import com.emirozturk.model.Lyric;
import com.emirozturk.model.Song;

import java.util.ArrayList;
import java.util.List;

public class Database {
    public static List<Artist> artists = new ArrayList<>();
    public static List<Song> songs = new ArrayList<>();
    public static List<Lyric> lyrics = new ArrayList<>();
    public static void Fill(){
        artists.add(new Artist(1,"Artist1"));
        artists.add(new Artist(2,"Artist2"));
        artists.add(new Artist(3,"Artist3"));
        songs.add(new Song(1,"Song1",2017));
        songs.add(new Song(2,"Song2",2018));
        songs.add(new Song(3,"Song3",2019));
        songs.add(new Song(4,"Song4",2020));
        lyrics.add(new Lyric(1,"Türkçe",songs.get(0)));
        lyrics.add(new Lyric(2,"İngilizce",songs.get(0)));
        lyrics.add(new Lyric(3,"Türkçe",songs.get(1)));
        lyrics.add(new Lyric(4,"İngilizce",songs.get(1)));

        songs.get(0).addLyric(lyrics.get(0));
        songs.get(0).addLyric(lyrics.get(1));
        songs.get(1).addLyric(lyrics.get(2));
        songs.get(1).addLyric(lyrics.get(3));


        artists.get(0).addSong(songs.get(0)); //İlk artist ilk şarkıya sahip
        artists.get(1).addSong(songs.get(0)); //İkinci artist ilk şarkıya sahip
        songs.get(0).addArtist(artists.get(0)); //İlk şarkı ilk artiste bağlanıyor
        songs.get(0).addArtist(artists.get(1)); //ilk şarkı ikinci artiste bağlanıyor

        artists.get(0).addSong(songs.get(1)); //ilk artist ikinci şarkıya sahip
        songs.get(1).addArtist(artists.get(0));

        artists.get(0).addSong(songs.get(2)); //ilk artist üçüncü şarkıya sahip
        songs.get(2).addArtist(artists.get(0));

        artists.get(2).addSong(songs.get(3)); //üçüncü artist dördüncü şarkıya sahip
        songs.get(3).addArtist(artists.get(2));

    }
}
