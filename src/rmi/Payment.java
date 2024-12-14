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
    private int paymentId;
    private Calendar transactionDate;
    private PaymentBehaviour paymentMethod;
    private float amount;

    public Payment() {
    }

    public Payment(int paymentId, Calendar transactionDate, PaymentBehaviour paymentMethod, float amount) {
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

    public Calendar getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Calendar transactionDate) {
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
