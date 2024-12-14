/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rmi;

/**
 *
 * @author Sara
 */
public class Nutritionist {
    private ROIMember ROIMember; 
    private NutritionPlan nuturitionPlan;

    public Nutritionist() {
    }

    public Nutritionist(ROIMember ROIMember, NutritionPlan nuturitionPlan) {
        this.ROIMember = ROIMember;
        this.nuturitionPlan = nuturitionPlan;
    }

    public ROIMember getROIMember() {
        return ROIMember;
    }

    public void setROIMember(ROIMember ROIMember) {
        this.ROIMember = ROIMember;
    }

    public NutritionPlan getNuturitionPlan() {
        return nuturitionPlan;
    }

    public void setNuturitionPlan(NutritionPlan nuturitionPlan) {
        this.nuturitionPlan = nuturitionPlan;
    }
    
    
}
