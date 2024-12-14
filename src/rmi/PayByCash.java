/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rmi;

/**
 *
 * @author Sara
 */
public class PayByCash implements PaymentBehaviour {
    @Override
    public void makePayment(float amount) {
        System.out.println("Processing cash payment of: $" + amount);
        // Additional logic for cash payment
    }
}
