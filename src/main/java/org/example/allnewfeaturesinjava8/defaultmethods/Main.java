package org.example.allnewfeaturesinjava8.defaultmethods;

public class Main {
    static void main() {
        TransferService service = new BankTransferService();
        service.transfer("ACC001", "ACC002", 500);
    }
}
