/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rmi;
import java.util.ArrayList;

/**
 *
 * @author Sara
 */
public class Admin extends User {

    private static Admin adminInstance;
    private ArrayList<GymClass> gymClasses;//all the classes in the gym
    private Locker locker;

    public Admin() {
    }

    public Admin(ArrayList<GymClass> gymClasses, Locker locker, int id, String name, int age, String email, String username, String password, String gender) {
        super(id, name, age, email, username, password, gender);
        this.gymClasses = gymClasses;
        this.locker = locker;
    }

    public static Admin getAdminInstance() {
        return adminInstance;
    }

    public static void setAdminInstance(Admin adminInstance) {
        Admin.adminInstance = adminInstance;
    }

    public ArrayList<GymClass> getGymClasses() {
        return gymClasses;
    }

    public void setGymClasses(ArrayList<GymClass> gymClasses) {
        this.gymClasses = gymClasses;
    }

    public Locker getLocker() {
        return locker;
    }

    public void setLocker(Locker locker) {
        this.locker = locker;
    }

    

}
