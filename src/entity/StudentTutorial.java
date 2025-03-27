/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import static java.lang.String.format;

/**
 *
 * @author Koh Yoke Yieng
 */
public class StudentTutorial implements Comparable<StudentTutorial> {
    private String name;
    private String gender;
    private int age;
    private int studId;
    private String tutorialGroup;
    private int capacity;
    private String programmeCode;
    
    public StudentTutorial() {
        
    }

    public StudentTutorial(String name, String gender, int age, int studId, String tutorialGroup, int capacity, String programmeCode) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.studId = studId;
        this.tutorialGroup = tutorialGroup;
        this.capacity = capacity;
        this.programmeCode = programmeCode;
    }

    public String getProgrammeCode() {
        return programmeCode;
    }

    public void setProgrammeCode(String porgrammeCode) {
        this.programmeCode = porgrammeCode;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public int getStudId() {
        return studId;
    }

    public String getTutorialGroup() {
        return tutorialGroup;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setStudId(int studId) {
        this.studId = studId;
    }

    public void setTutorialGroup(String tutorialGroup) {
        this.tutorialGroup = tutorialGroup;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
    @Override
    public String toString() {
        return format("%31s %7d %10s %16d %20s", this.name, this.age, this.gender, this.studId, this.programmeCode);
    }
    
    @Override
    public int compareTo(StudentTutorial st) {
        return this.name.compareTo(st.name);
    }
}
