package com.emirozturk.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@Getter
@Setter
public class Batter {
    private IdType[] batter;

    @Override
    public String toString() {
        return "Batter{" +
                "batter=" + Arrays.toString(batter) +
                '}';
    }
}
