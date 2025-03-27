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
public class TutorialGroupTutor implements Comparable<TutorialGroupTutor> {
    private String tutorialGroup;
    private int capacity;
    private String programmeCode;
    
    private int id;
    private String name;
    private String gender;

    public TutorialGroupTutor() {
    }

    public TutorialGroupTutor(String tutorialGroup, int capacity, String programmeCode, int id, String name, String gender) {
        this.tutorialGroup = tutorialGroup;
        this.capacity = capacity;
        this.programmeCode = programmeCode;
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    public String getProgrammeCode() {
        return programmeCode;
    }

    public void setProgrammeCode(String programmeCode) {
        this.programmeCode = programmeCode;
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

    @Override
    public String toString() {
        return format(" %-10s %-10d %-20s %-28d %-30s %-10s", this.tutorialGroup, this.capacity, this.programmeCode, this.id, this.name, this.gender);
    }

    @Override
    public int compareTo(TutorialGroupTutor o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
