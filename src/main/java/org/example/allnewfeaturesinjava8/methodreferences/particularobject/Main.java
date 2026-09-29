package org.example.allnewfeaturesinjava8.methodreferences.particularobject;

import java.util.function.Consumer;

public class Main {
    static void main() {
        MessageService  messageService = new MessageService();
        Consumer<String> sender = messageService::sendMessage;
        sender.accept("Hello World");
    }
}
