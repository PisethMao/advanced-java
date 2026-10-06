package org.example.allnewfeaturesinjava11.httpclientapi;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/posts/1")).GET().build();
        CompletableFuture<HttpResponse<String>> future = client
                .sendAsync(request, HttpResponse.BodyHandlers.ofString());
        IO.println("Request has been sent...");
        IO.println("Main thread can continue...");
        future.thenApply(HttpResponse::body).thenAccept(body -> {
            IO.println("Response:");
            IO.println(body);
        }).exceptionally(error -> {
            IO.println("Error: " + error.getMessage());
            return null;
        }).join();
    }
}