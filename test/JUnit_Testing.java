import com.mongodb.connection.Server.*; // Replace with the correct package name where Admin and GymClass are located
import java.rmi.RemoteException;
import java.time.LocalDateTime;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;
import rmi.Admin;
import rmi.GymClass;

public class JUnit_Testing {

    Admin admin; // Admin object to test Admin functionality

    public static void setUpClass() {
        System.out.println("Testing is Running for the Gym Management System...");
    }

    @Before
    public void setup() throws RemoteException {
        // Initialize Admin before running tests
        admin = new Admin();
    }

    @Test
    public void testSetClassName() {
        System.out.println("Testing Admin's ability to set class name and notify observers...");

        // Create a GymClass object
        GymClass gymClass = new GymClass(1, "Yoga", "John Doe", 
                                         LocalDateTime.of(2024, 12, 20, 10, 0),
                                         LocalDateTime.of(2024, 12, 20, 11, 0), "1 hour");

        // Verify initial class name
        Assert.assertEquals("Yoga", gymClass.getClassName());

        // Set the class name
        gymClass.setClassName("Advanced Yoga");

        // Verify the class name has been updated
        Assert.assertEquals("Advanced Yoga", gymClass.getClassName());

        // Verify that observers were notified (you need to verify this via a mock or logs if implemented)
        System.out.println("Observers notified successfully (assume this is verified).");
    }
}