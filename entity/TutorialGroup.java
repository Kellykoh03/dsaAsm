/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Koh Yoke Yieng
 */
public class TutorialGroup implements Comparable<TutorialGroup>{
    private String tutorialGroupID;
    private int capacity;
    private String programmeCode;

    public TutorialGroup(){
        
    }

    public TutorialGroup(String tutorialGroupID, int capacity, String programmeCode) {
        this.tutorialGroupID = tutorialGroupID;
        this.capacity = capacity;
        this.programmeCode = programmeCode;
    }

    public String getProgrammeCode() {
        return programmeCode;
    }

    public void setProgrammeCode(String programmeCode) {
        this.programmeCode = programmeCode;
    }

    public String getTutorialGroupID() {
        return tutorialGroupID;
    }

    public void setTutorialGroup(String tutorialGroupID) {
        this.tutorialGroupID = tutorialGroupID;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return  String.format("%7s %24s/30 %31s",this.tutorialGroupID, this.capacity, this.programmeCode);
    }

    @Override
    public int compareTo(TutorialGroup t) {
        return this.tutorialGroupID.compareTo(t.tutorialGroupID);
    }
}
    
    