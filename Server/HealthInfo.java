/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

/**
 *
 * @author Sara
 */
public class HealthInfo {

    private float weight;
    private float height;
    private String gender;
    private String fitnessGoal;

    public HealthInfo() {
    }

    public HealthInfo(float weight, float height, String gender, String fitnessGoal) {
        this.weight = weight;
        this.height = height;
        this.gender = gender;
        this.fitnessGoal = fitnessGoal;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFitnessGoal() {
        return fitnessGoal;
    }

    public void setFitnessGoal(String fitnessGoal) {
        this.fitnessGoal = fitnessGoal;
    }
    
    

}
