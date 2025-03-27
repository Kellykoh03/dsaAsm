/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import static java.lang.String.format;

/**
 *
 * @author Cham Yee
 */
public class Semester implements Comparable<Semester>{
    private String semesterCode;
    
    private String courseCode;
    private String courseTitle;
    private String courseType;
    private int creditHour;
    private double courseFee = 259.0;
    
    public Semester() {
    }

    public Semester(String semesterCode, String courseCode, String courseTitle, String courseType, int creditHour, double courseFee) {
        this.semesterCode = semesterCode;
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
        this.courseType = courseType;
        this.creditHour = creditHour;
        this.courseFee = courseFee;
    }

    public String getSemesterCode() {
        return semesterCode;
    }

    public void setSemesterCode(String semesterCode) {
        this.semesterCode = semesterCode;
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

    public int getCreditHour() {
        return creditHour;
    }

    public void setCreditHour(int creditHour) {
        this.creditHour = creditHour;
    }

    public double getCourseFee() {
        return courseFee;
    }

    public void setCourseFee(double courseFee) {
        this.courseFee = courseFee;
    }
    
    @Override
    public String toString(){
        return format("%10s %15s %30s %15s %15d %15f", semesterCode, courseCode, courseTitle, courseType, creditHour, courseFee);
    }

    @Override
    public int compareTo(Semester s) {
       return this.courseCode.compareTo(s.courseCode);
    }
}
