/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import adt.ListInterface;
import adt.DoublyLinkedList;
import entity.TutorialProgramme;

/**
 *
 * @author Koh Yoke Yieng
 */
public class TutorialProgrammeInitializer {
    public ListInterface<TutorialProgramme> initializeTutorialProgramme() {
        ListInterface<TutorialProgramme> tpList = new DoublyLinkedList<>();
        tpList.add(new TutorialProgramme("RSW1", 30, "RSW", "Bachelor of Software Engineering (Honours)"));
        tpList.add(new TutorialProgramme("RSW2", 4, "RSW", "Bachelor of Software Engineering (Honours)"));
        tpList.add(new TutorialProgramme("RSW3", 2, "RSW", "Bachelor of Software Engineering (Honours)"));
        tpList.add(new TutorialProgramme("RSW4", 1, "RSW", "Bachelor of Software Engineering (Honours)"));
        tpList.add(new TutorialProgramme("RDS1", 15, "RDS", "Bachelor of Computer Science (Honours) in Data Science"));
        
        return tpList;
    }
}
