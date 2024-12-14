package Server;

/**
 *
 * @author Sara
 */
public class Trainer extends User implements Observer , ROIMember {
    private String specialty;
    private Member member;

    public Trainer() {
    }

    public Trainer(String specialty, Member member) {
        this.specialty = specialty;
        this.member = member;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    // Implementation of Observer interface
    @Override
    public void update() {
        // Handle the received notification
        System.out.println("GYM Claas updated" );
        // Optionally, update the GUI or perform additional actions based on the notification
    }
    
    // Implementation of ROIMember interface
    @Override
    public String viewMemberProfile() {
        return "Member Profile: " + member.getName() + ", Membership Plan: " + member.getMembershipPlan().getPlanName();
    }

    @Override
    public String viewHealthInfo() {
        HealthInfo healthInfo = member.getHealthInfo();
        return "Health Info: Weight: " + healthInfo.getWeight() + "kg, Height: " + healthInfo.getHeight() + "cm";
    }
}

