/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rmi;

/**
 *
 * @author Sara
 */
public class Nutritionist implements Observer {
    private ROIMember ROIMember; 
    private NutritionPlan nuturitionPlan;
    private NutritionPlanBehaviour plan; 

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
    
    
    // Implementation of Observer interface
    @Override
    public void update(String message) {
        // Handle the received notification
        System.out.println("Nutritionist received update: " + message);
        // Optionally, update the GUI or perform additional actions based on the notification
    }

    // Nutrition Plan Behaviour Methods
    public NutritionPlanBehaviour getPlan() {
        return plan;
    }

    public void setPlan(NutritionPlanBehaviour plan) {
        this.plan = plan;
    }

    // Method to provide the nutrition plan
    public boolean provideNutritionPlan(User u) {
        if (plan != null) {
            return plan.provideNutritionPlan(u);  // Return the result from the plan
        }
        return false;  // Return false if no plan is set
    }
    
}
