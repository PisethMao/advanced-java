package org.example.allnewfeaturesinjava8.base64api;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Main {
    static void main() {
        // Encode
        String message = "Hello, World!!!";
        String encoded = Base64.getEncoder().encodeToString(
                message.getBytes(StandardCharsets.UTF_8)
        );
        IO.println(encoded);
        // Decode
        String encode = "SGVsbG8sIFdvcmxkISEh";
        byte[] decodeBytes = Base64.getDecoder().decode(encode);
        String decoded = new String(decodeBytes, StandardCharsets.UTF_8);
        IO.println(decoded);
    }
}
