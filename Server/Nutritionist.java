package Server;

/**
 *
 * @author Sara
 */
public class Nutritionist implements Observer {
    private ROIMember ROIMember;
    private NutritionPlan nutritionPlan;

    public Nutritionist() {
    }

    public Nutritionist(ROIMember ROIMember, NutritionPlan nutritionPlan) {
        this.ROIMember = ROIMember;
        this.nutritionPlan = nutritionPlan;
    }

    public ROIMember getROIMember() {
        return ROIMember;
    }

    public void setROIMember(ROIMember ROIMember) {
        this.ROIMember = ROIMember;
    }

    public NutritionPlan getNuturitionPlan() {
        return nutritionPlan;
    }

    public void setNuturitionPlan(NutritionPlan nuturitionPlan) {
        this.nutritionPlan = nuturitionPlan;
    }
    
    // Implementation of ROIMember interface
    public void generateNutritionPlan() {
        if (ROIMember != null) {
            String profile = ROIMember.viewMemberProfile();
            String healthInfo = ROIMember.viewHealthInfo();

            System.out.println("Accessing Member Profile: " + profile);
            System.out.println("Accessing Member Health Info: " + healthInfo);

            // Logic to create a nutrition plan based on health info
            nutritionPlan = new NutritionPlan();
            System.out.println("Nutrition plan created for the member.");
        } else {
            System.out.println("No member data available for generating a nutrition plan.");
        }
    }
    
    // Implementation of Observer interface
    @Override
    public void update() {
        // Handle the received notification
        System.out.println("GYM Class Updated " );
        // Optionally, update the GUI or perform additional actions based on the notification
    }
}
