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
public class CourseProgramme implements Comparable<CourseProgramme>{
    private String courseCode;
    private String courseTitle;
    private String courseType;
    private int creditHour;
    private double courseFee = 259.0;
    
    private String programmeCode;
    private String programmeName;

    public CourseProgramme() {
    }
    
    public CourseProgramme(String courseCode, String courseTitle, String courseType, int creditHour, double courseFee, String programmeCode, String programmeName) {
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
        this.courseType = courseType;
        this.creditHour = creditHour;
        this.courseFee = courseFee;
        this.programmeCode = programmeCode;
        this.programmeName = programmeName;
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

    public String getProgrammeCode() {
        return programmeCode;
    }

    public void setProgrammeCode(String programmeCode) {
        this.programmeCode = programmeCode;
    }

    public String getProgrammeName() {
        return programmeName;
    }

    public void setProgrammeName(String programmeName) {
        this.programmeName = programmeName;
    }
    
    @Override
    public String toString() {
        return format("%15s %30s %15s %15d %15f %15s %30s", courseCode, courseTitle, courseType, creditHour, courseFee, programmeCode, programmeName);
    }

    @Override
    public int compareTo(CourseProgramme o) {
        return this.courseCode.compareTo(o.courseCode);
    }

    
}