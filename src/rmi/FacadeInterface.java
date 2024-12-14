
package rmi;
import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author a_h_s
 */
public interface FacadeInterface extends Remote {
    
   public MemplanDTO getmembershipPlan()throws RemoteException;
   public void setmembershipPlan(int ID ,String n,float p , String s)throws RemoteException;
}
