/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

/**
 *
 * @author Sara
 */
public class Locker {
    private int lockerId;
    private int userId;
    private boolean isOccupied;

    public Locker() {
    }

    public Locker(int lockerId, int userId, boolean isOccupied) {
        this.lockerId = lockerId;
        this.userId = userId;
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
    
    
    
}
