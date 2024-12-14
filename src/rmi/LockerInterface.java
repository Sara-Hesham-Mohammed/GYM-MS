/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author a_h_s
 */
public interface LockerInterface extends Remote {
    public boolean requestLocker(int lockID) throws RemoteException;
     public void assignLocker(int lockID, int usrID) throws RemoteException;
}
