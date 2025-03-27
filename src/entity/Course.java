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
public class Course implements Comparable<Course> {

    private String courseCode;
    private String courseTitle;
    private String courseType;
    private int creditHour;
    private double courseFee = 259.0;

    public Course() {
    }

    public Course(String courseCode, String courseTitle, String courseType, int creditHour, int courseFee) {
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
        this.courseType = courseType;
        this.creditHour = creditHour;
        this.courseFee = courseFee;
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

    public int getCreditHour() {
        return creditHour;
    }

    public double getCourseFee() {
        return courseFee;
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

    public void setCreditHour(int creditHour) {
        this.creditHour = creditHour;
    }

    public void setCourseFee(double courseFee) {
        this.courseFee = courseFee;
    }

    @Override
    public String toString() {
        return format("%17s %30s %15s %15d %15.2f", courseCode, courseTitle, courseType, creditHour, courseFee);
    }

    @Override
    public int compareTo(Course c) {
        return this.courseTitle.compareTo(c.courseTitle);
    }
}

