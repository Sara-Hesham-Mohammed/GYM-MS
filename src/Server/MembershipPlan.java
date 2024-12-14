package Server;

import java.io.Serializable;
import java.util.Calendar;

/**
 *
 * @author Sara
 */
class MembershipPlan {

    private int planId;
    private String planName;
    private String description;
    private int duration;
    private float price;
    private Calendar startDate; // Changed to Calendar
    private Calendar endDate;   // Changed to Calendar
    private String membershipType;
    private MembershipStatus membershipStatus = new ActiveMembership();
    private String status;
    private boolean paid;

    public MembershipPlan() {
    }

    public MembershipPlan(int planId, String planName, String description, int duration, float price, Calendar startDate, Calendar endDate, String membershipType, MembershipStatus membershipStatus, String status, boolean paid) {
        this.planId = planId;
        this.planName = planName;
        this.description = description;
        this.price = price;
        this.duration = duration;
        this.startDate = startDate;
        this.endDate = endDate;
        this.membershipType = membershipType;
        this.membershipStatus = membershipStatus;
        this.status = status;
        this.paid = paid;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    // Get the start date as a Calendar object
    public Calendar getStartDate() {
        return startDate;
    }

    // Set the start date using year, month, and day
    public void setStartDate(int year, int month, int day) {
        startDate = Calendar.getInstance();
        startDate.set(year, month - 1, day); // Calendar months are 0-indexed
    }

    // Get the start date components (year, month, day)
    public String getStartDateFormatted() {
        return String.format("%d-%02d-%02d", startDate.get(Calendar.YEAR), startDate.get(Calendar.MONTH) + 1, startDate.get(Calendar.DAY_OF_MONTH));
    }

    // Get the end date as a Calendar object
    public Calendar getEndDate() {
        return endDate;
    }

    // Set the end date using year, month, and day
    public void setEndDate(int year, int month, int day) {
        endDate = Calendar.getInstance();
        endDate.set(year, month - 1, day); // Calendar months are 0-indexed
    }

    // Get the end date components (year, month, day)
    public String getEndDateFormatted() {
        return String.format("%d-%02d-%02d", endDate.get(Calendar.YEAR), endDate.get(Calendar.MONTH) + 1, endDate.get(Calendar.DAY_OF_MONTH));
    }

    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    public MembershipStatus getMembershipStatus() {
        return membershipStatus;
    }

    public void setMembershipStatus(MembershipStatus membershipStatus) {
        this.membershipStatus = membershipStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    //this needs to run periodically
    public void changeStatus(Member m) {
        this.membershipStatus.changeStatus(m);
    }

    public boolean inActivePeriod() {

        Calendar currentDate = Calendar.getInstance(); // Changed to Calendar
        boolean isActivePeriod;

        isActivePeriod = (currentDate.after(this.startDate) || currentDate.equals(this.startDate)) && currentDate.before(this.endDate);
        
        return isActivePeriod;

    }

    public boolean inGracePeriod() {
        final int GRACE_PERIOD = 30;
        Calendar currentDate = Calendar.getInstance(); // Changed to Calendar

        Calendar finalEndDate = (Calendar) this.endDate.clone();
        finalEndDate.add(Calendar.DAY_OF_MONTH, GRACE_PERIOD);

        boolean isGracePeriod;

        if ((currentDate.equals(this.endDate) || currentDate.after(this.endDate)) && currentDate.before(finalEndDate)) {

            isGracePeriod = true;
            
        } else if (currentDate.equals(finalEndDate) || currentDate.after(finalEndDate)) {
            isGracePeriod = false;
        } else {
            return false;
        }
        
        return isGracePeriod;

    }

    public boolean isHalfPast() {
        Calendar currentDate = Calendar.getInstance();
        //constants
        final int DAYS_AVG = 30;

        //getting duration in days to calc half the duration
        int durationInDays = this.duration * DAYS_AVG;
        int halfDuration = Math.floorDiv(durationInDays, 2);// gets the lower num

        //date of half duration is the startDate + half the duration
        Calendar halfDurationDate = (Calendar) this.startDate.clone();
        halfDurationDate.add(Calendar.DAY_OF_MONTH, halfDuration);
        
        
        boolean isHalfPast =false;
        
        if(currentDate.after(halfDurationDate) || currentDate.equals(halfDurationDate)){
            isHalfPast = true;
        }
        
        return isHalfPast;
        
        
    }

    public int getAttendanceAvg() {

        // assume avg attendance is once a week for simplicity
        final int WEEKS_PER_MONTH = 4;
        int durationInWeeks = this.duration * WEEKS_PER_MONTH;
        final int ATTENDANCE_AVG = durationInWeeks;
        return ATTENDANCE_AVG;
    }

}
