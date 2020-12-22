package com.emirozturk;

import com.emirozturk.entity.Song;


public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.addSong("Wonders at your feet",2005);
        Song song = controller.getSong("Wonders at your feet");
        controller.addLyric(song,"lyriclyriclyriclyriclyric");
    }
}
