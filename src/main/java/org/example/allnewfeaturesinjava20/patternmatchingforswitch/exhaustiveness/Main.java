package org.example.allnewfeaturesinjava20.patternmatchingforswitch.exhaustiveness;

public class Main {
    sealed interface Result permits Success, Failure {
    }

    record Success(String message) implements Result {
    }

    record Failure(String reason) implements Result {
    }

    static String handle(Result result) {
        return switch (result) {
            case Success s -> s.message();
            case Failure f -> f.reason();
        };
    }

    static void main() {
        IO.println(handle(new Success("Success")));
        IO.println(handle(new Failure("Failure")));
    }
}
