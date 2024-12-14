package Server;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Sara
 */
public class SuspendedMembership implements MembershipStatus {


    @Override
    public void changeStatus(Member m) {
        MembershipPlan p = m.getMembershipPlan();
        
        //current date is equal to or after final end date + grace period
        if (!(p.inGracePeriod()) && !p.isPaid()) {
            p.setMembershipStatus(this);
            p.setStatus("Suspended");
            System.out.println("Member has now been suspended.");
        } else if (p.inGracePeriod()&& !p.isPaid()) 
        {
            p.setMembershipStatus(new FrozenMembership());
            p.changeStatus(m);
            System.out.println("Member cannot be suspended. Conditions do not apply.");
        }
    }

}
