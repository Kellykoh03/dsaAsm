/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import adt.DoublyLinkedList;
import adt.ListInterface;
import entity.Semester;
/**
 *
 * @author Cham Yee
 */
public class SemesterInitializer {
    public ListInterface<Semester> initializeSemester() {
    ListInterface<Semester> mList = new DoublyLinkedList<>();
    mList.add(new Semester("202401", "BACS1053", "Database Management", "Main", 3, 777));
    mList.add(new Semester("202401", "BACS2023", "Object-Oriented Programming", "Main", 3, 777));
    mList.add(new Semester("202401", "BACS2063", "Data Structure and Algorithm", "Main", 3, 777));
    mList.add(new Semester("202401", "BAIT1023", "Web Design and Development", "Resit", 3, 90));
    mList.add(new Semester("202401", "BAIT1043", "System Analysis and Design", "Resit", 3, 90));
    mList.add(new Semester("202401", "BAIT2203", "Human Computer Interaction", "Repeat", 3, 777));
    mList.add(new Semester("202310", "BACS1053", "Database Management", "Main", 3, 777));
    return mList;
  }
}
