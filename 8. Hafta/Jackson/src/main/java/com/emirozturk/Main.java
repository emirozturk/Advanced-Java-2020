package com.emirozturk;

import com.emirozturk.model.Model;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            Model model = mapper.readValue(new File("C:\\Users\\emiro\\desktop\\OrnekJson.txt"),Model.class);
            System.out.println(model.toString());
            mapper.writeValue(new File("C:\\Users\\emiro\\desktop\\cikti.txt"), model.getBatters());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
