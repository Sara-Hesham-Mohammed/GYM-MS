/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Server;

import java.time.LocalDateTime;

/**
 *
 * @author Sara
 */
public class GymClass {
    private int classId;
    private String className;
    private String instructorName;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String duration;

    public GymClass(){
        
    }
    
    

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
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
    
    
}
