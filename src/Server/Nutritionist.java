package Server;

/**
 *
 * @author Sara
 */
public class Nutritionist implements Observer {
    private ROIMember roiMember;  // Fixed spelling: 'ROIMember'
    private NutritionPlan nutritionPlan;
    private NutritionPlanBehaviour plan;  // 'plan' is used to provide nutrition plan

    // Default constructor
    public Nutritionist() {
    }

    // Constructor with parameters
    public Nutritionist(ROIMember roiMember, NutritionPlan nutritionPlan) {
        this.roiMember = roiMember;
        this.nutritionPlan = nutritionPlan;
    }

    // Getters and setters
    public ROIMember getROIMember() {
        return roiMember;
    }

    public void setROIMember(ROIMember roiMember) {
        this.roiMember = roiMember;
    }

    public NutritionPlan getNutritionPlan() {
        return nutritionPlan;
    }

    public void setNutritionPlan(NutritionPlan nutritionPlan) {
        this.nutritionPlan = nutritionPlan;
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
