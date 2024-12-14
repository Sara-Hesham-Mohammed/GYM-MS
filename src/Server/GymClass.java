package Server;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GymClass implements Subject {
    private int classId;
    private String className;
    private String instructorName;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String duration;
    private List<Observer> observers = new ArrayList<>(); // List of registered observers

    public GymClass() {
    }

    // Parameterized constructor
    public GymClass(int classId, String className, String instructorName, LocalDateTime startTime, LocalDateTime endTime, String duration) {
        this.classId = classId;
        this.className = className;
        this.instructorName = instructorName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.duration = duration;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
        notifyObservers("Class name updated to: " + className);
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
        notifyObservers("Instructor updated to: " + instructorName);
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
        notifyObservers("Start time updated to: " + startTime);
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
        notifyObservers("End time updated to: " + endTime);
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
        notifyObservers("Duration updated to: " + duration);
    }

    @Override
    public void registerObserver(Observer o) {
        if (!observers.contains(o)) {
            observers.add(o);
        }
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    /*public boolean updateGymClassDetails() {
        boolean isUpdated = Database.getDatabase().updateGymClassDetails(classId);
        if (isUpdated) {
            notifyObservers("GymClass details have been updated for class: " + className);
        }
        return isUpdated;
    }*/
}
