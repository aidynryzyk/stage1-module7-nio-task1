package com.epam.mjc.nio;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;


public class FileReader {

    public Profile getDataFromFile(File file) {
        Profile profile = new Profile();
        try (BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(file))) {
            String word;
            while ((word = bufferedReader.readLine()) != null) {
                String key = word.split(" ")[0];
                String value = word.split(" ")[1];
                switch (key) {
                    case "Name:":
                        profile.setName(value);
                        break;
                    case "Age:":
                        profile.setAge(Integer.parseInt(value));
                        break;
                    case "Email:":
                        profile.setEmail(value);
                        break;
                    case "Phone:":
                        profile.setPhone(Long.parseLong(value));
                        break;
                    default:
                        break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
        return profile;
    }
}
