package Server;

import java.util.Calendar;

/**
 *
 * @author Sara
 */
public class ActiveMembership implements MembershipStatus {

    Calendar currentDate = Calendar.getInstance(); // Changed to Calendar
    boolean isActivePeriod = false;

    @Override
    public void changeStatus(Member m) {

        MembershipPlan p = m.getMembershipPlan();

        // Convert start and end date to Calendar
        Calendar startDate = p.getStartDate(); // Convert MembershipPlan startDate to Calendar
        Calendar endDate = p.getEndDate(); // Convert MembershipPlan endDate to Calendar

        if ((currentDate.after(startDate) || currentDate.equals(startDate)) && currentDate.before(endDate)) {
            isActivePeriod = true;
        }

        if (isActivePeriod && p.isPaid()) {
            p.setMembershipStatus(this);
            p.setStatus("Active");
            System.out.println("Membership is now active.");
        } else{
            p.setMembershipStatus(new FrozenMembership());
            System.out.println("Membership isn't activated. Conditions do not apply.");
        }

    }

}
