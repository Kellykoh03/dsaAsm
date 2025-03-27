/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import static java.lang.String.format;

/**
 *
 * @author Alex Lee Chia Hau
 */
public class Registered implements Comparable<Registered>{
    private String studentName;
    private String studentGender;
    private int studentAge;
    private int id;
    private String programmeCode;
    
    private String courseCode;
    private String courseTitle;
    private String courseType;
    private int courseCreditHour;
    private double courseFee;

    public Registered() {
    }

    public Registered(String studentName, String studentGender, int studentAge, int id, String programmeCode, String courseCode, String courseTitle, String courseType, int courseCreditHour, double courseFee) {
        this.studentName = studentName;
        this.studentGender = studentGender;
        this.studentAge = studentAge;
        this.id = id;
        this.programmeCode = programmeCode;
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
        this.courseType = courseType;
        this.courseCreditHour = courseCreditHour;
        this.courseFee = courseFee;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentGender() {
        return studentGender;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public int getId() {
        return id;
    }

    public String getProgrammeCode() {
        return programmeCode;
    }
    
    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public String getCourseType() {
        return courseType;
    }

    public int getCourseCreditHour() {
        return courseCreditHour;
    }

    public double getCourseFee() {
        return courseFee;
    }
    
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudentGender(String studentGender) {
        this.studentGender = studentGender;
    }

    public void setStudentAge(int studentAge) {
        this.studentAge = studentAge;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProgrammeCode(String programmeCode) {
        this.programmeCode = programmeCode;
    }
    
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public void setCourseCreditHour(int courseCreditHour) {
        this.courseCreditHour = courseCreditHour;
    }

    public void setCourseFee(double courseFee) {
        this.courseFee = courseFee;
    }
    
    @Override
    public String toString(){
        return format("%30s %6d %9s %16s %16s %18s %30s %15s %15d %15.2f", studentName, studentAge, studentGender, id, programmeCode, courseCode, courseTitle, courseType, courseCreditHour, courseFee);
    }
    
    @Override
    public int compareTo(Registered r) {
        return this.studentName.compareTo(r.studentName);
    }
}
