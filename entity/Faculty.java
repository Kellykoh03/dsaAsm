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
public class Faculty implements Comparable<Faculty>{
    private String facultyCode;
    private String facultyName;
    
    private String courseCode;
    private String courseTitle;
    private String courseType;
    private int creditHour;
    private double courseFee = 259.0;

    public Faculty() {
    }

    public Faculty(String facultyCode, String facultyName, String courseCode, String courseTitle, String courseType, int creditHour, double courseFee) {
        this.facultyCode = facultyCode;
        this.facultyName = facultyName;
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
        this.courseType = courseType;
        this.creditHour = creditHour;
        this.courseFee = courseFee;
    }

    public String getFacultyCode() {
        return facultyCode;
    }

    public void setFacultyCode(String facultyCode) {
        this.facultyCode = facultyCode;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
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
    public String toString() {
        return String.format("%15s %30s %15s %30s %15s %15d %15f", facultyCode, facultyName, courseCode, courseTitle, courseType, creditHour, courseFee);
    }    

    @Override
    public int compareTo(Faculty f) {
        return this.courseCode.compareTo(f.courseCode);
    }
}
