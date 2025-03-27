/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import adt.ListInterface;
import adt.DoublyLinkedList;
import entity.TutorialGroup;

/**
 *
 * @author Koh Yoke Yieng
 */
public class TutorialGroupInitializer {
    
    public ListInterface<TutorialGroup> initializeTutorialGroup(){
        ListInterface<TutorialGroup> tList = new DoublyLinkedList<>();
        tList.add(new TutorialGroup("RSW1", 30, "RSW"));
        tList.add(new TutorialGroup("RSW2", 30,"RSW"));
        tList.add(new TutorialGroup("RSW3", 30,"RSW"));
        tList.add(new TutorialGroup("RSW4", 30,"RSW"));
        tList.add(new TutorialGroup("RDS1", 30,"RDS"));
        return tList;
    }
}
