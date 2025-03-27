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
public class TutorialProgramme implements Comparable<TutorialProgramme> {
    private String programmeCode;
    private String programmeName;
    private String programmeFaculty;
    private String tutorialGroup;
    private int capacity;

    public TutorialProgramme() {

    }

    public TutorialProgramme(String tutorialGroup, int capacity, String programmeCode, String programmeName) {
        this.programmeCode = programmeCode;
        this.programmeName = programmeName;
        this.tutorialGroup = tutorialGroup;
        this.capacity = capacity;
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
        return format("%31s %7d %10s %16d %30d", this.programmeCode, this.programmeName, this.programmeFaculty, this.tutorialGroup, this.capacity, 30); 
    }

    @Override
    public int compareTo(TutorialProgramme t) {
        return this.programmeCode.compareTo(t.getProgrammeCode());
    }
}
