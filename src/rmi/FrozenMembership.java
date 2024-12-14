package rmi;

import java.util.Calendar;

/**
 *
 * @author Sara
 */
public class FrozenMembership implements MembershipStatus {

    @Override
    public void changeStatus(Member m) {

        // if not paid and theres a grace period
        MembershipPlan p = m.getMembershipPlan();
        int attendance = m.getAttendanceRecord();

        int avgAttendance = p.getAttendanceAvg();

        // current status is active and half the duration has passed but attendance is bad
        if (p.getStatus().equalsIgnoreCase("Active") && p.isHalfPast() && attendance < avgAttendance) {

            p.setMembershipStatus(this);
            p.setStatus("Frozen");
            System.out.println("Membership is now frozen.");
        } else if (p.inGracePeriod()) {
            p.setMembershipStatus(this);
            p.changeStatus(m);
            p.setStatus("Frozen");
            System.out.println("Membership is now frozen due to grace period.");
        } else {

            System.out.println("Membership cannot be frozen. Conditions do not apply.");
            p.setMembershipStatus(new SuspendedMembership());
            p.changeStatus(m);
        }

    }

}
