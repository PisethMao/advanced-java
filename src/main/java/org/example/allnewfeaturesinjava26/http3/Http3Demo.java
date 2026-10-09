package org.example.allnewfeaturesinjava26.http3;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Http3Demo {
    void main() throws Exception {
        try (HttpClient client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_3)
                .connectTimeout(java.time.Duration.ofSeconds(10)).build()) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://www.example.com"))
                    .timeout(java.time.Duration.ofSeconds(10)).GET().build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            IO.println("Status code: " + response.statusCode());
            IO.println("Protocol: " + response.version());
            IO.println("Response body: " + response.body().length());
        }
    }
}
