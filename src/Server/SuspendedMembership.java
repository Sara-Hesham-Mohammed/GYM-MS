/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

import java.time.LocalDateTime;

/**
 *
 * @author Sara
 */
public class SuspendedMembership implements MembershipStatus {

    public static final long GRACE_PERIOD = 30 ;
    @Override
    public void changeStatus(Member m) {
        //collection of users
        
        MembershipPlan p = m.getMembershipPlan();
        LocalDateTime currentDate = LocalDateTime.now();
        LocalDateTime finalEndDate = p.getEndDate().plusDays(GRACE_PERIOD);
        //if current date is = or more than end date + grace period
        if(currentDate.isEqual(finalEndDate) || currentDate.isAfter(finalEndDate)){
            p.setMembershipStatus(this);
            p.setStatus("Suspended");
            System.out.println("Member has now been suspended.");
        }
        else{
            System.out.println("Member cannot be suspended. Conditions do not apply.");
        }
        
        
    }
    
}
