/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

import java.time.LocalDateTime;

/**
 *
 * @author Sara
 */

public class Payment {
    private int paymentId;
    private LocalDateTime transactionDate;
    private PaymentBehaviour paymentMethod;
    private float amount;

    public Payment() {
    }

    public Payment(int paymentId, LocalDateTime transactionDate, PaymentBehaviour paymentMethod, float amount) {
        this.paymentId = paymentId;
        this.transactionDate = transactionDate;
        this.paymentMethod = paymentMethod;
        this.amount = amount;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public PaymentBehaviour getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentBehaviour paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
    
    
}
