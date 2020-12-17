package com.emirozturk.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "artists")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @NonNull
    private String name;

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
