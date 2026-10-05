package org.example.allnewfeaturesinjava9.processapi;

import java.io.IOException;

public class Main {
    static void main() throws IOException {
        ProcessBuilder builder = new ProcessBuilder("java", "-version");
        Process process = builder.start();
        ProcessHandle handle = process.toHandle();
        IO.println("Worker started");
        IO.println("PID: " + handle.pid());
        ProcessHandle.Info info = handle.info();
        IO.println("Command: " + info.command().orElse("Unknown"));
        IO.println("User: " + info.user().orElse("Unknown"));
        IO.println("Alive: " + handle.isAlive());
        process.onExit().thenAccept(p -> System.out.println("Worker stopped. Exit code: " + p.exitValue()));
    }
}
