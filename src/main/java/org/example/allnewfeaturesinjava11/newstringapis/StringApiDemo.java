package org.example.allnewfeaturesinjava11.newstringapis;

public class StringApiDemo {
    static void main() {
        IO.println("Java 11 String API Demo");
//        String text1 = "";
//        String text2 = "     ";
//        String text3 = "\t";
//        String text4 = "\n";
//        String text5 = "Hello";
//        String text6 = "  Hello  ";
//        IO.println("text1 is blank: " + true);
//        IO.println("text2 is blank: " + text2.isBlank());
//        IO.println("text3 is blank: " + text3.isBlank());
//        IO.println("text4 is blank: " + text4.isBlank());
//        IO.println("text5 is blank: " + text5.isBlank());
//        IO.println("text6 is blank: " + text6.isBlank());
//        String value = "     ";
//        IO.println("value is blank: " + true);
//        IO.println("value is blank: " + value.isEmpty());
//        String username = "     ";
//        if (username == null || username.isBlank()) {
//            throw new IllegalArgumentException("Username is required");
//        }
        String name = "     Piseth Mao     ";
        String cleanedName = name.strip();
        IO.println("Before: [" + name + "]");
        IO.println("After : [" + cleanedName + "]");

        String text = "   Java   ";
        IO.println(text.trim());
        IO.println(text.strip());

        String text1 = "     Java Programming     ";
        String result1 = text1.stripLeading();
        IO.println("Before: [" + text1 + "]");
        IO.println("After : [" + result1 + "]");

        String text2 = "     Java Programming     ";
        String result2 = text2.stripTrailing();
        IO.println("Before: [" + text2 + "]");
        IO.println("After : [" + result2 + "]");

        String text3 = "Java ";
        String result3 = text3.repeat(5);
        IO.println(result3);

//        String technologies = "Java\n" + "Spring Boot\n" + "Docker\n" + "PostgreSQL";
        String technologies = """
                Java
                Spring Boot
                Docker
                PostgreSQL""";
        technologies.lines().forEach(IO::println);

        String data = """
                Java
                Spring Boot\s
                Docker""";
        data.lines().filter(line -> !line.isBlank()).forEach(IO::println);
    }
}
