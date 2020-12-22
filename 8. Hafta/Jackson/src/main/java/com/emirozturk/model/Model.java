package com.emirozturk.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Model {
    private String id;
    private String type;
    private String name;
    private float ppu;
    private Batter batters;
    private IdType[] topping;

    @Override
    public String toString() {
        return "Model{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", ppu=" + ppu +
                ", batters=" + batters +
                ", topping=" + Arrays.toString(topping) +
                '}';
    }
}
