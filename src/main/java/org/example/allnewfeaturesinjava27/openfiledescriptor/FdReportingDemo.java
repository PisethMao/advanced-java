package org.example.allnewfeaturesinjava27.openfiledescriptor;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FdReportingDemo {
    void main() throws Exception {
        Path directory = Files.createTempDirectory("fd-demo-");
        List<FileInputStream> openedFiles = new ArrayList<>();
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        IO.println("PID: " + ProcessHandle.current().pid());
        try {
            IO.println("STAGE 1: Before opening files");
            IO.println("Inspect VM.info, then press Enter.");
            console.readLine();
            for (int i = 0; i < 25; i++) {
                Path file = directory.resolve("file-" + i + ".txt");
                Files.writeString(file, "Sample data " + i);
                openedFiles.add(new FileInputStream(file.toFile()));
            }
            IO.println("STAGE 2: 25 files are now open");
            IO.println("Inspect VM.info, then press Enter.");
            console.readLine();
            for (FileInputStream stream : openedFiles) {
                stream.close();
            }
            openedFiles.clear();
            IO.println("STAGE 3: All 25 files are closed");
            IO.println("Inspect VM.info, then press Enter.");
            console.readLine();
        } finally {
            for (FileInputStream stream : openedFiles) {
                stream.close();
            }
            try (var files = Files.list(directory)) {
                for (Path file : files.toList()) {
                    Files.deleteIfExists(file);
                }
            }
            Files.deleteIfExists(directory);
        }
    }
}

