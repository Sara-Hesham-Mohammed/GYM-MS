/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;

import java.util.List;

/**
 *
 * @author Sara
 */
public class GymClass implements Subject{

    private int classId;
    private String className;
    private String instructorName;
    private Calendar startTime;
    private Calendar endTime;
    private String duration;
    private ArrayList<Member> enrolledMembers;
    private List<Observer> observers = new ArrayList<>(); // List of registered observers

    public GymClass() {

    }

    public GymClass(int classId, String className, String instructorName, Calendar startTime, Calendar endTime, String duration, ArrayList<Member> enrolledMembers) {
        this.classId = classId;
        this.className = className;
        this.instructorName = instructorName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.duration = duration;
        this.enrolledMembers = enrolledMembers;
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

    public ArrayList<Member> getEnrolledMembers() {
        return enrolledMembers;
    }

    public void setEnrolledMembers(ArrayList<Member> enrolledMembers) {
        this.enrolledMembers = enrolledMembers;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
        notifyObservers("Instructor updated to: " + instructorName);
    }

    public Calendar getStartTime() {
        return startTime;
    }

    public void setStartTime(Calendar startTime) {
        this.startTime = startTime;
        
        notifyObservers("Start time updated to: " + startTime);
    }

    public Calendar getEndTime() {
        return endTime;
    }

    public void setEndTime(Calendar endTime) {
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

    public void manageClass(Member member) {
        // Add a class (enroll a member)
        enrolledMembers.add(member);
        System.out.println("Member added: " + member.getName());

        // Cancel class enrollment (remove a member)
        if (!enrolledMembers.isEmpty()) {
            Member removedMember = enrolledMembers.remove(0);
            System.out.println("Member removed: " + removedMember.getName());
        } else {
            System.out.println("No members to remove.");
        }
    }

    public void viewClassDetails() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        System.out.println("Class ID: " + classId);
        System.out.println("Class Name: " + className);
        System.out.println("Instructor Name: " + instructorName);
        System.out.println("Start Time: " + (startTime != null ? sdf.format(startTime.getTime()) : "Not Set"));
        System.out.println("End Time: " + (endTime != null ? sdf.format(endTime.getTime()) : "Not Set"));
        System.out.println("Duration: " + duration);
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




}
