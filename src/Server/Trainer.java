package Server;

/**
 *
 * @author Sara
 */
public class Trainer extends User implements Observer {
    private String specialty;
    private Member member;  // Optional: You can link a trainer to a specific member
    private GymClass gymClass;  // Optional: Link to a GymClass if the trainer is observing classes

    // Default constructor
    public Trainer() {
    }

    // Constructor with specialty and member
    public Trainer(String specialty, Member member, GymClass gymClass) {
        this.specialty = specialty;
        this.member = member;
        this.gymClass = gymClass;
    }

    // Getters and setters
    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public GymClass getGymClass() {
        return gymClass;
    }

    public void setGymClass(GymClass gymClass) {
        this.gymClass = gymClass;
    }

    // Implementation of Observer interface
    @Override
    public void update(String message) {
        // Handle the received notification (e.g., gym class update)
        System.out.println("Trainer received update: " + message);
        // Optionally, update the trainer's state or display the message in the GUI
    }
}
