package Server;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Sara
 */
public class SuspendedMembership implements MembershipStatus {

    public static final long GRACE_PERIOD = 30;

    Calendar currentDate = Calendar.getInstance(); // Changed to Calendar

    @Override
    public void changeStatus(Member m) {
        MembershipPlan p = m.getMembershipPlan();
        
        // Get the end date from the membership plan and add the grace period
        Calendar finalEndDate = p.getEndDate();
        finalEndDate.add(Calendar.DAY_OF_MONTH, (int) GRACE_PERIOD); // Add grace period days

        // Check if current date is equal to or after final end date + grace period
        if ((currentDate.equals(finalEndDate) || currentDate.after(finalEndDate)) && !p.isPaid()) {
            p.setMembershipStatus(this);
            p.setStatus("Suspended");
            System.out.println("Member has now been suspended.");
        } else {
            System.out.println("Member cannot be suspended. Conditions do not apply.");
        }
    }

}
