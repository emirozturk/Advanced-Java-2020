package com.emirozturk.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "lyric")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Lyric {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "content")
    @NonNull private String content;

    @ManyToOne
    @JoinColumn(name = "songid")
    private Song song;
}
