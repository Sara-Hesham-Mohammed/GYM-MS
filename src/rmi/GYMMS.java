package rmi;

import java.awt.List;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author Sara
 */
public class GYMMS {

    static Member m1;

    public static void main(String[] args) throws RemoteException, AlreadyBoundException {

        //ArrayList<Locker> lockers = new ArrayList<>();
        //DataMapper db = new DataMapper();
        //String n= "Luna piece of ice";
        //Member m = new Member(12,n);
        //Locker totalLocker=new Locker();
        Locker l1 = new Locker(1, 0, false);
        Locker l2 = new Locker(2, 2, false);
        Locker l3 = new Locker(3, 0, true);

        System.out.println("the 3 lockers are added.");
        //lockers.add(l1);
        //lockers.add(l2);

        //db.insertMember(m);
//       String f="ffff";
//       db.insertDummy(n);
        //String s = "a lot of ice";
        //Trainer f = new Trainer(s);
        //DataMapper db = new DataMapper();
        MemberInterface mm = new Member();
        LockerInterface ll = new Locker();
        //FacadeInterface ff= new MembershipFacade();

        Registry r = LocateRegistry.createRegistry(1099);

        r.bind("member", mm);
        r.bind("locker", ll);
        //r.bind("memshipfacade",ff);

        System.out.println("The server is ready");

        //db.insertMember(m);
        //m1 = new Member(12,n);
        //db.insertMember(m1);
        //db.close();
        //WorkoutPlan p= new WorkoutPlan(3);
        //db.insertDummy(p);
        //db.insertMember(m);
        //db.deleteMember(n);
        //GymClass gymClass1;
//      GymClass gymclass2;
//      //gymClass1 = new GymClass(1, "Yoga Class", "John Doe", LocalDateTime.of(2024, 12, 15, 10, 0), LocalDateTime.of(2024, 12, 15, 11, 0),"1 hour");
//      gymclass2 = new GymClass(3, " double shmer Class", "John Doe", LocalDateTime.of(2024, 12, 15, 10, 0), LocalDateTime.of(2024, 12, 15, 11, 0),"1 hour");
//      //db.insertGymClass(gymClass1);
//      db.insertGymClass(gymclass2);
//      db.insertLocker(l1);
//      //db.insertLocker(l2);
        //db.requestLockerDB(2);
    }
}
