/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.io.Serializable;

/**
 *
 * @author a_h_s
 */
public class MemplanDTO implements Serializable {
    private int planID;
    private String planName;
    private float price;
    private String status;

    public MemplanDTO(int planID, String planName, float price, String status) {
        this.planID = planID;
        this.planName = planName;
        this.price = price;
        this.status = status;
    }

  //  public MemplanDTO() {
    //}

    public int getPlanID() {
        return planID;
    }

    public void setPlanID(int planID) {
        this.planID = planID;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
    
}
