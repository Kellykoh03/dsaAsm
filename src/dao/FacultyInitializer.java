/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import adt.DoublyLinkedList;
import adt.ListInterface;
import entity.Faculty;
/**
 *
 * @author Cham Yee
 */
public class FacultyInitializer {
    public ListInterface<Faculty> initializeFaculty() {
    ListInterface<Faculty> fList = new DoublyLinkedList<>();
    fList.add(new Faculty("FOCS", "Faculty of Computing and Information Technology", "BACS1053", "Database Management", "Main", 3, 777));
    fList.add(new Faculty("FOCS", "Faculty of Computing and Information Technology", "BACS2023", "Object-Oriented Programming", "Main", 3, 777));
    fList.add(new Faculty("FOCS", "Faculty of Computing and Information Technology", "BACS2063", "Data Structure and Algorithm", "Main", 3, 777));
    fList.add(new Faculty("FOCS", "Faculty of Computing and Information Technology", "BAIT1023", "Web Design and Development", "Resit", 3, 90));
    fList.add(new Faculty("FOCS", "Faculty of Computing and Information Technology", "BAIT1043", "System Analysis and Design", "Resit", 3, 90));
    fList.add(new Faculty("FOCS", "Faculty of Computing and Information Technology", "BAIT2203", "Human Computer Interaction", "Repeat", 3, 777));
    fList.add(new Faculty("FAFB", "Faculty of Accountancy, Finance and Business", "ABBL3104", "Commercial Law of Malaysia", "Main", 3, 777));
    fList.add(new Faculty("FAFB", "Faculty of Accountancy, Finance and Business", "BBMF3183", "Strategic Financial Management", "Main", 3, 777));
    return fList;
  }
}
