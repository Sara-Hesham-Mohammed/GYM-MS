/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gym.client;

import Controllers.MainWindowController;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Sara
 */
public class GYMClient {

   public static void main(String[] args) throws RemoteException {

        // We create an object from the GUI window
        MainWindow gui = new MainWindow();
        gui.setLocationRelativeTo(null); // This makes the window appears centered
        gui.setVisible(true); // This shows the gui
        
        // We connect to the RMI Registry
        Registry r = LocateRegistry.getRegistry(1099);
        
        // we create a new object from the controller and we pass it the
        // gui object along with the registry object
        MainWindowController gui_controller = new MainWindowController(gui, r);
        
    }
}
