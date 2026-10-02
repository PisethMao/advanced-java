package org.example.allnewfeaturesinjava8.repeatingannotations;

public class PaymentService {
    @Role("ADMIN")
    @Role("MANAGER")
    public void approvePayment(){
        IO.println("Payment Approval!!!!!");
    }
}
