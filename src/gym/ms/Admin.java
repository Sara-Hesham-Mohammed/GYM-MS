/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gym.ms;

/**
 *
 * @author Sara
 */
// Singleton Admin class
public class Admin extends User {
    // Static instance variable
    private static Admin adminInstance;

    // Private constructor to prevent instantiation
    private Admin() {
       
    }

    // Public method to get the singleton instance
    public static Admin getAdminInstance(String name, String email) {
        
        return null;
    }

    // Method to send notifications
    public void sendNotification(String message) {
       
    }

    // Method to add an observer (stub for demonstration)
    public void addObserver(Object observer) {
    }
    
}
