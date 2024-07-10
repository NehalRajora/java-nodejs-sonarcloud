// src/main/java/com/example/App.java
package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello from Java!");

        // Example of calling a Node.js script from Java
        try {
            ProcessBuilder pb = new ProcessBuilder("node", "src/main/resources/hello.js");
            Process process = pb.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String output = reader.lines().collect(Collectors.joining("\n"));

            System.out.println("Output from Node.js script:");
            System.out.println(output);

            int exitCode = process.waitFor();
            System.out.println("Node.js script exited with code: " + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
