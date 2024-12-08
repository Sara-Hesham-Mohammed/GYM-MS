/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gym.ms;

/**
 *
 * @author Sara
 */
public class User {
    private int ID; // Corresponds to "- ID: int"
    private String name; // Corresponds to "- name: String"
    private int age; // Corresponds to "- age: int"
    private String email; // Corresponds to "- email: String"
    private String gender; // Corresponds to "- gender: String"
    private String username; // Corresponds to "- username: String"
    private String password; // Corresponds to "- password: String"

    // Default constructor
    public User() {
    }

    // Parameterized constructor
    public User(int ID, String name, int age, String email, String gender, String username, String password) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.email = email;
        this.gender = gender;
        this.username = username;
        this.password = password;
    }

    // Getters and Setters
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Overriding toString() for display purposes
    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

