/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rmi;

/**
 *
 * @author Sara
 */
public class NutritionPlan {
    
    private int planId;
    private String description;
    private String fitessGoal;

    public NutritionPlan() {
    }

    public NutritionPlan(int planId, String description, String fitessGoal) {
        this.planId = planId;
        this.description = description;
        this.fitessGoal = fitessGoal;
    }

    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFitessGoal() {
        return fitessGoal;
    }

    public void setFitessGoal(String fitessGoal) {
        this.fitessGoal = fitessGoal;
    }
    
    
    
    
}
    
