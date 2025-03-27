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
public class TutorCourse implements Comparable<TutorCourse> {
    private int id;
    private String name;
    private String gender;
    
    private String courseCode;
    private String courseTitle;
    private String courseType;
    private int courseCreditHour;
    private double courseFee;
    
    private String session;

    public TutorCourse() {
    }

    public TutorCourse(int id, String name, String gender, String courseCode, String courseTitle, String courseType, int courseCreditHour, double courseFee) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
        this.courseType = courseType;
        this.courseCreditHour = courseCreditHour;
        this.courseFee = courseFee;
    }
    
    public TutorCourse(int id, String name, String gender, String courseCode, String courseTitle, String courseType, int courseCreditHour, double courseFee, String session) {
        this.id = id;
        this.name = name;
        this.gender = gender;
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
        return format("%-10d %-20s %-10s %-12s %-30s %-12s %-12d %-12.2f %-12s", this.id, this.name, this.gender, this.courseCode, this.courseTitle, this.courseType, this.courseCreditHour, this.courseFee, this.session);
    }

    @Override
    public int compareTo(TutorCourse o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
