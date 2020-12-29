package com.emirozturk;

import com.emirozturk.Db.Database;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        Database.Fill();
        SpringApplication.run(Main.class,args);
    }
}
