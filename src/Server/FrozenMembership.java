package Server;

import java.util.Calendar;

/**
 *
 * @author Sara
 */
public class FrozenMembership implements MembershipStatus {

    Calendar currentDate = Calendar.getInstance(); // Changed to Calendar
    static final int DAYS_AVG = 30;
    static final int WEEKS_PER_MONTH = 4;

    //dummy avg 
    public int getAttendanceAvg(int duration) {

        int durationInWeeks = duration * WEEKS_PER_MONTH;
        final int ATTENDANCE_AVG = durationInWeeks;
        return ATTENDANCE_AVG;
    }

    @Override
    public void changeStatus(Member m) {

        // if not paid and theres a grace period
        
        MembershipPlan p = m.getMembershipPlan();
        int attendance = m.getAttendanceRecord();

        // Convert start and end date to Calendar
        Calendar startDate = p.getStartDate(); // Convert MembershipPlan startDate to Calendar
        Calendar endDate = p.getEndDate(); // Convert MembershipPlan endDate to Calendar

        int duration = p.getDuration();
        int durationInDays = duration * DAYS_AVG;
        int durationPassed = Math.floorDiv(durationInDays, 2);
        
        Calendar halfDurationDate = startDate;
        halfDurationDate.add(Calendar.DAY_OF_MONTH, durationPassed);
        boolean isHalfPast = currentDate.after(halfDurationDate) || currentDate.equals(halfDurationDate);

        // current status is active and half the duration has passed but attendance is bad
        if (p.getStatus().equalsIgnoreCase("Active") && isHalfPast && attendance < getAttendanceAvg(duration)) {

            p.setMembershipStatus(this);
            p.setStatus("Frozen");
            System.out.println("Membership is now frozen.");
        } else {

            System.out.println("Membership cannot be frozen. Conditions do not apply.");
            p.setMembershipStatus(new SuspendedMembership());
        }

    }

}
