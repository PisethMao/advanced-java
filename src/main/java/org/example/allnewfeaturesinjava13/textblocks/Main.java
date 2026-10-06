package org.example.allnewfeaturesinjava13.textblocks;

public class Main {
    static void main() {
        String json = """
                {
                  "user": {
                    "name": "Piseth",
                    "language": "Java"
                  }
                }
                """;
        IO.println(json.getClass());
        IO.println(json);
    }
}
