package Server;

/**
 *
 * @author Sara
 */
public class ActiveMembership implements MembershipStatus {

    @Override
    public void changeStatus(Member m) {

        MembershipPlan p = m.getMembershipPlan();
        if (p.inActivePeriod() && p.isPaid()) {
            p.setMembershipStatus(this);
            p.setStatus("Active");
            System.out.println("Membership is now active.");

            if (p.isHalfPast()) {
                p.setMembershipStatus(new FrozenMembership());
                p.changeStatus(m);
            }

        } else {
            //suspend or say that ur still in the grace period

            p.setMembershipStatus(new SuspendedMembership());
            p.changeStatus(m);
            System.out.println("Membership isn't activated. Conditions do not apply.");
        }

    }

}
