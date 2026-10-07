package org.example.allnewfeaturesinjava14.textblocks;

public class Main {
    static void main() {
        basicExample();
        jsonExample();
        sqlExample();
        htmlExample();
        lineContinuationExample();
        variableExample();
    }

    private static void basicExample() {
        IO.println("=== BASIC EXAMPLE ===");
        String message = """
                Hello Piseth
                Welcome to Java
                You are learning JEP 368
                """;
        IO.println(message);
    }

    private static void jsonExample() {
        IO.println("=== JSON EXAMPLE ===");
        String json = """
                {
                  "username": "piseth",
                  "role": "DEVELOPER",
                  "active": true
                }
                """;
        IO.println(json);
    }

    private static void sqlExample() {
        IO.println("=== SQL EXAMPLE ===");
        String sql = """
                SELECT
                    id,
                    username,
                    email
                FROM users
                WHERE active = true
                ORDER BY username;
                """;
        IO.println(sql);
    }

    private static void htmlExample() {
        IO.println("=== HTML EXAMPLE ===");
        String html = """
                <html>
                    <body>
                        <h1>Hello Piseth</h1>
                        <p>Welcome to Java</p>
                    </body>
                </html>
                """;
        IO.println(html);
    }

    private static void lineContinuationExample() {
        IO.println("=== LINE CONTINUATION ===");
        String message = """
                Your transaction has been completed successfully, \
                and the confirmation has been sent to your \
                registered email address.
                """;
        IO.println(message);
    }

    private static void variableExample() {
        IO.println("=== VARIABLE EXAMPLE ===");
        String username = "Piseth";
        String role = "API Developer";
        String language = "Java";
        String template = """
                Developer Information
                ---------------------
                Username : %s
                Role     : %s
                Language : %s
                """;
        String result = String.format(
                template,
                username,
                role,
                language
        );
        IO.println(result);
    }
}
