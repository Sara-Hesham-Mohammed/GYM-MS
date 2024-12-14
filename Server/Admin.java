package Server;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sara
 */
public class Admin extends User {
    private static Admin adminInstance;
    private GymClass className;
    private Locker locker;
    
    
    private Supplier supplier;

    public Admin() {
        super(); 
        this.supplier = new Supplier(); 
    }

    public Admin(GymClass className, Locker locker) {
        this();  // Default constructor
        this.className = className;
        this.locker = locker;
    }

    public static Admin getAdminInstance() {
        return adminInstance;
    }

    public static void setAdminInstance(Admin adminInstance) {
        Admin.adminInstance = adminInstance;
    }

    public GymClass getClassName() {
        return className;
    }

    public Locker getLocker() {
        return locker;
    }

    public void setLocker(Locker locker) {
        this.locker = locker;
    }

    // Function to request equipment from the supplier
    public void requestEquipment(Equipment equipment) {
        System.out.println(getName() + " is requesting the following equipment: " + equipment.getName());
        
        // Make sure the supplier is available
        if (supplier != null) {
            supplier.processRequest(equipment); 
        } else {
            System.out.println("No supplier available to process the request.");
        }
    }
}





