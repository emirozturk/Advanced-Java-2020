package com.emirozturk.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "songs")
@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @NonNull
    private String name;

    @Column(name = "releaseyear")
    @NonNull
    private int releaseyear;
}
