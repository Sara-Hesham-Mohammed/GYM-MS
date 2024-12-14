/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rmi;

/**
 *
 * @author Sara
 */

public class PayByCard implements PaymentBehaviour {
    @Override
    public void makePayment(float amount) {
        System.out.println("Processing card payment of: $" + amount);
        // Additional logic for card payment (e.g., contacting bank API)
    }
}
