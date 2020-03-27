package com.mohbajal.java14demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileMisMatch {

    private final static String BASE_PATH="/Users/211008/workspaces/java14-demo/src/main/resources/";

    public static void main(String[] args) throws IOException {
        System.out.println(
            Files.mismatch(Paths.get(BASE_PATH+"1.txt"), Paths.get(BASE_PATH+"2.txt"))
        );
        // there's also Arrays.mismatch
    }
}
