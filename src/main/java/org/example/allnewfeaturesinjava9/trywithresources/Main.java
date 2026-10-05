package org.example.allnewfeaturesinjava9.trywithresources;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    static void main() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("data.txt"));
            try (bufferedReader) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    IO.println(line);
                }
            } catch (IOException e) {
                IO.println("Error: " + e.getMessage());
            }
        } catch (Exception e) {
            IO.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}
