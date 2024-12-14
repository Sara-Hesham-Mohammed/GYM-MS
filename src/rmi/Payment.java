/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rmi;

import java.time.LocalDateTime;
import java.util.Calendar;

/**
 *
 * @author Sara
 */
public class Payment {

    private int paymentID;
    private String transactionDate;
    private String paymentMethod; // e.g., "Card" or "Cash"
    private float amount;

    private PaymentBehaviour paymentBehaviour;

    // Constructor
    public Payment(int paymentID, String transactionDate, float amount) {
        this.paymentID = paymentID;
        this.transactionDate = transactionDate;
        this.amount = amount;
    }

    public Payment() {
    }

    Payment(int bookingID, Calendar bookingDate, int i) {
        
        }

    // Setter to dynamically change the payment behaviour
    public void setPaymentMethod(PaymentBehaviour paymentBehaviour) {
        this.paymentBehaviour = paymentBehaviour;
    }

    // Method to execute the payment
    public void makePayment() {
        if (paymentBehaviour != null) {
            paymentBehaviour.makePayment(amount);
        } else {
            System.out.println("Payment method not set.");
        }
    }

    // Getters and setters 
    public int getPaymentID() {
        return paymentID;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public float getAmount() {
        return amount;
    }
}
