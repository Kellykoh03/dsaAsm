/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import static java.lang.String.format;

/**
 *
 * @author Tang Yi Jun
 */
public class TutorTutorialGroupCourse implements Comparable<TutorTutorialGroupCourse>{
    private int id;
    private String name;
    private String gender;
    
    private String tutorialGroup;
    private int capacity;
    private String programmeCode;
    
    private String courseCode;
    private String courseTitle;
    private String courseType;
    private int courseCreditHour;
    private double courseFee;
    private String session;

    public TutorTutorialGroupCourse() {
    }

    public TutorTutorialGroupCourse(int id, String name, String gender, String tutorialGroup, int capacity, String programmeCode, String courseCode, String courseTitle, String courseType, int courseCreditHour, double courseFee, String session) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.tutorialGroup = tutorialGroup;
        this.capacity = capacity;
        this.programmeCode = programmeCode;
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
        this.courseType = courseType;
        this.courseCreditHour = courseCreditHour;
        this.courseFee = courseFee;
        this.session = session;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getProgrammeCode() {
        return programmeCode;
    }

    public void setProgrammeCode(String programmeCode) {
        this.programmeCode = programmeCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTutorialGroup() {
        return tutorialGroup;
    }

    public void setTutorialGroup(String tutorialGroup) {
        this.tutorialGroup = tutorialGroup;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public int getCourseCreditHour() {
        return courseCreditHour;
    }

    public void setCourseCreditHour(int courseCreditHour) {
        this.courseCreditHour = courseCreditHour;
    }

    public double getCourseFee() {
        return courseFee;
    }

    public void setCourseFee(double courseFee) {
        this.courseFee = courseFee;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    @Override
    public String toString() {
        return format(" %-28d %-30s %-10s %-10s %-10d %-20s %-12s %-30s %-12s %-12d %-12.2f %-12s", this.id, this.name, this.gender, this.tutorialGroup, this.capacity, this.programmeCode, this.courseCode, this.courseTitle, this.courseType, this.courseCreditHour, this.courseFee, this.session);
    }

    @Override
    public int compareTo(TutorTutorialGroupCourse o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
