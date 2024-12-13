/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author Sara
 */
class MembershipPlan {
    private int planId;
    private String planName;
    private String description;
    private float price;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String membershipType;
    private MembershipStatus membershipStatus;
    private String status;
    private boolean paid;

    public MembershipPlan() {
    }

    public MembershipPlan(int planId, String planName, String description, float price, LocalDateTime startDate, LocalDateTime endDate, String membershipType, MembershipStatus membershipStatus, String status, boolean paid) {
        this.planId = planId;
        this.planName = planName;
        this.description = description;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
        this.membershipType = membershipType;
        this.membershipStatus = membershipStatus;
        this.status = status;
        this.paid = paid;
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

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
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
    
    public void changeStatus(Member m){
        membershipStatus.changeStatus(m);
    }
    
    
}
