
package rmi;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author a_h_S
 */
public class Locker extends UnicastRemoteObject implements LockerInterface {
    private int lockerId;
    private int userId;
    private boolean isOccupied;
    private DataMapper dm;
    static ArrayList<Locker> lockers = new ArrayList<>();

    public Locker() throws RemoteException {
    }

    public Locker(int lockerId, int userId, boolean isOccupied) throws RemoteException {
        this.lockerId = lockerId;
        this.userId = userId;
        this.isOccupied = isOccupied;
        this.dm=dm;
        lockers.add(this);
    }

    public Locker(int lockerId, boolean isOccupied) throws RemoteException {
        this.lockerId = lockerId;
        this.isOccupied = isOccupied;
        this.dm=dm;
        lockers.add(this);
    }

    public Locker(int lockerId, boolean isOccupied, int port) throws RemoteException {
        super(port);
        this.lockerId = lockerId;
        this.isOccupied = isOccupied;
    }

    public Locker(int lockerId, boolean isOccupied, int port, RMIClientSocketFactory csf, RMIServerSocketFactory ssf) throws RemoteException {
        super(port, csf, ssf);
        this.lockerId = lockerId;
        this.isOccupied = isOccupied;
    }
    
    

    public int getLockerId() {
        return lockerId;
    }

    public void setLockerId(int lockerId) {
        this.lockerId = lockerId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean isIsOccupied() {
        return isOccupied;
    }

    public void setIsOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }
    
//    @Override
//    public  ArrayList<Locker> getAllLockers() throws RemoteException{
//    ArrayList<Locker> lockers = new ArrayList<>();
//    lockers.addAll(dm.getAllLockersDB());
//    return lockers;
//    }
//    
//    @Override
//    public boolean requestLocker(int lockID){
//        boolean bool;
//         for (int i = 0; i < lockers.size(); i++) {
//             System.out.println(lockers.get(i));
//        if (lockers.get(i).getLockerId()== lockID)  // Compare lockID with locker id
//            if (lockers.get(i).isOccupied == true) {
//                System.out.println("Locker " + i + " is occupied");
//                return bool= false; // Locker is occupied
//            } else {
//                System.out.println("Locker " + i + " is available");
//                return bool= true; // Locker is available
//            }
//        }
//        //return bool;
//      }
    
    
    
    @Override
public boolean requestLocker(int lockID) {
    for (int i = 0; i < lockers.size(); i++) {
        System.out.println(lockers.get(i)); // Debugging statement
        if (lockers.get(i).getLockerId()== lockID) { // Compare lockID with locker id
            if (lockers.get(i).isOccupied == true) {
                System.out.println("Locker " + i + " is occupied");
                return false; // Locker is occupied
            } else {
                System.out.println("Locker " + i + " is available");
                return true; // Locker is available
            }
        }
    }
    System.out.println("Locker with ID " + lockID + " not found");
    return false; // If no locker with the given lockID is found
}

//         lockers.addAll(dm.getAllLockersDB());
//        for (int i = 0; i < lockers.size(); i++) {
//        System.out.println(lockers.get(i));
//        Locker l1= dm.getLockerByID(lockID);
//        if (l1.isOccupied){
//            System.out.println("locker"+ l1.lockerId + "is occupied");
//       }
//         return dm.requestLockerDB(lockID);
    
    @Override
    public void assignLocker(int lockID, int usrID){
        dm.assignLockerDB(lockID,usrID);
        System.out.println("locker assigned!");
    }
}
      
//    
    
