/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

/**
 *
 * @author Sara
 */
public class Facade {
    private MembershipPlan membershipPlan;
    private DTO memPlanDTO;

    public MembershipPlan getMembershipPlan() {
        return membershipPlan;
    }

    //fix setter
    public void setMembershipPlan(MembershipPlan membershipPlan) {
        this.membershipPlan = membershipPlan;
    }
    

    public DTO getMemPlanDTO() {
        return memPlanDTO;
    }

    public void setMemPlanDTO(DTO memPlanDTO) {
        this.memPlanDTO = memPlanDTO;
    }
    
    
}
