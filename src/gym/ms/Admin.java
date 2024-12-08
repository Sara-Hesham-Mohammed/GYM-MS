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
    private Admin(String name, String email) {
       
    }

    // Public method to get the singleton instance
    public static Admin getAdminInstance(String name, String email) {
        if (adminInstance == null) {
            synchronized (Admin.class) {
                if (adminInstance == null) {
                    adminInstance = new Admin(name, email);
                }
            }
        }
        return adminInstance;
    }

    // Method to send notifications
    public void sendNotification(String message) {
        System.out.println("Notification sent: " + message);
    }

    // Method to add an observer (stub for demonstration)
    public void addObserver(Object observer) {
        System.out.println("Observer added: " + observer.toString());
    }

    public static void main(String[] args) {
        // Create the singleton Admin instance
        Admin admin = Admin.getAdminInstance("Admin Name", "admin@example.com");

        // Use Admin methods
        admin.sendNotification("System update at 10 PM.");
        admin.addObserver("Observer1");

        // Verify singleton behavior
        Admin anotherAdmin = Admin.getAdminInstance("Another Name", "another@example.com");
        System.out.println("Is singleton: " + (admin == anotherAdmin));
        System.out.println("Admin Name: " + admin.getName());
    }
    
}
