/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rmi;

/**
 *
 * @author Sara
 */
public class NutritionPlan implements NutritionPlanBehaviour{
    
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
    
    
    
    // Provide nutrition plan
    @Override
public boolean provideNutritionPlan(User u) {
    // Ensure the user is a Member
    if (u instanceof Member) {
        Member m = (Member) u;

        // Ensure that the date of birth is not null or empty
        String dateOfBirth = m.getDateOfBirth();
        if (dateOfBirth == null || dateOfBirth.isEmpty()) {
            System.err.println("Date of birth is missing.");
            return false;
        }

        // Define the formatter (adjust this if the format is different)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            // Parse the member's date of birth
            LocalDate birthDate = LocalDate.parse(dateOfBirth, formatter);

            // Get the current date
            LocalDate currentDate = LocalDate.now();

            // Calculate the member's age
            Period period = Period.between(birthDate, currentDate);
            int years = period.getYears();

            // Conditions to provide a nutrition plan: age >= 16 and training level >= 5
            if (years >= 16 && m.getTrainingLevel() >= 5) {
                // Update the approval in the database
                Database.getDatabase().updateApproval(m.getMemberID());
                return true; // Plan provided successfully
            } else {
                System.out.println("Conditions not met: age or training level insufficient.");
                return false;
            }
        } catch (DateTimeParseException e) {
            // Handle parsing error
            System.err.println("Invalid date format: " + e.getMessage());
            return false;
        }
    }

    // Return false if the user is not a Member
    System.err.println("User is not a Member.");
    return false;
}
    
}
    
