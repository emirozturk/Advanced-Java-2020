package com.emirozturk.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IdType {
    private String id;
    private String type;

    @Override
    public String toString() {
        return "IdType{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
