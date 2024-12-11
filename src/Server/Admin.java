/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

/**
 *
 * @author Sara
 */
public class Admin extends User{
    private static Admin adminInstance;
    private GymClass className;
    private Locker locker;

    public Admin() {
    }

    
    public Admin(GymClass className, Locker locker) {
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

    public void setClassName(GymClass className) {
        this.className = className;
    }

    public Locker getLocker() {
        return locker;
    }

    public void setLocker(Locker locker) {
        this.locker = locker;
    }
    
    
    
    
}
